package com.pk.rentflat.controller.dto.offers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OffersFilter {

    private String city;

    private String streetAddress;

    private String postalCode;

    private Float priceFrom;

    private Float priceTo;

    private Integer areaFrom;

    private Integer areaTo;

    private Integer roomCountFrom;

    private Integer roomCountTo;

    private String marketType;

    private String district;

    private LocalDateTime availableFrom;

    private LocalDateTime availableUntil;

    private Pageable pageable;

}
