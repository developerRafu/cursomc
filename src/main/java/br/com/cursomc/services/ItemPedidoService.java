package br.com.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.ItemPedido;
import br.com.cursomc.repositories.ItemPedidoRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository repository;

	public ItemPedido findOne(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<ItemPedido> saveAll(List<ItemPedido> lista) {
		return this.repository.saveAll(lista);
	}
}
