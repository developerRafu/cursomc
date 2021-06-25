package br.com.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Category;
import br.com.cursomc.domain.dto.CategoryDTO;
import br.com.cursomc.repositories.CategoryRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category find(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Category> saveAll(List<Category> lista) {
		return this.repository.saveAll(lista);
	}

	public Category insert(Category obj) {
		obj.setId(null);
		return this.repository.save(obj);
	}

	public Category update(Category obj) {
		Category newObj = this.find(obj.getId());
		this.updateData(newObj, obj);
		return this.repository.save(obj);
	}

	public void delete(Integer id) {
		this.find(id);
		try {
			this.repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new br.com.cursomc.services.exceptions.DataIntegrityViolationException("Não é possível escluir uma categoria que possui produtos");
		}
	}

	public List<Category> findAll() {
		return this.repository.findAll();
	}
	
	public Page<Category> findPage(Integer page, Integer size){
		PageRequest pageRequest = PageRequest.of(page,size);
		return this.repository.findAll(pageRequest);
	}
	
	public Category fromDTO(CategoryDTO dto) {
		return new Category(dto.getId(),dto.getNome());
	}
	
	private void updateData(Category newObj, Category obj) {
		newObj.setNome(obj.getNome());
	}
}
