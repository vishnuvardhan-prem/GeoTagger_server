package com.nissan.geoTaggy.dao.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.geoTaggy.dao.LocationDAO;
import com.nissan.geoTaggy.persistence.entities.LocationEntity;
import com.nissan.geoTaggy.persistence.entities.UserEntity;
import com.nissan.geoTaggy.repository.LocationRepository;
import com.nissan.geoTaggy.repository.UserRepository;

@Service
public class LocationDAOImpl implements LocationDAO {

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(Long userId, String locationName, double latitude, double longitude) throws Exception {

		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(() -> new EntityNotFoundException(userId.toString()));

		LocationEntity locationEntity = new LocationEntity(locationName, latitude, longitude, userEntity);
		locationRepository.save(locationEntity);

	}

	@Override
	public void update(Long locationId, String locationName, double latitude, double longitude) throws Exception {

		LocationEntity locationEntity = locationRepository.findById(locationId)
				.orElseThrow(() -> new EntityNotFoundException(locationId.toString()));

		if(locationName != null) {
			locationEntity.setName(locationName);
		}
		if(latitude != 0.0) {
			locationEntity.setLatitude(latitude);
		}
		if(longitude != 0.0) {
		locationEntity.setLongitude(longitude);
		}

		locationRepository.save(locationEntity);
	}

	@Override
	public void deleteById(long locationId) throws Exception {

		locationRepository.deleteById(locationId);

	}

}
