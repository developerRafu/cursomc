package br.com.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cursomc.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("SELECT DISTINCT p FROM Product p "
			+ "INNER JOIN p.categories cat "
			+ "WHERE 1=1 "
			+ "AND (:nome IS NULL OR p.name LIKE %:nome%) "
			+ "AND (COALESCE(:categories, NULL) IS NULL OR cat.id IN :categories)")
	Page<Product> search(@Param(value="nome") String nome, @Param(value="categories") List<Integer> list, Pageable page);
}
