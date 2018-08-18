package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.Pet;

@Repository("petRepository")
public interface PetsRepository extends JpaRepository<Pet, Long> {
	Pet findById(Long id);
}
