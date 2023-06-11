package com.pk.rentflat.controller.dto.offers;

import com.pk.rentflat.controller.dto.building.BuildingResponse;
import com.pk.rentflat.controller.dto.customers.CustomerDetailsResponse;
import com.pk.rentflat.controller.dto.reviews.ReviewsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OffersResponse {

    private Integer id;

    private String city;

    private String streetAddress;

    private String postalCode;

    private Float price;

    private Integer area;

    private Integer roomCount;

    private String marketType;

    private String description;

    private String district;

    private byte[] mainPicture;

    private List<byte[]> allPictures;

    private BuildingResponse buildingResponse;

    private List<ReviewsResponse> reviewsResponse;

    private CustomerDetailsResponse owner;

    private Integer buildingDetails;

    private LocalDate availableFrom;

    private LocalDate availableUntil;

}
