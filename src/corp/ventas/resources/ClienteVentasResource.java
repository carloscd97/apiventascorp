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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import corp.ventas.domain.Venta;
import corp.ventas.services.dto.VentaDTO;
import corp.ventas.services.ejb.ClienteEJBInterface;

/**
 * URI: clientes/{clienteId: \\d+}/ventas
 * @generated
 */
@Path("/")  //esta anotacion cuando se trata de subservicios es opcional
@Stateless
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class ClienteVentasResource {
	@Inject private ClienteEJBInterface sCliente;
	@Context private HttpServletResponse response;
	
	 /**
     * Convierte una lista de Venta (entidades) a una lista de VentasDTO.
     *
     * @param entityList Lista de Venta a convertir.
     * @return Lista de VentaDTO convertida.
     * @generated
     */
    private List<VentaDTO> ventasListEntity2DTO(List<Venta> entityList) {
        List<VentaDTO> list = new ArrayList<>();
        for (Venta entity : entityList) {
            list.add(new VentaDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de VentaDTO a una lista de Venta.
     *
     * @param dtos Lista de VentaDTO a convertir.
     * @return Lista de Venta convertida.
     * @generated
     */
    private List<Venta> ventasListDTO2Entity(List<VentaDTO> dtos){
        List<Venta> list = new ArrayList<>();
        for (VentaDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una coleccion de instancias de VentaDTO asociadas a una
     * instancia de Cliente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @return Coleccion de instancias de VentasDTO asociadas a la instancia de Cliente
     * @generated
     */
    @GET
    public List<VentaDTO> listVentas(@PathParam("clienteId") int clienteId) {
        return ventasListEntity2DTO(sCliente.getVentas(clienteId));      
    }

    /**
     * Obtiene una instancia de Venta asociada a una instancia de Cliente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @param ventaId Identificador de la instancia de Venta
     * @generated
     */
    @GET
    @Path("{ventaId: \\d+}")
    public VentaDTO getVenta(@PathParam("clienteId") int clienteId, @PathParam("ventaId") int ventaId) {
        return new VentaDTO(sCliente.getVenta(clienteId, ventaId));       
    }

    /**
     * Asocia una Venta existente a un Cliente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @param ventaId Identificador de la instancia de Venta
     * @return Instancia de VentaDTO que fue asociada a Cliente
     * @generated
     */
    @POST
    @Path("{ventaId: \\d+}")
    public VentaDTO addVenta(@PathParam("clienteId") int clienteId, @PathParam("ventaId") int ventaId) {
        return new VentaDTO(sCliente.addVenta(clienteId, ventaId));
    }

    /**
     * Remplaza las instancias de Venta asociadas a una instancia de Cliente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @param ventas Coleccion de instancias de VentaDTO a asociar a instancia de Cliente
     * @return Nueva coleccion de VentaDTO asociada a la instancia de Cliente
     * @generated
     */
    @PUT
    public List<VentaDTO> replaceVentas(@PathParam("clienteId") int clienteId, List<VentaDTO> ventas) {
        return ventasListEntity2DTO(sCliente.replaceVentas(clienteId,  
        		ventasListDTO2Entity(ventas)));
    }

    /**
     * Desasocia una Venta existente de un Cliente existente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @param ventaId Identificador de la instancia de Venta
     * @generated
     */
    @DELETE
    @Path("{ventaId: \\d+}")
    public void removeVenta(@PathParam("clienteId") int clienteId, @PathParam("ventaId") int ventaId) {
    	sCliente.removeVenta(clienteId, ventaId);
    }
    
    
}
