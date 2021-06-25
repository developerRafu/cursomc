package br.com.cursomc.resource;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursomc.domain.AvisoPendente;

@RestController
@RequestMapping("/avisos")
public class Aviso {
	
	@GetMapping
	public ResponseEntity<?> find(){
		AvisoPendente aviso = new AvisoPendente();
		return ResponseEntity.ok(Arrays.asList(aviso));
	}
}
