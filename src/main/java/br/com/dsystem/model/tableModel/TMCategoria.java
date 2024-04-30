/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.tableModel;

import br.com.dsystem.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class TMCategoria extends AbstractTableModel {

    List<Categoria> categorias = new ArrayList<>();
    private final String[] colunas = {"Código", "Categoria"};

    public TMCategoria(List<Categoria> lstCategoria) {
        this.categorias = lstCategoria;
    }

    @Override
    public int getRowCount() {
        return categorias.size();
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
        Categoria cat = categorias.get(linha);
        switch (coluna) {
            case 0 -> {
                return cat.getId();
            }
            case 1 -> {
                return cat.getDescricao();
            }
            default -> {

            }
        }
        return null;
    }

}
