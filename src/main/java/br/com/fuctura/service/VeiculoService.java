package br.com.fuctura.service;

import br.com.fuctura.dto.VeiculoDTO;
import br.com.fuctura.model.Veiculo;

public class VeiculoService {

	public Veiculo convertToVeiculo(VeiculoDTO veiculoDTO) {
		Veiculo veiculo = new Veiculo();
		veiculo.setMarca(veiculoDTO.getMarca());
		veiculo.setModelo(veiculoDTO.getModelo());
		veiculo.setAno(veiculoDTO.getAno());
		veiculo.setPlaca(veiculoDTO.getPlaca());
		veiculo.setTipoVeiculo(veiculoDTO.getTipoVeiculo());
		veiculo.setLoja(veiculoDTO.getLoja());
		
		return veiculo;
	}
}
