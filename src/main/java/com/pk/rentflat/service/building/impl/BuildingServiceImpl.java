package com.pk.rentflat.service.building.impl;

import com.pk.rentflat.model.Building;
import com.pk.rentflat.repository.BuildingRepository;
import com.pk.rentflat.service.building.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    @Override
    public Building getBuilding(Integer id) {
        return buildingRepository.getReferenceById(id);
    }

    @Override
    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }
}
