package br.com.fuctura.dto;

public class TipoVeiculoDTO {

	private String categoria;
	private String descricao;

	public TipoVeiculoDTO() {

	}

	public TipoVeiculoDTO(String categoria, String descricao) {
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
