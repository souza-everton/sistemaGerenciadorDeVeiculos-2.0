package br.com.fuctura.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "lojas")
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loja_seq")
	@SequenceGenerator(name = "loja_seq", allocationSize = 1)
	private Long codigo;

	@Column(nullable = false, unique = true)
	private String cnpj;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Loja() {

	}

	public Loja(String cnpj, String nome, String telefone, Endereco endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "\n-------------------------------------------------------------" +
				"\nCódigo: " + getCodigo() +
				"\nNome: " + getNome() + 
				"\nCNPJ: " + getCnpj() +
				"\nTelefone:" + getTelefone() +
				"\nCEP: " + endereco.getCep() +
				"\nLogradouro: " + endereco.getLogradouro() +
				", " + endereco.getNumero() +
				"\nBairro: " + endereco.getBairro() +
				"\nCidade: " + endereco.getLocalidade() +
				"\nComplemento: " + endereco.getComplemento() +
				"\n-------------------------------------------------------------";
	}
	
	

}
