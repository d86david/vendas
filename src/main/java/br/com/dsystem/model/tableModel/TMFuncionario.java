/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.tableModel;

import br.com.dsystem.model.Funcionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class TMFuncionario extends AbstractTableModel {

    private final List<Funcionario> funcionarios;
    private final String colunas[] = {"Código", "Nome", "Cargo", "Celular"};

    public TMFuncionario(List<Funcionario> lstFuncionario) {
        this.funcionarios = lstFuncionario;
    }

    @Override
    public int getRowCount() {
        return funcionarios.size();
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
        Funcionario f = funcionarios.get(linha);
        switch (coluna) {
            case 0 -> {
                return f.getId();
            }
            case 1 -> {
                return f.getNome();
            }
            case 2 -> {
                return f.getCargo();
            }
            case 3 -> {
                return f.getCelular();
            }
            default -> {
            }
        }
        return null;
    }
}
