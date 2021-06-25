package br.com.cursomc.domain.enums;

public enum PaymentStatus {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3,"Cancelado");
	
	private int cod;
	private String description;

	private PaymentStatus(int cod, String description) {

	}

	public int getCod() {
		return this.cod;
	}

	public String getDescription() {
		return this.description;
	}
	
	public static PaymentStatus toEnum(Integer code) {
		if(code==null) {
			return null;
		}
		for (PaymentStatus x : PaymentStatus.values()) {
			if(code.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código inválido: "+ code);
	}
}
