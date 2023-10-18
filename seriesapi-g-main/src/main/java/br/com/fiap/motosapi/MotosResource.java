package br.com.fiap.motosapi;

import java.util.List;

import br.com.fiap.motosapi.model.Motos;
import br.com.fiap.motosapi.service.MotosService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("motos")
public class MotosResource {
	
	
	MotosService service = new MotosService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Motos> index() {
		return service.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		var motos = service.findById(id);
		
		if (motos == null ) {
			return Response.status(404).build();
		}
		
		return Response.ok(motos).build();

	}
}
