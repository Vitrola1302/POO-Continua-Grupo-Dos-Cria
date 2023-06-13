package br.gov.cesarschool.poo.fidelidade.cliente.entidade;
import br.gov.cesarschool.poo.fidelidade.geral.entidade.*;

import java.util.Date;
import java.util.Calendar;

public class Cliente extends Identificavel implements Comparavel {
	private String cpf;
	private	String nomeCompleto;
	private Sexo sexo;
	private Date dataNascimento;
	private double renda;
	private Endereco endereco;
	
	 public Cliente(String cpf, String nomeCompleto, Sexo sexo, Date dataNascimento, double renda, Endereco endereco) {
	        this.cpf = cpf;
	        this.nomeCompleto = nomeCompleto;
	        this.sexo = sexo;
	        this.dataNascimento = dataNascimento;
	        this.renda = renda;
	        this.endereco = endereco;
	 }
	 	public String obterChave() {
	 		return cpf;
	 	}

	 	public String getCpf() {
	        return cpf;
	    }

	    public String getNomeCompleto() {
	        return nomeCompleto;
	    }

	    public Sexo getSexo() {
	        return sexo;
	    }

	    public Date getDataNascimento() {
	        return dataNascimento;
	    }

	    public double getRenda() {
	        return renda;
	    }

	    public Endereco getEndereco() {
	        return endereco;
	    }

	    public void setNomeCompleto(String nomeCompleto) {
	        this.nomeCompleto = nomeCompleto;
	    }

	    public void setSexo(Sexo sexo) {
	        this.sexo = sexo;
	    }

	    public void setDataNascimento(Date dataNascimento) {
	        this.dataNascimento = dataNascimento;
	    }

	    public void setRenda(double renda) {
	        this.renda = renda;
	    }

	    public void setEndereco(Endereco endereco) {
	        this.endereco = endereco;
	    }
	    public int obterIdade() {
	        Calendar hoje = Calendar.getInstance();
	        Calendar dataNascimento = Calendar.getInstance();
	        dataNascimento.setTime(this.dataNascimento);
	        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
	        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH) || (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH))) {
	            idade--;
	        }
	        return idade;
	    }

		public int comparar(Comparavel outraEntidade) {
			Cliente cliente2 = (Cliente) outraEntidade;
			
			int resultado;
			if(nomeCompleto.compareTo(cliente2.getNomeCompleto()) > 0) {
				resultado = 1;
			}else if(nomeCompleto.compareTo(cliente2.getNomeCompleto()) < 0) {
				resultado = -1;
			}else {
				resultado = 0;
			}
			
			return resultado; //Retorna 0 caso iguais, 1 caso cliente2 seja menor ou -1 caso maior.
		}
}
