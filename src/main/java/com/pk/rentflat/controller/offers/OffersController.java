package com.pk.rentflat.controller.offers;

import com.pk.rentflat.controller.dto.offers.OffersResponse;
import com.pk.rentflat.converter.offers.OffersConverter;
import com.pk.rentflat.model.Offers;
import com.pk.rentflat.service.building.BuildingService;
import com.pk.rentflat.service.offers.OffersService;
import com.pk.rentflat.service.reviews.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/offers")
@CrossOrigin(origins = "*")
public class OffersController {

    private final OffersService offersService;

    private final ReviewsService reviewsService;

    private final BuildingService buildingService;

    @GetMapping
    public List<OffersResponse> getAllOffers() {
        return OffersConverter.convertOffersListToOffersResponseList(offersService.getAllOffers());
    }

    @GetMapping("/{id}")
    public OffersResponse getOfferById(@PathVariable Integer id) {
        Offers offer = offersService.getOfferById(id);
        return OffersConverter.convertOffersToOffersResponseWithReviewsAndBuilding(
                offer,
                reviewsService.getOfferReviews(offer.getId()),
                buildingService.getBuilding(offer.getBuildingDetails())
        );
    }

}
