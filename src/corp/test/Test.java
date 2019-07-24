package corp.test;

// Para crear las tablas de la base de datos
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	private static final String PERSISTENCE_UNIT_NAME ="apiVentasCorp";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
			System.out.println("creación exitosa de la base de datos");
		
		em.getTransaction().commit();
		em.close();
	}

}
