package com.pk.rentflat.service.customers;

import com.pk.rentflat.model.Customers;

public interface CustomersService {

    Customers getCustomerByEmail(String email);

    Customers saveCustomer(Customers customer);

}
