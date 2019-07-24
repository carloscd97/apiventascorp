package corp.ventas.mapper;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;

public class GenericMapper<T, V> implements IGenericMapper<T, V> {

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<V> getAll(List<T> listEntity) {
		// TODO Auto-generated method stub
		Class<V> entityClassDTO = (Class<V>) ((ParameterizedType)
				getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		List<V> list = new ArrayList<>();
		for(T entity : listEntity) {
			V entityDTO = new ModelMapper().map(entity, entityClassDTO);
			list.add(entityDTO);
		}
		return list;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public V mapperModelToViewModel(T entity) {
		Class<V> entityClassDTO = (Class<V>) ((ParameterizedType)
				getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		V entityDTO = new ModelMapper().map(entity, entityClassDTO);
		return entityDTO;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public T mapperViewModelToModel(V entityDTO) {
		Class<T> entityClass = (Class<T>) ((ParameterizedType)
				getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		T entity = new ModelMapper().map(entityDTO, entityClass);
		return entity;
	}
}
