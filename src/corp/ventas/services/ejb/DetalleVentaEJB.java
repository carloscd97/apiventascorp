package corp.ventas.services.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import corp.ventas.domain.DetalleVenta;
import corp.ventas.services.dao.DetalleVentaDAOLocal;

/**
 * Session Bean implementation class DetalleVentaEJB
 */
@Stateless
@LocalBean
public class DetalleVentaEJB implements DetalleVentaEJBInterface {
	@Inject
	DetalleVentaDAOLocal detalledao;
	
    /**
     * Default constructor. 
     */
    public DetalleVentaEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int countDetalleVenta() {
		return detalledao.count();
	}

	@Override
	public List<DetalleVenta> getDetallesVenta() {
		return detalledao.findAll();
	}

	@Override
	public List<DetalleVenta> getDetallesVenta(Integer page, Integer maxRecords) {
		return detalledao.pagination("DetalleVenta.findAll", page, maxRecords);
	}

	@Override
	public DetalleVenta getDetalleVentaById(Object id) {
		return detalledao.findByID(id);
	}

	@Override
	public DetalleVenta createDetalleVenta(DetalleVenta entity) {
		detalledao.create(entity);
		return entity;
	}

	@Override
	public DetalleVenta updateDetalleVenta(DetalleVenta entity) {
		return detalledao.update(entity);
	}

	@Override
	public void deleteDetalleVenta(DetalleVenta entity) {
		detalledao.delete(entity);		
	}

}
