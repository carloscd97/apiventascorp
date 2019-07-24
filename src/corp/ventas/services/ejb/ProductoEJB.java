package corp.ventas.services.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import corp.ventas.domain.Producto;
import corp.ventas.services.dao.ProductoDAOLocal;

/**
 * Session Bean implementation class ProductoEJB
 */
@Stateless
@LocalBean
public class ProductoEJB implements ProductoEJBInterface {
	
	@Inject
	ProductoDAOLocal productodao;
	
    /**
     * Default constructor. 
     */
    public ProductoEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int countProducto() {
		return productodao.count();
	}

	@Override
	public List<Producto> getProductos() {
		return productodao.findAll();
	}

	@Override
	public List<Producto> getProductos(Integer page, Integer maxRecords) {
		return productodao.pagination("Producto.findAll", page, maxRecords);
	}

	@Override
	public Producto getProductoById(Object id) {
		return productodao.findByID(id);
	}

	@Override
	public Producto createProducto(Producto entity) {
		productodao.create(entity);
		return entity;
	}

	@Override
	public Producto updateProducto(Producto entity) {
		return productodao.update(entity);
	}

	@Override
	public void deleteProducto(Producto entity) {
		productodao.delete(entity);
		
	}

}
