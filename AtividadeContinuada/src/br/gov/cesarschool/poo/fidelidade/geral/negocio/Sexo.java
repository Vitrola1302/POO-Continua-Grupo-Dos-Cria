package br.gov.cesarschool.poo.fidelidade.geral.negocio;

public enum Sexo {
    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino"),


    private final int codigo;
    private final String descricao;

    Sexo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}