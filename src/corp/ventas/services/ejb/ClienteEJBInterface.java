package corp.ventas.services.ejb;

import java.util.List;

import javax.ejb.Local;

import corp.ventas.domain.Cliente;
import corp.ventas.domain.Venta;
import corp.ventas.services.dto.ClienteDTO;



@Local
public interface ClienteEJBInterface {
	public int countCliente();
    public List<Cliente> getClientes();
    public List<Cliente> pagination(Integer page, Integer maxRecords);
    public Cliente getClienteById(Integer id);
    public Cliente createCliente(Cliente entity);
    public Cliente updateCliente(Cliente entity);
    public void deleteCliente(Cliente entity);
    public List<Cliente> getClientesByEstado(String dato);
    public List<Cliente> getClientesByNombre(String criterio);
    
    // navegacion
    public Cliente getFirst();
	public Cliente getLast();
	public Cliente getNext(int clienteId);
	public Cliente getPrev(int clienteId);
    
    //Relacion con Ventas
    public List<Venta> getVentas(int clienteId);
    public Venta getVenta(int clienteId, int ventaId);
    public Venta addVenta(int clienteId, int ventaId);
    public List<Venta> replaceVentas(int clienteId, List<Venta> list);
    public void removeVenta(int clienteId, int ventaId);
}
