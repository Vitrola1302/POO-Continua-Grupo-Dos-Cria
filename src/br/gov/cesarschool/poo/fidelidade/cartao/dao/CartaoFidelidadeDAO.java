package br.gov.cesarschool.poo.fidelidade.cartao.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.CartaoFidelidade;
import br.gov.cesarschool.poo.fidelidade.geral.dao.*;

public class CartaoFidelidadeDAO{
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "fidelidade" + FILE_SEP + "cartao" + FILE_SEP;
    private DAOGenerico <CartaoFidelidade>daoEncapsulado;

    public CartaoFidelidadeDAO() {
    	this.daoEncapsulado = new DAOGenerico(DIR_BASE);
    }

    public boolean incluir(CartaoFidelidade cartao) {
        return daoEncapsulado.incluir(cartao);
    }
    public boolean alterar(CartaoFidelidade cartao) {
    	return daoEncapsulado.alterar(cartao);
    }
    public CartaoFidelidade buscar(String chave) {
        return daoEncapsulado.buscar(chave);
    }
}