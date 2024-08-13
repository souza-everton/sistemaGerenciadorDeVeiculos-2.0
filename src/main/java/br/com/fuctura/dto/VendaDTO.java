package br.com.fuctura.dto;

import java.time.LocalDateTime;

public class VendaDTO {

	private Double valor;
	private ClienteDTO cliente;
	private VendedorDTO vendedor;
	private LojaDTO loja;
	private VeiculoDTO veiculo;
	private LocalDateTime dataVenda;
	
	public VendaDTO() {
		
	}
	
	public VendaDTO(Double valor, ClienteDTO cliente, VendedorDTO vendedor, LojaDTO loja, VeiculoDTO veiculo,
			LocalDateTime dataVenda) {
		this.valor = valor;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.loja = loja;
		this.veiculo = veiculo;
		this.dataVenda = dataVenda;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public VendedorDTO getVendedor() {
		return vendedor;
	}
	public void setVendedor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}
	public LojaDTO getLoja() {
		return loja;
	}
	public void setLoja(LojaDTO loja) {
		this.loja = loja;
	}
	public VeiculoDTO getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}
	public LocalDateTime getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}
}
