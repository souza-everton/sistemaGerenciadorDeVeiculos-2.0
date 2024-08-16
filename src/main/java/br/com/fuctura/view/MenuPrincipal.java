package br.com.fuctura.view;

import javax.swing.JOptionPane;

import br.com.fuctura.view.manutencao_cadastro.MenuManutencaoCadastro;

public class MenuPrincipal {

	public static void exibirMenuPrincipal() {
		int opcao = 0;
		int confirmacao = 0;
		
		String menu = JOptionPane.showInputDialog("""
				1 - Frente de Loja
				2 - Manutenção Cadastro
				3 - Sair
				""");
		
		try {
			opcao = Integer.parseInt(menu);
		}catch(NumberFormatException e){
			e.printStackTrace();
			confirmacao = JOptionPane.showConfirmDialog(null, "Deseja Sair?","Confirmação:",
					JOptionPane.YES_NO_OPTION);
			if(confirmacao == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}else if(confirmacao == JOptionPane.YES_NO_OPTION) {
				exibirMenuPrincipal();
			}else {
				exibirMenuPrincipal();
			}
		}
		switch(opcao) {
		case 1:
			break;
		case 2:
			MenuManutencaoCadastro.exibirMenuManutencao();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Obrigado pela visita!");
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
			exibirMenuPrincipal();
			break;
		}
	}
}
