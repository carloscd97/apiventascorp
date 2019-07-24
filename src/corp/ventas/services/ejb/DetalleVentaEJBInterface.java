package corp.ventas.services.ejb;

import java.util.List;

import javax.ejb.Local;

import corp.ventas.domain.DetalleVenta;



@Local
public interface DetalleVentaEJBInterface {
	public int countDetalleVenta();
    public List<DetalleVenta> getDetallesVenta();
    public List<DetalleVenta> getDetallesVenta(Integer page, Integer maxRecords);
    public DetalleVenta getDetalleVentaById(Object id);
    public DetalleVenta createDetalleVenta(DetalleVenta entity);
    public DetalleVenta updateDetalleVenta(DetalleVenta entity);
    public void deleteDetalleVenta(DetalleVenta entity);
    
}
