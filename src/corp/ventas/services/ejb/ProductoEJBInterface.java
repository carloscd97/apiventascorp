package corp.ventas.services.ejb;

import java.util.List;

import javax.ejb.Local;

import corp.ventas.domain.Producto;


@Local
public interface ProductoEJBInterface {
	public int countProducto();
    public List<Producto> getProductos();
    public List<Producto> getProductos(Integer page, Integer maxRecords);
    public Producto getProductoById(Object id);
    public Producto createProducto(Producto entity);
    public Producto updateProducto(Producto entity);
    public void deleteProducto(Producto entity);

}
