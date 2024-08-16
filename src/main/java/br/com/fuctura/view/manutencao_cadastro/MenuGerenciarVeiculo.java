package br.com.fuctura.view.manutencao_cadastro;

import javax.swing.JOptionPane;

import br.com.fuctura.controller.LojaController;
import br.com.fuctura.controller.VeiculoController;
import br.com.fuctura.dto.LojaDTO;
import br.com.fuctura.dto.TipoVeiculoDTO;
import br.com.fuctura.dto.VeiculoDTO;
import br.com.fuctura.model.Loja;
import br.com.fuctura.model.Veiculo;
import br.com.fuctura.service.LojaService;
import br.com.fuctura.service.VeiculoService;

public class MenuGerenciarVeiculo {

	private static VeiculoController veiculoController;
	private static VeiculoService veiculoService;
	private static LojaController lojaController;
	private static LojaService lojaService;
	// private static Veiculo veiculo;
	// private static VeiculoDTO veiculoDTO;
	// private static TipoVeiculoDTO tipoVeiculo;

	public static void exibirMenuVeiculo() {

		int opcao = 0;
		int confirmacao = 0;

		String menu = JOptionPane.showInputDialog("""
				1 - Cadastrar Veículo
				2 - Excluir Veículo
				3 - Alterar Dados Do Veículo
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
				exibirMenuVeiculo();
			} else {
				exibirMenuVeiculo();
			}
		}

		switch (opcao) {
		case 1:
			cadastrarVeiculo();
			break;
		case 2:
			excluirVeiculo();
			break;
		case 3:
			alterarDados();
			break;
		case 4:
			MenuManutencaoCadastro.exibirMenuManutencao();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
			exibirMenuVeiculo();
			break;
		}
	}

	public static void cadastrarVeiculo() {
		String marca = JOptionPane.showInputDialog(null, "Digite a Marca do Carro:");
		String modelo = JOptionPane.showInputDialog(null, "Digite o Modelo do Carro:");
		Integer ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Ano do Carro:"));
		String placa = JOptionPane.showInputDialog(null, "Digite a Placa do Carro:");
		Double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o Preço do Carro:"));
		String categoria = JOptionPane.showInputDialog(null, "Digite a Categoria do Carro:");
		String descricao = JOptionPane.showInputDialog(null, "Digite a Descrição do Carro:");
		String cnpjLoja = JOptionPane.showInputDialog(null, "Digite o CNPJ da Loja:");

		TipoVeiculoDTO tipoVeiculoDTO = new TipoVeiculoDTO(categoria, descricao);
		Loja loja = lojaController.findByCnpj(cnpjLoja);
		LojaDTO lojaDTO = lojaService.convertToLojaDTO(loja);
		VeiculoDTO veiculoDTO = new VeiculoDTO(marca, modelo, ano, placa, preco, tipoVeiculoDTO, lojaDTO);
		veiculoController.cadastrar(veiculoDTO);

		exibirMenuVeiculo();

	}
	
	public static void excluirVeiculo() {
		String placa = JOptionPane.showInputDialog(null, "Digite a Placa do Carro:");
		veiculoController.excluir(placa);
		excluirVeiculo();
	}
	
	public static void alterarDados() {
		String placa = JOptionPane.showInputDialog(null, "Digite a Placa do Veículo:");
		Veiculo veiculo = veiculoController.findByPlaca(placa);
		if(veiculo != null) {
			VeiculoDTO veiculoDTO = veiculoService.convertToVeiculoDTO(veiculo);
			String escolherCampo = JOptionPane.showInputDialog("Informe o Campo que Deseja Alterar", """
					1 - Marca
					2 - Modelo
					3 - Ano
					4 - Placa
					5 - Preço
					""");
			Integer campoEscolhido = Integer.parseInt(escolherCampo);
			
			switch(campoEscolhido) {
				case 1:
					String marca = JOptionPane.showInputDialog(null, "Digite a Marca do Veículo:");
					veiculoDTO.setMarca(marca);
					break;
				case 2:
					String modelo = JOptionPane.showInputDialog(null, "Digite o Modelo do Veículo:");
					veiculoDTO.setModelo(modelo);
					break;
				case 3:
					Integer ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Ano do Carro:"));
					veiculoDTO.setAno(ano);
					break;
				case 4:
					placa = JOptionPane.showInputDialog(null, "Digite a Placa do Carro:");
					veiculoDTO.setPlaca(placa);
					break;
				case 5:
					Double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o Preço do Carro:"));
					veiculoDTO.setPreco(preco);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
					exibirMenuVeiculo();
					break;
			}
			veiculoController.update(placa, veiculoDTO);
		}else {
			JOptionPane.showMessageDialog(null, "Atenção!", "Veículo Não Encontrado", JOptionPane.WARNING_MESSAGE);
			exibirMenuVeiculo();
		}
	}
}
