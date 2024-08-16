package br.com.fuctura.view.manutencao_cadastro;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import br.com.fuctura.controller.ClienteController;
import br.com.fuctura.controller.LojaController;
import br.com.fuctura.controller.VeiculoController;
import br.com.fuctura.controller.VendasController;
import br.com.fuctura.controller.VendedorController;
import br.com.fuctura.dto.ClienteDTO;
import br.com.fuctura.dto.LojaDTO;
import br.com.fuctura.dto.VeiculoDTO;
import br.com.fuctura.dto.VendaDTO;
import br.com.fuctura.dto.VendedorDTO;
import br.com.fuctura.model.Cliente;
import br.com.fuctura.model.Loja;
import br.com.fuctura.model.Veiculo;
import br.com.fuctura.model.Vendedor;
import br.com.fuctura.service.ClienteService;
import br.com.fuctura.service.LojaService;
import br.com.fuctura.service.VeiculoService;
import br.com.fuctura.service.VendedorService;

public class MenuGerenciarVenda {

	private static VendasController vendasController;
	private static VeiculoController veiculoController;
	private static VeiculoService veiculoService;
	private static LojaController lojaController;
	private static LojaService lojaService;
	private static ClienteController clienteController;
	private static ClienteService clienteService;
	private static VendedorController vendedorController;
	private static VendedorService vendedorService;
	
	public static void exibirMenuVenda() {
		int opcao = 0;
		int confirmacao = 0;

		String menu = JOptionPane.showInputDialog("""
				1 - Cadastrar Venda
				2 - Excluir Venda
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
				exibirMenuVenda();
			} else {
				exibirMenuVenda();
			}
		}
		
		switch(opcao) {
		case 1:
			cadastrarVenda();
			break;
		case 2:
			excluirVenda();
			break;
		case 3:
			MenuManutencaoCadastro.exibirMenuManutencao();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
			exibirMenuVenda();
			break;
		}
	}
	
	public static void cadastrarVenda() {
		String cnpj = JOptionPane.showInputDialog(null, "Digite o CNPJ da Loja para Venda:");
		Loja loja = lojaController.findByCnpj(cnpj);
		LojaDTO lojdaDTO = lojaService.convertToLojaDTO(loja);
		
		String cpfVendedor = JOptionPane.showInputDialog(null, "Digite o CPF do Vendedor para Venda:");
		Vendedor vendedor = vendedorController.findByCPF(cpfVendedor);
		VendedorDTO vendedorDTO = vendedorService.convertToVendedorDTO(vendedor);
		
		String cpfCliente = JOptionPane.showInputDialog(null, "Digite o CPF do Cliente para Venda:");
		Cliente cliente = clienteController.findByCPF(cpfCliente);
		ClienteDTO clienteDTO = clienteService.convertToClienteDTO(cliente);
		
		String placa = JOptionPane.showInputDialog(null, "Digite a Placa do Carro para Venda:");
		Veiculo veiculo = veiculoController.findByPlaca(placa);
		VeiculoDTO veiculoDTO = veiculoService.convertToVeiculoDTO(veiculo);
		Double valor = veiculoDTO.getPreco();
		
		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		dataAtual.format(formatarData);
		
		VendaDTO vendaDTO = new VendaDTO(valor,clienteDTO,vendedorDTO,lojdaDTO,veiculoDTO,dataAtual);
		
		vendasController.create(vendaDTO);
		exibirMenuVenda();
	}
	
	public static void excluirVenda() {
		
	}
}
