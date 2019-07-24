package corp.ventas.services.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import corp.ventas.domain.Cliente;
import corp.ventas.domain.DetalleVenta;
import corp.ventas.domain.Venta;
import lombok.Data;

@XmlRootElement
@Data
public class VentaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idVenta;
	private String estadoVenta;
	private Date fechaVenta;
	private List<DetalleVenta> detalleVentas;
	private Cliente cliente;
	

	
	public VentaDTO() {
		
	}
	
	public VentaDTO(Venta entity) {
		   if (entity!=null){
			   this.cliente = entity.getCliente();
			   this.detalleVentas= entity.getDetalleVentas();
			   this.estadoVenta = entity.getEstadoVenta();
			   this.fechaVenta = entity.getFechaVenta();
			   this.idVenta = entity.getIdVenta();
		   }
	    }
    public Venta toEntity() {
    		Venta entity = new Venta();
    		entity.setCliente(cliente);
    		entity.setDetalleVentas(detalleVentas);
    		entity.setEstadoVenta(estadoVenta);
    		entity.setFechaVenta(fechaVenta);
    		entity.setIdVenta(idVenta);	        
	        return entity;
	    }

}
