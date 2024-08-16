package br.com.fuctura.service;

import br.com.fuctura.dto.LojaDTO;
import br.com.fuctura.jpa.JpaTransactionManager;
import br.com.fuctura.model.Loja;
import br.com.fuctura.repository.impl.LojaRepositoryImpl;
import jakarta.persistence.EntityManager;

public class LojaService {

	EntityManager entityManager = JpaTransactionManager.getEntityManager();
	LojaRepositoryImpl lojaRepository = new LojaRepositoryImpl(entityManager);
	EnderecoService enderecoService = new EnderecoService();

	public Loja convertToLoja(LojaDTO lojaDTO) {
		Loja loja = new Loja();
		loja.setCnpj(lojaDTO.getCnpj());
		loja.setNome(lojaDTO.getNome());
		loja.setTelefone(lojaDTO.getTelefone());
		loja.setEndereco(enderecoService.convertToEndereco(lojaDTO.getEndereco()));
		return loja;
	}

	public LojaDTO convertToLojaDTO(Loja loja) {
		LojaDTO lojaDTO = new LojaDTO();
		lojaDTO.setCnpj(loja.getCnpj());
		lojaDTO.setNome(loja.getNome());
		lojaDTO.setTelefone(loja.getTelefone());
		lojaDTO.setEndereco(enderecoService.convertToEnderecoDTO(loja.getEndereco()));
		return lojaDTO;
	}

	public LojaDTO updateLoja(String cnpj, LojaDTO lojaDTO) {
		Loja lojaAtual = lojaRepository.findByCnpj(cnpj);
		lojaAtual.setCnpj(lojaDTO.getCnpj());
		lojaAtual.setNome(lojaDTO.getNome());
		lojaAtual.setTelefone(lojaDTO.getTelefone());
		lojaAtual.setEndereco(enderecoService.convertToEndereco(lojaDTO.getEndereco()));

		lojaAtual = lojaRepository.update(lojaAtual);

		lojaDTO = convertToLojaDTO(lojaAtual);
		return lojaDTO;
	}
}
