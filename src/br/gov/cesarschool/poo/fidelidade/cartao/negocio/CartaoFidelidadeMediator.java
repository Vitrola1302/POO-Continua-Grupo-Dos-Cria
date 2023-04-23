package br.gov.cesarschool.poo.fidelidade.cartao.negocio;

import java.time.*;

import br.gov.cesarschool.poo.fidelidade.cartao.dao.*;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.*;
import br.gov.cesarschool.poo.fidelidade.cliente.entidade.*;

public class CartaoFidelidadeMediator
{
	private static CartaoFidelidadeMediator instance;
	private CartaoFidelidadeDAO repositorioCartao;
	private LancamentoExtratoDAO repositorioLancamento;
	
	private CartaoFidelidadeMediator()
	{
		this.repositorioCartao = new CartaoFidelidadeDAO();
		this.repositorioLancamento = new LancamentoExtratoDAO();
	}
	
	public static CartaoFidelidadeMediator getInstance()
	{
		if (instance == null)
		{
			instance = new CartaoFidelidadeMediator();
		}
		return instance;
	}
	
	public long gerarCartao(Cliente cliente)
	{
		String cpfCliente = cliente.getCpf();
		LocalDate dataAtual = LocalDate.now();
		
		long numero = Long.parseLong(cpfCliente + dataAtual.getYear() + dataAtual.getMonthValue() + dataAtual.getDayOfMonth());
		
		repositorioCartao.incluir(new CartaoFidelidade(numero));
		return numero;		
	}
	
	String pontuar(long numeroCartao, double quantidadePontos)
	{
		CartaoFidelidade cartao = repositorioCartao.buscar(numeroCartao);
		if(quantidadePontos <= 0)
		{
			return "Quantidade de pontos é menor ou igual a zero!";
		}
		else if(cartao == null) {
			return "Cartão não encontrado!";
		}
		else 
		{
			cartao.creditar(quantidadePontos);
			repositorioCartao.alterar(cartao);
			repositorioLancamento.incluir(new LancamentoExtratoPontuacao(numeroCartao, (int) quantidadePontos, null));
		}
		
		return null;
	}
	
	String resgatar(long numeroCartao, double quantidadePontos, TipoResgate tipo)
	{
		CartaoFidelidade cartao = repositorioCartao.buscar(numeroCartao);
		if(quantidadePontos <= 0)
		{
			return "Quantidade de pontos é menor ou igual a zero!";
		}
		else if(cartao == null) {
			return "Cartão não encontrado!";
		}
		//Se o saldo do cartão for menor do que quantidadePontos, retornar mensagem de erro pertinente.
		//Debitare no cartão encontrado a quantidadePontos recebida.
		//Alterar o cartão encontrado no repositorioCartao.
		//Incluir em repositorioLancamento uma instância de LancamentoExtratoResgate com os dados do resgate.
		return null;
	}
}
