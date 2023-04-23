package br.gov.cesarschool.poo.fidelidade.cliente.tela;

public class ProdutoMediator {
	public static Produto buscar(long codigo) {
		if (codigo > 10000) {
			return new Produto(codigo, "Celular", 2000.0, 2, 
					TipoProduto.COMPUTADORES_CELULARES);
		} else {
			return null;
		}
	}
	public static String incluir(Produto prod) {
		return validar(prod);
	}
	public static String alterar(Produto prod) {
		return validar(prod);
	}	
	private static String validar(Produto prod) {
		if (prod.getCodigo() <= 0) {
			return "Código inválido!";
		} else if (prod.getPreco() == 0) {
			return "Preço inválido!";
		} else if (prod.getEstoque() < 0) {
			return "Estoque inválido!";
		} else if (prod.getTipo() == null) {
			return "Tipo de produto não informado!";
		} else {
			return null;
		}
	}
}