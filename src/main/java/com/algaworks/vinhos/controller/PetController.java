package com.algaworks.vinhos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.vinhos.model.EspecieAnimal;
import com.algaworks.vinhos.model.Pet;
import com.algaworks.vinhos.model.TipoVinho;
import com.algaworks.vinhos.model.Vinho;
import com.algaworks.vinhos.repository.Pets;

@Controller
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private Pets pets;
	
	@GetMapping("/novo")
	public ModelAndView novo(Pet pet) {
		ModelAndView modelAndView = new ModelAndView("pets/cadastro-pet");
		
		modelAndView.addObject(pet);
		modelAndView.addObject("especie", EspecieAnimal.values());
		
		return modelAndView ;
	}
	

	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(pets.findOne(id)); 
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Pet pet, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(pet);
		}
		
		pets.save(pet);
		
		attributes.addFlashAttribute("mensagem", "Pet salvo com sucesso!");
		
		return new ModelAndView("redirect:/pets/novo");
	}
	
	@GetMapping
	public ModelAndView listarVinhos() {
		ModelAndView modelAndView =  new ModelAndView("pets/lista-pets");
		modelAndView.addObject("vinhos", pets.findAll());
		
		return modelAndView;
	}
	
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		pets.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Pet removido com sucesso!");
		
		return "redirect:/pets";
		
	}
}
