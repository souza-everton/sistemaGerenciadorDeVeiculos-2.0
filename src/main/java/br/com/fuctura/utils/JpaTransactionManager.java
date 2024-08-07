package br.com.fuctura.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaTransactionManager {

	private static final EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("VEICULOS-PU");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
