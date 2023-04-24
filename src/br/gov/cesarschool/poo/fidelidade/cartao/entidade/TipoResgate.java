package br.gov.cesarschool.poo.fidelidade.cartao.entidade;

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
    public static TipoResgate getByDescricao(String descricao) {
        if(descricao == "produto") {
            return PRODUTO;
        }if(descricao == "serviço") {
            return SERVICO;
        }if(descricao == "viagem") {
            return VIAGEM;
        }else {
            return null;
        }
    }
}
