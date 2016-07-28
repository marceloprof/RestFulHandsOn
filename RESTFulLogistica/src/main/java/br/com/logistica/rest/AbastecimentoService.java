package br.com.logistica.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.logistica.dao.AbastecimentoDAO;
import br.com.logistica.exception.LogisticaException;
import br.com.logistica.rest.bean.CargaBean;
import br.com.logistica.rest.bean.PacoteBean;

@Path("abastecimento")
public class AbastecimentoService {
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response getHello() {
//        return "Hello World!";
		List<PacoteBean> pacotes = new ArrayList<PacoteBean>();
		pacotes.add(new PacoteBean(3L, 100D));
		CargaBean carga = new CargaBean(1L, 1L, pacotes);
        return Response.status(200).entity(carga).build();
    }
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCarga(CargaBean carga){
		try {
			new AbastecimentoDAO().salvarCarga(carga);
		} catch (LogisticaException e) {
			return Response.status(500).build();
		}
		return Response.status(200).entity(carga).build();
	}

}
