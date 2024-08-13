package br.com.fuctura.service;

import br.com.fuctura.dto.VeiculoDTO;
import br.com.fuctura.model.Veiculo;
import br.com.fuctura.repository.impl.VeiculoRepositoryImpl;

public class VeiculoService {

	VeiculoRepositoryImpl veiculoRepository;

	public Veiculo convertToVeiculo(VeiculoDTO veiculoDTO) {
		Veiculo veiculo = new Veiculo();
		veiculo.setMarca(veiculoDTO.getMarca());
		veiculo.setModelo(veiculoDTO.getModelo());
		veiculo.setAno(veiculoDTO.getAno());
		veiculo.setPlaca(veiculoDTO.getPlaca());
		veiculo.setPreco(veiculoDTO.getPreco());
		veiculo.setTipoVeiculo(veiculoDTO.getTipoVeiculo());
		veiculo.setLoja(veiculoDTO.getLoja());

		return veiculo;
	}

	public VeiculoDTO convertToVeiculoDTO(Veiculo veiculo) {
		VeiculoDTO veiculoDTO = new VeiculoDTO();
		veiculoDTO.setMarca(veiculo.getMarca());
		veiculoDTO.setModelo(veiculo.getModelo());
		veiculoDTO.setAno(veiculo.getAno());
		veiculoDTO.setPlaca(veiculo.getPlaca());
		veiculoDTO.setPreco(veiculo.getPreco());
		veiculoDTO.setTipoVeiculo(veiculo.getTipoVeiculo());
		veiculoDTO.setLoja(veiculo.getLoja());
		return veiculoDTO;
	}

	public VeiculoDTO updateVeiculo(String placa, VeiculoDTO veiculoDTO) {

		Veiculo veiculoAtual = veiculoRepository.findByPlaca(placa);

		veiculoAtual.setMarca(veiculoDTO.getMarca());
		veiculoAtual.setModelo(veiculoDTO.getModelo());
		veiculoAtual.setAno(veiculoDTO.getAno());
		veiculoAtual.setPlaca(veiculoDTO.getPlaca());
		veiculoAtual.setPreco(veiculoDTO.getPreco());
		veiculoAtual.setTipoVeiculo(veiculoDTO.getTipoVeiculo());
		veiculoAtual.setLoja(veiculoDTO.getLoja());

		veiculoAtual = veiculoRepository.update(veiculoAtual);

		veiculoDTO = convertToVeiculoDTO(veiculoAtual);

		return veiculoDTO;

	}
}
