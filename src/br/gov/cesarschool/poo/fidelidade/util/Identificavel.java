package br.gov.cesarschool.poo.fidelidade.util;

import java.io.Serializable;

public abstract class Identificavel implements Serializable {
    public abstract String obterChave();
}
