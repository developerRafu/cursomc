package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
