package br.com.cursomc.resource;

import java.net.URI;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import br.com.cursomc.domain.Client;
import br.com.cursomc.domain.dto.ClientDTO;
import br.com.cursomc.domain.dto.ClientNewDto;
import br.com.cursomc.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	@Autowired
	private ClientService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findeById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(this.service.find(id));
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok()
				.body(this.service.findAll().stream().map(c -> new ClientDTO(c)).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ClientNewDto objNewDto) {
		Client obj = this.service.fromDTO(objNewDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody ClientDTO objDto, @PathVariable Integer id) {
		Client obj = this.service.fromDTO(objDto);
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
				.map(c -> new ClientDTO(c)));
	}
}
