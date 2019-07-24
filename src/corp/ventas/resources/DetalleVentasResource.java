package corp.ventas.resources;

import java.util.ArrayList;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

import corp.ventas.domain.DetalleVenta;
import corp.ventas.domain.DetalleVentaPK;
import corp.ventas.services.dto.DetalleVentaDTO;
import corp.ventas.services.ejb.DetalleVentaEJBInterface;


@Path("detalleVentas")
@Stateless
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class DetalleVentasResource {
	@Inject
	DetalleVentaEJBInterface detalleejb;
	
	@Context 
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("limit")
    private Integer maxRecords;
	
	
	private List<DetalleVentaDTO> listEntity2DTO(List<DetalleVenta> entityList) {
	       List<DetalleVentaDTO> list = new ArrayList<>();
	       for (DetalleVenta entity : entityList) {
	    	   list.add(new DetalleVentaDTO(entity));
	       }
	       return list;
	   }
	
	 /**
     * Obtiene la lista de los registros de DetalleVentas
     *
     * @return Coleccion de objetos de DetalleVentaDTO
     * Acepta parametros para page y maxRecords
     * @generated
     * 
     * estructura de la consulta REST
     * http://localhost:8080/apiVentasCorp/v1/DetalleVentas?page=1&limit=2
     */
   
	@GET     
	public List<DetalleVentaDTO> getDetalleVentas(){  
		
		  if (page != null && maxRecords != null) {
		        this.response.setIntHeader("X-Total-Count", detalleejb.countDetalleVenta());	            
	            return listEntity2DTO(detalleejb.getDetallesVenta(page, maxRecords));
	        }		
  		return listEntity2DTO(detalleejb.getDetallesVenta());
    }
	
	/*
     * pathSemgent represents a URI path segment and any associated matrix parameters.
     * URI path part is supposed to be in form of 'somePath;idVenta=idVentaValue;idProducto=idProductoValue'.
     * Here 'somePath' is a result of getPath() method invocation and
     * it is ignored in the following code.
     * Matrix parameters are used as field names to build a primary key instance.
     */
	private DetalleVentaPK getPrimaryKey(PathSegment pathSegment) { 
        DetalleVentaPK key = new DetalleVentaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        List<String> idVenta = map.get("idVenta");
        if (idVenta != null && !idVenta.isEmpty()) {
            key.setIdVenta(new Integer(idVenta.get(0)));
        }
        List<String> idProducto = map.get("idProducto");
        if (idProducto != null && !idProducto.isEmpty()) {
            key.setIdProducto(new Integer(idProducto.get(0)));
        }
        return key;
    }
	
	
	 /**
     * Obtiene los datos de una instancia de DetalleVenta a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de DetalleVentaDTO con los datos del DetalleVenta consultado
     * @generated
     */
	// url ejemplo: http://localhost:8080/apiVentasCorp/v1/detalleVentas/id;idVenta=1;idProducto=21
	@GET     
	@Path("/{id}") 
    public DetalleVentaDTO getDetalleVenta(@PathParam("id") PathSegment id){
		DetalleVentaPK key = getPrimaryKey(id);
		return new DetalleVentaDTO(detalleejb.getDetalleVentaById(key));
    }
	
	
	   /**
     * Se encarga de crear un DetalleVenta en la base de datos
     *
     * @param dto Objeto de DetalleVentaDTO con los datos nuevos
     * @return Objeto de DetalleVentaDTO con los datos nuevos y su ID
     * @generated
     */
    @POST
    //@StatusCreated
    public DetalleVentaDTO createDetalleVenta(DetalleVentaDTO dto) {
        return new DetalleVentaDTO(detalleejb.createDetalleVenta(dto.toEntity()));
    }

    /**
     * Actualiza la informacion de una instancia de un DetalleVenta
     *
     * @param id Identificador de la instancia del DetalleVenta a modificar
     * @param dto Instancia de DetalleVentaDTO con los nuevos datos
     * @return Instancia de DetalleVentaDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("/{id}")
    public DetalleVentaDTO updateDetalleVenta(@PathParam("id") PathSegment id, DetalleVentaDTO dto) {
        
    	DetalleVenta entity = dto.toEntity();
    	DetalleVentaPK key = getPrimaryKey(id);
    	entity.setId(key);
    	DetalleVenta oldEntity = detalleejb.getDetalleVentaById(key);
    	entity.setVenta(oldEntity.getVenta());
    	return new DetalleVentaDTO(detalleejb.updateDetalleVenta(entity));
    }

    /**
     * Elimina una instancia de DetalleVenta de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void deleteDetalleVenta(@PathParam("id") PathSegment id) {
    	DetalleVentaPK key = getPrimaryKey(id);
    	detalleejb.deleteDetalleVenta(detalleejb.getDetalleVentaById(key));
    }

	
	
	
}
