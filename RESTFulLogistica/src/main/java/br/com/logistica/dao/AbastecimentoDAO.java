package br.com.logistica.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.logistica.exception.LogisticaException;
import br.com.logistica.rest.bean.CargaBean;
import br.com.logistica.rest.bean.PassoBean;
import br.com.logistica.util.LogisticaConstantes;
import br.com.logistica.util.LogisticaUtil;

import com.google.gson.Gson;

public class AbastecimentoDAO implements IAbastecimentoDAO{
	
	private static final String FILE_CARGAS_JSON = "/carga.json";
	
	final static Logger logger = Logger.getLogger(AbastecimentoDAO.class);

	public void salvarCarga(CargaBean cargaBean) throws LogisticaException {
		FileWriter file = null;
		try{
			Gson gson = new Gson();
			
			file = new FileWriter(new File(getClass().getResource(FILE_CARGAS_JSON).getPath()));
			file.write(gson.toJson(cargaBean));
			file.flush();
		}catch(IOException ex){
			String msgErro = LogisticaUtil.getInstance().getPropriedade(LogisticaConstantes.MSG_ERROR_CARREGAR_ARQUIVO);
			logger.error(msgErro, ex);
			throw new LogisticaException(msgErro);
		}finally{
			if(file != null){
				try {
					file.close();
				} catch (IOException e) {
					String msgErro = LogisticaUtil.getInstance().getPropriedade(LogisticaConstantes.MSG_ERROR_FECHAR_ARQUIVO);
					logger.error(msgErro, e);
					throw new LogisticaException(msgErro);
				}
			}
		}
		
	}

	public List<PassoBean> consultarInstrucoes(Long idEntrega, Long idCaminhao) {
		return null;
	}

}
