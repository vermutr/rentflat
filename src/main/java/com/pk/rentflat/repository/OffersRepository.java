package com.pk.rentflat.repository;

import com.pk.rentflat.model.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Integer>, JpaSpecificationExecutor<Offers> {

    List<Offers> findAllByCustomerDetailsId(Integer id);

}
