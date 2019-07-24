package corp.ventas.services.ejb;

import java.util.List;

import javax.ejb.Local;

import corp.ventas.domain.Venta;

@Local
public interface VentaEJBInterface {
	public int countVenta();
    public List<Venta> getVentas();
    public List<Venta> getVentas(Integer page, Integer maxRecords);
    public Venta getVentaById(Object id);
    public Venta createVenta(Venta entity);
    public Venta updateVenta(Venta entity);
    public void deleteVenta(Venta entity);
}
