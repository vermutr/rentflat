package com.pk.rentflat.converter.customerdetails;


import com.pk.rentflat.controller.dto.customers.CustomerDetailsResponse;
import com.pk.rentflat.model.CustomerDetails;


public class CustomerDetailsConverter {

    private CustomerDetailsConverter() {

    }

    public static CustomerDetailsResponse convertCustomerDetailsToCustomerDetailsResponse(CustomerDetails customerDetails) {
        CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();
        customerDetailsResponse.setId(customerDetails.getId());
        customerDetailsResponse.setName(customerDetails.getName());
        customerDetailsResponse.setSurname(customerDetails.getSurname());
        customerDetailsResponse.setPhoneNumber(customerDetails.getPhoneNumber());
        customerDetailsResponse.setCity(customerDetails.getCity());
        customerDetailsResponse.setStreetAddress(customerDetailsResponse.getStreetAddress());
        customerDetailsResponse.setPostalCode(customerDetails.getPostalCode());
        customerDetailsResponse.setIsAdmin(customerDetails.getIsAdmin());
        customerDetailsResponse.setCustomerNumber(customerDetails.getCustomerNumber());
        return customerDetailsResponse;
    }

}
