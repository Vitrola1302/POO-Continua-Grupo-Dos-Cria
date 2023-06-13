package br.gov.cesarschool.poo.fidelidade.cliente.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.gov.cesarschool.poo.fidelidade.cartao.entidade.CartaoFidelidade;
import br.gov.cesarschool.poo.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.poo.fidelidade.geral.dao.*;

public class ClienteDAO {
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "fidelidade" + FILE_SEP + "cliente" + FILE_SEP;
	private DAOGenerico daoEncapsulado;

	public ClienteDAO() {
		this.daoEncapsulado = new DAOGenerico(DIR_BASE);
	}


	public boolean incluir(Cliente cliente) {
		 return daoEncapsulado.incluir(cliente);
	}

	public boolean alterar(Cliente cliente) {
		return daoEncapsulado.alterar(cliente);
	}

	public Cliente buscar(String chave) {
		return (Cliente)daoEncapsulado.buscar(chave);
	}
	
	public Cliente[] buscarTodos() {
        Identificavel[] identificaveis = daoEncapsulado.buscarTodos();
        
        Cliente[] clientes = new Cliente[identificaveis.length];
        
        int contadorClientes = 0;
        
        for(Identificavel ident:identificaveis) {
            
            Object objeto = (Object) ident;
            
            if(objeto instanceof Cliente) {
                clientes[contadorClientes] = (Cliente) ident;
                
                contadorClientes++;
            }
        }
        
        if(contadorClientes == 0) {
            return new Cliente[0];
        }
        return clientesList;
        
    }
}