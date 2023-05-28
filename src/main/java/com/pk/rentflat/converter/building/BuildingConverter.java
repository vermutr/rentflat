package com.pk.rentflat.converter.building;

import com.pk.rentflat.controller.dto.building.BuildingResponse;
import com.pk.rentflat.model.Building;

public class BuildingConverter {

    private BuildingConverter() {

    }

    public static BuildingResponse convertBuildingToBuildingResponse(Building building) {
        BuildingResponse buildingResponse = new BuildingResponse();
        buildingResponse.setId(building.getId());
        buildingResponse.setBuildingType(building.getBuildingType());
        buildingResponse.setFloorCount(building.getFloorCount());
        buildingResponse.setConstructionDate(building.getConstructionDate());
        return buildingResponse;
    }

}
