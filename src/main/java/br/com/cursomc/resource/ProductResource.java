package br.com.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursomc.domain.dto.ProductDTO;
import br.com.cursomc.resource.utils.URL;
import br.com.cursomc.services.ProductService;

@RestController
@RequestMapping(value = "products")
public class ProductResource {

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<?> page(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "categories", required = false) String categories,
			@RequestParam(value = "page", required = false) int page) {
		List<Integer> ids = URL.decodeList(categories);
		nome = URL.decodeParam(nome);
		Page<ProductDTO> list = this.service.search(nome, ids, page).map(x -> new ProductDTO(x));
		return ResponseEntity.ok(list);
	}
}
