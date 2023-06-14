package br.gov.cesarschool.poo.fidelidade.cartao.entidade;
import lombok.*;
	
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RetornoConsultaExtrato {

	private LancamentoExtrato[] lancamentos;
	private String mensagemErro;

}