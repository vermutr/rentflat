package com.pk.rentflat.service.customerdetails;

import com.pk.rentflat.model.CustomerDetails;

public interface CustomerDetailsService {

    CustomerDetails getCustomerDetailsById(Integer id);

    CustomerDetails saveCustomerDetails(CustomerDetails customerDetails);

    void deleteCustomerDetailsById(Integer id);

    CustomerDetails updateCustomerDetailsById(CustomerDetails customerDetails, Integer id);
}
