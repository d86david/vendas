/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.valid;

import br.com.dsystem.model.Ingrediente;
import br.com.dsystem.model.exceptions.IngredienteException;

/**
 *
 * @author Administrador
 */
public class ValidaIngrediente {
    
    public Ingrediente validaCamposEntrada(String ingrediente){
        
        Ingrediente ingr = new Ingrediente();
        
        if(ingrediente.isEmpty())
            throw new IngredienteException("Erro - Campo Ingrediente vazio!");
        ingr.setIngrediente(ingrediente);
        
        return ingr;
    }
    
}
