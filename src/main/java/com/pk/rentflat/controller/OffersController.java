package com.pk.rentflat.controller;

import com.pk.rentflat.controller.dto.offers.OffersResponse;
import com.pk.rentflat.converter.offers.OffersConverter;
import com.pk.rentflat.service.offers.OffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/offers")
@CrossOrigin(origins = "*")
public class OffersController {

    private final OffersService offersService;

    @GetMapping
    public List<OffersResponse> getAllOffers() {
        return OffersConverter.convertOffersListToOffersResponseList(offersService.getAllOffers());
    }


}
