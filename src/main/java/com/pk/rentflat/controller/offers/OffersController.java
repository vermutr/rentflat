package com.pk.rentflat.controller.offers;

import com.pk.rentflat.controller.dto.offers.OffersFilter;
import com.pk.rentflat.controller.dto.offers.OffersRequest;
import com.pk.rentflat.controller.dto.offers.OffersResponse;
import com.pk.rentflat.converter.offers.OffersConverter;
import com.pk.rentflat.model.Offers;
import com.pk.rentflat.service.building.BuildingService;
import com.pk.rentflat.service.offers.OffersService;
import com.pk.rentflat.service.reviews.ReviewsService;
import com.pk.rentflat.utils.PageDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
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

    @GetMapping("/filter")
    public PageDto<OffersResponse> getAllOffersFilter(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String streetAddress,
            @RequestParam(required = false) String postalCode,
            @RequestParam(required = false) Float priceFrom,
            @RequestParam(required = false) Float priceTo,
            @RequestParam(required = false) Integer areaFrom,
            @RequestParam(required = false) Integer areaTo,
            @RequestParam(required = false) Integer roomCountFrom,
            @RequestParam(required = false) Integer roomCountTo,
            @RequestParam(required = false) String marketType,
            @RequestParam(required = false) String district,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(required = false) LocalDate availableFrom,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(required = false) LocalDate availableUntil,
            @RequestParam(required = false, defaultValue = "25") int pageSize,
            @RequestParam(required = false, defaultValue = "0") int pageNumber
    ) {
        OffersFilter offersFilter = OffersFilter
                .builder()
                .city(city)
                .streetAddress(streetAddress)
                .postalCode(postalCode)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .areaFrom(areaFrom)
                .areaTo(areaTo)
                .roomCountFrom(roomCountFrom)
                .roomCountTo(roomCountTo)
                .marketType(marketType)
                .district(district)
                .availableFrom(availableFrom)
                .availableUntil(availableUntil)
                .pageable(PageRequest.of(pageNumber, pageSize))
                .build();

        Page<Offers> allOffers = offersService.getAllOffers(offersFilter);
        List<OffersResponse> offersResponses =
                OffersConverter.convertOffersListToOffersResponseList(allOffers.getContent());
        return new PageDto<>(new PageImpl<>(offersResponses, allOffers.getPageable(),
                allOffers.getTotalElements()));
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

    @GetMapping("/customer")
    public List<OffersResponse> getOfferByCustomerId() {
        return OffersConverter.convertOffersListToOffersResponseList(offersService.getAllOffersByCustomerId());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public OffersResponse saveOffer(@RequestBody OffersRequest offersRequest, @RequestParam(required = false, value = "image") MultipartFile multipartFile) throws IOException {
        Offers offer = offersService.saveOffer(OffersConverter.convertOffersRequestToOffers(offersRequest, multipartFile));
        return OffersConverter.convertOffersRequestToOffers(offer);
    }

    @PutMapping
    public OffersResponse updateOffer(@RequestBody OffersRequest offersRequest, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        Offers offer = offersService.updateOffer(OffersConverter.convertOffersRequestToOffers(offersRequest, multipartFile));
        return OffersConverter.convertOffersRequestToOffers(offer);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Integer id) {
        offersService.deleteOffer(id);
    }


}
