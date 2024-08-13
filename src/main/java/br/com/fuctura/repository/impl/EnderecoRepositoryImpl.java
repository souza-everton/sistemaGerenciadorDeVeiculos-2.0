package br.com.fuctura.repository.impl;

import br.com.fuctura.model.Endereco;
import br.com.fuctura.repository.interfaces.IEnderecoRepository;
import jakarta.persistence.EntityManager;

public class EnderecoRepositoryImpl implements IEnderecoRepository {

	private final EntityManager entityManager;

	public EnderecoRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Endereco endereco) {
		entityManager.getTransaction().begin();
		entityManager.persist(endereco);
		entityManager.getTransaction().commit();

	}
}
