package br.gov.cesarschool.poo.fidelidade.cartao.entidade;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LancamentoExtratoResgate extends LancamentoExtrato {
	private TipoResgate tipoResgate;

	public LancamentoExtratoResgate(long numeroCartao, int quantidadePontos, LocalDateTime dataHoraLancamento, TipoResgate tipoResgate) {
	    super(numeroCartao, quantidadePontos, dataHoraLancamento);
	    this.tipoResgate = tipoResgate;
	}

	public String obterChave() {
		long numeroCartao = this.getNumeroCartao();
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
 		return "R" + numeroCartao + timestamp;
 	}
	
	public TipoResgate getTipoResgate() {
	    return tipoResgate;
	}
    
    public String getIdentificadorTipo() {
    	return "R";
    }
}
