
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrador
 */
public class TesteTabelas extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable tabela, Object obj, boolean isSelected, boolean hasFocus, int linha, int coluna){
        JLabel label = (JLabel) super.getTableCellRendererComponent(tabela, obj, isSelected, hasFocus, linha, coluna);
        label.setText("<html><div style='width:100px;'>"+obj.toString()+"</div></html>");
        return label;
    }
    
}
