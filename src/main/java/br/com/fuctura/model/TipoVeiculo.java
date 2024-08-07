package br.com.fuctura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_veiculo")
public class TipoVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_seq")
	@SequenceGenerator(name = "tipo_seq", allocationSize = 1)
	private Long codigo;
	private String categoria;
	private String descricao;

	public TipoVeiculo() {

	}

	public TipoVeiculo(String categoria, String descricao) {
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
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
