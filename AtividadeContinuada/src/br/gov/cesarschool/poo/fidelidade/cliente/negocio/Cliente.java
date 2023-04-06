package br.gov.cesarschool.poo.fidelidade.cliente.negocio;

import java.util.Date;
import br.gov.cesarschool.poo.fidelidade.geral.negocio.Endereco;
import br.gov.cesarschool.poo.fidelidade.geral.negocio.Sexo;

public class Cliente {
    private String cpf;
    private String nomeCompleto;
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
        Date dataAtual = new Date();
        int idade = dataAtual.getYear() - dataNascimento.getYear();
        if (dataAtual.getMonth() < dataNascimento.getMonth() || (dataAtual.getMonth() == dataNascimento.getMonth() && dataAtual.getDate() < dataNascimento.getDate())) {
            idade--;
        }
        return idade;
    }
}