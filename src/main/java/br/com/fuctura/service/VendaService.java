package br.com.fuctura.service;

import br.com.fuctura.dto.VendaDTO;
import br.com.fuctura.model.Venda;
import br.com.fuctura.repository.impl.VendaRepositoryImpl;

public class VendaService {
	
	VendaRepositoryImpl vendaRepository;
	ClienteService cliente;
	VendedorService vendedor;
	LojaService loja;
	VeiculoService veiculo;

	public Venda convertToVenda(VendaDTO vendaDTO) {
		Venda venda = new Venda();
		venda.setValor(vendaDTO.getVeiculo().getPreco());
		venda.setCliente(cliente.convertToCliente(vendaDTO.getCliente()));
		venda.setVendedor(vendedor.convertToVendedor(vendaDTO.getVendedor()));
		venda.setLoja(loja.convertToLoja(vendaDTO.getLoja()));
		venda.setVeiculo(veiculo.convertToVeiculo(vendaDTO.getVeiculo()));
		venda.setDataDaVenda(vendaDTO.getDataVenda());
		
		return venda;
	}
	
	public VendaDTO convertToVendaDTO(Venda venda) {
		VendaDTO vendaDTO = new VendaDTO();
		vendaDTO.setValor(venda.getVeiculo().getPreco());
		vendaDTO.setCliente(cliente.convertToClienteDTO(venda.getCliente()));
		vendaDTO.setVendedor(vendedor.convertToVendedorDTO(venda.getVendedor()));
		vendaDTO.setLoja(loja.convertToLojaDTO(venda.getLoja()));
		vendaDTO.setVeiculo(veiculo.convertToVeiculoDTO(venda.getVeiculo()));
		vendaDTO.setDataVenda(venda.getDataDaVenda());
		
		return vendaDTO;
	}
}
