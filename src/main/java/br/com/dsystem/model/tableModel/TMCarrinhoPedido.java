/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.tableModel;

import br.com.dsystem.model.CarrinhoPedido;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class TMCarrinhoPedido extends AbstractTableModel {

    private final List<CarrinhoPedido> produtos = new ArrayList<>();
    private final String colunas[] = {"Qtd", "Código", "Produto", "Valor", "Subtotal"};

    @Override
    public int getRowCount() {
        return produtos.size();
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
        CarrinhoPedido produto = produtos.get(linha);

        switch (coluna) {
            case 0 -> {
                 return produto.getQuantidade();
            }
            case 1 -> {
                return produto.getProduto().getCodigoProduto();
            }
            case 2 -> { 
                return produto.getProduto().getDescricao();
            }
            case 3 -> {
                 return produto.getProduto().getPreco();
            }
            case 4 -> {
                return produto.getSubtotal();
            }

        }
        return null;
    }

    public void addRow(CarrinhoPedido p) {
        this.produtos.add(p);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.produtos.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public BigDecimal somaColuna() {
        BigDecimal total = new BigDecimal(0.00);

        for (int i = 0; i < getRowCount(); i++) {
            total = total.add((BigDecimal) getValueAt(i, 4));
        }

        return total;
    }   

}
