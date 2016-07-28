package br.com.logistica.rest.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CargaBean {
	
	private Long idVeiculo;
	private Long idEntrega;
	private List<PacoteBean> pacotes;
	
	public CargaBean() {}
	
	public CargaBean(Long idVeiculo, Long idEntrega, List<PacoteBean> pacotes) {
		this.idVeiculo = idVeiculo;
		this.idEntrega = idEntrega;
		this.pacotes = pacotes;
	}
	
	public Long getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public Long getIdEntrega() {
		return idEntrega;
	}
	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}
	public List<PacoteBean> getPacotes() {
		return pacotes;
	}
	public void setPacotes(List<PacoteBean> pacotes) {
		this.pacotes = pacotes;
	}
	
	

}
