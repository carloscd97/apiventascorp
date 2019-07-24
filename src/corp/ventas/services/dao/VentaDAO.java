package corp.ventas.services.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import corp.ventas.domain.Venta;

/**
 * Session Bean implementation class VentaDAO
 */
@Stateless
@LocalBean
public class VentaDAO extends GenericDAO<Venta> implements VentaDAOLocal {

    /**
     * Default constructor. 
     */
    public VentaDAO() {
        // TODO Auto-generated constructor stub
    }

}
