package br.com.cursomc.domain.dto;

import br.com.cursomc.domain.Client;

public class ClientDTO {

	private Integer id;
	private String nome;
	private String email;

	public ClientDTO() {

	}

	public ClientDTO(Client client) {
		this.id = client.getId();
		this.nome = client.getName();
		this.email = client.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
