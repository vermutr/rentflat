package com.pk.rentflat.service.reviews.impl;


import com.pk.rentflat.model.Reviews;
import com.pk.rentflat.repository.ReviewsRepository;
import com.pk.rentflat.service.reviews.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;

    @Override
    public List<Reviews> getOfferReviews(Integer offerId) {
        return reviewsRepository.findAllByOfferId(offerId);
    }

}
