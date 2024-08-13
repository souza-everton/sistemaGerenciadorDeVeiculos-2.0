package br.com.fuctura.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_seq")
	@SequenceGenerator(name = "veiculo_seq", allocationSize = 1)
	private Long codigo;

	@Column(nullable = false)
	private String marca;

	@Column(nullable = false)
	private String modelo;

	@Column(length = 4, nullable = false)
	private Integer ano;

	@Column(length = 7, unique = true, nullable = false)
	private String placa;

	@Column(nullable = false)
	private Double preco;

	@OneToOne(cascade = CascadeType.ALL)
	private TipoVeiculo tipoVeiculo;

	@ManyToOne(cascade = CascadeType.ALL)
	private Loja loja;

	public Veiculo() {

	}

	public Long getCodigo() {
		return codigo;
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

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public String toString() {
		return "\n-------------------------------------------------------------" +
				"\nCódigo: " + getCodigo() +
				"\nMarca: " + getMarca() + 
				"\nPlaca: " + getPlaca() +
				"\nAno:" + getAno() +
				"\nPreço: " + getPreco() +
				"\nBairro: " + tipoVeiculo.getCategoria() +
				"\nLoja: " + getLoja() +
				"\nDescrição: " + tipoVeiculo.getDescricao() +
				"\n-------------------------------------------------------------";
	}
}
