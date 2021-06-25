package br.com.cursomc.domain.dto;

import java.io.Serializable;

import br.com.cursomc.domain.Category;

public class CategoryDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;
	
	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.nome = category.getNome();
	}
	
	public CategoryDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
