package com.pk.rentflat.service.building;

import com.pk.rentflat.model.Building;

public interface BuildingService {

    Building getBuilding(Integer id);

    Building saveBuilding(Building building);

}
