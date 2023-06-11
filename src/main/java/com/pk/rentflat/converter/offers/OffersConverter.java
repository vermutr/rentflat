package com.pk.rentflat.converter.offers;

import com.pk.rentflat.controller.dto.offers.OffersRequest;
import com.pk.rentflat.controller.dto.offers.OffersResponse;
import com.pk.rentflat.converter.building.BuildingConverter;
import com.pk.rentflat.converter.customerdetails.CustomerDetailsConverter;
import com.pk.rentflat.converter.reviews.ReviewsConverter;
import com.pk.rentflat.model.Building;
import com.pk.rentflat.model.Offers;
import com.pk.rentflat.model.Reviews;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class OffersConverter {

    private OffersConverter() {

    }

    public static OffersResponse convertOffersRequestToOffers(Offers offers) {
        OffersResponse offersResponse = new OffersResponse();
        offersResponse.setId(offers.getId());
        offersResponse.setCity(offers.getCity());
        offersResponse.setStreetAddress(offers.getStreetAddress());
        offersResponse.setPostalCode(offers.getPostalCode());
        offersResponse.setPrice(offers.getPrice());
        offersResponse.setArea(offers.getArea());
        offersResponse.setRoomCount(offers.getRoomCount());
        offersResponse.setMarketType(offers.getMarketType());
        offersResponse.setDescription(offers.getDescription());
        offersResponse.setDistrict(offers.getDistrict());
        offersResponse.setBuildingDetails(offers.getBuildingDetails());
        offersResponse.setAvailableFrom(offers.getAvailableFrom());
        offersResponse.setAvailableUntil(offers.getAvailableUntil());
        offersResponse.setMainPicture(offers.getMainPicture());
        offersResponse.setAllPictures(offers.getAllPictures());
        offersResponse.setOwner(
                CustomerDetailsConverter.convertCustomerDetailsToCustomerDetailsResponse(offers.getCustomerDetails())
        );

        return offersResponse;
    }

    public static Offers convertOffersRequestToOffers(OffersRequest offersRequest) {
        Offers offers = new Offers();
        offers.setCity(offersRequest.getCity());
        offers.setStreetAddress(offersRequest.getStreetAddress());
        offers.setPostalCode(offersRequest.getPostalCode());
        offers.setPrice(offersRequest.getPrice());
        offers.setArea(offersRequest.getArea());
        offers.setRoomCount(offersRequest.getRoomCount());
        offers.setMarketType(offersRequest.getMarketType());
        offers.setDescription(offersRequest.getDescription());
        offers.setDistrict(offersRequest.getDistrict());
        offers.setBuildingDetails(offersRequest.getBuildingDetails());
        offers.setAvailableFrom(offersRequest.getAvailableFrom());
        offers.setAvailableUntil(offersRequest.getAvailableUntil());

        try {
            if (Objects.nonNull(offersRequest.getMainPicture())) {
                offers.setMainPicture(offersRequest.getMainPicture().getBytes());
            }
            if (Objects.nonNull(offersRequest.getAllPictures())) {
                offers.setAllPictures(offersRequest.getAllPictures()
                        .stream()
                        .filter(Objects::nonNull)
                        .map(s -> {
                            try {
                                return s.getBytes();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }).toList());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return offers;
    }

    public static OffersResponse convertOffersToOffersResponseWithReviewsAndBuilding(
            Offers offers,
            List<Reviews> reviews,
            Building building
    ) {
        OffersResponse offersResponse = convertOffersRequestToOffers(offers);
        offersResponse.setReviewsResponse(ReviewsConverter.convertReviewsListToReviewsResponseList(reviews));
        offersResponse.setBuildingResponse(BuildingConverter.convertBuildingToBuildingResponse(building));
        return offersResponse;
    }

    public static List<OffersResponse> convertOffersListToOffersResponseList(List<Offers> offersList) {
        return offersList.stream()
                .map(OffersConverter::convertOffersRequestToOffers)
                .toList();
    }


}
