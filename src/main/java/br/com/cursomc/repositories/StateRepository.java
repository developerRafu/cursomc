package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.State;

public interface StateRepository extends JpaRepository<State, Integer>{

}
