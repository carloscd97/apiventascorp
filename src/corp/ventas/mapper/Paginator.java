package corp.ventas.mapper;

import java.util.List;

public class Paginator<T> {

	public int itemsPerPage;
	public int pageInit;
	public int currentPage;
	public int lastPage;
	public List<T> items;
	
	public Paginator(int itemsPerPage, int pageInit, int currentPage, int lastPage, List<T> items){
		this.itemsPerPage = itemsPerPage;
		this.pageInit = pageInit;
		this.currentPage = currentPage;
		this.lastPage = lastPage;
		this.items = items;
	}
}
