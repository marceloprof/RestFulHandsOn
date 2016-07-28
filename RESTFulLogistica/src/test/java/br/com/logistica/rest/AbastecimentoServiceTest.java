package br.com.logistica.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import br.com.logistica.rest.bean.CargaBean;
import br.com.logistica.rest.bean.PacoteBean;

public class AbastecimentoServiceTest extends JerseyTest{
	
	protected Application configure(){
		return new ResourceConfig(AbastecimentoService.class);
	}
	
	@Test
	public void getMsgTest(){
		final String hello = target("abastecimento").path("teste").request().get(String.class);
		assertEquals("Jersey say : teste", hello);
	}
	
	@Test
	public void addCargaTest(){
		List<PacoteBean> pacotes = new ArrayList<PacoteBean>();
		pacotes.add(new PacoteBean(3L, 100D));
		CargaBean carga = new CargaBean(1L, 1L, pacotes);
//		final String resultado = target("abastecimento").path("add");
	}

}
