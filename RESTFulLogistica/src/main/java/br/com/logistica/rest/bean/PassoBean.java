package br.com.logistica.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PassoBean {

	private PacoteBean pacote;
	private String de;
	private String para;
	
	public PacoteBean getPacote() {
		return pacote;
	}
	public void setPacote(PacoteBean pacote) {
		this.pacote = pacote;
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	
	
	
}
