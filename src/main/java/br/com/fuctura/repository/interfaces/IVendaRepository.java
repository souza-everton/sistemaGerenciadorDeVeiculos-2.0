package br.com.fuctura.repository.interfaces;

import java.util.List;

import br.com.fuctura.model.Venda;

public interface IVendaRepository {

	void create(Venda venda);
	
	void delete(Long codigo);
	
	List<Venda> findAll();
}
