package com.pk.rentflat.controller.building;

import com.pk.rentflat.controller.dto.building.BuildingRequest;
import com.pk.rentflat.controller.dto.building.BuildingResponse;
import com.pk.rentflat.converter.building.BuildingConverter;
import com.pk.rentflat.service.building.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/building")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BuildingController {

    private final BuildingService buildingService;

    @PostMapping
    public BuildingResponse saveBuilding(@RequestBody BuildingRequest buildingRequest) {
        return BuildingConverter.convertBuildingToBuildingResponse(
                buildingService.saveBuilding(BuildingConverter.convertBuildingRequestToBuilding(buildingRequest))
        );
    }

}
