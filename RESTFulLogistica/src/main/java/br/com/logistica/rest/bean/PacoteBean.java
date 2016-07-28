package br.com.logistica.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PacoteBean {
	
	public PacoteBean() {}
	
	public PacoteBean(Long idPacote, Double peso) {
		this.idPacote = idPacote;
		this.peso = peso;
	}
	
	private Long idPacote;
	private Double peso;
	
	public Long getIdPacote() {
		return idPacote;
	}
	
	public void setIdPacote(Long idPacote) {
		this.idPacote = idPacote;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
