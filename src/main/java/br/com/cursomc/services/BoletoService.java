package br.com.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.cursomc.domain.PaymentWithTicket;

@Service
public class BoletoService {

	public void preencher(PaymentWithTicket pag, Date instante) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_WEEK, 7);
		pag.setDataVencimento(cal.getTime());
	}
}
