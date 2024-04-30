/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.controller;

import br.com.dsystem.model.Cliente;
import br.com.dsystem.model.FormaPagto;
import br.com.dsystem.model.Funcionario;
import br.com.dsystem.model.PedidoCaixa;
import br.com.dsystem.model.dao.PedidoCaixaDAO;
import br.com.dsystem.model.exceptions.PedidoCaixaException;
import br.com.dsystem.model.tableModel.TMPedidoCaixa;
import br.com.dsystem.view.DlgPedidoCaixa;
import br.com.dsystem.view.FrmPedidosCaixa;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public class PedidoCaixaController {

    private PedidoCaixaDAO repositorio;
    SimpleDateFormat dataMysql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat dataBr = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public PedidoCaixaController() {
        repositorio = new PedidoCaixaDAO();
    }

    public void cadastrarPedido(Cliente cliente, String dataPedido, String vlTotal, String obsPedido,
            Funcionario func, FormaPagto fpagto, String statusPedido) {

        BigDecimal valorTotal = new BigDecimal(vlTotal);
        Date dtPedido = null;
        try {
            dtPedido = dataBr.parse(dataPedido);
        } catch (ParseException ex) {
            Logger.getLogger(DlgPedidoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String data = dataMysql.format(dtPedido);

        PedidoCaixa novoPedido = new PedidoCaixa();

        novoPedido.setClienteId(cliente.getId());
        novoPedido.setDataPedido(data);
        novoPedido.setTotalPedido(valorTotal);
        novoPedido.setFormaPagtoId(fpagto.getId());
        novoPedido.setStatusPedido(statusPedido);
        novoPedido.setObsPedido(obsPedido);
        novoPedido.setAtendenteId(func.getId());

        repositorio.cadastraPedido(novoPedido);

    }
    
    public void baixaPedido(String codigo, BigDecimal vlPagar, BigDecimal vlDesconto, String dtBaixa){
        int id = Integer.parseInt(codigo);
        PedidoCaixa pedido = new PedidoCaixa();
        pedido.setClienteId(id);
        pedido.setTotalAPagar(vlPagar);
        pedido.setValorDesconto(vlDesconto);
        pedido.setDataBaixa(dtBaixa);
        
        try {
            repositorio.baixaPedido(pedido);
        } catch (Exception e) {
            throw new PedidoCaixaException("O Pedido não pode ser baixado "+e);
        }
        
    }

    public void carregarTabela(JTable grdPedidos) {
        List<PedidoCaixa> pedidos = repositorio.listarPedidos();

        TMPedidoCaixa tmPedidos = new TMPedidoCaixa(pedidos);
        grdPedidos.setModel(tmPedidos);
    }

    public PedidoCaixa pegaPedido(int linha) {
        List<PedidoCaixa> pedidos = repositorio.listarPedidos();
        TMPedidoCaixa tmPedido = new TMPedidoCaixa(pedidos);

        PedidoCaixa pedido = tmPedido.pegaPedido(linha);
        return pedido;
    }

    public void carregaPedidosAbertos(JTable grdPedidos) {
        List<PedidoCaixa> pedidos = repositorio.buscarAbertos();

        TMPedidoCaixa tmPedidos = new TMPedidoCaixa(pedidos);
        grdPedidos.setModel(tmPedidos);
    }
    
    public PedidoCaixa pesquisarIdPedido(String codigo){
        int id = Integer.parseInt(codigo);
        return repositorio.buscaPedidoId(id);
    }

    public int calculaPreparo(String dtPedido) {
        int tempoPreparo = 0;
        Date tPreparo;
        Date atual = new Date();
        try {
            tPreparo = dataMysql.parse(dtPedido);
            long tempo = atual.getTime() - tPreparo.getTime(); //Milisegundos
            tempoPreparo = (int) (tempo / 1000 / 60);
        } catch (ParseException ex) {
            Logger.getLogger(FrmPedidosCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tempoPreparo;
    }

}
