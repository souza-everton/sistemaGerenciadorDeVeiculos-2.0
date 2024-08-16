package br.com.fuctura.view.manutencao_cadastro;

import javax.swing.JOptionPane;

import br.com.fuctura.controller.LojaController;
import br.com.fuctura.dto.EnderecoDTO;
import br.com.fuctura.dto.LojaDTO;
import br.com.fuctura.model.Loja;
import br.com.fuctura.service.LojaService;
import br.com.fuctura.service.ViacepService;

public class MenuGerenciarLoja {

	private static LojaController lojaController = new LojaController();
	private static LojaService lojaService = new LojaService();
	private static ViacepService viacepService = new ViacepService();

	public static void exibirMenuLoja() {
		int opcao = 0;
		int confirmacao = 0;

		String menu = JOptionPane.showInputDialog("""
				1 - Cadastrar Loja
				2 - Excluir Loja
				3 - Alterar Dados Da Loja
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
				exibirMenuLoja();
			} else {
				exibirMenuLoja();
			}
		}

		switch (opcao) {
		case 1:
			cadastrarLoja();
			break;
		case 2:
			excluirLoja();
			break;
		case 3:
			alterarDados();
			break;
		case 4:
			MenuManutencaoCadastro.exibirMenuManutencao();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
			exibirMenuLoja();
			break;
		}
	}

	public static void cadastrarLoja() {
		String cnpj = JOptionPane.showInputDialog(null, "Digite o CNPJ da Loja:");
		String nome = JOptionPane.showInputDialog(null, "Digite o Nome da Loja:");
		String telefone = JOptionPane.showInputDialog(null, "Digite o Telefone da Loja:");
		String cep = JOptionPane.showInputDialog(null, "Digite o CEP da Loja:");
		String numero = JOptionPane.showInputDialog(null, "Digite o Número da Loja:");

		EnderecoDTO enderecoDTO = viacepService.getEndereco(cep);
		enderecoDTO.setNumero(numero);

		LojaDTO lojaDTO = new LojaDTO(cnpj, nome, telefone, enderecoDTO);
		
		lojaController.cadastrar(lojaDTO);

		exibirMenuLoja();
	}

	public static void excluirLoja() {
		String cnpj = JOptionPane.showInputDialog(null, "Digite o CNPJ da Loja:");
		lojaController.excluir(cnpj);
		exibirMenuLoja();
	}

	public static void alterarDados() {
		String cnpj = JOptionPane.showInputDialog(null, "Digite o CNPJ da Loja:");
		Loja loja = lojaController.findByCnpj(cnpj);
		if (loja != null) {
			LojaDTO lojaDTO = lojaService.convertToLojaDTO(loja);
			String escolherCampo = JOptionPane.showInputDialog("Informe o Campo que Deseja Alterar", """
					1 - CNPJ
					2 - Nome
					3 - Telefone
					4 - Endereco
					""");
			Integer campoEscolhido = Integer.parseInt(escolherCampo);

			switch (campoEscolhido) {
			case 1:
				cnpj = JOptionPane.showInputDialog(null, "Digite o CNPJ da Loja:");
				lojaDTO.setCnpj(cnpj);
				break;
			case 2:
				String nome = JOptionPane.showInputDialog(null, "Digite o Nome da Loja:");
				lojaDTO.setNome(nome);
				break;
			case 3:
				String telefone = JOptionPane.showInputDialog(null, "Digite o Telefone da Loja:");
				lojaDTO.setTelefone(telefone);
				break;
			case 4:
				String cep = JOptionPane.showInputDialog(null, "Digite o CEP da Loja:");
				EnderecoDTO enderecoDTO = viacepService.getEndereco(cep);
				String numero = JOptionPane.showInputDialog(null, "Digite o Número da Loja:");
				enderecoDTO.setNumero(numero);
				lojaDTO.setEndereco(enderecoDTO);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
				exibirMenuLoja();
				break;
			}
			lojaController.update(lojaDTO, cnpj);
		} else {
			JOptionPane.showMessageDialog(null, "Atenção!", "Loja Não Encontrada", JOptionPane.WARNING_MESSAGE);
			exibirMenuLoja();
		}

	}
}
