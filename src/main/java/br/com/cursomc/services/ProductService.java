package br.com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Product;
import br.com.cursomc.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product findOne(Integer id) {
		Optional<Product> obj = this.repository.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
		
	}

	public List<Product> saveAll(List<Product> lista) {
		return this.repository.saveAll(lista);
	}
}
