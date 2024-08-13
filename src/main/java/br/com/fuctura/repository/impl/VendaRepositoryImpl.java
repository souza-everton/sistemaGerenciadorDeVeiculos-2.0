package br.com.fuctura.repository.impl;

import java.util.List;

import br.com.fuctura.model.Venda;
import br.com.fuctura.repository.interfaces.IVendaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class VendaRepositoryImpl implements IVendaRepository{

	private final EntityManager entityManager;
	
	public VendaRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Venda venda) {
		entityManager.getTransaction().begin();
		entityManager.persist(venda);
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(Long codigo) {
		entityManager.getTransaction().begin();
		Venda venda = entityManager.find(Venda.class, codigo);
		entityManager.remove(venda);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Venda> findAll() {
		String comandoSQL = "select v from Venda v";
		TypedQuery<Venda> query = entityManager.createQuery(comandoSQL, Venda.class);
		List<Venda> resultList = query.getResultList();
		return resultList;
	}
}
