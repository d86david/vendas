/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model;

import java.math.BigDecimal;

/**
 *
 * @author Administrador
 */
public class CarrinhoPedido {
    
    private int id;
    private PedidoCaixa pedido;
    private Produto produto;
    private Borda borda;
    private int quantidade;
    private BigDecimal subtotal;
    private Ingrediente ingredientes;
    private String sabores;

    public CarrinhoPedido() {
    }

    public CarrinhoPedido(int id, PedidoCaixa pedido, Produto produto, int quantidade, BigDecimal subtotal, Ingrediente ingredientes, String sabores) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.ingredientes = ingredientes;
        this.sabores = sabores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PedidoCaixa getPedido() {
        return pedido;
    }

    public void setPedido(PedidoCaixa pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Ingrediente getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getSabores() {
        return sabores;
    }

    public void setSabores(String sabores) {
        this.sabores = sabores;
    } 

    public Borda getBorda() {
        return borda;
    }

    public void setBorda(Borda borda) {
        this.borda = borda;
    }
    
    
    
}
