package br.com.fuctura.view.manutencao_cadastro;

import javax.swing.JOptionPane;

import br.com.fuctura.controller.ClienteController;
import br.com.fuctura.dto.ClienteDTO;
import br.com.fuctura.dto.EnderecoDTO;
import br.com.fuctura.model.Cliente;
import br.com.fuctura.service.ClienteService;
import br.com.fuctura.service.ViacepService;

public class MenuGerenciarCliente {

	private static ClienteController clienteController;
	private static ClienteService clienteService;
	private static ViacepService viacepService;

	public static void exibirMenuCliente() {
		int opcao = 0;
		int confirmacao = 0;

		String menu = JOptionPane.showInputDialog("""
				1 - Cadastrar Cliente
				2 - Excluir Cliente
				3 - Alterar Dados Do Cliente
				4 - Menu Superior
				""");

		try {
			opcao = Integer.parseInt(menu);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			confirmacao = JOptionPane.showConfirmDialog(null, "Deseja Sair?", "Confirmação:",
					JOptionPane.YES_NO_OPTION);
			if (confirmacao == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			} else if (confirmacao == JOptionPane.YES_NO_OPTION) {
				exibirMenuCliente();
			} else {
				exibirMenuCliente();
			}
		}

		switch (opcao) {
		case 1:
			cadastrarCliente();
			break;
		case 2:
			excluirCliente();
			break;
		case 3:
			alterarDados();
			break;
		case 4:
			MenuManutencaoCadastro.exibirMenuManutencao();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
			exibirMenuCliente();
			break;
		}
	}

	public static void cadastrarCliente() {
		String nome = JOptionPane.showInputDialog(null, "Digite o Nome do Cliente:");
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente:");
		String celular = JOptionPane.showInputDialog(null, "Digite o Celular do Cliente:");
		String cep = JOptionPane.showInputDialog(null, "Digite o CEP do Endereço:");
		String numero = JOptionPane.showInputDialog(null, "Digite o Número do Endereço:");

		EnderecoDTO enderecoDTO = viacepService.getEndereco(cep);
		enderecoDTO.setNumero(numero);

		ClienteDTO clienteDTO = new ClienteDTO(nome, cpf, celular, enderecoDTO);

		clienteController.cadastrar(clienteDTO);
		exibirMenuCliente();
	}

	public static void excluirCliente() {
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente que Deseja Excluir:");
		clienteController.excluir(cpf);
		exibirMenuCliente();
	}

	public static void alterarDados() {
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente que Alterar os Dados:");
		Cliente cliente = clienteController.findByCPF(cpf);
		if (cliente != null) {
			ClienteDTO clienteDTO = clienteService.convertToClienteDTO(cliente);
			String escolherCampo = JOptionPane.showInputDialog("Informe o Campo que Deseja Alterar", """
					1 - Nome
					2 - CPF
					3 - Celular
					4 - Endereco
					""");
			Integer campoEscolhido = Integer.parseInt(escolherCampo);

			switch (campoEscolhido) {
			case 1:
				String nome = JOptionPane.showInputDialog(null, "Digite o Nome do Cliente:");
				clienteDTO.setNome(nome);
				break;
			case 2:
				cpf = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente:");
				clienteDTO.setCpf(cpf);
				break;
			case 3:
				String celular = JOptionPane.showInputDialog(null, "Digite o Celular do Cliente:");
				clienteDTO.setCelular(celular);
				break;
			case 4:
				String cep = JOptionPane.showInputDialog(null, "Digite o CEP do Endereço:");
				EnderecoDTO enderecoDTO = viacepService.getEndereco(cep);
				String numero = JOptionPane.showInputDialog(null, "Digite o Número do Endereço:");
				enderecoDTO.setNumero(numero);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
				exibirMenuCliente();
				break;
			}
			clienteController.update(clienteDTO, cpf);
		} else {
			JOptionPane.showMessageDialog(null, "Atenção!", "Cliente Não Encontrado", JOptionPane.WARNING_MESSAGE);
			exibirMenuCliente();
		}
	}
}
