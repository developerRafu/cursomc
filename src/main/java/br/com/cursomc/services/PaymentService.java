package br.com.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Payment;
import br.com.cursomc.repositories.PaymentRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	public Payment findOne(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public List<Payment> saveAll(List<Payment> lista) {
		return this.repository.saveAll(lista);
	}
}
