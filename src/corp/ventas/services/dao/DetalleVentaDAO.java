package corp.ventas.services.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import corp.ventas.domain.DetalleVenta;

/**
 * Session Bean implementation class DetalleVentaDAO
 */
@Stateless
@LocalBean
public class DetalleVentaDAO extends GenericDAO<DetalleVenta> implements DetalleVentaDAOLocal {

    /**
     * Default constructor. 
     */
    public DetalleVentaDAO() {
        // TODO Auto-generated constructor stub
    }

}
