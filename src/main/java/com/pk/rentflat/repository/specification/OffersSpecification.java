package com.pk.rentflat.repository.specification;

import com.pk.rentflat.controller.dto.offers.OffersFilter;
import com.pk.rentflat.model.Offers;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class OffersSpecification implements Specification<Offers> {

    private final OffersFilter offersFilter;

    @Override
    public Predicate toPredicate(Root<Offers> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new LinkedList<>();
        if (Objects.nonNull(offersFilter.getCity())) {
            predicates.add(criteriaBuilder.equal(root.get("city"), offersFilter.getCity()));
        }

        if (Objects.nonNull(offersFilter.getStreetAddress())) {
            predicates.add(criteriaBuilder.equal(root.get("streetAddress"), offersFilter.getStreetAddress()));
        }

        if (Objects.nonNull(offersFilter.getPostalCode())) {
            predicates.add(criteriaBuilder.equal(root.get("postalCode"), offersFilter.getPostalCode()));
        }

        if (Objects.nonNull(offersFilter.getMarketType())) {
            predicates.add(criteriaBuilder.equal(root.get("marketType"), offersFilter.getMarketType()));
        }

        if (Objects.nonNull(offersFilter.getDistrict())) {
            predicates.add(criteriaBuilder.equal(root.get("district"), offersFilter.getDistrict()));
        }

        if (Objects.nonNull(offersFilter.getAvailableFrom())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("availableFrom"),
                    offersFilter.getAvailableFrom()));
        }

        if (Objects.nonNull(offersFilter.getAvailableUntil())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("availableUntil"),
                    offersFilter.getAvailableUntil()));
        }

        if (Objects.nonNull(offersFilter.getAreaFrom()) && Objects.nonNull(offersFilter.getAreaTo())) {
            predicates.add(criteriaBuilder.between(root.get("area"), offersFilter.getAreaFrom(), offersFilter.getAreaTo()));
        } else if (Objects.nonNull(offersFilter.getAreaFrom())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("area"), offersFilter.getAreaFrom()));
        } else if (Objects.nonNull(offersFilter.getAreaTo())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("area"), offersFilter.getAreaTo()));
        }

        if (Objects.nonNull(offersFilter.getPriceFrom()) && Objects.nonNull(offersFilter.getPriceTo())) {
            predicates.add(criteriaBuilder.between(root.get("price"), offersFilter.getPriceFrom(), offersFilter.getPriceTo()));
        } else if (Objects.nonNull(offersFilter.getPriceFrom())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), offersFilter.getPriceFrom()));
        } else if (Objects.nonNull(offersFilter.getPriceTo())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), offersFilter.getPriceTo()));
        }

        if (Objects.nonNull(offersFilter.getRoomCountFrom()) && Objects.nonNull(offersFilter.getRoomCountTo())) {
            predicates.add(criteriaBuilder.between(root.get("roomCount"), offersFilter.getRoomCountFrom(), offersFilter.getRoomCountTo()));
        } else if (Objects.nonNull(offersFilter.getRoomCountFrom())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("roomCount"), offersFilter.getRoomCountFrom()));
        } else if (Objects.nonNull(offersFilter.getRoomCountTo())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("roomCount"), offersFilter.getRoomCountTo()));
        }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }
    }
