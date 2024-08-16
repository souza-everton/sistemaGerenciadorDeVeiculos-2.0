package br.com.fuctura.view.manutencao_cadastro;

import javax.swing.JOptionPane;

import br.com.fuctura.view.MenuPrincipal;

public class MenuManutencaoCadastro {

	public static void exibirMenuManutencao() {
		int opcao = 0;
		int confirmacao = 0;
		
		String menu = JOptionPane.showInputDialog("""
				1 - Gerenciar Veículo
				2 - Gerenciar Loja
				3 - Gerenciar Vendedor
				4 - Gerenciar Cliente
				5 - Gerenciar Venda
				6 - Menu Superior
				""");
		
		try {
			opcao = Integer.parseInt(menu);
		}catch(NumberFormatException e){
			e.printStackTrace();
			confirmacao = JOptionPane.showConfirmDialog(null, "Deseja Voltar?","Confirmação:",
					JOptionPane.YES_NO_OPTION);
			if(confirmacao == JOptionPane.YES_NO_OPTION) {
				MenuPrincipal.exibirMenuPrincipal();
			}else if(confirmacao == JOptionPane.YES_NO_OPTION) {
				exibirMenuManutencao();
			}else {
				exibirMenuManutencao();
			}
		}
		switch(opcao) {
		case 1:
			MenuGerenciarVeiculo.exibirMenuVeiculo();
			break;
		case 2:
			MenuGerenciarLoja.exibirMenuLoja();
			break;
		case 3:
			MenuGerenciarVendedor.exibirMenuVendedor();
			break;
		case 4:
			MenuGerenciarCliente.exibirMenuCliente();
			break;
		case 5:
			MenuGerenciarVenda.exibirMenuVenda();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
			exibirMenuManutencao();
			break;
		}
	}
}
