package br.com.fuctura.repository.impl;

import java.util.List;

import br.com.fuctura.model.Loja;
import br.com.fuctura.repository.interfaces.ILojaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LojaRepositoryImpl implements ILojaRepository {

	private final EntityManager entityManager;

	public LojaRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Loja loja) {
		entityManager.getTransaction().begin();
		entityManager.persist(loja);
		entityManager.getTransaction().commit();
	}

	@Override
	public Loja update(Loja loja) {
		entityManager.getTransaction().begin();
		entityManager.merge(loja);
		entityManager.getTransaction().commit();
		return loja;
	}

	@Override
	public void delete(String cnpj) {
		entityManager.getTransaction().begin();
		Loja loja = findByCnpj(cnpj);
		entityManager.remove(loja);
		entityManager.getTransaction().commit();
	}

	@Override
	public Loja findByCnpj(String cnpj) {
		String comandoSQL = "select l from Loja l where cnpj = :cnpj";
		TypedQuery<Loja> query = entityManager.createQuery(comandoSQL, Loja.class);
		query.setParameter("cnpj", cnpj);

		Loja loja = query.getSingleResult();
		return loja;
	}

	@Override
	public List<Loja> findAll() {
		String comandoSQL = "select l from Loja l";
		TypedQuery<Loja> query = entityManager.createQuery(comandoSQL, Loja.class);
		List<Loja> resultList = query.getResultList();
		return resultList;
	}
}
