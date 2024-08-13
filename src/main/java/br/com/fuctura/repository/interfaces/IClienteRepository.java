package br.com.fuctura.repository.interfaces;

import java.util.List;

import br.com.fuctura.model.Cliente;

public interface IClienteRepository {

	void create(Cliente cliente);
	
	Cliente update(Cliente cliente);
	
	void delete(String cpf);
	
	Cliente findByCPF(String cpf);
	
	List<Cliente> findAll();
	
}
