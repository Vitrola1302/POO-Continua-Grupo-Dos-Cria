package br.gov.cesarschool.poo.fidelidade.geral.entidade;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.LancamentoExtrato;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RetornoConsultaExtrato {

	private LancamentoExtrato[] lancamentos;
	private String mensagemErro;
}