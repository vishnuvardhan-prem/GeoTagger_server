package com.nissan.geoTaggy.dao;

public interface LocationDAO {
	void save(Long userId, String locationName, double latitude, double longitude) throws Exception;

	void update(Long locationId, String locationName, double latitude, double longitude) throws Exception;

	void deleteById(long locationId) throws Exception;
}
