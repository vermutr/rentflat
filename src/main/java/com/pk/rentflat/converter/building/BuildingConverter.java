package com.pk.rentflat.converter.building;

import com.pk.rentflat.controller.dto.building.BuildingRequest;
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
        buildingResponse.setName(building.getName());
        return buildingResponse;
    }

    public static Building convertBuildingRequestToBuilding(BuildingRequest buildingRequest) {
        Building building = new Building();
        building.setBuildingType(buildingRequest.getBuildingType());
        building.setFloorCount(buildingRequest.getFloorCount());
        building.setName(buildingRequest.getName());
        return building;
    }

}
