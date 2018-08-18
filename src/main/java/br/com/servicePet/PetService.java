package br.com.servicePet;

import java.util.List;

import br.com.model.Pet;

public interface PetService {
	public Pet findId(Long id);
	public void save (Pet pets);
	public void delete(Long id);
	public List<Pet> findAll();
}
