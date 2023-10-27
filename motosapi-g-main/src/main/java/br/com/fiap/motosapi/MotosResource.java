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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Motos> listAll() throws SQLException{
		return service.findAll();
	}
	
	@GET
	@Path("{id")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) throws SQLException {
		var motos = service.findById(id);
		
		if (motos == null) {
			return Response.status(404).build();		
		}
		
		return Response.ok(motos).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id")Long id) {
		var motos = service.findById(id);
		
		if (motos == null)
			return Response.status(404).build();		
		
		service.delete(motos);
		return Response.status(Response.Status.NO_CONTENT).build();
		
	}
		
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Motos motos) throws SQLException {
		if (!service.save(motos)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.ok(motos).build();		
	}
	
	@PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") Long id, Motos motos) throws SQLException {
    	var motosEncontrada = service.findById(id);
    	
    	if(motosEncontrada == null)
    		return Response.status(Response.Status.NOT_FOUND).build();
    			
    			
    	try {
			if (!service.update(motos))
				return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return Response.ok(motos).build();
    	
    }
}

