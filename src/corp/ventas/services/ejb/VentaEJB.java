package corp.ventas.services.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import corp.ventas.domain.Venta;
import corp.ventas.services.dao.VentaDAOLocal;

/**
 * Session Bean implementation class VentaEJB
 */
@Stateless
@LocalBean
public class VentaEJB implements VentaEJBInterface {
	@Inject
	VentaDAOLocal ventadao;
	
    /**
     * Default constructor. 
     */
    public VentaEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int countVenta() {
		return ventadao.count();
	}

	@Override
	public List<Venta> getVentas() {
		return ventadao.findAll();
	}

	@Override
	public List<Venta> getVentas(Integer page, Integer maxRecords) {
		return ventadao.pagination("Venta.findAll", page, maxRecords);
	}

	@Override
	public Venta getVentaById(Object id) {
		return ventadao.findByID(id);
	}

	@Override
	public Venta createVenta(Venta entity) {
		ventadao.create(entity);
		return entity;
	}

	@Override
	public Venta updateVenta(Venta entity) {
		return ventadao.update(entity);
	}

	@Override
	public void deleteVenta(Venta entity) {
		ventadao.delete(entity);		
	}

}
