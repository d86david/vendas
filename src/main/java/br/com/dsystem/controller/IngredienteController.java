/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.controller;

import br.com.dsystem.model.Ingrediente;
import br.com.dsystem.model.dao.IngredienteDAO;
import br.com.dsystem.model.tableModel.TMIngrediente;
import br.com.dsystem.model.valid.ValidaIngrediente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public class IngredienteController {

    private final IngredienteDAO repositorio = new IngredienteDAO();

    public void cadastrarIngrediente(String ingrediente) {
        ValidaIngrediente ingredienteValido = new ValidaIngrediente();
        Ingrediente ingr = ingredienteValido.validaCamposEntrada(ingrediente);
        
        repositorio.cadastraIngrediente(ingr);
    }

    public void atualizarIngrediente(Ingrediente ingr) {
        ValidaIngrediente ingredienteValido = new ValidaIngrediente();
        ingredienteValido.validaCamposEntrada(ingr.getIngrediente());

        repositorio.atualizaIngrediente(ingr);

    }

    public void deletarIngrediente(Ingrediente ingr) {
        
        repositorio.deletaIngrediente(ingr.getId());

    }

    public void carregarTabelaIngrediente(JTable grdIngrediente) {

        List<Ingrediente> ingredientes = repositorio.listaIngrediente();
        TMIngrediente tmIngrediente = new TMIngrediente(ingredientes);
        grdIngrediente.setModel(tmIngrediente);
    }

    public void buscarDescricaoIngrediente(JTable grdIngrediente, String descricao) {
        List<Ingrediente> ingredientes = repositorio.buscaDescricaoIngrediente(descricao);
        TMIngrediente tmIngrediente = new TMIngrediente(ingredientes);
        grdIngrediente.setModel(tmIngrediente);

    }

    public void buscarIdIngrediente(JTable grdIngrediente, Ingrediente ingr) {

        Ingrediente ingrediente = repositorio.buscaCodigoIngrediente(ingr.getId());
        List<Ingrediente> ingredientes = new ArrayList<>();

        ingredientes.add(ingrediente);

        TMIngrediente tmIngrediente = new TMIngrediente(ingredientes);
        grdIngrediente.setModel(tmIngrediente);

    }

    public Ingrediente buscarIdIngrediente(int codigo) {

        return repositorio.buscaCodigoIngrediente(codigo);

    }

    public boolean verificaIngrediente(Ingrediente igr) {

        return repositorio.temIngrediente(igr.getId()) || repositorio.temIngrediente(igr.getIngrediente());
    }

}
