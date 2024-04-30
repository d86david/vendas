
import java.math.BigDecimal;
import javax.swing.JTable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Teste {
    
    public static void main(String[] args) {
        
        JTable table = new JTable();
        table.setDefaultRenderer(Object.class, new TesteTabelas());
        
        
      /**
        BigDecimal valor1 = new BigDecimal("4.00");
        BigDecimal valor2 = new BigDecimal("5.00");
        int i = valor2.compareTo(valor1);
        
        //valor1 = valor1.add(valor2); // forma convencional de adicionar dois valores BigDecimal
        
      //  System.out.println("Valor1: " + valor1);
        
       // valor1 = new BigDecimal("10.5");
       // valor1 = valor1.add(valor2); // usando o operador +=
        
        System.out.println("resultado " + i);*/
    }
}
