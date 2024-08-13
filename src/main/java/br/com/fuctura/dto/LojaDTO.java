package br.com.fuctura.dto;

public class LojaDTO {

	private String cnpj;
	private String nome;
	private String telefone;
	private EnderecoDTO endereco;

	public LojaDTO() {

	}

	public LojaDTO(String cnpj, String nome, String telefone, EnderecoDTO endereco) {
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
}
