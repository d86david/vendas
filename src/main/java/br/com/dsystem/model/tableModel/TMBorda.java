/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.tableModel;

import br.com.dsystem.model.Borda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class TMBorda extends AbstractTableModel {

    List<Borda> bordas = new ArrayList<>();
    private final String[] colunas = {"Código", "Borda", "valor R$"};

    public TMBorda(List<Borda> lstBorda) {
        this.bordas = lstBorda;
    }
   
    @Override
    public int getRowCount() {
        return bordas.size();
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
        Borda borda = this.bordas.get(linha);
        switch (coluna) {
            case 0 -> {
                return borda.getId();
            }
            case 1 -> {
                return borda.getDescricao();
            }
            case 2 -> {
                return borda.getValor();
            }
            default -> {
            }
        }
        return null;
    }

}
