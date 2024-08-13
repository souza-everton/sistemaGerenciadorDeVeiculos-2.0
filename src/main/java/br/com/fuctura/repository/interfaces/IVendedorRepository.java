package br.com.fuctura.repository.interfaces;

import java.util.List;

import br.com.fuctura.model.Vendedor;

public interface IVendedorRepository {

	void create(Vendedor vendedor);
	
	Vendedor update(Vendedor vendedor);
	
	void delete(String cpf);
	
	Vendedor findByNome(String nome);
	
	Vendedor findByCPF(String cpf);
	
	List<Vendedor> findAll();
}
