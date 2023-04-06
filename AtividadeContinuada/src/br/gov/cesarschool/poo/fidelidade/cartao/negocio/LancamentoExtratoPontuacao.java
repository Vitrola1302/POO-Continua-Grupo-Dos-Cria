package br.gov.cesarschool.poo.fidelidade.cartao.negocio;
import  java.util.Date;

public class LancamentoExtratoPontuacao extends LancamentoExtrato{
	LancamentoExtratoPontuacao(long numeroCartao, int quantidadePontos, Date dataHoraAtualizacao){
		super(numeroCartao, numeroCartao, dataHoraAtualizacao);
	}
}