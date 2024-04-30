package br.com.dsystem.controller;

import br.com.dsystem.model.dao.FormaPagtoDAO;
import br.com.dsystem.model.FormaPagto;
import br.com.dsystem.model.exceptions.FormaPagtoException;
import br.com.dsystem.model.tableModel.TMFormaPagto;
import br.com.dsystem.model.valid.ValidaFormaPagto;
import java.util.ArrayList;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author david
 */
public class FormaPagtoController {

    FormaPagtoDAO repositorio = new FormaPagtoDAO();

    public void cadastrarFPagto(String descricao) {
        ValidaFormaPagto fpagtoValida = new ValidaFormaPagto();
        FormaPagto fpagto = fpagtoValida.validaCamposEntrada(descricao);

        if (repositorio.temFormaPagto(fpagto.getDescricao())) {
            throw new FormaPagtoException("Forma de Pagamento já cadastrada!");
        } else {
            repositorio.cadastraFormaPagto(fpagto);
        }
    }

    public void atualizarFPagto(String codigo, String descricao) {
        int id = Integer.parseInt(codigo);
        ValidaFormaPagto fpagtoValida = new ValidaFormaPagto();
        FormaPagto fpagto = fpagtoValida.validaCamposEntrada(descricao);
        fpagto.setId(id);

        repositorio.atualizaFormaPagto(fpagto);

    }

    public void deletarFPagto(String codigo) {
        int id = Integer.parseInt(codigo);

        if (repositorio.temFormaPagto(id)) {
            repositorio.deletaFormaPagto(id);
        } else {
            throw new FormaPagtoException("Forma de Pagamento não cadastrada!");
        }
    }

    public void carregarTabelaFPagto(JTable grdFPagto) {
        List<FormaPagto> formas = repositorio.listaFormaPagto();

        TMFormaPagto tmFormaPagto = new TMFormaPagto(formas);
        grdFPagto.setModel(tmFormaPagto);
    }

    public void pesquisaDescFPagto(JTable grdPagto, String descricao) {
        String fpagto = "%" + descricao + "%";
        List<FormaPagto> formas = repositorio.buscaFormaPagto(fpagto);

        TMFormaPagto tmFormaPagto = new TMFormaPagto(formas);
        grdPagto.setModel(tmFormaPagto);
    }
    
    public FormaPagto pesquisaDescFPagto(String descricao) {
        try {
            return repositorio.buscaDescFormaPagto(descricao);
        } catch (Exception e) {
            throw new FormaPagtoException(e.getMessage());
        }
    }

    public void pesquisarIdFormaPagto(JTable grdPagto, String codigo) {
        int id = Integer.parseInt(codigo);
        FormaPagto fpagto = repositorio.buscaFormaPagto(id);

        List<FormaPagto> pagtos = new ArrayList<>();
        pagtos.add(fpagto);

        TMFormaPagto tmFormaPagto = new TMFormaPagto(pagtos);
        grdPagto.setModel(tmFormaPagto);
    }

    public FormaPagto pesquisaIdFormaPagto(String codigo) {
        int id = Integer.parseInt(codigo);
        return repositorio.buscaFormaPagto(id);
    }

    public DefaultComboBoxModel listarComboFPagto() {

        FormaPagtoDAO dao = new FormaPagtoDAO();

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        try {
            List<FormaPagto> formas = dao.listaFormaPagto();

            for (FormaPagto f : formas) {
                modelo.addElement(f);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Lista Categoria", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;

    }

}
