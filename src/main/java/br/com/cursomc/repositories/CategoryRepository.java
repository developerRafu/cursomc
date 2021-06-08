package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
