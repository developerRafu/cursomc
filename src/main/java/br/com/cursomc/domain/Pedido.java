package br.com.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date instant;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Payment pagamento;

	@ManyToOne
	private Client client;

	@ManyToOne
	private Endereco enderecoDeEntrega;

	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> items = new HashSet<>();

	public Pedido() {

	}

	public Pedido(Integer id, Date instant, Client client, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instant = instant;
		this.client = client;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public double getTotal() {
		double sum = 0;
		for (ItemPedido ip : items) {
			sum += ip.getSubTotal();
		}
		return sum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public Payment getPagamento() {
		return pagamento;
	}

	public void setPagamento(Payment pagamento) {
		this.pagamento = pagamento;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<ItemPedido> getItems() {
		return this.items;
	}
}
