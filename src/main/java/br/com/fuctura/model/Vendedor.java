package br.com.fuctura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedores")
public class Vendedor extends Pessoa {

	public Vendedor() {

	}

	public Vendedor(String nome, String cpf, String celular) {
		super(nome, cpf, celular);
	}
	
	@Override
	public String toString() {
		return "\n-------------------------------------------------------------" +
				"\nCódigo: " + getCodigo() +
				"\nNome: " + getNome() + 
				"\nCPF: " + getCpf() +
				"\nCelular:" + getCelular() +
				"\n-------------------------------------------------------------";
	}

}
