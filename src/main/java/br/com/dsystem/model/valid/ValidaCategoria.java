/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.valid;

import br.com.dsystem.model.Categoria;
import br.com.dsystem.model.exceptions.CategoriaException;

/**
 *
 * @author david
 */
public class ValidaCategoria {
    
    public Categoria validaCamposEntrada(String descricao){
        
        Categoria cat = new Categoria();
        
        if(descricao.isEmpty())
            throw new CategoriaException("Erro - Campo Descrição vazio!");
        cat.setDescricao(descricao);
        
        return cat;
    }
    
}
