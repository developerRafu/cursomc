package br.com.cursomc;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cursomc.domain.Category;
import br.com.cursomc.domain.City;
import br.com.cursomc.domain.Client;
import br.com.cursomc.domain.Endereco;
import br.com.cursomc.domain.ItemPedido;
import br.com.cursomc.domain.Payment;
import br.com.cursomc.domain.PaymentWithCard;
import br.com.cursomc.domain.PaymentWithTicket;
import br.com.cursomc.domain.Pedido;
import br.com.cursomc.domain.Product;
import br.com.cursomc.domain.State;
import br.com.cursomc.domain.enums.ClientType;
import br.com.cursomc.domain.enums.PaymentStatus;
import br.com.cursomc.services.CategoryService;
import br.com.cursomc.services.CityService;
import br.com.cursomc.services.ClientService;
import br.com.cursomc.services.EnderecoService;
import br.com.cursomc.services.ItemPedidoService;
import br.com.cursomc.services.PaymentService;
import br.com.cursomc.services.PedidoService;
import br.com.cursomc.services.ProductService;
import br.com.cursomc.services.StateService;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CityService cityService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private ItemPedidoService itemPedidoService;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Hardware");
		Category c2 = new Category(null, "Livros");
		Category c3 = new Category(null, "Hardware");
		Category c4 = new Category(null, "Livros");
		Category c5 = new Category(null, "Hardware");
		Category c6 = new Category(null, "Livros");
		Category c7 = new Category(null, "Hardware");
		Category c8 = new Category(null, "Livros");
		Category c9 = new Category(null, "Hardware");
		Category c10 = new Category(null, "Livros");
		Category c11 = new Category(null, "Hardware");
		Category c12 = new Category(null, "Livros");
		Product p1 = new Product(null, "RTX 3090", 30000.0);
		Product p2 = new Product(null, "JoJo's Bizarre Adventure", 30.0);
		c1.getProdutos().add(p1);
		c2.getProdutos().add(p2);
		p1.getCategories().add(c1);
		p2.getCategories().add(c2);

		State s1 = new State(null, "Pará");
		State s2 = new State(null, "São Paulo");
		City city1 = new City(null, "Belém", s1);
		City city2 = new City(null, "São Paulo", s2);
		s1.getCities().add(city1);
		s2.getCities().add(city2);

		this.stateService.saveAll(Arrays.asList(s1, s2));
		this.cityService.saveAll(Arrays.asList(city1, city2));
		this.categoryService.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
		this.productService.saveAll(Arrays.asList(p1, p2));

		Client client1 = new Client(null, "Rafu", "fel.rique70@gmail.com", "04649488273", ClientType.PESSOAFISICA);
		client1.getTelefones().add("91983610117");

		Endereco end = new Endereco(null, "Psg. Belo Horizonte", "22", "Quadra A", "Terra Firme", "66077-040", client1,
				city1);
		client1.getEnderecos().add(end);
		clientService.saveAll(Arrays.asList(client1));
		enderecoService.saveAll(Arrays.asList(end));

		Pedido ped1 = new Pedido(null, new Date(), client1, end);
		Pedido ped2 = new Pedido(null, new Date(), client1, end);

		Payment pay1 = new PaymentWithCard(null, PaymentStatus.QUITADO, ped1, 6);
		ped1.setPagamento(pay1);
		Payment pay2 = new PaymentWithTicket(null, PaymentStatus.PENDENTE, ped2, new Date(), null);
		ped2.setPagamento(pay2);
		client1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		this.pedidoService.saveAll(Arrays.asList(ped1, ped2));
		this.paymentService.saveAll(Arrays.asList(pay1, pay2));
		this.clientService.saveAll(Arrays.asList(client1));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p2, 0.0, 2, 80.0);
		ped1.getItems().add(ip1);
		ped2.getItems().add(ip2);
		p1.getItems().add(ip1);
		p2.getItems().add(ip2);
		itemPedidoService.saveAll(Arrays.asList(ip1, ip2));
	}

}
