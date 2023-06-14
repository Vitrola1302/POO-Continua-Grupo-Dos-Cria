package br.gov.cesarschool.poo.fidelidade.cliente.relatorios;

import br.gov.cesarschool.poo.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.poo.fidelidade.cliente.negocio.ClienteMediator;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.text.DateFormatter;


public class RelatorioCliente {

	public static void gerarRelatorioClientes() {
		ClienteMediator mediator = ClienteMediator.getInstance();
    	Cliente[] clientes = mediator.consultarClientesOrdenadosPorNome();


    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        for (Cliente cliente : clientes) {
            String nome = cliente.getNomeCompleto();
            String dataNascimento = cliente.getDataNascimento().toString();
            String renda = String.format("%.2f", cliente.getRenda());

            System.out.println(nome + "-" + dataNascimento + "-" + renda);
        }
    }

    public static void main(String[] args) {
        ClienteMediator clienteMediator = ClienteMediator.getInstance();
        gerarRelatorioClientes();
            }

            
}