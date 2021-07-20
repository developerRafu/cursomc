package br.com.cursomc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Category;
import br.com.cursomc.domain.Product;
import br.com.cursomc.repositories.CategoryRepository;
import br.com.cursomc.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;

	public Product findOne(Integer id) {
		Optional<Product> obj = this.repository.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;

	}

	public List<Product> saveAll(List<Product> lista) {
		return this.repository.saveAll(lista);
	}

	public Page<Product> search(String nome, List<Integer> ids, int pageIndex) {
		PageRequest page = PageRequest.of(pageIndex, 10);
		List<Category> categories = this.categoryRepository.findAllById(ids);
		ids = categories.stream().map(x -> x.getId()).collect(Collectors.toList());
		if (ids.isEmpty()) {
			return this.repository.search(nome, null, page);
		}
		return this.repository.search(nome, ids, page);
	}
}
