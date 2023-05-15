package com.pk.rentflat.service.building.impl;

import com.pk.rentflat.model.Building;
import com.pk.rentflat.repository.BuildingRepository;
import com.pk.rentflat.service.building.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;
}
