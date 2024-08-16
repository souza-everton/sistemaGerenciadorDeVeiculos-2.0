package br.com.fuctura.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fuctura.dto.LojaDTO;
import br.com.fuctura.jpa.JpaTransactionManager;
import br.com.fuctura.model.Loja;
import br.com.fuctura.repository.impl.LojaRepositoryImpl;
import br.com.fuctura.service.LojaService;
import jakarta.persistence.EntityManager;

public class LojaController {

	EntityManager entityManager = JpaTransactionManager.getEntityManager();
	private LojaRepositoryImpl lojaRepository = new LojaRepositoryImpl(entityManager);
	private LojaService lojaService = new LojaService();
	
	public LojaController() {
		
	}
	
	public void cadastrar(LojaDTO lojaDTO) {
		Loja loja = lojaService.convertToLoja(lojaDTO);
		lojaRepository.create(loja);
		JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso.");
	}
	
	public void excluir(String cnpj) {
		lojaRepository.delete(cnpj);
		JOptionPane.showMessageDialog(null, "Cadastro Excluído com Sucesso");
	}
	
	public LojaDTO update(LojaDTO lojaDTO, String cnpj) {
		lojaDTO = lojaService.updateLoja(cnpj, lojaDTO);
		JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso");
		return lojaDTO;
	}
	
	public Loja findByCnpj(String cnpj) {
		Loja loja = new Loja();
		try {
			loja = lojaRepository.findByCnpj(cnpj);
			return loja;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Loja Não Encontrada");
			e.printStackTrace();
			
		}
		return null;
	}
	
	public List<Loja> findAll(){
		try {
			List<Loja> lojas = lojaRepository.findAll();
			return lojas;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não Há Lojas Cadastradas.");
			e.printStackTrace();
		}
		return null;
	}
}
