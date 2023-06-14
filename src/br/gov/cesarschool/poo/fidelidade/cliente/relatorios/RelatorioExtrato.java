package br.gov.cesarschool.poo.fidelidade.cliente.relatorios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.gov.cesarschool.poo.fidelidade.cartao.dao.CartaoFidelidadeDAO;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.CartaoFidelidade;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.LancamentoExtrato;
import br.gov.cesarschool.poo.fidelidade.cartao.negocio.CartaoFidelidadeMediator;
import br.gov.cesarschool.poo.fidelidade.geral.entidade.RetornoConsultaExtrato;

public class RelatorioExtrato {
	
	public void gerarRelatorioExtratos(String numeroCartao, LocalDateTime inicio, LocalDateTime fim) {
		CartaoFidelidadeMediator mediator = CartaoFidelidadeMediator.getInstance();
		
		RetornoConsultaExtrato retorno = mediator.consultaEntreDatas(numeroCartao, inicio, fim);
		
		if(retorno.getMensagemErro() != null) {
			System.out.println("Erro: " + retorno.getMensagemErro());
		}else {
			LancamentoExtrato[] lancamentos = retorno.getLancamentos();
			if(lancamentos != null) {			
				for(LancamentoExtrato lancamento:lancamentos) {
					LocalDateTime data = lancamento.getDataHoraLancamento();
					double valor = lancamento.getquantidadePontos();
					String tipo = lancamento.getIdentificadorTipo();
					
					System.out.println(data + "–" + String.format("%.2f", valor) + "–" + tipo);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		RelatorioExtrato relatorio = new RelatorioExtrato();
		
		System.out.println("Informe o número do cartão");
		String numero = entrada.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Informe a data de inicio");
		String dataIn = entrada.nextLine();
		LocalDateTime dateTimeIn = LocalDateTime.parse(dataIn, formatter);
		
		System.out.println("Informe a data de fim");
		String dataFim = entrada.nextLine();
		LocalDateTime dateTimeFim = LocalDateTime.parse(dataIn, formatter);
		
		relatorio.gerarRelatorioExtratos(numero, dateTimeIn, dateTimeFim);
	}
}
