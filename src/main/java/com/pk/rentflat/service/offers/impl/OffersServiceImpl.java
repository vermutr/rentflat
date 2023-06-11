package com.pk.rentflat.service.offers.impl;

import com.pk.rentflat.config.security.util.SecurityUtil;
import com.pk.rentflat.model.Offers;
import com.pk.rentflat.repository.OffersRepository;
import com.pk.rentflat.service.customerdetails.CustomerDetailsService;
import com.pk.rentflat.service.offers.OffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffersServiceImpl implements OffersService {

    private final OffersRepository offersRepository;

    private final CustomerDetailsService customerDetailsService;

    @Override
    public List<Offers> getAllOffers() {
        return offersRepository.findAll();
    }

    @Override
    public Offers getOfferById(Integer id) {
        return offersRepository.getReferenceById(id);
    }

    @Override
    public List<Offers> getAllOffersByCustomerId() {
        return offersRepository.findAllByCustomerDetailsId(SecurityUtil.getCustomerId());
    }

    @Override
    public Offers saveOffer(Offers offer) {
        offer.setCustomerDetails(
                customerDetailsService.getCustomerDetails(SecurityUtil.getCustomerId())
        );

        return offersRepository.save(offer);
    }

    @Override
    public Offers updateOffer(Offers offer) {
        Offers referenceById = offersRepository.getReferenceById(offer.getId());
        updateOldOffer(referenceById, offer);
        return offersRepository.save(referenceById);
    }

    @Override
    public void deleteOffer(Integer id) {
        offersRepository.deleteById(id);
    }

    private void updateOldOffer(Offers oldOffer, Offers newOffer) {
        oldOffer.setCity(newOffer.getCity());
        oldOffer.setStreetAddress(newOffer.getStreetAddress());
        oldOffer.setPostalCode(newOffer.getPostalCode());
        oldOffer.setPrice(newOffer.getPrice());
        oldOffer.setArea(newOffer.getArea());
        oldOffer.setRoomCount(newOffer.getRoomCount());
        oldOffer.setMarketType(newOffer.getMarketType());
        oldOffer.setDescription(newOffer.getDescription());
        oldOffer.setDistrict(newOffer.getDistrict());
        oldOffer.setMainPicture(newOffer.getMainPicture());
        oldOffer.setAllPictures(newOffer.getAllPictures());
        oldOffer.setBuildingDetails(newOffer.getBuildingDetails());
        oldOffer.setAvailableUntil(newOffer.getAvailableUntil());
        oldOffer.setAvailableFrom(newOffer.getAvailableFrom());
    }


}
