package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
