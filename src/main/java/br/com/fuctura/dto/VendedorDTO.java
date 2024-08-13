package br.com.fuctura.dto;

public class VendedorDTO {

	private String nome;
	private String cpf;
	private String celular;

	public VendedorDTO() {
	}

	public VendedorDTO(String nome, String cpf, String celular) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
