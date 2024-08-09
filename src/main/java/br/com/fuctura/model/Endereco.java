package br.com.fuctura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
	@SequenceGenerator(name = "endereco_seq", allocationSize = 1)
	@Column(unique = true)
	private Long codigo;
	@Column(length = 8, nullable = false)
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String localidade;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Long getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return 	"\nCEP: "+ getCep() +
				"\nLogradouro: "+ getLogradouro() + ", " + getNumero() +
				"\nBairro: "+ getBairro() +
				"\nCidade: "+ getLocalidade() +
				"\nComplemento: " + getComplemento();
	}
}
