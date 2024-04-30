/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.valid;

import br.com.dsystem.model.Fornecedor;
import br.com.dsystem.model.exceptions.ClienteExceptions;
import br.com.dsystem.model.exceptions.FornecedorException;
import br.com.dsystem.util.ValidaDocumento;

/**
 *
 * @author Administrador
 */
public class ValidaFornecedor {
    
    public Fornecedor validaCamposEntrada(String nome, String cpfCnpj, String numero  ){
        Fornecedor f = new Fornecedor();
        
        if(nome.isEmpty())
            throw new FornecedorException("Erro - Campo Nome vazio!");
        f.setNome(nome);
        
        if(cpfCnpj.isEmpty())
            throw new FornecedorException("Erro - Campo CPF/CNPJ Inválido!");
        
         //Verificando o tamanho da String para determinar se é CPF ou CNPJ
        switch (cpfCnpj.length()) {
            case 14 -> {
                if (ValidaDocumento.validaCPF(cpfCnpj) == false) {
                    throw new ClienteExceptions("Erro - CPF Inválido!");
                }
                f.setCpfCnpj(cpfCnpj);
            }
            case 18 -> {
                if (ValidaDocumento.validaCNPJ(cpfCnpj) == false) {
                    throw new ClienteExceptions("Erro - CNPJ Inválido!");
                }
                f.setCpfCnpj(cpfCnpj);
            }
            default ->
                throw new ClienteExceptions("Erro - Campo CPF/CNPJ vazio!");
        }
        
        if (!numero.matches("[0-9]*"))
            throw new ClienteExceptions("Valor inválido no campo Numero!");
        int numInt = Integer.parseInt(numero);
        f.setNumero(numInt);
        
        return f;
    }
    
    
}
