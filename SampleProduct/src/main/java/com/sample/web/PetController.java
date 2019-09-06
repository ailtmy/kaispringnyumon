package com.sample.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.web.Dao.PetDao;
import com.sample.web.domain.Pet;

@Controller
public class PetController {

	@Autowired
	private PetDao dao;

	@RequestMapping("/pet")
	public String showAllPets(Model model) {
		List<Pet> pets = dao.findAll();
		model.addAttribute("pets", pets);
		return "pet/list";
	}

	@RequestMapping("/pet/{id}")
	public String showpet(@RequestParam("id") int id,
			Model model) {
		Optional<Pet> pet = dao.findById(id);
		model.addAttribute("pet", pet);
		return "pet/detail";
	}
}
