package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
