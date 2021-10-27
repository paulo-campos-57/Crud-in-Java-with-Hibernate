package Model.utill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutill {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("JPA_Project");
	}

	/**
	 * Método responsável por retornar um entityManager
	 * 
	 * @return EntityManager
	 */
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void closeEntityManager() {
		factory.close();
	}
}
