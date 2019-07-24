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

import corp.ventas.domain.Venta;
import corp.ventas.services.dto.VentaDTO;
import corp.ventas.services.ejb.VentaEJBInterface;

@Path("ventas")
@Stateless
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class VentaResource {
	@Inject
	VentaEJBInterface ventaejb;
	
	@Context 
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("limit")
    private Integer maxRecords;
    
    
    private List<VentaDTO> listEntity2DTO(List<Venta> entityList) {
	       List<VentaDTO> list = new ArrayList<>();
	       for (Venta entity : entityList) {
	    	   list.add(new VentaDTO(entity));
	       }
	       return list;
	   }
	
	 /**
  * Obtiene la lista de los registros de Ventas
  *
  * @return Coleccion de objetos de VentaDTO
  * Acepta parametros para page y maxRecords
  * @generated
  * 
  * estructura de la consulta REST
  * http://localhost:8080/apiVentasCorp/v1/Ventas?page=1&limit=2
  */

	@GET     
	public List<VentaDTO> getVentas(){  
		
		  if (page != null && maxRecords != null) {
		        this.response.setIntHeader("X-Total-Count", ventaejb.countVenta());	            
	            return listEntity2DTO(ventaejb.getVentas(page, maxRecords));
	        }		
		return listEntity2DTO(ventaejb.getVentas());
 }
	
	
	 /**
  * Obtiene los datos de una instancia de Venta a partir de su ID
  *
  * @param id Identificador de la instancia a consultar
  * @return Instancia de VentaDTO con los datos del Venta consultado
  * @generated
  */
	@GET     
	@Path("/{id: \\d+}") 
 public VentaDTO getVenta(@PathParam("id") int id){
		return new VentaDTO(ventaejb.getVentaById(id));
 }
	
	
	   /**
  * Se encarga de crear un Venta en la base de datos
  *
  * @param dto Objeto de VentaDTO con los datos nuevos
  * @return Objeto de VentaDTO con los datos nuevos y su ID
  * @generated
  */
 @POST
 //@StatusCreated
 public VentaDTO createVenta(VentaDTO dto) {
     return new VentaDTO(ventaejb.createVenta(dto.toEntity()));
 }

 /**
  * Actualiza la informacion de una instancia de un Venta
  *
  * @param id Identificador de la instancia del Venta a modificar
  * @param dto Instancia de VentaDTO con los nuevos datos
  * @return Instancia de VentaDTO con los datos actualizados
  * @generated
  */
 @PUT
 @Path("{id: \\d+}")
 public VentaDTO updateVenta(@PathParam("id") int id, VentaDTO dto) {
     
 	Venta entity = dto.toEntity();
     entity.setIdVenta(id);
     Venta oldEntity = ventaejb.getVentaById(id);
     entity.setDetalleVentas(oldEntity.getDetalleVentas());
     return new VentaDTO(ventaejb.updateVenta(entity));
     
 }

 /**
  * Elimina una instancia de Venta de la base de datos
  *
  * @param id Identificador de la instancia a eliminar
  * @generated
  */
 @DELETE
 @Path("{id: \\d+}")
 public void deleteVenta(@PathParam("id") int id) {
     ventaejb.deleteVenta(ventaejb.getVentaById(id));
 }


	

}
