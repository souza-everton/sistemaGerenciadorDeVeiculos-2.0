package br.com.fuctura.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fuctura.dto.VeiculoDTO;
import br.com.fuctura.model.Veiculo;
import br.com.fuctura.repository.impl.VeiculoRepositoryImpl;
import br.com.fuctura.service.VeiculoService;

public class VeiculoController {

	private final VeiculoRepositoryImpl veiculoRepository;
	private final VeiculoService veiculoService;
	
	public VeiculoController(VeiculoRepositoryImpl veiculoRepository, VeiculoService veiculoService) {
		this.veiculoRepository = veiculoRepository;
		this.veiculoService = veiculoService;
	}
	
	public void cadastrar(VeiculoDTO veiculoDTO) {
		Veiculo veiculo = veiculoService.convertToVeiculo(veiculoDTO);
		veiculoRepository.create(veiculo);
		JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso.");
	}
	
	public void excluir(String placa) {
		veiculoRepository.delete(placa);
		JOptionPane.showMessageDialog(null, "Cadastro Excluído com Sucesso");
	}
	
	public VeiculoDTO update(String placa, VeiculoDTO veiculoDTO) {
		veiculoDTO = veiculoService.updateVeiculo(placa, veiculoDTO);
		JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso");
		return veiculoDTO;
	}
	
	public Veiculo findByPlaca(String placa) {
		Veiculo veiculo = new Veiculo();
		try {
			veiculo = veiculoRepository.findByPlaca(placa);
			return veiculo;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Veículo Não Encontrado.");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Veiculo> findAll(){
		try {
			List<Veiculo> veiculos = veiculoRepository.findAll();
			return veiculos;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não Há Veículos Cadastradas.");
			e.printStackTrace();
		}
		return null;
	}
}
