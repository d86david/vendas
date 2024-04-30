/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.valid;

import br.com.dsystem.model.Cliente;
import br.com.dsystem.model.exceptions.ClienteExceptions;
import br.com.dsystem.util.ValidaDocumento;

/**
 *
 * @author david Classe resposanvel por fazer todas as validações necessarias do
 * campos do Cliente antes de salvar no Banco dados
 *
 * Essa classe não faz manipulação do Banco de dados ela apenas valida e repassa
 * para a classe Controller
 */
public class ValidaCliente {

    public Cliente validaCamposEntrada(String nome, String celular, String cpfCnpj, String endereco, String numero) {

        Cliente cliente = new Cliente();

        if (nome.isEmpty()) {
            throw new ClienteExceptions("Campo 'Nome' vazio!");
        }
        cliente.setNome(nome);

        String semespaco = celular.replace(" ", "");
        if (semespaco.length() <= 3) {
            throw new ClienteExceptions("Campo  'Celular'  vazio!");
        } else if (semespaco.length() >= 4 && celular.length() <= 13) {
            throw new ClienteExceptions("Campo 'Celular'  inválido!");
        } else {
            cliente.setCelular(celular);
        }

        //Verificando o tamanho da String para determinar se é CPF ou CNPJ
        switch (cpfCnpj.length()) {
            case 14 -> {
                if (ValidaDocumento.validaCPF(cpfCnpj) == false) {
                    throw new ClienteExceptions("CPF Inválido!");
                }
                cliente.setCpfCnpj(cpfCnpj);
            }
            case 18 -> {
                if (ValidaDocumento.validaCNPJ(cpfCnpj) == false) {
                    throw new ClienteExceptions("CNPJ Inválido!");
                }
                cliente.setCpfCnpj(cpfCnpj);
            }
            default ->
                throw new ClienteExceptions("Campo CPF/CNPJ vazio!");
        }

        if (endereco.isEmpty()) {
            throw new ClienteExceptions("Campo Endereço vazio!");
        }
        cliente.setEndereco(endereco);

        int numeroInt = 0;
        if (numero.isEmpty()) {
            throw new ClienteExceptions("Erro - Campo Número vazio!");
        }

        if (!numero.matches("[0-9]*")) {
            throw new ClienteExceptions("Erro - valor inválido no campo Numero!");
        }

        numeroInt = Integer.parseInt(numero);
        cliente.setNumero(numeroInt);

        return cliente;

    }

}
