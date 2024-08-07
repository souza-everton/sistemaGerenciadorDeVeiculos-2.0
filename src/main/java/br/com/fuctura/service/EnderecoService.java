package br.com.fuctura.service;

import br.com.fuctura.dto.EnderecoDTO;
import br.com.fuctura.model.Endereco;

public class EnderecoService {

	public Endereco convertToEntity(EnderecoDTO enderecoDto) {
		Endereco endereco = new Endereco();
		endereco.setCep(enderecoDto.getCep());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setLocalidade(enderecoDto.getLocalidade());
		endereco.setComplemento(enderecoDto.getComplemento());
		return endereco;
	}
}
