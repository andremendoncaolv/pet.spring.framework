package com.algaworks.vinhos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.vinhos.model.Pet;

public interface Pets extends JpaRepository<Pet, Long> {

}
