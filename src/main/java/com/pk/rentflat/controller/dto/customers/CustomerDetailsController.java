package com.pk.rentflat.controller.dto.customers;


import com.pk.rentflat.converter.customerdetails.CustomerDetailsConverter;
import com.pk.rentflat.model.CustomerDetails;
import com.pk.rentflat.service.customerdetails.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer_details")
@CrossOrigin(origins = "*")
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;

    @GetMapping
    public CustomerDetailsResponse getCustomerDetailsById(Integer id) {
        return CustomerDetailsConverter.convertCustomerDetailsToCustomerDetailsResponse(customerDetailsService.getCustomerDetailsById(id));
    }

    @PostMapping
    public CustomerDetailsResponse saveCustomerDetails(CustomerDetails customerDetails) {
        return CustomerDetailsConverter.convertCustomerDetailsToCustomerDetailsResponse(customerDetailsService.saveCustomerDetails(customerDetails));
    }

    @DeleteMapping
    void deleteCustomerDetailsById(Integer id) {
        customerDetailsService.deleteCustomerDetailsById(id);
    }

    @PutMapping
    public CustomerDetailsResponse updateCustomerDetailsById(CustomerDetails customerDetails, Integer id) {
        return CustomerDetailsConverter.convertCustomerDetailsToCustomerDetailsResponse(customerDetailsService.updateCustomerDetailsById(customerDetails, id));
    }
}
