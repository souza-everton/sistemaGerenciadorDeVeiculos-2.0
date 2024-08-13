package br.com.fuctura.repository.interfaces;

import java.util.List;

import br.com.fuctura.model.Veiculo;

public interface IVeiculoRepository {

	void create(Veiculo veiculo);

	Veiculo update(Veiculo veiculo);

	void delete(String placa);

	Veiculo findByPlaca(String placa);
	
	List<Veiculo> findAll();

}
