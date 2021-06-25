package br.com.cursomc.resource;

import java.net.URI;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursomc.domain.Category;
import br.com.cursomc.domain.dto.CategoryDTO;
import br.com.cursomc.services.CategoryService;

@RestController
@RequestMapping(value = "categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findeById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(this.service.find(id));
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok()
				.body(this.service.findAll().stream().map(c -> new CategoryDTO(c)).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CategoryDTO objDto) {
		Category obj = this.service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody CategoryDTO objDto, @PathVariable Integer id) {
		Category obj = this.service.fromDTO(objDto);
		obj.setId(id);
		obj = this.service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value="page")
	public ResponseEntity<?> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size
			){
		return ResponseEntity.ok().body(
				this.service.findPage(page, size)
				.map(c -> new CategoryDTO(c)));
	}
}
