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
public class PedidoCaixa {

    private int id;
    private int clienteId;
    private String dataPedido;
    private BigDecimal totalPedido;
    private String tempoPreparo;
    private String dataBaixa;
    private int formaPagtoId;
    private String statusPedido;
    private int atendenteId;
    private String obsPedido;
    private BigDecimal valorDesconto;
    private BigDecimal totalAPagar;

    public PedidoCaixa() {
    }

    public PedidoCaixa(int id, int cliente_id, String dataPedido, BigDecimal totalPedido, String tempoPreparo, String dataBaixa, int formaPagto_id, String statusPedido, int atendente, String obsPedido, BigDecimal vlDesconto, BigDecimal totalAPagar) {
        this.id = id;
        this.clienteId = cliente_id;
        this.dataPedido = dataPedido;
        this.totalPedido = totalPedido;
        this.tempoPreparo = tempoPreparo;
        this.dataBaixa = dataBaixa;
        this.formaPagtoId = formaPagto_id;
        this.statusPedido = statusPedido;
        this.atendenteId = atendente;
        this.obsPedido = obsPedido;
        this.valorDesconto = vlDesconto;
        this.totalAPagar = totalAPagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(String dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public int getFormaPagtoId() {
        return formaPagtoId;
    }

    public void setFormaPagtoId(int formaPagtoId) {
        this.formaPagtoId = formaPagtoId;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public int getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(int atendente) {
        this.atendenteId = atendente;
    }

    public String getObsPedido() {
        return obsPedido;
    }

    public void setObsPedido(String obsPedido) {
        this.obsPedido = obsPedido;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(BigDecimal totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

}
