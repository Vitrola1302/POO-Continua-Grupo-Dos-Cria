package br.gov.cesarschool.poo.fidelidade.cartao.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.poo.fidelidade.cartao.entidade.LancamentoExtrato;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.LancamentoExtratoPontuacao;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.LancamentoExtratoResgate;
import br.gov.cesarschool.poo.fidelidade.util.DAOGenerico;

public class LancamentoExtratoDAO {
	
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "fidelidade" + FILE_SEP + "lancamento" + FILE_SEP;
	private DAOGenerico daoEncapsulado;
	
	public LancamentoExtratoDAO() {
		this.daoEncapsulado = new DAOGenerico(DIR_BASE);
	}
	
	public boolean incluir(LancamentoExtratoPontuacao pontuacao) {
		return daoEncapsulado.incluir(pontuacao);
	}
	
	public boolean incluir(LancamentoExtratoResgate resgate) {
		return daoEncapsulado.incluir(resgate);
	}
}
