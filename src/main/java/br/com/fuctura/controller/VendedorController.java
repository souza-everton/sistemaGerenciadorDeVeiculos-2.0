package br.com.fuctura.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fuctura.dto.VendedorDTO;
import br.com.fuctura.model.Vendedor;
import br.com.fuctura.repository.impl.VendedorRepositoryImpl;
import br.com.fuctura.service.VendedorService;

public class VendedorController {

	private final VendedorRepositoryImpl vendedorRepository;
	private final VendedorService vendedorService;
	
	public VendedorController(VendedorRepositoryImpl vendedorRepository, VendedorService vendedorService) {
		this.vendedorRepository = vendedorRepository;
		this.vendedorService = vendedorService;
	}
	
	public void cadastrar(VendedorDTO vendedorDTO) {
		Vendedor vendedor = vendedorService.convertToVendedor(vendedorDTO);
		vendedorRepository.create(vendedor);
		JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso.");
	}
	
	public void excluir(String cpf) {
		vendedorRepository.delete(cpf);
		JOptionPane.showMessageDialog(null, "Cadastro Excluído com Sucesso");
	}
	
	public VendedorDTO update(String cpf, VendedorDTO vendedorDTO) {
		vendedorDTO = vendedorService.updateVendedor(cpf, vendedorDTO);
		JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso");
		return vendedorDTO;
	}
	
	public Vendedor findByNome(String nome) {
		Vendedor vendedor = new Vendedor();
		try {
			vendedor = vendedorRepository.findByNome(nome);
			return vendedor;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vendedor Não Encontrado.");
			e.printStackTrace();
		}
		return null;
	}
	
	public Vendedor findByCPF(String cpf) {
		Vendedor vendedor = new Vendedor();
		try {
			vendedor = vendedorRepository.findByCPF(cpf);
			return vendedor;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cliente Não Encontrado.");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Vendedor> findAll(){
		try {
			List<Vendedor> vendedores = vendedorRepository.findAll();
			return vendedores;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não Há Vendedores Cadastradas.");
			e.printStackTrace();
		}
		
		return null;
	}
}
