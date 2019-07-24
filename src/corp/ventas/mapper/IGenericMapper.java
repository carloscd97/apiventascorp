package corp.ventas.mapper;
import java.util.List;

public interface IGenericMapper<T, V> {
	public List<V> getAll(List<T> listEntity);
	public V mapperModelToViewModel(T entity);
	public T mapperViewModelToModel(V entityDTO);
}
