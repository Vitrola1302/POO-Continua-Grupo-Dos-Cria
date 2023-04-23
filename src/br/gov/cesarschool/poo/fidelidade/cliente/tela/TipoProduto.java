package br.gov.cesarschool.poo.fidelidade.cliente.tela;

import java.io.Serializable;


public enum TipoProduto implements Serializable {
	ELETRONICO(0, "Eletrônicos"), 
	LINHA_BRANCA(1, "Linha Branca"), 
	COMPUTADORES_CELULARES(2,"Computadores e Celulares"); 
	
	private int codigo;
	private String descricao;
	
	private TipoProduto(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public static TipoProduto obterPorCodigo(int codigo) {
		for (TipoProduto tipoProduto : TipoProduto.values()) {
			if (tipoProduto.getCodigo() == codigo) {
				return tipoProduto;
			}
		}
		return null;
	}
}