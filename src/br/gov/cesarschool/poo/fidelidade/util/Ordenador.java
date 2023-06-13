package br.gov.cesarschool.poo.fidelidade.util;

import br.gov.cesarschool.poo.fidelidade.geral.entidade.Comparavel;

public class Ordenador {
    public static <T extends Comparavel> void ordenar(T[] array) {
    int n = 1;
    int troca = 0;
    while(n <= array.length && troca == 1){
        for (int i = 0; i < array.length - 1; i++) {
                if (array[i].comparar(array[i+1]) > 0) {
                    T aux = array[i];
                    array[i] = array[i];
                    array[i+1] = aux;
            troca = 1;
                }
            }
        n++;
        }
    }
}
