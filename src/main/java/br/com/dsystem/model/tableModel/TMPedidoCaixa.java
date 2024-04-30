/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.tableModel;

import br.com.dsystem.controller.PedidoCaixaController;
import br.com.dsystem.model.PedidoCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class TMPedidoCaixa extends AbstractTableModel {

    private Timer timer;
    int coluna = 3;
    private PedidoCaixaController pcCOntrol = new PedidoCaixaController();
    private final SimpleDateFormat dataMysql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat dataBr = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date data = new Date();
    List<PedidoCaixa> pedidosCaixa = new ArrayList<>();
    String[] colunas = {"Código Pedido", "Data Pedido", "Valor Pedido", "Tempo Preparo", "Baixa", "Status"};

    public TMPedidoCaixa(List<PedidoCaixa> lstPedido) {
        this.pedidosCaixa = lstPedido;
        
        timer = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                for (int i = 0; i<=pedidosCaixa.size();i++){
                     fireTableCellUpdated(i, coluna);
                }
            }
        });
        timer.start();
        
    }

    @Override
    public int getRowCount() {
        return pedidosCaixa.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        PedidoCaixa pedido = pedidosCaixa.get(linha);
        switch (coluna) {
            case 0 -> {
                return pedido.getId();
            }
            case 1 -> {
                String dtPedido = pedido.getDataPedido();
                try {
                    data = dataMysql.parse(dtPedido);
                } catch (ParseException ex) {
                    Logger.getLogger(TMPedidoCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
                String dataFormatada = dataBr.format(data);
                return dataFormatada;
            }

            case 2 -> {
                return pedido.getTotalPedido().toString().replace(".", ",");
            }

            case 3 -> {
                if (pedido.getDataBaixa() != null) {
                    int result = Integer.parseInt(pedido.getTempoPreparo());
                    int horas = result / 60;
                    int minutos = result % 60;
                    if (horas > 0) {
                        String tempoPreparo = Integer.toString(horas) + "h:" + Integer.toString(minutos) + "min";
                        return tempoPreparo;
                    } else {
                        String tempoPreparo = Integer.toString(minutos) + "min";
                        return tempoPreparo;
                    }

                } else {
                    int result = pcCOntrol.calculaPreparo(pedido.getDataPedido());
                    int horas = result / 60;
                    int minutos = result % 60;
                    if (horas > 0) {
                        String tempoPreparo = Integer.toString(horas) + " h : " + Integer.toString(minutos) + " min";
                        return tempoPreparo;
                    } else {
                        String tempoPreparo = Integer.toString(minutos) + " min";
                        return tempoPreparo;
                    }

                }

            }

            case 4 -> {
                if (pedido.getDataBaixa() == null) {
                    return "ABERTO";
                } else {
                    return "BAIXADO";
                }
            }

            case 5 -> {
                return pedido.getStatusPedido();
            }
            default -> {
            }
        }
        return null;
    }

    public PedidoCaixa pegaPedido(int linha) {
        return pedidosCaixa.get(linha);
    }

}
