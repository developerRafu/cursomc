package br.com.cursomc.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.ItemPedido;
import br.com.cursomc.domain.PaymentWithTicket;
import br.com.cursomc.domain.Pedido;
import br.com.cursomc.domain.enums.PaymentStatus;
import br.com.cursomc.repositories.ItemPedidoRepository;
import br.com.cursomc.repositories.PaymentRepository;
import br.com.cursomc.repositories.PedidoRepository;
import br.com.cursomc.repositories.ProductRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public Pedido findOne(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Pedido> saveAll(List<Pedido> lista) {
		return this.repository.saveAll(lista);
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstant(new Date());
		obj.getPagamento().setStatus(PaymentStatus.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PaymentWithTicket) {
			PaymentWithTicket pag = (PaymentWithTicket) obj.getPagamento();
			this.boletoService.preencher(pag, obj.getInstant());
		}
		obj = this.repository.save(obj);
		this.paymentRepository.save(obj.getPagamento());
		
		for(ItemPedido ip : obj.getItems()) {
			ip.setDesconto(0.0);
			ip.setPreco(productRepository.findById(ip.getProduto().getId()));
			ip.setPedido(obj);
		}
		ItemPedidoRepository.save(obj.getItems());
		return obj;
	}
}
