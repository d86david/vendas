
package br.com.dsystem.model.tableModel;

import br.com.dsystem.model.Ingrediente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class TMIngrediente extends AbstractTableModel {
    private List<Ingrediente> ingredientes = new ArrayList<>();
    String colunas[] = {"Código","Ingrediente"};

    public TMIngrediente(List<Ingrediente> lstIngredientes) {
        this.ingredientes = lstIngredientes;     
    }
    

    @Override
    public int getRowCount() {
        return ingredientes.size();
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
        Ingrediente ingrediente = this.ingredientes.get(linha);
        
        switch (coluna){
            case 0 -> {
                return ingrediente.getId();
            }
            case 1 -> {
                return ingrediente.getIngrediente();
            }
            default -> {
            }
        }
        return null;
    }
    
    
}
