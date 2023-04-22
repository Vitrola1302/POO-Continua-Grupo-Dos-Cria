package br.gov.cesarschool.poo.fidelidade.util;

public class ValidadorCPF {
    
    private ValidadorCPF()
    {
        
    }
    
    public static boolean ehCpfValido(String cpf)
    {
        if (cpf == null || cpf.isEmpty() || cpf.length() != 11)
        {
            return false;
        }
        
        for (int i = 0; i < 11; i+=1) 
        {
              if (!Character.isDigit(cpf.charAt(i)))
              {
                return false;
              }
        }
        
        int soma = 0;
        int digitoVerificador1;
        int digitoVerificador2;
        
        for (int i = 0; i < 9; i += 1)
        {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);     
        }
        
        if (soma % 11 == 0 || soma % 11 == 1)
        {
            digitoVerificador1 = 0;
        }
        
        else
        {
            digitoVerificador1 = 11 - (soma % 11);
        }
        
        soma = 0;
        
        for (int i = 1; i < 9; i += 1)
        {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);     
        }
        
        soma += digitoVerificador1 * 2;
        
        if (soma % 11 == 0 || soma % 11 == 1)
        {
            digitoVerificador2 = 0;
        }
        
        else
        {
            digitoVerificador2 = 11 - (soma % 11);
        }
        
        if (digitoVerificador1 == Character.getNumericValue(cpf.charAt(9)) && digitoVerificador2 == Character.getNumericValue(cpf.charAt(10)))
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
}