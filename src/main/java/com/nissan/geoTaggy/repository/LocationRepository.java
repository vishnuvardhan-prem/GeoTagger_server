package com.nissan.geoTaggy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.geoTaggy.persistence.entities.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long>{
    
	List<LocationEntity> findByUserId(long id);
}
