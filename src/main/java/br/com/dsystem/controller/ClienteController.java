/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.controller;

import br.com.dsystem.model.dao.ClienteDAO;
import br.com.dsystem.model.Cliente;
import br.com.dsystem.model.tableModel.TMCliente;
import br.com.dsystem.model.exceptions.ClienteExceptions;
import br.com.dsystem.model.exceptions.FuncionarioException;
import br.com.dsystem.model.valid.ValidaCliente;
import br.com.dsystem.util.WebServiceCep;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author david
 */
public class ClienteController {

    private final ClienteDAO repositório;

    public ClienteController() {
        repositório = new ClienteDAO();
    }

    public void cadastrarCliente(String nome, String celular, String telFixo, String tpPessoa, String cpfCnpj,
            String rg, String cep, String endereco, String numero, String compl, String bairro, String cidade, String uf, String email, String obs) {

        ValidaCliente clienteValido = new ValidaCliente();
        Cliente novoCliente = clienteValido.validaCamposEntrada(nome, celular, cpfCnpj, endereco, numero);

        novoCliente.setPessoa(tpPessoa);
        novoCliente.setFoneFixo(telFixo);
        novoCliente.setRg(rg);
        novoCliente.setCompl(compl);
        novoCliente.setBairro(bairro);
        novoCliente.setCidade(cidade);
        novoCliente.setEstado(uf);
        novoCliente.setCep(cep);
        novoCliente.setEmail(email);
        novoCliente.setObs(obs);

        if (repositório.temCpfCliente(cpfCnpj) == true) {
            throw new ClienteExceptions("Já existe um cliente com esse CPF/CNPJ");
        } else if (repositório.temCelularCliente(celular) == true) {
            throw new ClienteExceptions("Já existe um cliente com esse Celular");
        } else {
            repositório.cadastraCliente(novoCliente);
        }
    }

    public void atuaizarCliente(String id, String nome, String celular, String telFixo, String tpPessoa, String cpfCnpj,
            String rg, String cep, String endereco, String numero, String compl, String bairro, String cidade, String uf, String email, String obs) {

        int codiInt = Integer.parseInt(id);
        ValidaCliente clienteValido = new ValidaCliente();
        Cliente novoCliente = clienteValido.validaCamposEntrada(nome, celular, cpfCnpj, endereco, numero);
        novoCliente.setId(codiInt);
        novoCliente.setPessoa(tpPessoa);
        novoCliente.setFoneFixo(telFixo);
        novoCliente.setRg(rg);
        novoCliente.setCompl(compl);
        novoCliente.setBairro(bairro);
        novoCliente.setCidade(cidade);
        novoCliente.setEstado(uf);
        novoCliente.setCep(cep);
        novoCliente.setEmail(email);
        novoCliente.setObs(obs);

        repositório.atualizaCliente(novoCliente);
    }

    public void deletarCliente(String codigo) {
        int id = Integer.parseInt(codigo);

        if (repositório.temCodigoCliente(id)) {
            repositório.deletaCliente(id);
        } else {
            throw new ClienteExceptions("Cliente não cadastrado");
        }

    }

    public Cliente pesquisaCodigoCliente(String codigo) {
        int codInt = Integer.parseInt(codigo);

        if (repositório.temCodigoCliente(codInt)) {
            return repositório.buscaCodigoCliente(codInt);
        } else {
            throw new ClienteExceptions("Cliente não encontrado!");
        }

    }

    public void atualizatabela(JTable grdCliente) {
        ClienteDAO dao = new ClienteDAO();

        List<Cliente> clientes = dao.listarCliente();

        TMCliente tmCliente = new TMCliente(clientes);
        grdCliente.setModel(tmCliente);
    }

    public void pesquisaCliNOme(String nome, JTable grdCliente) {
        ClienteDAO dao = new ClienteDAO();
        String sql = "%" + nome + "%";
        List<Cliente> clientes = dao.buscaNomeCliente(sql);

        TMCliente tmClientes = new TMCliente(clientes);
        grdCliente.setModel(tmClientes);
    }

    public Cliente pesquisaCliCelular(String celular) {

        return repositório.buscaCelularCliente(celular);

    }

    public Cliente pesquisaCepCliente(String cep) {

        if (cep.length() != 9) {
            throw new ClienteExceptions("CEP inválido");
        } else {
            WebServiceCep wsCep = WebServiceCep.searchCep(cep);
            Cliente cli = new Cliente();

            if (wsCep.wasSuccessful()) {
                cli.setEndereco(wsCep.getLogradouroFull());
                cli.setCidade(wsCep.getCidade());
                cli.setBairro(wsCep.getBairro());
                cli.setEstado(wsCep.getUf());
                return cli;
            } else {
                throw new FuncionarioException("Erro número: " + wsCep.getResulCode() + "\nDescrição do erro: " + wsCep.getResultText());
            }
        }

    }

    public boolean validaCelularCli(String celular) {
        return repositório.temCelularCliente(celular);
    }

}
