package com.pk.rentflat.controller.dto.offers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OffersRequest {

    private String id;

    private String city;

    private String streetAddress;

    private String postalCode;

    private Float price;

    private Integer area;

    private Integer roomCount;

    private String marketType;

    private String description;

    private String district;

    private Integer buildingDetails;

    private LocalDate availableFrom;

    private LocalDate availableUntil;

}
