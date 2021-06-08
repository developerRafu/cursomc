package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
