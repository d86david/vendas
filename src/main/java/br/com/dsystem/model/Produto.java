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
public class Produto {
    private int id;
    private int codigoProduto;
    private String descricao;
    private BigDecimal preco;
    private int qtdEstoquue;
    private boolean controlaEstoque;
    private Categoria categoria;

    public Produto() {
    }

    public Produto(int id, int codigoProduto, String descricao, BigDecimal preco, int qtdEstoquue, Categoria categoria) {
        this.id = id;
        this.codigoProduto = codigoProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoquue = qtdEstoquue;
        this.categoria = categoria;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
     /**
     * @return the codigoProduto
     */
    public int getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the id to set
     */
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco
     */
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    /**
     * @return the qtdEstoquue
     */
    public int getQtdEstoquue() {
        return qtdEstoquue;
    }

    /**
     * @param qtdEstoquue the qtdEstoquue to set
     */
    public void setQtdEstoquue(int qtdEstoquue) {
        this.qtdEstoquue = qtdEstoquue;
    }


    public boolean isControlaEstoque() {
        return controlaEstoque;
    }

    public void setControlaEstoque(boolean controlaEstoque) {
        this.controlaEstoque = controlaEstoque;
    }

    
    /**
     * @return the ctegoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param ctegoria the ctegoria to set
     */
    public void setCategoria(Categoria ctegoria) {
        this.categoria = ctegoria;
    }


    @Override
    public String toString() {
        return getDescricao();
    }   
}
