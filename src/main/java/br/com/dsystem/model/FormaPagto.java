/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model;

/**
 *
 * @author david
 */
public class FormaPagto {
    
    private int id;
    private String descricao;
    
    public FormaPagto(){
        
    }
    
    public FormaPagto(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
    
    
    
}
