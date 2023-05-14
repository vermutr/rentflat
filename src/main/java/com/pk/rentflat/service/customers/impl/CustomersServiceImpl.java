package com.pk.rentflat.service.customers.impl;

import com.pk.rentflat.model.Customers;
import com.pk.rentflat.repository.CustomersRepository;
import com.pk.rentflat.service.customers.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomersServiceImpl implements CustomersService {

    private final CustomersRepository customersRepository;

    @Override
    public Customers getCustomerByEmail(String email) {
        return customersRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public Customers saveCustomer(Customers customer) {
        return customersRepository.save(customer);
    }

}
