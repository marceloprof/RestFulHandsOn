package br.com.logistica.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.logistica.dao.AbastecimentoDAO;
import br.com.logistica.exception.LogisticaException;
import br.com.logistica.rest.bean.CargaBean;
import br.com.logistica.rest.bean.PassoBean;

@Path("abastecimento")
public class AbastecimentoService {
	
	@GET
	@Path("/instrucoes")
	public Response getInstrucoesAbastecimento(@QueryParam("idVeiculo") Long idVeiculo,
			@QueryParam("idEntrega") Long idEntrega) {
		try{
			List<PassoBean> passos = new AbastecimentoDAO().consultarInstrucoes(idEntrega, idVeiculo);
			return Response.status(200).entity(passos).build();
		} catch(LogisticaException e){
			return Response.status(500).build();
		}
 
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCarga(CargaBean carga){
		try {
			new AbastecimentoDAO().salvarCarga(carga);
			return Response.status(200).entity(carga).build();
		} catch (LogisticaException e) {
			return Response.status(500).build();
		}
	}

}
