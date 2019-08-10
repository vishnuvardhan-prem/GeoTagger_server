package com.nissan.geoTaggy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.geoTaggy.dto.common.ErrorCodeResponse;
import com.nissan.geoTaggy.dto.location.LocationRequestDTO;
import com.nissan.geoTaggy.dto.user.UserCreateRequestDTO;
import com.nissan.geoTaggy.dto.user.UserDTO;
import com.nissan.geoTaggy.dto.user.UserResponseDTO;
import com.nissan.geoTaggy.service.LocationService;
import com.nissan.geoTaggy.service.UserService;
import com.nissan.geoTaggy.utility.GlobalConstants;

@RestController
@RequestMapping(GlobalConstants.USER_API_PATH)
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired 
	LocationService locationService;	
	
	
	@PostMapping("")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateRequestDTO user) {

		try {
			userService.createUser(user);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ErrorCodeResponse(ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<?> getUsers() {
		List<UserResponseDTO> userList;
		
		try {
			userList = userService.getAllUsers();
		} catch (Exception ex) {
			return new ResponseEntity<>(new ErrorCodeResponse(ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(userList);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUser(@PathVariable Long userId) {
		UserDTO userInfo;
		
		try {
			userInfo = userService.getUser(userId);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ErrorCodeResponse(ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(userInfo);
	}
	
	@PostMapping("/{userId}/location")
	public ResponseEntity<?> addLocation(@PathVariable("userId") long userId,
										@Valid @RequestBody ArrayList<LocationRequestDTO> locationRequestDTOs) {

		try {
			locationService.addLocation(userId, locationRequestDTOs);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ErrorCodeResponse(ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}


}
