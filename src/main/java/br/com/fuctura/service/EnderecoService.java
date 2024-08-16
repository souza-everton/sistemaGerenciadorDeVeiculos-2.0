package br.com.fuctura.service;

import br.com.fuctura.dto.EnderecoDTO;
import br.com.fuctura.model.Endereco;

public class EnderecoService {

	public Endereco convertToEndereco(EnderecoDTO enderecoDto) {
		Endereco endereco = new Endereco();
		endereco.setCep(enderecoDto.getCep());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setLocalidade(enderecoDto.getLocalidade());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setNumero(enderecoDto.getNumero());
		return endereco;
	}
	
	public EnderecoDTO convertToEnderecoDTO(Endereco endereco) {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setLogradouro(endereco.getLogradouro());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setLocalidade(endereco.getLocalidade());
		enderecoDTO.setComplemento(endereco.getComplemento());
		enderecoDTO.setNumero(endereco.getNumero());
		return enderecoDTO;
	}
}
