package com.pk.rentflat.converter.offers;

import com.pk.rentflat.controller.dto.offers.OffersResponse;
import com.pk.rentflat.converter.customerdetails.CustomerDetailsConverter;
import com.pk.rentflat.model.Offers;

import java.util.List;

public class OffersConverter {

    private OffersConverter() {

    }

    public static OffersResponse convertOffersToOffersResponse(Offers offers) {
        OffersResponse offersResponse = new OffersResponse();
        offersResponse.setId(offers.getId());
        offersResponse.setCity(offersResponse.getCity());
        offersResponse.setStreetAddress(offers.getStreetAddress());
        offersResponse.setPostalCode(offers.getPostalCode());
        offersResponse.setPrice(offersResponse.getPrice());
        offersResponse.setArea(offersResponse.getArea());
        offersResponse.setRoomCount(offers.getRoomCount());
        offersResponse.setMarketType(offers.getMarketType());
        offersResponse.setDescription(offersResponse.getDescription());
        offersResponse.setDistrict(offersResponse.getDistrict());
        offersResponse.setBuildingDetails(offers.getBuildingDetails());
        offersResponse.setAvailableFrom(offers.getAvailableFrom());
        offersResponse.setAvailableUntil(offers.getAvailableUntil());
        offersResponse.setOwner(
                CustomerDetailsConverter.convertCustomerDetailsToCustomerDetailsResponse(offers.getCustomerDetails())
        );

        return offersResponse;
    }

    public static List<OffersResponse> convertOffersListToOffersResponseList(List<Offers> offersList) {
        return offersList.stream()
                .map(OffersConverter::convertOffersToOffersResponse)
                .toList();
    }


}
