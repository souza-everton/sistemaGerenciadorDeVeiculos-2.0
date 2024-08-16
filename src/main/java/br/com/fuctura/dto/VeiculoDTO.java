package br.com.fuctura.dto;

public class VeiculoDTO {

	private String marca;
	private String modelo;
	private Integer ano;
	private String placa;
	private Double preco;
	private TipoVeiculoDTO tipoVeiculo;
	private LojaDTO loja;
	
	public VeiculoDTO() {
		
	}

	public VeiculoDTO(String marca, String modelo, Integer ano, String placa,Double preco, TipoVeiculoDTO tipoVeiculo, LojaDTO loja) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.preco = preco;
		this.tipoVeiculo = tipoVeiculo;
		this.loja = loja;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public TipoVeiculoDTO getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculoDTO tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public LojaDTO getLoja() {
		return loja;
	}

	public void setLoja(LojaDTO loja) {
		this.loja = loja;
	}
}
