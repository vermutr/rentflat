package com.pk.rentflat.service.offers;

import com.pk.rentflat.model.Offers;

import java.util.List;

public interface OffersService {

    List<Offers> getAllOffers();

    Offers getOfferById(Integer id);

    List<Offers> getAllOffersByCustomerId();

}
