/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.tableModel;

import br.com.dsystem.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author david
 */
public class TMCliente extends AbstractTableModel {

    List<Cliente> clientes = new ArrayList<>();
    private final String[] colunas = {"código", "Nome", "CPF/CNPJ", "celular"};

    public TMCliente(List<Cliente> lstCliente) {
        this.clientes = lstCliente;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }
    

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cliente cli = this.clientes.get(linha);

        switch (coluna) {
            case 0 -> {
                return cli.getId();
            }
            case 1 -> {
                return cli.getNome();
            }
            case 2 -> {
                return cli.getCpfCnpj();
            }
            case 3 -> {
                return cli.getCelular();
            }
            default -> {
            }
        }
        return null;
    }

}
