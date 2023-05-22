package com.pk.rentflat.service.building;

import com.pk.rentflat.model.Building;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface BuildingService {

    Building getBuildingById(Integer buildingId);

    Building saveBuilding(Building building);

    void deleteBuildingById(Integer buildingId);

    Building updateBuildingById(Building building, Integer buildingId);
}
