package br.gov.cesarschool.poo.fidelidade.cartao.entidade;
import lombok.ToString;
import lombok.ToString.Exclude;
import java.util.*;

import br.gov.cesarschool.poo.fidelidade.geral.entidade.*;

@ToString
public class CartaoFidelidade extends Identificavel {
	
	private long numero;
	private double saldo;
	@Exclude
	private Date dataHoraAtualizacao = new java.util.Date(); 
	
	public CartaoFidelidade(long numero) {
		this.numero = numero;
	}
	public String obterChave() {
 		return numero + "";
 	}
	public long getNumeroFidelidade() {
    	return numero;
    }
	public double getSaldo() {
		return saldo;
	}
	public Date getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
	
	public void creditar(double valor) {
		saldo = saldo + valor;
		dataHoraAtualizacao = new Date();
	}
	
	public void debitar(double valor) {	
		saldo = saldo - valor;
		dataHoraAtualizacao = new Date();
	}
	
}
