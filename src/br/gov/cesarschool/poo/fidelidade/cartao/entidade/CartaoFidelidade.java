package br.gov.cesarschool.poo.fidelidade.cartao.entidade;
import java.io.Serializable;
import java.util.*;

public class CartaoFidelidade implements Serializable {
	
	private long numero;
	private double saldo;
	private Date dataHoraAtualizacao = new java.util.Date(); 
	
	public CartaoFidelidade(long numero) {
		this.numero = numero;
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
