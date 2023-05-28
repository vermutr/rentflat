package com.pk.rentflat.service.building.impl;

import com.pk.rentflat.model.Building;
import com.pk.rentflat.repository.BuildingRepository;
import com.pk.rentflat.service.building.BuildingService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    @Override
    public Building getBuildingById(Integer buildingId) {
        return buildingRepository.findById(buildingId).orElseThrow(()-> new RuntimeException("Building not found!"));
    }

    @Override
    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    };

    @Override
    public void deleteBuildingById(Integer buildingId) {
        buildingRepository.deleteById(buildingId);
    };

    @Override
    public Building updateBuildingById(Building building, Integer buildingId) {
        return buildingRepository.save(building);
    };
}
