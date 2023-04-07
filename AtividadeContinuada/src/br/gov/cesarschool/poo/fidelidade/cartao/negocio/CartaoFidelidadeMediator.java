package br.gov.cesarschool.poo.fidelidade.cartao.negocio;

import br.gov.cesarschool.poo.fidelidade.cartao.dao.CartaoFidelidadeDAO;
import br.gov.cesarschool.poo.fidelidade.cartao.dao.LancamentoExtratoDAO;

public class CartaoFidelidadeMediator {
		
	private static CartaoFidelidadeMediator cartaoFidelidadeMediatorInstance;
		
	private CartaoFidelidadeDAO repositorioCartao;
	private LancamentoExtratoDAO repositorioLancamento;
	
	private CartaoFidelidadeMediator() {
		//this.repositorioCartao = new ClienteDAO();
		//this.repositorioLancamento = new CartaoFidelidadeMediator();
	}
		
		
	public static synchronized CartaoFidelidadeMediator getInstance() {
		if (cartaoFidelidadeMediatorInstance == null)
			cartaoFidelidadeMediatorInstance = new CartaoFidelidadeMediator();

		return cartaoFidelidadeMediatorInstance;
	}
}
