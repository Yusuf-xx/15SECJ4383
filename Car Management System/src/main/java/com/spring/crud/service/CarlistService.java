package com.spring.crud.service;

import java.util.List;

import com.spring.crud.model.dto.CarlistDTO;

public interface CarlistService {
	
	List<CarlistDTO> getAllCarlist();

	void saveCarlist(CarlistDTO carlistDTO);

	CarlistDTO getCarlistById(long id);

	void deleteCarlistById(long id);
}
