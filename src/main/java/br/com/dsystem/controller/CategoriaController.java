package br.com.dsystem.controller;

import br.com.dsystem.model.dao.CategoriaDAO;
import br.com.dsystem.model.Categoria;
import br.com.dsystem.model.exceptions.CategoriaException;
import br.com.dsystem.model.tableModel.TMCategoria;
import br.com.dsystem.model.valid.ValidaCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CategoriaController {
    
    private final CategoriaDAO repositorio = new CategoriaDAO();
    
    public void cadastrarCategoria(String categoria, boolean temBorda, boolean VariosSabores) {
        
        ValidaCategoria categoriaValida = new ValidaCategoria();
        Categoria novaCategoria = categoriaValida.validaCamposEntrada(categoria);
        novaCategoria.setTemBorda(temBorda);
        novaCategoria.setVariosSabores(VariosSabores);
        
        if (repositorio.temCategoria(categoria)) {
            throw new CategoriaException("Categoria ja Cadastrada!");
        } else {
            repositorio.cadastraCategoria(novaCategoria);
        }       
    }
    
    public void atualizarCategoria(String codigo, String categoria, boolean temBorda, boolean VariosSabores) {
        int id = 0;     
        ValidaCategoria categoriaValida = new ValidaCategoria();
        Categoria novaCategoria = categoriaValida.validaCamposEntrada(categoria);
        id = Integer.parseInt(codigo);
        novaCategoria.setId(id);
        novaCategoria.setTemBorda(temBorda);
        novaCategoria.setVariosSabores(VariosSabores);
        
        if(repositorio.temCategoria(id)){
            repositorio.atuiazaCategoria(novaCategoria);
        }else{
            throw new CategoriaException("Categoria não cadastrada!");
        }
           
    }
    
    public void deletarCategoria(String codigo) {
        int id = Integer.parseInt(codigo);
        
        if(repositorio.temCategoria(id)){
            repositorio.deletaCategoria(id);
        }else{
            throw new CategoriaException("Categoria não cadastrada!");
        }          
    }
    
    public void listarCategorias(JTable grdCategoria) {
        
        List<Categoria> categorias = repositorio.listaCategoria();
        
        TMCategoria tmCategoria = new TMCategoria(categorias);
        grdCategoria.setModel(tmCategoria);
    }
    
    public void pesquisarCodigoCategoria(JTable grdCategoria, String codigo){
        int id = Integer.parseInt(codigo);
        List<Categoria> categorias = new ArrayList<>();
        
        if(repositorio.temCategoria(id)){
            Categoria cat = repositorio.buscaCategoria(id);
            categorias.add(cat);
            
            TMCategoria tmCategoria = new TMCategoria(categorias);
            grdCategoria.setModel(tmCategoria);
            
        }else{
            throw new CategoriaException("Categoria não encotrada!");
        }
        
    }
    
    public Categoria pesquisarCodigoCategoria(String codigo){
        int id = Integer.parseInt(codigo);
        
        if(repositorio.temCategoria(id)){
            return repositorio.buscaCategoria(id);
        }else{
            throw new CategoriaException("categoria não cadastrada!");
        }
    }
    
    public void pesquiarCateoria (JTable grdCategoria, String categoria){
        String descricao = "%" + categoria + "%";
        List<Categoria> categorias = repositorio.buscaCategoria(descricao);
        
        TMCategoria tMCategoria = new TMCategoria(categorias);
        grdCategoria.setModel(tMCategoria);
    }
    
    public DefaultComboBoxModel listarComboCategoria() {
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        try {
            List<Categoria> categorias = repositorio.listaCategoria();
            
            for (Categoria c : categorias) {
                modelo.addElement(c);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Lista Categoria", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        return modelo;
        
    }
    
}
