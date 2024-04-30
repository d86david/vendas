/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model;

/**
 *
 * @author david
 */
public class Categoria {
    
    private int id;
    private String descricao;
    private boolean temBorda;
    private boolean variosSabores;
    
    public Categoria(){
        
    }
    
    public Categoria (int id, String descricao, boolean temBorda, boolean variosSabores){
        this.id = id;
        this.descricao = descricao;
        this.temBorda = temBorda;
        this.variosSabores = variosSabores;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public boolean isTemBorda() {
        return temBorda;
    }

    public void setTemBorda(boolean temBorda) {
        this.temBorda = temBorda;
    }

    public boolean isVariosSabores() {
        return variosSabores;
    }

    public void setVariosSabores(boolean variosSabores) {
        this.variosSabores = variosSabores;
    }
    
    
    @Override
    public String toString() {
        return getDescricao();
    }
    
}
