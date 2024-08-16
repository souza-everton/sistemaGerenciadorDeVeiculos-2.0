package br.com.fuctura.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fuctura.dto.VendaDTO;
import br.com.fuctura.model.Venda;
import br.com.fuctura.repository.impl.VendaRepositoryImpl;
import br.com.fuctura.service.VendaService;

public class VendasController {

	private final VendaRepositoryImpl vendaRepository;
	private final VendaService vendaService;

	public VendasController(VendaRepositoryImpl vendaRepository, VendaService vendaService) {
		this.vendaRepository = vendaRepository;
		this.vendaService = vendaService;
	}
	
	public void create(VendaDTO vendaDTO) {
		Venda venda = vendaService.convertToVenda(vendaDTO);
		vendaRepository.create(venda);
		JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso.");
	}
	
	public void excluir(Long codigo) {
		vendaRepository.delete(codigo);
		JOptionPane.showMessageDialog(null, "Cadastro Excluído com Sucesso");
	}
	
	public List<Venda> findAll(){
		List<Venda> vendas = vendaRepository.findAll();
		return vendas;
	}
}
