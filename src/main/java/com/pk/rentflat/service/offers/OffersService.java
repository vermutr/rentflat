package com.pk.rentflat.service.offers;

import com.pk.rentflat.controller.dto.offers.OffersFilter;
import com.pk.rentflat.model.Offers;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OffersService {

    List<Offers> getAllOffers();

    Page<Offers> getAllOffers(OffersFilter offersFilter);

    Offers getOfferById(Integer id);

    List<Offers> getAllOffersByCustomerId();

    Offers saveOffer(Offers offer);

    Offers updateOffer(Offers offer);

    void deleteOffer(Integer id);

}
