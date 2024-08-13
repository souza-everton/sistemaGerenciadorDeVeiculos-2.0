package br.com.fuctura.repository.interfaces;

import java.util.List;

import br.com.fuctura.model.Loja;

public interface ILojaRepository {

	void create(Loja loja);
	
	Loja update(Loja loja);
	
	void delete(String cnpj);
	
	Loja findByCnpj(String cnpj);
	
	List<Loja> findAll();
}
