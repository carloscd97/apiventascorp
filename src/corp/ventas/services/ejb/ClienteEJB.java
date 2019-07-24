package corp.ventas.services.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import corp.ventas.domain.Cliente;
import corp.ventas.domain.Venta;
import corp.ventas.mapper.GenericMapper;
import corp.ventas.services.dao.ClienteDAOLocal;
import corp.ventas.services.dto.ClienteDTO;

/**
 * Session Bean implementation class ClienteEJB
 */
@Stateless
@LocalBean
public class ClienteEJB implements ClienteEJBInterface {
	@Inject
	ClienteDAOLocal clientedao;
	
    /**
     * Default constructor. 
     */
    public ClienteEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int countCliente() {
		return clientedao.count();
	}

	@Override
	public List<Cliente> getClientes() {
		return clientedao.findAll();
	}
	
	@Override
	public List<Cliente> pagination(Integer page, Integer maxRecords) {
		return clientedao.pagination("Cliente.findAll", page, maxRecords);
	}

	@Override
	public Cliente getClienteById(Integer id) {
		return clientedao.findByID(id);
	}

	@Override
	public Cliente createCliente(Cliente entity) {
		clientedao.create(entity);
		return entity;
	}

	@Override
	public Cliente updateCliente(Cliente entity) {
		return clientedao.update(entity);
	}

	@Override
	public void deleteCliente(Cliente entity) {
		clientedao.delete(entity);

	}

	@Override
	public List<Cliente> getClientesByEstado(String estadoCliente) {
		
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("estadoCliente", estadoCliente);
		return clientedao.executeListNamedQuery("Cliente.findAllByEstado", params);
       
	}

	@Override
	public List<Cliente> getClientesByNombre(String criterio) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("cBusqueda", criterio);
		//return clientedao.executeListNamedQuery("Cliente.findByNombre", params);
        return clientedao.executeListNamedQueryByString("Cliente.findByNombre", "cBusqueda", criterio);
	}
	
	// Relacion de cliente con ventas
	
	/**
     * Obtiene una coleccion de instancias de Venta asociadas a una
     * instancia de Cliente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @return Coleccion de instancias de Venta asociadas a la instancia de Cliente
     * @generated
     */
	@Override
	public List<Venta> getVentas(int clienteId) {
		return getClienteById(clienteId).getVentas();
	}
	
	/**
     * Obtiene una instancia de Venta asociada a una instancia de Cliente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @param ventaId Identificador de la instancia de Venta
     * @generated
     */
	@Override
	public Venta getVenta(int clienteId, int ventaId) {
		List<Venta> list = getClienteById(clienteId).getVentas();
		Venta venta = new Venta();
		venta.setIdVenta(ventaId);
		int index = list.indexOf(venta);
		if (index >= 0) {
			return list.get(index);
		}
		return null;
	}
	
	/**
     * Asocia una Venta existente a un Cliente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @param ventaId Identificador de la instancia de Venta
     * @return Instancia de Venta que fue asociada a Cliente
     * @generated
     */

	@Override
	public Venta addVenta(int clienteId, int ventaId) {
		
		Cliente cliente = getClienteById(clienteId);
		Venta venta = new Venta();
		venta.setIdVenta(ventaId);
		cliente.getVentas().add(venta);
		return getVenta(clienteId, ventaId);
	}
	
	
	/**
     * Remplaza las instancias de Venta asociadas a una instancia de Cliente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @param list Coleccion de instancias de Venta a asociar a instancia de Cliente
     * @return Nueva coleccion de Venta asociada a la instancia de Cliente
     * @generated
     */
	@Override
	public List<Venta> replaceVentas(int clienteId, List<Venta> list) {
		Cliente cliente = getClienteById(clienteId);
		cliente.setVentas(list);
		return cliente.getVentas();
		
	}
	
	/**
     * Desasocia una Venta existente de un Cliente existente
     *
     * @param clienteId Identificador de la instancia de Cliente
     * @param ventaId Identificador de la instancia de Venta
     * @generated
     */
	@Override
	public void removeVenta(int clienteId, int ventaId) {
		Cliente cliente = getClienteById(clienteId);
		Venta venta = new Venta();
		venta.setIdVenta(ventaId);
		cliente.getVentas().remove(venta);
	}
	// navegacion en clientes
	@Override
	public Cliente getFirst() {
		return clientedao.getFirst();
	}

	@Override
	public Cliente getLast() {
		return clientedao.getLast();
	}

	@Override
	public Cliente getNext(int clienteId) {
		return clientedao.getNext(clienteId);
	}

	@Override
	public Cliente getPrev(int clienteId) {
		return clientedao.getPrev(clienteId);
	}
}
