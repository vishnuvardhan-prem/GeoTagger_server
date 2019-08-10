package com.nissan.geoTaggy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.geoTaggy.dto.common.ErrorCodeResponse;
import com.nissan.geoTaggy.dto.location.LocationRequestDTO;
import com.nissan.geoTaggy.service.LocationService;
import com.nissan.geoTaggy.utility.GlobalConstants;

@RestController
@RequestMapping(GlobalConstants.LOCATION_API_PATH)
public class LocationController {
	
	@Autowired 
	LocationService locationService;	
	
	@PutMapping("/{locationId}")
	public ResponseEntity<?> updateLocation(@PathVariable long locationId,
											@Valid @RequestBody LocationRequestDTO locationRequestDTO){
		try {
			locationService.updateLocation(locationId, locationRequestDTO);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ErrorCodeResponse(ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{locationId}")
	public ResponseEntity<?> deleteLocation(@PathVariable long locationId){
		
		try {
			locationService.deleteLocationById(locationId);
		} catch (Exception ex){
			return new ResponseEntity<>(new ErrorCodeResponse(ex.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return ResponseEntity.noContent().build();
	}

}
