package br.com.dsystem.util;

import java.util.InputMismatchException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author david
 */
public class ValidaDocumento {

    public static boolean validaCPF(String doc) {
        String cpf = doc.replaceAll("[^0-9]+", "");
        /**
         * Considera-se erro CPF's formados por uma sequencia de numero iguais
         */

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999") || cpf.length() != 11) {
            return false;
        } else {
            char dig10, dig11;
            int soma, i, r, num, peso;

            // "try-catch" - Para proteger o código de eventuais erros de conversão de tipo (int) 
            try {
                //Calculo do 1º DV do CPF
                soma = 0;
                peso = 10;

                for (i = 0; i < 9; i++) {
                    /* Converte o i-esimo caracter do CPF em um numero: por exemplo 
                    *  transforma o caracter "0" n ointeiro 0 (48 é a posição de '0' na tabela ASCII)
                     */
                    num = (int) (cpf.charAt(i) - 48);
                    soma = soma + (num * peso);
                    peso = peso - 1;
                }
                r = 11 - (soma % 11);
                if ((r == 10) || (r == 11)) {
                    dig10 = '0';
                } else {
                    dig10 = (char) (r + 48); // Converte o respectivo caratcer numero para char 
                }

                // Calculo do 2º DV do CPF
                soma = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = (int) (cpf.charAt(i) - 48);
                    soma = soma + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (soma % 11);
                if ((r == 10) || (r == 11)) {
                    dig11 = '0';
                } else {
                    dig11 = (char) (r + 48);
                }

                //Verifica se os digitos calculados conferem com os digitos informdos
                return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
            } catch (InputMismatchException erro) {
                return false;
            }
        }
    }

    public static boolean validaCNPJ(String doc) {
        String cnpj = doc.replaceAll("[^0-9]+", "");
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
                || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
                || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
                || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")
                || (cnpj.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

// "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

// Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
    //fim do metodo

}
