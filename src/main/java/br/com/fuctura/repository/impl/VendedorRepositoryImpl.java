package br.com.fuctura.repository.impl;

import java.util.List;

import br.com.fuctura.model.Vendedor;
import br.com.fuctura.repository.interfaces.IVendedorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class VendedorRepositoryImpl implements IVendedorRepository {

	private final EntityManager entityManager;

	public VendedorRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Vendedor vendedor) {
		entityManager.getTransaction().begin();
		entityManager.persist(vendedor);
		entityManager.getTransaction().commit();

	}

	@Override
	public Vendedor update(Vendedor vendedor) {
		entityManager.getTransaction().begin();
		entityManager.merge(vendedor);
		entityManager.getTransaction().commit();
		return vendedor;
	}

	@Override
	public void delete(String cpf) {
		entityManager.getTransaction().begin();
		Vendedor vendedor = findByCPF(cpf);
		entityManager.remove(vendedor);
		entityManager.getTransaction().commit();

	}

	@Override
	public Vendedor findByNome(String nome) {
		String comandoSQL = "select v from Vendedor v where nome = :nome";
		TypedQuery<Vendedor> query = entityManager.createQuery(comandoSQL, Vendedor.class);
		query.setParameter("nome", nome);

		Vendedor resultadoConsulta = query.getSingleResult();

		return resultadoConsulta;
	}

	@Override
	public List<Vendedor> findAll() {
		String comandoSQL = "select v from Vendedor v";
		TypedQuery<Vendedor> query = entityManager.createQuery(comandoSQL,Vendedor.class);
		List<Vendedor> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public Vendedor findByCPF(String cpf) {
		String comandoSQL = "select v from Vendedor v where cpf = :cpf";
		TypedQuery<Vendedor> query = entityManager.createQuery(comandoSQL, Vendedor.class);
		query.setParameter("cpf", cpf);
		
		Vendedor resultadoConsulta = query.getSingleResult();
		return resultadoConsulta;
	}

}
