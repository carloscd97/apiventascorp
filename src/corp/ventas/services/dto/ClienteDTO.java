package corp.ventas.services.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;

import corp.ventas.domain.Venta;
import lombok.Data;

@XmlRootElement
@Data
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	int idCliente;
	String apellidoMaterno;
	String apellidoPaterno;
	String dni;
	String estadoCliente;
	String nombres;
	List<VentaDTO> ventas;
	
	public ClienteDTO() {
		
	}
    
}
