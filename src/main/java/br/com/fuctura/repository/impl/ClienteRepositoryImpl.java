package br.com.fuctura.repository.impl;

import java.util.List;

import br.com.fuctura.model.Cliente;
import br.com.fuctura.repository.interfaces.IClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClienteRepositoryImpl implements IClienteRepository {

	private final EntityManager entityManager;

	public ClienteRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
	}

	@Override
	public Cliente update(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		return cliente;
	}

	@Override
	public void delete(String cpf) {
		entityManager.getTransaction().begin();
		Cliente cliente = findByCPF(cpf);
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();

	}

	@Override
	public Cliente findByCPF(String cpf) {
		String comandoSQL = "select c from Cliente c where cpf = :cpf";
		TypedQuery<Cliente> query = entityManager.createQuery(comandoSQL, Cliente.class);
		query.setParameter("cpf", cpf);
		
		Cliente resultadoConsulta = query.getSingleResult();
		return resultadoConsulta;
	}

	@Override
	public List<Cliente> findAll() {
		String comandoSQL = "select c from Cliente c";
		TypedQuery<Cliente> query = entityManager.createQuery(comandoSQL, Cliente.class);
		List<Cliente> resultList = query.getResultList();
		
		return resultList;
	}

}
