package br.com.fuctura.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendas")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
	@SequenceGenerator(name = "venda_seq", allocationSize = 1)
	private Long codigo;

	@Column(nullable = false)
	private Double valor;

	@JoinColumn(nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private Cliente cliente;

	@JoinColumn(nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private Vendedor vendedor;

	@JoinColumn(nullable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	private Loja loja;

	@JoinColumn(nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private Veiculo veiculo;

	private LocalDateTime dataDaVenda;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getDataDaVenda() {
		return dataDaVenda;
	}

	public void setDataDaVenda(LocalDateTime dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		return "\n-------------------------------------------------------------" +
				"\nCódigo: " + getCodigo() +
				"\nData: " + getDataDaVenda() +
				"\nLoja: " + loja.getNome() + 
				"\nPlaca do Veículo: " + veiculo.getPlaca() +
				"\nModelo do Veículo:" + veiculo.getModelo() +
				"\nAno do Veículo: " + veiculo.getAno() +
				"\nVendedor: " + vendedor.getNome() +
				" - " + vendedor.getCpf() +
				"\nCliente: " + cliente.getNome() +
				" - " + cliente.getCpf() +
				"\n-------------------------------------------------------------";
	}
}
