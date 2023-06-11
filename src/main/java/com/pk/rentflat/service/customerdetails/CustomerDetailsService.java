package com.pk.rentflat.service.customerdetails;

import com.pk.rentflat.model.CustomerDetails;

public interface CustomerDetailsService {

    CustomerDetails saveCustomerDetails(CustomerDetails customerDetails);

    CustomerDetails getCustomerDetails(Integer id);

}
