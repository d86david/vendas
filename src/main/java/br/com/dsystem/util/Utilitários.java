package br.com.dsystem.util;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Utilitários {
    
    public void limparTela(JPanel container){
        Component components[] = container.getComponents();
        for (Component component : components ){
            if(component instanceof JTextField jTextField ){
                jTextField.setText(null);            
            } 
        }
    }
    
    
}
