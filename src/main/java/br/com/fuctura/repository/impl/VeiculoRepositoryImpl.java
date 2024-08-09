package br.com.fuctura.repository.impl;

import br.com.fuctura.model.TipoVeiculo;
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
	public void update(String uniquePlaca, Integer opcao, String marca, String modelo, Integer ano, String Placa,
			Double preco, String categoria, String descricao) {
		entityManager.getTransaction().begin();
		Long codigoVeiculo = findByPlaca(uniquePlaca).getCodigo();
		Veiculo veiculo = entityManager.find(Veiculo.class, codigoVeiculo);
		TipoVeiculo tipoVeiculo = veiculo.getTipoVeiculo();
		veiculo.setMarca(marca);
		veiculo.setModelo(modelo);
		veiculo.setAno(ano);
		veiculo.setPlaca(Placa);
		veiculo.setPreco(preco);
		tipoVeiculo.setCategoria(categoria);
		tipoVeiculo.setDescricao(descricao);

		switch (opcao) {
		case 1:
			veiculo.setMarca(marca);
			break;
		case 2:
			veiculo.setModelo(modelo);
			break;
		case 3:
			veiculo.setAno(ano);
			break;
		case 4:
			veiculo.setPlaca(Placa);
			break;
		case 5:
			veiculo.setPreco(preco);
			break;
		case 6:
			tipoVeiculo.setCategoria(categoria);
			break;
		case 7:
			tipoVeiculo.setDescricao(descricao);
			break;
		}
		entityManager.getTransaction().commit();
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

}
