package br.com.mobilesaude.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.mobilesaude.modelo.Testes;
import br.com.mobilesaude.servicounimedse.bean.CarteiraSE.CarteiraSE;
import br.com.mobilesaude.servicounimedse.bean.base.CarteiraBean;



@SuppressWarnings({ "unused" })
@Path("/ws/servico")

public class Service {
	@EJB
	CarteiraBean b;
	
	@GET
	@Path("/teste")
	@Produces( MediaType.APPLICATION_XML )
	public Testes namedQuery( ){
		 	
		return new Testes();
	}
	
	
	@GET
	@Path("/inicio")
	@Produces( MediaType.APPLICATION_JSON )
	public String cliente( ){
		Testes t = new Testes();
		return t.getCliente();
	}
	
	
	@GET
	@Path("/exemplo")
	@Produces( MediaType.APPLICATION_XML )
	public CarteiraSE plano( ){
	
		CarteiraSE p = b.busca();
		if(p==null) return new CarteiraSE();
		return p;
	}
	
	@GET
	@Path("find/{cateirinha}")
	@Produces( MediaType.APPLICATION_XML )
	public CarteiraSE find( @PathParam("cateirinha") String cateirinha ){
		///ta retornando null
		System.out.println("CARTEIRA >>>>>> "+cateirinha);
		CarteiraSE p = b.find(cateirinha);
		if(p==null) return new CarteiraSE();
		return p;
	}
	
	@GET
	@Path("find2/{cateirinha}")
	@Produces( MediaType.APPLICATION_XML )
	public CarteiraSE find2( @PathParam("cateirinha") String cateirinha ){
		///ta retornando null
		CarteiraSE p = b.busca2(cateirinha);
		if(p==null) return new CarteiraSE();
		return p;
	}
	
}
