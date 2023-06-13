package br.gov.cesarschool.poo.fidelidade.cartao.entidade;
import java.time.LocalDateTime;

import br.gov.cesarschool.poo.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.poo.fidelidade.geral.entidade.*;

public abstract class LancamentoExtrato extends Identificavel implements Comparavel {
	private long numeroCartao;
	private double quantidadePontos;
	private LocalDateTime dataHoraLancamento = LocalDateTime.now();
	
	
	public LancamentoExtrato(long numeroCartao, double quantidadePontos, LocalDateTime dataHoraLancamento) {
		super();
		this.numeroCartao = numeroCartao;
		this.quantidadePontos = quantidadePontos;
		this.dataHoraLancamento = dataHoraLancamento;
	}
		
	public long getNumeroCartao() {
		return numeroCartao;
	}
	
	public double getquantidadePontos() {
		return quantidadePontos;
	}
	
	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}
	
	public int comparar(Comparavel outraEntidade) {
		LancamentoExtrato extrato2 = (LancamentoExtrato) outraEntidade;
		
		int resultado;
		if(dataHoraLancamento.compareTo(extrato2.getDataHoraLancamento()) > 0) {
			resultado = 1;
		}else if(dataHoraLancamento.compareTo(extrato2.getDataHoraLancamento()) < 0) {
			resultado = -1;
		}else {
			resultado = 0;
		}
		
		return resultado; //Retorna 0 caso iguais, 1 caso extrato2 seja mais recente ou -1 caso mais antigo.
	}
	
	 public abstract String getIdentificadorTipo();

}
