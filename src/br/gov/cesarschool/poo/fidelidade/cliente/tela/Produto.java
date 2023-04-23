package br.gov.cesarschool.poo.fidelidade.cliente.tela;

public class Produto {
	private long codigo;
	private String nome;
	private double preco;
	private int estoque;
	private TipoProduto tipo;
	public Produto(long codigo, String nome, double preco, int estoque, TipoProduto tipo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public TipoProduto getTipo() {
		return tipo;
	}
	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
	public long getCodigo() {
		return codigo;
	}
}