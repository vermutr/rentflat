package com.pk.rentflat.service.auth.impl;

import com.pk.rentflat.config.security.JwtService;
import com.pk.rentflat.controller.dto.auth.AuthenticationRequest;
import com.pk.rentflat.controller.dto.auth.AuthenticationResponse;
import com.pk.rentflat.controller.dto.auth.RegisterRequest;
import com.pk.rentflat.model.CustomerDetails;
import com.pk.rentflat.model.Customers;
import com.pk.rentflat.model.Role;
import com.pk.rentflat.service.auth.AuthenticationService;
import com.pk.rentflat.service.customerdetails.CustomerDetailsService;
import com.pk.rentflat.service.customers.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final CustomersService customersService;

    private final CustomerDetailsService customerDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        int customerNumber = ThreadLocalRandom.current().nextInt(1, 100000);
        Customers customers = Customers
                .builder()
                .email(request.getEmail())
                .customerNumber(customerNumber)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        CustomerDetails customerDetails = CustomerDetails
                .builder()
                .name(request.getName())
                .surname(request.getSurname())
                .city(request.getCity())
                .phoneNumber(request.getPhoneNumber())
                .postalCode(request.getPostalCode())
                .streetAddress(request.getStreetAddress())
                .customerNumber(customerNumber)
                .isAdmin(false)
                .build();

        customerDetailsService.saveCustomerDetails(customerDetails);

        customersService.saveCustomer(customers);

        String jwtToken = jwtService.generateToken(customers);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
                  request.getEmail(),
                  request.getPassword()
          )
        );

        Customers customers = customersService.getCustomerByEmail(request.getEmail());
        String jwtToken = jwtService.generateToken(customers);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
