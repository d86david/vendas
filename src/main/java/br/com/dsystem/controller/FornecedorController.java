/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.controller;

import br.com.dsystem.model.Fornecedor;
import br.com.dsystem.model.dao.FornecedorDAO;
import br.com.dsystem.model.exceptions.FornecedorException;
import br.com.dsystem.model.tableModel.TMFornecedor;
import br.com.dsystem.model.valid.ValidaFornecedor;
import br.com.dsystem.util.WebServiceCep;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public class FornecedorController {
    
    FornecedorDAO repositorio = new FornecedorDAO();
    
    public void cadastrarFornecedor(String nome, String celular, String foneFixo, String pessoa, String cpfCnpj,
            String rg, String cep, String endereco, String numero, String compl, String bairro, String cidade,
            String uf, String email, String obs) {
        ValidaFornecedor fornecValido = new ValidaFornecedor();
        Fornecedor f = fornecValido.validaCamposEntrada(nome, cpfCnpj, numero);
        f.setCelular(celular);
        f.setFoneFixo(foneFixo);
        f.setPessoa(pessoa);
        f.setRgIe(rg);
        f.setCep(cep);
        f.setEndereco(endereco);
        f.setCompl(compl);
        f.setBairro(bairro);
        f.setEstado(uf);
        f.setEmail(email);
        f.setObs(obs);
        
        if (repositorio.temCpfCnpj(f.getCpfCnpj())) {
            throw new FornecedorException("Já Existe um Fornecedor \ncom esse CPF/CNPJ Cadastrado|");
        } else {
            repositorio.cadastraFornecedor(f);
        }
        
    }
    
    public void atualizarFornecedor(String codigo, String nome, String celular, String foneFixo, String pessoa, String cpfCnpj,
            String rg, String cep, String endereco, String numero, String compl, String bairro, String cidade,
            String uf, String email, String obs) {
        ValidaFornecedor fornecValido = new ValidaFornecedor();
        
        Fornecedor f = fornecValido.validaCamposEntrada(nome, cpfCnpj, numero);
        f.setId(Integer.parseInt(codigo));
        f.setCelular(celular);
        f.setFoneFixo(foneFixo);
        f.setPessoa(pessoa);
        f.setRgIe(rg);
        f.setCep(cep);
        f.setEndereco(endereco);
        f.setCompl(compl);
        f.setBairro(bairro);
        f.setEstado(uf);
        f.setEmail(email);
        f.setObs(obs);
        
        repositorio.atualizaFornecedor(f);
        
    }
    
    public void deletarFornecedor(String codigo) {
        int id = Integer.parseInt(codigo);
        if (repositorio.temId(id)) {
            repositorio.deletaFornecedor(id);
        } else {
            throw new FornecedorException("Fornecedor não cadastrado!");
        }
        
    }
    
    public void carregaTabelaFornecedor(JTable grdFornecedor) {
        
        List<Fornecedor> fornecedores = repositorio.listaFornecedores();
        
        TMFornecedor tmFornecedor = new TMFornecedor(fornecedores);
        grdFornecedor.setModel(tmFornecedor);
    }
    
    public void buscaNomeFornecedor(JTable grdFornecedor, String nome) {
        String busca = "%"+nome+"%";
        
        List<Fornecedor> fornecedores = repositorio.buscaNomeFornecedor(busca);
            
            TMFornecedor tmFornecedor = new TMFornecedor(fornecedores);
            grdFornecedor.setModel(tmFornecedor);
        
    }
    
    public Fornecedor buscaCPFFornecedor(String cpf) {
        if (repositorio.temCpfCnpj(cpf)){
            return repositorio.buscaCpfFornecedor(cpf);
        } else {
            throw new FornecedorException("Fornecedor não Cadastrado!");
        }
    }
    
    public void buscaIdFornecedor(JTable grdFornecedor, String codigo) {
        
        int id = Integer.parseInt(codigo);
        
        if (repositorio.temId(id)) {
            Fornecedor fornecedor = repositorio.buscaCodigoFornecedor(id);
            
            List<Fornecedor> fornec = new ArrayList<>();
            fornec.add(fornecedor);
            
            TMFornecedor tmFornecedor = new TMFornecedor(fornec);
            grdFornecedor.setModel(tmFornecedor);
        }
        
    }
    
    public Fornecedor buscaIdFornecedor(String  codigo) {
        int id = Integer.parseInt(codigo);
        if (repositorio.temId(id)) {
            return repositorio.buscaCodigoFornecedor(id);
        } else {
            throw new FornecedorException("Fornecedor não cadastrado!");
        }
    }
    
    public Fornecedor buscaCEPFornecedor(String cep) {
        WebServiceCep wsCep = WebServiceCep.searchCep(cep);
        Fornecedor f = new Fornecedor();
        
        if (wsCep.wasSuccessful()) {
            f.setEndereco(wsCep.getLogradouroFull());
            f.setCidade(wsCep.getCidade());
            f.setBairro(wsCep.getBairro());
            f.setEstado(wsCep.getUf());
            return f;
        } else {
            throw new RuntimeException("Erro número: " + wsCep.getResulCode() + "\nDescrição do erro: " + wsCep.getResultText());
        }
    }
    
    public boolean buscaFornecedor(Fornecedor f) {
        return repositorio.temCpfCnpj(f.getCpfCnpj()) || repositorio.temId(f.getId());
    }
    
}
