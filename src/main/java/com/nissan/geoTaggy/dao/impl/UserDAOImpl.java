package com.nissan.geoTaggy.dao.impl;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.geoTaggy.dao.UserDAO;
import com.nissan.geoTaggy.persistence.entities.LocationEntity;
import com.nissan.geoTaggy.persistence.entities.UserEntity;
import com.nissan.geoTaggy.repository.LocationRepository;
import com.nissan.geoTaggy.repository.UserRepository;

@Service
public class UserDAOImpl implements UserDAO {

	@Autowired
	UserRepository userRepository;

	@Autowired
	LocationRepository locationRepository;

	@Override
	public void save(String firstName, String lastName) throws Exception {
		UserEntity userEntity = new UserEntity(firstName, lastName);
		userRepository.save(userEntity);
	}

	@Override
	public List<UserEntity> findAll() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findById(Long userId) throws Exception {
		UserEntity user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(userId.toString()));
		List<LocationEntity> locations = locationRepository.findByUserId(userId);
		user.setLocations(new HashSet<LocationEntity>(locations));

		return user;

	}

}
