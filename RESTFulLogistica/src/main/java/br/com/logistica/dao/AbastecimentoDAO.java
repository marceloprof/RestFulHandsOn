package br.com.logistica.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.logistica.exception.LogisticaException;
import br.com.logistica.rest.bean.CargaBean;
import br.com.logistica.rest.bean.PassoBean;
import br.com.logistica.util.LogisticaConstantes;
import br.com.logistica.util.LogisticaUtil;

import com.google.gson.Gson;

/**
 * Este DAO salva em um arquivo json, seria substituido por outro que salva em um banco de dados
 * @author marcelofdn
 *
 */
public class AbastecimentoDAO implements IAbastecimentoDAO{
	
	private static final String FILE_CARGAS_JSON = "/carga.json";
	
	final static Logger logger = Logger.getLogger(AbastecimentoDAO.class);
	private File arquivo = new File(getClass().getResource(FILE_CARGAS_JSON).getPath());

	public void salvarCarga(CargaBean cargaBean) throws LogisticaException {
		FileWriter file = null;
		try{
			Gson gson = new Gson();
			
			file = new FileWriter(arquivo);
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

	public List<PassoBean> consultarInstrucoes(Long idEntrega, Long idCaminhao) throws LogisticaException {
		
		JSONParser parser = new JSONParser();
		
		try{
			FileReader file = new FileReader(arquivo);
			JSONObject obj = (JSONObject) parser.parse(file);
			Gson gson = new Gson();
			gson.fromJson(obj.toJSONString(), CargaBean.class);
			
			//TODO Fazer a ordenação do resultado com os pacotes e montar os passos para serem retornados a quem consultou
			
		}catch(IOException ex){
			String msgErro = LogisticaUtil.getInstance().getPropriedade(LogisticaConstantes.MSG_ERROR_CARREGAR_ARQUIVO);
			logger.error(msgErro, ex);
			throw new LogisticaException(msgErro);
		}catch(ParseException ex){
			String msgErro = LogisticaUtil.getInstance().getPropriedade(LogisticaConstantes.MSG_ERROR_PARSEAR_ARQUIVO);
			logger.error(msgErro, ex);
			throw new LogisticaException(msgErro);
		}
		
		return null;
	}

}
