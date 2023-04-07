package br.gov.cesarschool.poo.fidelidade.cliente.negocio;

import br.gov.cesarschool.poo.fidelidade.cartao.negocio.CartaoFidelidadeMediator;
import br.gov.cesarschool.poo.fidelidade.cliente.dao.ClienteDAO;
import br.gov.cesarschool.poo.fidelidade.cliente.entidade.Cliente;

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
	
	//public ResultadoInclusaoCliente incluir(Cliente cliente) {}
	
	//public String alterar(Cliente cliente) {};
	
	private String validar(Cliente cliente) {
		
		if(cliente.getSexo() == null) {
			System.out.println();
		}
	}
}
