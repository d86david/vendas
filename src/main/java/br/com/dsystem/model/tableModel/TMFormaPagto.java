/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.tableModel;

import br.com.dsystem.model.FormaPagto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class TMFormaPagto extends AbstractTableModel{
    
    private List<FormaPagto> formas = new ArrayList<>();
    private final String colunas[] = {"Código", "Descrição"}; 
    
    public TMFormaPagto(List<FormaPagto> lstFormas){
        this.formas = lstFormas;
    }

    @Override
    public int getRowCount() {
        return formas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        FormaPagto fpagto = formas.get(linha);
        
        switch(coluna){
            case 0 ->{
                return fpagto.getId();
            }
            case 1 ->{
                return fpagto.getDescricao();
            }
            default ->{
                
            }
        }
        return null;
    }
    
}
