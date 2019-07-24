package corp.ventas.services.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import corp.ventas.domain.Cliente;

/**
 * Session Bean implementation class ClienteDAO
 */
@Stateless
@LocalBean
public class ClienteDAO extends GenericDAO<Cliente> implements ClienteDAOLocal {

    /**
     * Default constructor. 
     */
    public ClienteDAO() {
        // TODO Auto-generated constructor stub
    }

    
}
