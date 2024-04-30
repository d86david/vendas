/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.tableModel;

import br.com.dsystem.model.Fornecedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class TMFornecedor extends AbstractTableModel {

    private final List<Fornecedor> fornecedores;
    private final String colunas[] = {"Código", "Nome", "CPF/CNPJ", "Celular"};

    public TMFornecedor(List<Fornecedor> lstFornec) {
        this.fornecedores = lstFornec;
    }
    
    
    @Override
    public int getRowCount() {
        return fornecedores.size();
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
        Fornecedor fornecedor = this.fornecedores.get(linha);

        switch (coluna) {
            case 0 -> {
                return fornecedor.getId();
            }
            case 1 -> {
                return fornecedor.getNome();
            }
            case 2 -> {
                return fornecedor.getCpfCnpj();
            }
            case 3 -> {
                return fornecedor.getCelular();
            }
            default -> {
            }
        }
        return null;
    }
}
