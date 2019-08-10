package com.nissan.geoTaggy.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.geoTaggy.dao.LocationDAO;
import com.nissan.geoTaggy.dto.location.LocationRequestDTO;
import com.nissan.geoTaggy.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationDAO locationDAO;

	@Override
	public void addLocation(long userId, ArrayList<LocationRequestDTO> locations) throws Exception {

		for(LocationRequestDTO location : locations) {
			locationDAO.save(userId, location.getName(), location.getLatitude(), location.getLongitude());
		}
		

	}

	@Override
	public void updateLocation(long locationId, LocationRequestDTO location) throws Exception {
		
		locationDAO.update(locationId, location.getName(), location.getLatitude(), location.getLongitude());
	}

	@Override
	public void deleteLocationById(long locationId) throws Exception {
		locationDAO.deleteById(locationId);
		
	}

}
