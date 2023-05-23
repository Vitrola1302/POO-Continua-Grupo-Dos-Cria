package br.gov.cesarschool.poo.fidelidade.cartao.entidade;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LancamentoExtratoPontuacao extends LancamentoExtrato {

	public LancamentoExtratoPontuacao(long numeroCartao, double quantidadePontos, LocalDateTime dataHoraLancamento) {
		super(numeroCartao, quantidadePontos, dataHoraLancamento);
	}
	public String obterChave() {
		long numeroCartao = this.getNumeroCartao();
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
 		return "P" + numeroCartao + timestamp;
 	}
	
}
