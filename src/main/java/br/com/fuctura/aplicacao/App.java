package br.com.fuctura.aplicacao;

import br.com.fuctura.dto.EnderecoDTO;
import br.com.fuctura.model.Cliente;
import br.com.fuctura.model.Endereco;
import br.com.fuctura.service.EnderecoService;
import br.com.fuctura.service.ViacepService;

public class App {

	public static void main(String[] args) {

		ViacepService viacepService = new ViacepService();
		EnderecoService enderecoService = new EnderecoService();
		Endereco endereco = new Endereco();
		Cliente cliente = new Cliente();
		
		
		

		try {
			EnderecoDTO enderecoDTO = viacepService.getEndereco("50070-425");
			endereco = enderecoService.convertToEndereco(enderecoDTO);
			endereco.setNumero("950");
			
			//System.out.println(endereco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cliente.setNome("Everton Souza");
		cliente.setCpf("123.456.789-55");
		cliente.setEndereco(endereco);
		cliente.setCelular("81999887766");
		System.out.println(cliente);
		
	}

}
