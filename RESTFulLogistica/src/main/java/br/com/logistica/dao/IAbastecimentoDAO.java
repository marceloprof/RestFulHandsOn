package br.com.logistica.dao;

import java.util.List;

import br.com.logistica.exception.LogisticaException;
import br.com.logistica.rest.bean.CargaBean;
import br.com.logistica.rest.bean.PassoBean;

public interface IAbastecimentoDAO {
	
	public void salvarCarga(CargaBean cargaBean) throws LogisticaException;
	public List<PassoBean> consultarInstrucoes(Long idEntrega, Long idCaminhao);

}
