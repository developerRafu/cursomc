package br.com.cursomc.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursomc.domain.Pedido;
import br.com.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findeById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(this.service.findOne(id));
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Pedido obj){
		obj = this.service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.ok(null);
	}
}
