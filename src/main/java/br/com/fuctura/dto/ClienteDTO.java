package br.com.fuctura.dto;

public class ClienteDTO {

	private String nome;
	private String cpf;
	private String celular;
	private EnderecoDTO endereco;

	public ClienteDTO() {

	}

	public ClienteDTO(String nome, String cpf, String celular, EnderecoDTO endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.endereco = endereco;
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
}
