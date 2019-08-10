package com.nissan.geoTaggy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.geoTaggy.dao.UserDAO;
import com.nissan.geoTaggy.dto.user.UserCreateRequestDTO;
import com.nissan.geoTaggy.dto.user.UserDTO;
import com.nissan.geoTaggy.dto.user.UserResponseDTO;
import com.nissan.geoTaggy.persistence.entities.UserEntity;
import com.nissan.geoTaggy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void createUser(UserCreateRequestDTO user) throws Exception {
		userDAO.save(user.getFirstName(), user.getLastName());
	}

	@Override
	public List<UserResponseDTO> getAllUsers() throws Exception {
		List<UserEntity> userEntities = userDAO.findAll();
        List<UserResponseDTO> userResponseDTO = userEntities.stream()
				   									  .map(userEntity -> new UserResponseDTO(userEntity))
				   									  .collect(Collectors.toList());
		return userResponseDTO;
	}

	@Override
	public UserDTO getUser(Long userId) throws Exception {
		UserEntity userEntity = userDAO.findById(userId);
		UserDTO userDTO = new UserDTO(userEntity);	
		return 	userDTO;
	}

}
