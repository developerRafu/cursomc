package br.com.cursomc.domain;

public class AvisoPendente {
	private Integer id;
	private Integer idProcesso;
	private String codigoProcesso;
	private String grau;
	private Integer grauId;
	private Double valorCausa;
	private String dataDisponibilizacao;
	private String dataAjuizamento;
	private String situacaoProcesso;
	private String instancia;
	private Integer countDistribuicoesVigentes;
	private String faseProcesso;

	public AvisoPendente() {

	}

	public AvisoPendente(Integer id, Integer idProcesso, String codigoProcesso, String grau, Integer grauId,
			Double valorCausa, String dataDisponibilizacao, String dataAjuizamento, String situacaoProcesso,
			String instancia, Integer countDistribuicoesVigentes, String faseProcesso) {
		super();
		this.id = id;
		this.idProcesso = idProcesso;
		this.codigoProcesso = codigoProcesso;
		this.grau = grau;
		this.grauId = grauId;
		this.valorCausa = valorCausa;
		this.dataDisponibilizacao = dataDisponibilizacao;
		this.dataAjuizamento = dataAjuizamento;
		this.situacaoProcesso = situacaoProcesso;
		this.instancia = instancia;
		this.countDistribuicoesVigentes = countDistribuicoesVigentes;
		this.faseProcesso = faseProcesso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer idProcesso) {
		this.idProcesso = idProcesso;
	}

	public String getCodigoProcesso() {
		return codigoProcesso;
	}

	public void setCodigoProcesso(String codigoProcesso) {
		this.codigoProcesso = codigoProcesso;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

	public Integer getGrauId() {
		return grauId;
	}

	public void setGrauId(Integer grauId) {
		this.grauId = grauId;
	}

	public Double getValorCausa() {
		return valorCausa;
	}

	public void setValorCausa(Double valorCausa) {
		this.valorCausa = valorCausa;
	}

	public String getDataDisponibilizacao() {
		return dataDisponibilizacao;
	}

	public void setDataDisponibilizacao(String dataDisponibilizacao) {
		this.dataDisponibilizacao = dataDisponibilizacao;
	}

	public String getDataAjuizamento() {
		return dataAjuizamento;
	}

	public void setDataAjuizamento(String dataAjuizamento) {
		this.dataAjuizamento = dataAjuizamento;
	}

	public String getSituacaoProcesso() {
		return situacaoProcesso;
	}

	public void setSituacaoProcesso(String situacaoProcesso) {
		this.situacaoProcesso = situacaoProcesso;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public Integer getCountDistribuicoesVigentes() {
		return countDistribuicoesVigentes;
	}

	public void setCountDistribuicoesVigentes(Integer countDistribuicoesVigentes) {
		this.countDistribuicoesVigentes = countDistribuicoesVigentes;
	}

	public String getFaseProcesso() {
		return faseProcesso;
	}

	public void setFaseProcesso(String faseProcesso) {
		this.faseProcesso = faseProcesso;
	}

}
