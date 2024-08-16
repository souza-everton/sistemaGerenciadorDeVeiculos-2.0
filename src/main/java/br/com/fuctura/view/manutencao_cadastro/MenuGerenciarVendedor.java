package br.com.fuctura.view.manutencao_cadastro;

import javax.swing.JOptionPane;

import br.com.fuctura.controller.VendedorController;
import br.com.fuctura.dto.VendedorDTO;
import br.com.fuctura.model.Vendedor;
import br.com.fuctura.service.VendedorService;

public class MenuGerenciarVendedor {

	private static VendedorController vendedorController;
	private static VendedorService vendedorService;

	public static void exibirMenuVendedor() {

		int opcao = 0;
		int confirmacao = 0;

		String menu = JOptionPane.showInputDialog("""
				1 - Cadastrar Vendedor
				2 - Excluir Vendedor
				3 - Alterar Dados Do Vendedor
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
				exibirMenuVendedor();
			} else {
				exibirMenuVendedor();
			}
		}

		switch (opcao) {
		case 1:
			cadastrarVendedor();
			break;
		case 2:
			excluirVendedor();
			break;
		case 3:
			alterarDados();
			break;
		case 4:
			MenuManutencaoCadastro.exibirMenuManutencao();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
			exibirMenuVendedor();
			break;
		}
	}

	public static void cadastrarVendedor() {
		String nome = JOptionPane.showInputDialog(null, "Digite o Nome do Vendedor:");
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do Vendedor:");
		String celular = JOptionPane.showInputDialog(null, "Digite o Celular do Vendedor:");

		VendedorDTO vendedorDTO = new VendedorDTO(nome, cpf, celular);

		vendedorController.cadastrar(vendedorDTO);
		exibirMenuVendedor();
	}

	public static void excluirVendedor() {
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do Vendedor que Deseja Excluir:");
		vendedorController.excluir(cpf);
		exibirMenuVendedor();
	}

	public static void alterarDados() {
		String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do Vendedor que Alterar os Dados:");
		Vendedor vendedor = vendedorController.findByCPF(cpf);

		if (vendedor != null) {
			VendedorDTO vendedorDTO = vendedorService.convertToVendedorDTO(vendedor);
			String escolherCampo = JOptionPane.showInputDialog("Informe o Campo que Deseja Alterar", """
					1 - Nome
					2 - CPF
					3 - Celular
					4 - Endereco
					""");
			Integer campoEscolhido = Integer.parseInt(escolherCampo);

			switch (campoEscolhido) {
			case 1:
				String nome = JOptionPane.showInputDialog(null, "Digite o Nome do Vendedor:");
				vendedorDTO.setNome(nome);
				break;
			case 2:
				cpf = JOptionPane.showInputDialog(null, "Digite o CPF do Vendedor:");
				vendedorDTO.setCpf(cpf);
				break;
			case 3:
				String celular = JOptionPane.showInputDialog(null, "Digite o Celular do Vendedor:");
				vendedorDTO.setCelular(celular);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
				exibirMenuVendedor();
				break;
			}
		}else {
			JOptionPane.showMessageDialog(null, "Atenção!", "Vendedor Não Encontrado", JOptionPane.WARNING_MESSAGE);
			exibirMenuVendedor();
		}

	}
}
