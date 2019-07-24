package corp.ventas.resources;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import corp.ventas.domain.Cliente;
import corp.ventas.mapper.GenericMapper;
import corp.ventas.mapper.Paginator;
import corp.ventas.services.dto.ClienteDTO;
import corp.ventas.services.ejb.ClienteEJBInterface;

@Path("clientes")
@Stateless
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

public class ClienteResource extends GenericMapper<Cliente, ClienteDTO> {
	@Inject
	ClienteEJBInterface clienteejb;
    
    private Integer pageInit = 1;
    private Integer pageLast = 1;
	
	@GET     
	public Paginator<ClienteDTO> getClientes(@QueryParam("page") int page, @QueryParam("limit") int maxRecords){  
		if (page > 0 && maxRecords > 0) {
			Integer itemsPerPage = maxRecords;
			Integer pageLast = (int)Math.ceil((double)clienteejb.countCliente()/itemsPerPage);
			Paginator<ClienteDTO> paginator = new Paginator<ClienteDTO>(itemsPerPage, pageInit,  page, pageLast, getAll(clienteejb.pagination(page, maxRecords)));
			return paginator;
		}	
		pageInit = 1;
		pageLast = 1;
		Paginator<ClienteDTO> paginator = new Paginator<ClienteDTO>(clienteejb.countCliente(), pageInit, page, pageLast, getAll(clienteejb.getClientes()));
		return paginator;
    }
	
	@GET     
	@Path("/{id: \\d+}") 
    public Cliente getCliente(@PathParam("id") int id){
		return clienteejb.getClienteById(id);	
    }

    @POST
    public Cliente createCliente(Cliente entity) {
        return clienteejb.createCliente(entity);
    }

    @PUT
    @Path("{id: \\d+}")
    public Cliente updateCliente(@PathParam("id") int id, Cliente entity) {
        entity.setIdCliente(id);
        Cliente oldEntity = clienteejb.getClienteById(id);
        entity.setVentas(oldEntity.getVentas());
        return clienteejb.updateCliente(entity); 
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCliente(@PathParam("id") int id) {
        clienteejb.deleteCliente(clienteejb.getClienteById(id));
    }

    public void existsCliente(int clienteId) {
    	Cliente cliente = getCliente(clienteId);
        if (cliente == null) {
            throw new WebApplicationException(404);
        }
    }
	
	// Servicios adicionales implementados para la practica	
	// Estructura de la consulta
	// http://localhost:8080/apiVentasCorp/v1/clientes/consulta?estado=a
	@Path ("consulta")
	@GET
	public List<ClienteDTO> getClientesByEstado(@QueryParam ("estado") String estado){
		return getAll(clienteejb.getClientesByEstado(estado));
	}
	
	// Estructura de la consulta
	// http://localhost:8080/apiVentasCorp/v1/clientes/filtrarPorNombre?criterio=prueb
	@Path ("filtrarPorNombre")
	@GET
	public List<ClienteDTO> getClientesByCriterio(@QueryParam ("criterio") String criterio){
		return getAll(clienteejb.getClientesByNombre(criterio));
	}

	//creando el subservicio
	// http://localhost:8080/apiVentasCorp/v1/clientes/2/ventas
	
	@Path("{clienteId: \\d+}/ventas")
    public Class<ClienteVentasResource> getClienteVentasResource(@PathParam("clienteId") int clienteId) {
        existsCliente(clienteId);
        return ClienteVentasResource.class;
    }
    
	
	
}
