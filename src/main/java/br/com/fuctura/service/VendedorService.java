package br.com.fuctura.service;

import br.com.fuctura.dto.VendedorDTO;
import br.com.fuctura.model.Vendedor;
import br.com.fuctura.repository.impl.VendedorRepositoryImpl;

public class VendedorService {

	VendedorRepositoryImpl vendedorRepository;
	
	public Vendedor convertToVendedor(VendedorDTO vendedorDTO) {
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(vendedorDTO.getNome());
		vendedor.setCpf(vendedorDTO.getCpf());
		vendedor.setCelular(vendedorDTO.getCelular());
		return vendedor;
	}
	
	public VendedorDTO convertToVendedorDTO(Vendedor vendedor) {
		VendedorDTO vendedorDTO = new VendedorDTO();
		vendedorDTO.setNome(vendedor.getNome());
		vendedorDTO.setCpf(vendedor.getCpf());
		vendedorDTO.setCelular(vendedor.getCelular());
		return vendedorDTO;
	}
	
	public VendedorDTO updateVendedor(String cpf, VendedorDTO vendedorDTO) {
		Vendedor vendedorAtual = vendedorRepository.findByCPF(cpf);
		
		vendedorAtual.setNome(vendedorDTO.getNome());
		vendedorAtual.setCpf(vendedorDTO.getCpf());
		vendedorAtual.setCelular(vendedorDTO.getCelular());
		
		vendedorAtual = vendedorRepository.update(vendedorAtual);
		
		vendedorDTO = convertToVendedorDTO(vendedorAtual);
		return vendedorDTO;
	}
}
