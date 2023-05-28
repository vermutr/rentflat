package com.pk.rentflat.service.reviews;

import com.pk.rentflat.model.Reviews;

import java.util.List;

public interface ReviewsService {

    List<Reviews> getOfferReviews(Integer offerId);

}
