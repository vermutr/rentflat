package com.pk.rentflat.service.customerdetails.impl;

import com.pk.rentflat.model.CustomerDetails;
import com.pk.rentflat.repository.CustomerDetailsRepository;
import com.pk.rentflat.service.customerdetails.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;

    @Override
    public CustomerDetails getCustomerDetailsById(Integer id) {
        return customerDetailsRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer details not found!"));
    }

    @Override
    public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails) {
        return customerDetailsRepository.save(customerDetails);
    }

    @Override
    public void deleteCustomerDetailsById(Integer id) {
        customerDetailsRepository.deleteById(id);
    }

    @Override
    public CustomerDetails updateCustomerDetailsById(CustomerDetails customerDetails, Integer id) {
        return customerDetailsRepository.save(customerDetails);
    }

}
