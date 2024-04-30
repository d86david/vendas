package br.com.dsystem.controller;

import br.com.dsystem.model.dao.BordaDAO;
import br.com.dsystem.model.Borda;
import br.com.dsystem.model.exceptions.BordaException;
import br.com.dsystem.model.exceptions.ClienteExceptions;
import br.com.dsystem.model.tableModel.TMBorda;
import br.com.dsystem.model.valid.ValidaBorda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

/**
 *
 * @author david
 */
public class BordaController {

    BordaDAO repositório;

    public BordaController() {
        repositório = new BordaDAO();
    }

    public void cadastraBorda(String descricao, String valor) {
        ValidaBorda bordaValida = new ValidaBorda();
        Borda novaBorda = bordaValida.validaCampoEntrada(descricao, valor);

        if (repositório.temBorda(descricao)) {
            throw new ClienteExceptions("Borda já existente");
        } else {
            repositório.cadastraBorda(novaBorda);
        }
    }

    public void atualizarBorda(String id, String descricao, String valor) {
        int IdInt = 0;
        ValidaBorda bordaValida = new ValidaBorda();
        Borda novaBorda = bordaValida.validaCampoEntrada(descricao, valor);
        IdInt = Integer.parseInt(id);
        novaBorda.setId(IdInt);
        
        if(repositório.temBorda(IdInt)){
            repositório.atualizaBorda(novaBorda);
        }else{
            throw new BordaException("Borda não cadastrada!");
        }
        
        
    }

    public void deletarBorda(String borda) {
        int id = Integer.parseInt(borda);

        if (repositório.temBorda(id)) {
            repositório.deletaBorda(id);
        } else {
            throw new BordaException("Borda não cadastrada!");
        }
    }

    public void carregaTabela(JTable grdBorda) {

        List<Borda> bordas = repositório.listaBorda();

        TMBorda tmBorda = new TMBorda(bordas);
        grdBorda.setModel(tmBorda);

    }

    public void pesquisaDescricaoBorda(JTable grdBorda, String descricao) {
        String borda = "%" + descricao + "%";
        List<Borda> bordas = repositório.buscaDescricaoBorda(borda);

        TMBorda tmBorda = new TMBorda(bordas);
        grdBorda.setModel(tmBorda);
    }

    public Borda pesquiarDescricaoBorda(String descricao) {
        if (repositório.temBorda(descricao)) {
            return repositório.buscaDescricao1Borda(descricao);
        } else {
            throw new BordaException("Borda não cadastrada");
        }
    }

    public Borda pesquiarCodigoBorda(String codigo) {
        int idInt = Integer.parseInt(codigo);
        if (repositório.temBorda(idInt)) {
            return repositório.buscaCodigoBorda(idInt);
        } else {
            throw new BordaException("Borda não cadastrada");
        }
    }

    public void pesquiarCodigoBorda(JTable grdBorda, String codigo) {
        int idInt = Integer.parseInt(codigo);
        List<Borda> borda = new ArrayList<>();
        if (repositório.temBorda(idInt)) {
            Borda b = repositório.buscaCodigoBorda(idInt);
            borda.add(b);

            TMBorda tmBorda = new TMBorda(borda);
            grdBorda.setModel(tmBorda);

        } else {
            throw new BordaException("Borda não cadastrada");
        }
    }

    public DefaultComboBoxModel listarComboBorda() {

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        try {
            List<Borda> bordas = repositório.listaBorda();

            for (Borda b : bordas) {
                modelo.addElement(b);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return modelo;
    }

}
