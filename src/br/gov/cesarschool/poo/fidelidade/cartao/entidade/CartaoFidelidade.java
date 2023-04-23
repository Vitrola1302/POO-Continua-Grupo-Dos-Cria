package br.gov.cesarschool.poo.fidelidade.cartao.entidade;
import  java.util.Date;

public class CartaoFidelidade
{    
    
    private long numero;
    private double saldo;
    private Date dataHoraAtualizacao = new Date();
    
    public CartaoFidelidade(long numero)
    {
        this.numero = numero;
    }
    
    
    public long getNumero()
    {
        return numero;
    }
    
    public double getSaldo()
    {
        return saldo;
    }
    
    public Date getDate()
    {
        return dataHoraAtualizacao;
    }
    
    public void creditar(double valor)
    {
        this.saldo += valor;
        this.dataHoraAtualizacao = new Date();
    }
    
    public void debitar(double valor)
    {
        this.saldo -= valor;
        this.dataHoraAtualizacao = new Date();
    }
}   