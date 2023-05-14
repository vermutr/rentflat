package com.pk.rentflat.service.offers.impl;

import com.pk.rentflat.model.Offers;
import com.pk.rentflat.repository.OffersRepository;
import com.pk.rentflat.service.offers.OffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffersServiceImpl implements OffersService {

    private final OffersRepository offersRepository;

    @Override
    public List<Offers> getAllOffers() {
        return offersRepository.findAll();
    }

}
