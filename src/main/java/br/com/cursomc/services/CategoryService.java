package br.com.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Category;
import br.com.cursomc.repositories.CategoryRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category findOne(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Category> saveAll(List<Category> lista) {
		return this.repository.saveAll(lista);
	}

	public Category insert(Category obj) {
		obj.setId(null);
		return this.repository.save(obj);
	}
}
