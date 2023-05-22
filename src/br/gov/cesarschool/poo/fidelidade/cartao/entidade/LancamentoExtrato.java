package br.gov.cesarschool.poo.fidelidade.cartao.entidade;
import java.io.Serializable;
import java.time.LocalDateTime;

public class LancamentoExtrato implements Serializable{
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

}
