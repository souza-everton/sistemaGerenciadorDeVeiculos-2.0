package br.com.fuctura.repository.impl;

import java.util.List;

import br.com.fuctura.model.Veiculo;
import br.com.fuctura.repository.interfaces.IVeiculoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class VeiculoRepositoryImpl implements IVeiculoRepository {

	private final EntityManager entityManager;

	public VeiculoRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Veiculo veiculo) {
		entityManager.getTransaction().begin();
		entityManager.persist(veiculo);
		entityManager.getTransaction().commit();

	}

	@Override
	public Veiculo update(Veiculo veiculo) {
		entityManager.getTransaction().begin();
		entityManager.merge(veiculo);
		entityManager.getTransaction().commit();

		return veiculo;

	}

	@Override
	public void delete(String placa) {
		entityManager.getTransaction().begin();
		Veiculo veiculo = findByPlaca(placa);
		entityManager.remove(veiculo);
		entityManager.getTransaction().commit();

	}

	@Override
	public Veiculo findByPlaca(String placa) {
		String comandoSQL = "select v from Veiculo v where placa = :placa";
		TypedQuery<Veiculo> query = entityManager.createQuery(comandoSQL, Veiculo.class);
		query.setParameter("placa", placa);

		Veiculo resultadoConsulta = query.getSingleResult();

		return resultadoConsulta;
	}

	@Override
	public List<Veiculo> findAll() {
		String comandoSQL = "select v from Veiculo v";
		TypedQuery<Veiculo> query = entityManager.createQuery(comandoSQL, Veiculo.class);
		
		List<Veiculo> resultList = query.getResultList();
		return resultList;
	}

}
