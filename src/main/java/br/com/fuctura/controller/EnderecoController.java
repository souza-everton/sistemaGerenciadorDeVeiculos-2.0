package br.com.fuctura.controller;

import javax.swing.JOptionPane;

import br.com.fuctura.dto.EnderecoDTO;
import br.com.fuctura.model.Endereco;
import br.com.fuctura.repository.impl.EnderecoRepositoryImpl;
//import br.com.fuctura.service.EnderecoService;

public class EnderecoController {

	private final EnderecoRepositoryImpl enderecoRepository;
	
	public EnderecoController(EnderecoRepositoryImpl enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public void cadastrar(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();
		enderecoRepository.create(endereco);
		JOptionPane.showMessageDialog(null, "Endereco Recebido.");
	}
	
	
}
