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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import corp.ventas.domain.Producto;
import corp.ventas.services.dto.ProductoDTO;
import corp.ventas.services.ejb.ProductoEJBInterface;

@Path("productos")
@Stateless
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class ProductoResource {
	@Inject
	ProductoEJBInterface productoejb;
	
	@Context 
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("limit")
    private Integer maxRecords;
    
	 @GET     
	 public List<Producto> getProductos(){  
		  if (page != null && maxRecords != null) {
		    this.response.setIntHeader("X-Total-Count", productoejb.countProducto());	            
		    return productoejb.getProductos(page, maxRecords);
		  }		
		  return productoejb.getProductos();
	 }
	
	 @GET     
	 @Path("/{id: \\d+}") 
	 public Producto getProducto(@PathParam("id") int id){
			return productoejb.getProductoById(id);
	 }
	
	 @POST
	 //@StatusCreated
	 public Producto createProducto(Producto entity) {
	     return productoejb.createProducto(entity);
	 }

	 @PUT
	 @Path("{id: \\d+}")
	 public Producto updateProducto(@PathParam("id") int id, Producto entity) {    
	     entity.setIdProducto(id);
	     Producto oldEntity = productoejb.getProductoById(id);
	     entity.setDetalleVentas(oldEntity.getDetalleVentas());
	     return productoejb.updateProducto(entity);
	     
	 }

	@DELETE
	@Path("{id: \\d+}")
	public void deleteProducto(@PathParam("id") int id) {
	    productoejb.deleteProducto(productoejb.getProductoById(id));
	}



}
