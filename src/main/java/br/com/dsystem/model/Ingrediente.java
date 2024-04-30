/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model;

import java.math.BigDecimal;

/**
 *
 * @author david
 */
public class Ingrediente {
    
    private int id;
    private String ingrediente;
    private BigDecimal valor;

    public Ingrediente() {
    }

    public Ingrediente(int id, String ingrediente, BigDecimal valor) {
        this.id = id;
        this.ingrediente = ingrediente;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    
    
}
