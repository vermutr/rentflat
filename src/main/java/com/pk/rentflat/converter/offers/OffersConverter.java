package com.pk.rentflat.converter.offers;

import com.pk.rentflat.controller.dto.offers.OffersResponse;
import com.pk.rentflat.converter.building.BuildingConverter;
import com.pk.rentflat.converter.customerdetails.CustomerDetailsConverter;
import com.pk.rentflat.converter.reviews.ReviewsConverter;
import com.pk.rentflat.model.Building;
import com.pk.rentflat.model.Offers;
import com.pk.rentflat.model.Reviews;

import java.util.List;

public class OffersConverter {

    private OffersConverter() {

    }

    public static OffersResponse convertOffersToOffersResponse(Offers offers) {
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

    public static OffersResponse convertOffersToOffersResponseWithReviewsAndBuilding(
            Offers offers,
            List<Reviews> reviews,
            Building building
    ) {
        OffersResponse offersResponse = convertOffersToOffersResponse(offers);
        offersResponse.setReviewsResponse(ReviewsConverter.convertReviewsListToReviewsResponseList(reviews));
        offersResponse.setBuildingResponse(BuildingConverter.convertBuildingToBuildingResponse(building));
        return offersResponse;
    }

    public static List<OffersResponse> convertOffersListToOffersResponseList(List<Offers> offersList) {
        return offersList.stream()
                .map(OffersConverter::convertOffersToOffersResponse)
                .toList();
    }


}
