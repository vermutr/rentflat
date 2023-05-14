package com.pk.rentflat.controller.dto.customers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsResponse {

    private Integer id;

    private String name;

    private String surname;

    private String phoneNumber;

    private String city;

    private String streetAddress;

    private String postalCode;

    private Boolean isAdmin = false;

    private Integer customerNumber;
}
