package com.pk.rentflat.controller.dto.building;


import com.pk.rentflat.converter.building.BuildingConverter;
import com.pk.rentflat.model.Building;
import com.pk.rentflat.service.building.BuildingService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/buildings")
@CrossOrigin(origins = "*")
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping
    public BuildingResponse getBuildingById(Integer buildingId) {
        return BuildingConverter.convertBuildingToBuildingResponse(buildingService.getBuildingById(buildingId));
    }

    @PostMapping
    public BuildingResponse saveBuilding(Building building) {
        return BuildingConverter.convertBuildingToBuildingResponse(buildingService.saveBuilding(building));
    }

    @DeleteMapping
    void deleteBuildingById(Integer buildingId) {
        buildingService.deleteBuildingById(buildingId);
    }

    @PutMapping
    public BuildingResponse updateBuildingById(Building building, Integer buildingId) {
        return BuildingConverter.convertBuildingToBuildingResponse(buildingService.updateBuildingById(building, buildingId));
    }
}
