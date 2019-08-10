package com.nissan.geoTaggy.dao;

import java.util.List;

import com.nissan.geoTaggy.persistence.entities.UserEntity;



public interface UserDAO {
	  List<UserEntity> findAll() throws Exception;
	  void save(String firstName, String lastName) throws Exception;
	  UserEntity findById(Long userId) throws Exception;
}
