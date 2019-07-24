package corp.ventas.services.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;

import javax.xml.bind.annotation.XmlRootElement;

import corp.ventas.domain.DetalleVenta;
import corp.ventas.domain.DetalleVentaPK;
import corp.ventas.domain.Producto;
import corp.ventas.domain.Venta;
import lombok.Data;

@XmlRootElement
@Data
public class DetalleVentaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DetalleVentaPK id;
	private BigDecimal cantidad;
	private BigDecimal precioVenta;
	private Venta venta;
	private Producto producto;
	
	public DetalleVentaDTO() {
		
	}
	public DetalleVentaDTO(DetalleVenta entity) {
		   if (entity!=null){
			   this.cantidad = entity.getCantidad();
			   this.id= entity.getId();
			   this.precioVenta= entity.getPrecioVenta();
			   this.producto = entity.getProducto();
			   this.venta = entity.getVenta();
		   }
	    }
    public DetalleVenta toEntity() {
	        DetalleVenta entity = new DetalleVenta();
	        entity.setCantidad(cantidad);
	        entity.setId(id);
	        entity.setPrecioVenta(precioVenta);
	        entity.setProducto(producto);
	        entity.setVenta(venta);
	        return entity;
	    }

}
