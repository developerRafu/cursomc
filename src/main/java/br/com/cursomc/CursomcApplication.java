package br.com.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cursomc.domain.Category;
import br.com.cursomc.domain.City;
import br.com.cursomc.domain.Product;
import br.com.cursomc.domain.State;
import br.com.cursomc.services.CategoryService;
import br.com.cursomc.services.CityService;
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
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Hardware");
		Category c2 = new Category(null, "Livros");
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
		this.stateService.saveAll(Arrays.asList(s1,s2));
		this.cityService.saveAll(Arrays.asList(city1,city2));
		this.categoryService.saveAll(Arrays.asList(c1, c2));
		this.productService.saveAll(Arrays.asList(p1, p2));
	}

}
