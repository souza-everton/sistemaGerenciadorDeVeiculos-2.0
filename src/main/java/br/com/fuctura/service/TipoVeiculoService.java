package br.com.fuctura.service;

import br.com.fuctura.dto.TipoVeiculoDTO;
import br.com.fuctura.model.TipoVeiculo;

public class TipoVeiculoService {

	public TipoVeiculo convertToTipoVeiculo(TipoVeiculoDTO tipoVeiculoDTO) {
		TipoVeiculo tipoVeiculo = new TipoVeiculo();
		tipoVeiculo.setCategoria(tipoVeiculoDTO.getCategoria());
		tipoVeiculo.setDescricao(tipoVeiculoDTO.getDescricao());
		return tipoVeiculo;
	}
	
	public TipoVeiculoDTO convertToTipoVeiculoDTO(TipoVeiculo tipoVeiculo) {
		TipoVeiculoDTO tipoVeiculoDTO = new TipoVeiculoDTO();
		tipoVeiculoDTO.setCategoria(tipoVeiculo.getCategoria());
		tipoVeiculoDTO.setDescricao(tipoVeiculo.getDescricao());
		return tipoVeiculoDTO;
	}
}
