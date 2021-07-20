package br.com.cursomc.domain.dto;

import br.com.cursomc.domain.Product;

public class ProductDTO {
	private Integer id;

	private String name;
	private Double price;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDTO(Product p) {
		id = p.getId();
		name = p.getName();
		price = p.getPrice();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
