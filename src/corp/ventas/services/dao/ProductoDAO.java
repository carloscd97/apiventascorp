package corp.ventas.services.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import corp.ventas.domain.Producto;

/**
 * Session Bean implementation class ProductoDAO
 */
@Stateless
@LocalBean
public class ProductoDAO extends GenericDAO<Producto> implements ProductoDAOLocal {

    /**
     * Default constructor. 
     */
    public ProductoDAO() {
        // TODO Auto-generated constructor stub
    }

}
