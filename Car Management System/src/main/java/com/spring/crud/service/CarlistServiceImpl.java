package com.spring.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.model.dto.CarlistDTO;
import com.spring.crud.model.entity.Carlist;
import com.spring.crud.repository.CarlistRepository;

@Service
public class CarlistServiceImpl implements CarlistService {

	@Autowired
	private CarlistRepository carlistRepository;

	@Override
	public List<CarlistDTO> getAllCarlist() {
		List<Carlist> carlists = carlistRepository.findAll();
		return carlists.stream().map(empl -> copyCarlistEntityToDto(empl)).collect(Collectors.toList());
	}

	@Override
	public void saveCarlist(CarlistDTO carlistDTO) {
		carlistRepository.save(copyCarlistDtoToEntity(carlistDTO));
	}

	@Override
	public CarlistDTO getCarlistById(long id) {
		Optional<Carlist> optional = carlistRepository.findById(id);
		CarlistDTO carlistDTO = null;
		if (optional.isPresent()) {
			carlistDTO = copyCarlistEntityToDto(optional.get());
		} else {
			throw new RuntimeException(" Carlist not found for id :: " + id);
		}
		return carlistDTO;
	}

	@Override
	public void deleteCarlistById(long id) {
		this.carlistRepository.deleteById(id);
	}

	public Carlist copyCarlistDtoToEntity(CarlistDTO carlistDTO) {
		Carlist carlist = new Carlist();
		BeanUtils.copyProperties(carlistDTO, carlist);
		return carlist;
	}

	public CarlistDTO copyCarlistEntityToDto(Carlist carlist) {
		CarlistDTO carlistDTO = new CarlistDTO();
		BeanUtils.copyProperties(carlist, carlistDTO);
		return carlistDTO;
	}

}
