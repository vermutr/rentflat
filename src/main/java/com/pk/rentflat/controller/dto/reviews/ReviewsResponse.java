package com.pk.rentflat.controller.dto.reviews;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsResponse {

    private Integer id;

    private String title;

    private Integer grade;

    private String content;

    private Integer offerId;

}
