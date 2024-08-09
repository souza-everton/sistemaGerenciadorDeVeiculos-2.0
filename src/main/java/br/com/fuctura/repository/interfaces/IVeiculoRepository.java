package br.com.fuctura.repository.interfaces;

import br.com.fuctura.model.Veiculo;

public interface IVeiculoRepository {

	void create(Veiculo veiculo);

	void update(String uniquePlaca, Integer opcao, String marca, String modelo, Integer ano, String Placa, Double preco,
			String categoria, String descricao);

	void delete(String placa);

	Veiculo findByPlaca(String placa);

}
