package br.gov.cesarschool.poo.fidelidade.cartao.negocio;

public enum TipoResgate{

    PRODUTO(1, "produto"),
    SERVICO(2, "serviço"),
    VIAGEM(3, "viagem");

    int codigo;
    String descricao;

    TipoResgate(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getDescricao(){
        return descricao;
    }
}