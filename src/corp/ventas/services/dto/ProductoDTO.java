package corp.ventas.services.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import corp.ventas.domain.DetalleVenta;
import corp.ventas.domain.Producto;
import lombok.Data;

@XmlRootElement
@Data
public class ProductoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idProducto;
	private String descripcion;
	private String foto;
	private BigDecimal precio;
	private BigDecimal stock;
	
	public ProductoDTO() {
		
	}

}
