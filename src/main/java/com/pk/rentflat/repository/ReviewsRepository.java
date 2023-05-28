package com.pk.rentflat.repository;


import com.pk.rentflat.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Integer>{

    List<Reviews> findAllByOfferId(Integer offerId);

}
