/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.valid;

import br.com.dsystem.model.Borda;
import br.com.dsystem.model.exceptions.BordaException;
import java.math.BigDecimal;

/**
 *
 * @author david
 */
public class ValidaBorda {
    
    public Borda validaCampoEntrada(String descricao, String valor){
        Borda borda = new Borda();
        
        if (descricao.isEmpty())
            throw new BordaException("Erro - Campo Descrição vazio!");
        borda.setDescricao(descricao);
        
        //BigDecimal valorBDecimal = new BigDecimal (0.0);
        if(valor.isEmpty())
            throw new BordaException("Erro - campo Valor vazio!");
        borda.setValor(new BigDecimal(valor.replace(",", ".")));
        
        return borda;
        
    }
    
}
