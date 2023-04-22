package br.gov.cesarschool.poo.fidelidade.cliente.negocio;

import br.gov.cesarschool.poo.fidelidade.cartao.negocio.*;
import br.gov.cesarschool.poo.fidelidade.cliente.dao.*;
import br.gov.cesarschool.poo.fidelidade.cliente.entidade.*;
import br.gov.cesarschool.poo.fidelidade.util.*;

public class ClienteMediator {
	
	private static ClienteMediator clienteMediatorInstance;
	
	private ClienteDAO repositorioCliente;
	private CartaoFidelidadeMediator cartaoMediator;
	
	private ClienteMediator() {
		this.repositorioCliente = new ClienteDAO();
		this.cartaoMediator = CartaoFidelidadeMediator.getInstance();
	}
	
	
	public static synchronized ClienteMediator getInstance() {
		if (clienteMediatorInstance == null)
			clienteMediatorInstance = new ClienteMediator();

		return clienteMediatorInstance;
	}
	
	public ResultadoInclusaoCliente incluir(Cliente cliente) {
		String valido = validar(cliente);
		
		if(valido == null) {
			repositorioCliente.incluir(cliente); 
			return new ResultadoInclusaoCliente(cartaoMediator.gerarCartao(cliente), null);
		}else {
			return new ResultadoInclusaoCliente(0, valido);
		}
	} 
	
	public String alterar(Cliente cliente) {
		String valido = validar(cliente);
		if(valido == null) {
			repositorioCliente.alterar(cliente);
		}
		return valido;
	}
	
	private String validar(Cliente cliente) {
		
		if(!ValidadorCPF.ehCpfValido(cliente.getCpf())){
			return "CPF inválido!!!";
		}
		else if(StringUtil.ehNuloOuBranco(cliente.getNomeCompleto())) {
			return "Nome completo é obrigatório!!!";
		}else if(cliente.getSexo() == null) {
			return "Sexo é obrigatório!!!";
		}else if(cliente.obterIdade() < 18) {
			return "Cliente deve ser maior de 18!!!";
		}else if(cliente.getRenda() < 0) {
			return "Renda deve ser maior ou igual a zero!!!";
		}else if(StringUtil.ehNuloOuBranco(cliente.getEndereco().getLogradouro())) {
			return "Endereço é obrigatório";
		}else if(cliente.getEndereco().getLogradouro().length() <= 4) {
			return "Endereço deve ter ao menos 4 caracteres!!!";
		}else if(cliente.getEndereco().getNumero() < 0) {
			return "Numero deve ser maior ou igual a zero!!!";
		}else if(StringUtil.ehNuloOuBranco(cliente.getEndereco().getCidade())) {
			return  "Cidade é obrigatória";
		}else if(StringUtil.ehNuloOuBranco(cliente.getEndereco().getEstado())) {
			return "Estado é obrigatório";
		}else if(StringUtil.ehNuloOuBranco(cliente.getEndereco().getPais())) {
			return "País é obrigatório";
		}else {
			return null;
		}
	}
}

 
