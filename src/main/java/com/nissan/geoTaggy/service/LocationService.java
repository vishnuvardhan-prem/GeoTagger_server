package com.nissan.geoTaggy.service;

import java.util.ArrayList;

import com.nissan.geoTaggy.dto.location.LocationRequestDTO;

public interface LocationService {
     void addLocation(long userId, ArrayList<LocationRequestDTO> locations) throws Exception;

	 void updateLocation(long locationId, LocationRequestDTO location) throws Exception;

	 void deleteLocationById(long locationId) throws Exception;
}
