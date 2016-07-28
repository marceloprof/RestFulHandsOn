package br.com.logistica.exception;

/**
 * Classe para representar uma excecao de negocio conhecida pela aplicação
 * @author marcelofdn
 *
 */
public class LogisticaException extends Exception {
	
	public LogisticaException(String msg){
		super(msg);
	}

}
