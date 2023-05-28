package com.pk.rentflat.controller.dto.building;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuildingRequest {

    private String name;

    private String buildingType;

    private Integer floorCount;

}
