package corp.ventas.services.dao;

import java.util.List;
import java.util.Map;

public interface GenericDAOInterface<T>  {
	public void create(T entity);
	public void delete(T entity);
	public T update(T entity) ;
	public T findByID(Object entityID);
	public List<T> findAll();
	public List<T> findRange(int[] range);
	public int count();
	public List<T> pagination(String name, Integer page, Integer maxRecords);
	public <V> List<V> executeListNamedQuery(String name);
	public <V> List<V> executeListNamedQuery(String name, Map<String, Object> params);
	public <V> V executeSingleNamedQuery(String name);
	public <V> V executeSingleNamedQuery(String name, Map<String, Object> params);
	public List<T> findByName(String text);
	public List<T> findByName(String text, Integer page, Integer maxRecords);
	public <V> List<V> executeListNamedQueryByString(String name, String parametroBusqueda, String textoBusqueda);
	
	//para navegacion entre objetos
	public T getFirst();
	public T getLast();
	public T getNext(Object id);
	public T getPrev(Object id);
}
