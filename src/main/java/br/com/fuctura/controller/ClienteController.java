package br.com.fuctura.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fuctura.dto.ClienteDTO;
import br.com.fuctura.model.Cliente;
import br.com.fuctura.repository.impl.ClienteRepositoryImpl;
import br.com.fuctura.service.ClienteService;

public class ClienteController {

	private final ClienteRepositoryImpl clienteRepository;
	private final ClienteService clienteService;
	
	public ClienteController(ClienteRepositoryImpl clienteRepository, ClienteService clienteService) {
		this.clienteRepository = clienteRepository;
		this.clienteService = clienteService;
	}
	
	public void cadastrar(ClienteDTO clienteDTO) {
		Cliente cliente = clienteService.convertToCliente(clienteDTO);
		clienteRepository.create(cliente);
		JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso.");
	}
	
	public void excluir(String cpf) {
		clienteRepository.delete(cpf);
		JOptionPane.showMessageDialog(null, "Cadastro Excluído com Sucesso");
	}
	
	public ClienteDTO update(ClienteDTO clienteDTO, String cpf) {
		clienteDTO = clienteService.updateCliente(cpf, clienteDTO);
		JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso");
		return clienteDTO;
	}
	
	public Cliente findByCPF(String cpf) {
		Cliente cliente = new Cliente();
		try {
			cliente = clienteRepository.findByCPF(cpf);
			return cliente;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cliente Não Encontrado.");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Cliente> findAll(){
		try {
			List<Cliente> clientes = clienteRepository.findAll();
			return clientes;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não Há Clientes Cadastradas.");
			e.printStackTrace();
		}
		 
		return null;
	}
}
