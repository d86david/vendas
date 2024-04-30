
package br.com.dsystem.model.valid;

import br.com.dsystem.model.FormaPagto;
import br.com.dsystem.model.exceptions.FormaPagtoException;

/**
 *
 * @author Administrador
 */
public class ValidaFormaPagto {
    
    public FormaPagto validaCamposEntrada(String descricao){
        FormaPagto formaPagto = new FormaPagto();
        
        if (descricao.isEmpty())
            throw new FormaPagtoException("Erro - Campo Descrição Vazio!");
        formaPagto.setDescricao(descricao);
        
        return formaPagto;
    }
    
}
