package com.pk.rentflat.controller.dto.building;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildingResponse {

    private Integer id;

    private String buildingType;

    private Integer floorCount;

    private LocalDateTime constructionDate;

}
