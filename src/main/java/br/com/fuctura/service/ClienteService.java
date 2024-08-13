package br.com.fuctura.service;

import br.com.fuctura.dto.ClienteDTO;
import br.com.fuctura.model.Cliente;
import br.com.fuctura.repository.impl.ClienteRepositoryImpl;

public class ClienteService {
	
	ClienteRepositoryImpl clienteRepository;
	EnderecoService enderecoService;

	public Cliente convertToCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setNome(clienteDTO.getNome());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setCelular(clienteDTO.getCelular());
		cliente.setEndereco(enderecoService.convertToEndereco(clienteDTO.getEndereco()));
		return cliente;
	}
	
	public ClienteDTO convertToClienteDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setCelular(cliente.getCelular());
		clienteDTO.setEndereco(enderecoService.convertToEnderecoDTO(cliente.getEndereco()));
		return clienteDTO;
	}
	
	public ClienteDTO updateCliente(String cpf, ClienteDTO clienteDTO) {
		Cliente clienteAtual = clienteRepository.findByCPF(cpf);
		
		clienteAtual.setNome(clienteDTO.getNome());
		clienteAtual.setCpf(clienteDTO.getCpf());
		clienteAtual.setCelular(clienteDTO.getCelular());
		clienteAtual.setEndereco(enderecoService.convertToEndereco(clienteDTO.getEndereco()));
		
		clienteAtual = clienteRepository.update(clienteAtual);
		
		clienteDTO = convertToClienteDTO(clienteAtual);
		
		return clienteDTO;
	}
}
