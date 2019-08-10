package com.nissan.geoTaggy.service;

import java.util.List;

import com.nissan.geoTaggy.dto.user.UserCreateRequestDTO;
import com.nissan.geoTaggy.dto.user.UserDTO;
import com.nissan.geoTaggy.dto.user.UserResponseDTO;



public interface UserService {
	void createUser(UserCreateRequestDTO user) throws Exception;
	List<UserResponseDTO> getAllUsers() throws Exception;
	UserDTO getUser(Long userId) throws Exception;

}
