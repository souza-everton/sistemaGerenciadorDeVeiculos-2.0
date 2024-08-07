package br.com.fuctura.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa {

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Cliente() {

	}

	public Cliente(String nome, String cpf, String celular, Endereco endereco) {
		super(nome, cpf, celular);
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "\n-------------------------------------------------------------" +
				"\nCódigo: " + getCodigo() +
				"\nNome: " + getNome() + 
				"\nCPF: " + getCpf() +
				"\nCelular:" + getCelular() +
				"\nCEP: " + endereco.getCep() +
				"\nLogradouro: " + endereco.getLogradouro() +
				", " + endereco.getNumero() +
				"\nBairro: " + endereco.getBairro() +
				"\nCidade: " + endereco.getLocalidade() +
				"\nComplemento: " + endereco.getComplemento() +
				"\n-------------------------------------------------------------";
	}
}
