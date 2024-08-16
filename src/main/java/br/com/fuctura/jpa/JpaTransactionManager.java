package br.com.fuctura.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaTransactionManager {

	private static final EntityManagerFactory factory;
	
	static {
	    try {
	        factory = Persistence.createEntityManagerFactory("VEICULOS-PU");
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to create EntityManagerFactory", e);
	    }
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
