/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.controller;

import br.com.dsystem.model.dao.ProdutoDAO;
import br.com.dsystem.model.Categoria;
import br.com.dsystem.model.Produto;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class ProdutoControl {
    
    public DefaultComboBoxModel listarProdutos(Categoria c){
        ProdutoDAO dao = new ProdutoDAO();
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        
        try {
            List<Produto> produtos = dao.pesquisaProdutoCategoria(c.getId());
            
            for(Produto p : produtos){
                modelo.addElement(p);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Lista Produtos dessa Categoria", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        return modelo;  
    }
    
}
