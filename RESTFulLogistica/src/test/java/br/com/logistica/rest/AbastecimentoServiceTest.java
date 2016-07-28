package br.com.logistica.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public void getInstrucoesAbastecimentoTest(){
		final String resposta = target("abastecimento").queryParam("idVeiculo", 1L).queryParam("idEntrega", 2L).path("instrucoes").request().get(String.class);
		assertEquals("Jersey say : teste", resposta);
	}
	
	@Test
	public void addCargaTest(){
		List<PacoteBean> pacotes = new ArrayList<PacoteBean>();
		pacotes.add(new PacoteBean(3L, 100D));
		CargaBean carga = new CargaBean(2L, 3L, pacotes);
		final Response resultado = target("abastecimento").path("add").register(carga).request().post(Entity.entity(carga, MediaType.APPLICATION_JSON));
		assertEquals(200, resultado.getStatus());
	}

}
