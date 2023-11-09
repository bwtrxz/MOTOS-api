package br.com.fiap.motosapi;

import java.sql.SQLException;

import java.util.List;
import br.com.fiap.motosapi.model.Motos;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.MotosService;


@Path("motos")
public class MotosResource {
	
	private MotosService service = new MotosService();
	
	public MotosResource() throws SQLException {
		service = new MotosService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Motos> index() throws SQLException {
		return service.findAll();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById throws SQLException {
		var motos = service.findById();
		
		if (motos == null) {
			return Response.status(404).build();		
		}
		
		return Response.ok(motos).build();
	}
	
	@PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response uptade(Motos motos) throws SQLException {
    	var motosEncontrada = service.findById();
    	
    	if(motosEncontrada == null)
    		return Response.status(Response.Status.NOT_FOUND).build();
    			
    	try {
    		
			if (!service.update(motos))
				return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (SQLException e) {

			e.printStackTrace();
		}
    	
    	return Response.ok(motos).build();
    }
	
	@DELETE
	@Path("{id}")
	public Response delete() throws SQLException {
		var motos = service.findById();
		
		if (motos == null) 
			return Response.status(Response.Status.NOT_FOUND).build();
		
		return Response.ok(motos).build();
	}
		
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Motos motos) {
		if (!service.save(motos)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.ok(motos).build();		
	}
	
}

