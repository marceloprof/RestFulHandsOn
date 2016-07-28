package br.com.logistica.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Classe utilitaria para carregar propriedades
 * @author marcelofdn
 *
 */
public class LogisticaUtil {
	
	final static Logger logger = Logger.getLogger(LogisticaUtil.class);
	
	private Properties properties = new Properties();
	private static LogisticaUtil instance;
	
	private LogisticaUtil() throws FileNotFoundException, IOException{
		properties.load(new FileInputStream(this.getClass().getResource("/application.properties").getFile()));
	}
	
	public synchronized static LogisticaUtil getInstance(){
		if(instance == null){
			try {
				instance = new LogisticaUtil();
			} catch (FileNotFoundException e) {
				logger.error("Não foi encontrado o arquivo de propriedades", e);
				throw new RuntimeException();
			} catch (IOException e) {
				logger.error("Erro ao carregar o arquivo de propriedades", e);
				throw new RuntimeException();
			}
		}
		return instance;
	}
	
	public String getPropriedade(String chave){
		return properties.getProperty(chave);
	}

}
