package br.gov.cesarschool.poo.fidelidade.cartao.entidade;

import java.util.Date;

public class LancamentoExtratoResgate extends LancamentoExtrato {
    private TipoResgate tipoResgate;

    public LancamentoExtratoResgate(long numeroCartao, int quantidadePontos, Date dataHoraLancamento, TipoResgate tipoResgate) {
        super(numeroCartao, quantidadePontos, dataHoraLancamento);
        this.tipoResgate = tipoResgate;
    }

    public TipoResgate getTipoResgate() {
        return tipoResgate;
    }
    
    public String getIdentificadorTipo() {
    	return "R";
    }
}