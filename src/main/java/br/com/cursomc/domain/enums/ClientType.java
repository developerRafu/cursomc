package br.com.cursomc.domain.enums;

public enum ClientType {
	PESSOAFISICA(1, "Pessoa física"), PESSOAJURIDICA(2, "Pessoa jurídica");

	private int cod;
	private String description;

	private ClientType(int cod, String description) {

	}

	public int getCod() {
		return this.cod;
	}

	public String getDescription() {
		return this.description;
	}
	
	public static ClientType toEnum(Integer code) {
		if(code==null) {
			return null;
		}
		for(ClientType x : ClientType.values()) {
			if(code.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código inválido: "+ code);
	}
}
