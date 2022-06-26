package com.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.crud.model.dto.CarlistDTO;
import com.spring.crud.model.entity.Carlist;
import com.spring.crud.service.CarlistService;

@Controller
public class CarlistController {

	@Autowired
	private CarlistService carlistService;

	// display list of cars
	@GetMapping("/")
	public ModelAndView viewHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listcarList", carlistService.getAllCarlist());
		modelAndView.setViewName("index");
		return modelAndView;
	}

	// create model attribute to bind form data
	@GetMapping("/showNewCarlistForm")
	public ModelAndView showNewCarlistForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("carlistDTO", new CarlistDTO());
		modelAndView.setViewName("new_carlist");
		return modelAndView;
	}

	// save car_list to database
	@PostMapping("/saveCarlist")
	public String saveCarlist(@ModelAttribute("carlistDTO") CarlistDTO carlistDTO) {
		carlistService.saveCarlist(carlistDTO);
		return "redirect:/";
	}

	@GetMapping("/showCarlistUpdated/{id}")
	public ModelAndView showCarlistUpdated(@PathVariable(value = "id") long id) {
		ModelAndView modelAndView = new ModelAndView();
		// get car_list from the service
		CarlistDTO carlistDTO = carlistService.getCarlistById(id);

		// set car_list as a model attribute to re-populate the form
		modelAndView.addObject("carlistDTO", carlistDTO);
		modelAndView.setViewName("update_carlist");
		return modelAndView;
	}

	@GetMapping("/deleteCarlist/{id}")
	public String deleteCarlist(@PathVariable(value = "id") long id) {

		// call delete car_list method
		this.carlistService.deleteCarlistById(id);
		return "redirect:/";
	}

}
