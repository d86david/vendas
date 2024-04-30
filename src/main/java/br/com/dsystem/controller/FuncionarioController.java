/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.controller;

import br.com.dsystem.model.Funcionario;
import br.com.dsystem.model.dao.FuncionarioDAO;
import br.com.dsystem.model.exceptions.FuncionarioException;
import br.com.dsystem.model.tableModel.TMFuncionario;
import br.com.dsystem.model.valid.ValidaFuncionario;
import br.com.dsystem.util.WebServiceCep;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public class FuncionarioController {

    private final FuncionarioDAO repositorio = new FuncionarioDAO();
    private Funcionario f = new Funcionario();

    public void cadastrarFuncionario(String nome, String nivel_acesso, String pessoa, String cpfCnpj,
            String rg, String cargo, String cep, String endereco, String numero,
            String compl, String bairro, String cidade, String estado, String foneFixo,
            String celular, String email, String obs, boolean userAtivo, String login, String Senha) {

        ValidaFuncionario funcionarioValido = new ValidaFuncionario();
        f = funcionarioValido.validaCamposEntrada(nome,cpfCnpj, numero);
        
        f.setNivel_acesso(nivel_acesso);
        f.setPessoa(pessoa);
        f.setRg(rg);
        f.setCargo(cargo);
        f.setCep(cep);
        f.setEndereco(endereco);
        f.setCompl(compl);
        f.setBairro(bairro);
        f.setCidade(cidade);
        f.setEstado(estado);
        f.setFoneFixo(foneFixo);
        f.setCelular(celular);
        f.setEmail(email);
        f.setObs(obs);
        f.setAtivo(userAtivo);

        if (repositorio.temCpfFuncionario(f.getCpf())) {
            throw new FuncionarioException("Já existem Funcionario cadastrado com esse CPF/CNPJ!");
        }

        if (f.getAtivo() == true) {
            if (repositorio.temLoginFuncionario(f.getLogin())) {
                throw new FuncionarioException("Já existem Funcionario cadastrado com esse Login!");
            } else{
                f.setLogin(login);
                f.setSenha(Senha);
            }
        }

        repositorio.cadastraFuncionario(f);
    }

    public void atualizarFuncionario(String codigo, String nome, String nivel_acesso, String pessoa, String cpfCnpj,
            String rg, String cargo, String cep, String endereco, String numero,
            String compl, String bairro, String cidade, String estado, String foneFixo,
            String celular, String email, String obs, boolean userAtivo, String cpfAntes) {

        ValidaFuncionario funcionarioValido = new ValidaFuncionario();
        f = funcionarioValido.validaCamposEntrada(nome,cpfCnpj, numero);
        
        f.setId(Integer.parseInt(codigo));
        f.setNivel_acesso(nivel_acesso);
        f.setPessoa(pessoa);
        f.setRg(rg);
        f.setCargo(cargo);
        f.setCep(cep);
        f.setEndereco(endereco);
        f.setCompl(compl);
        f.setBairro(bairro);
        f.setCidade(cidade);
        f.setEstado(estado);
        f.setFoneFixo(foneFixo);
        f.setCelular(celular);
        f.setEmail(email);
        f.setObs(obs);
        f.setAtivo(userAtivo);
        
        if(cpfCnpj.equals(cpfAntes)){
            repositorio.atualizaFuncionario(f);
        }else{
            if(repositorio.temCpfFuncionario(cpfCnpj)){
                throw new FuncionarioException("Já existe um Funcionario cadastrado com esse CPF/CNPJ!");
            }else{
                repositorio.atualizaFuncionario(f);    
            }
        }

        
        

    }

    public void deletarFuncionario(String codigo) {
        
        int id = Integer.parseInt(codigo);

        if (repositorio.temIdFuncionario(id)) {
            repositorio.deletaFuncionario(id);
        } else {
            throw new FuncionarioException("Funcionario não cadastrado!");
        }

    }

    public void carregaTabela(JTable grdFuncionario) {
        List<Funcionario> funcionarios = repositorio.listaFuncionario();

        TMFuncionario tmFuncionario = new TMFuncionario(funcionarios);
        grdFuncionario.setModel(tmFuncionario);
    }

    public void buscarNomeFuncionario(JTable grdFuncionario, String nome) {
        String buscaNome = "%" + nome + "%";
        List<Funcionario> funcionarios = repositorio.buscaNomeFuncionario(buscaNome);
        TMFuncionario tmFuncionario = new TMFuncionario(funcionarios);
        grdFuncionario.setModel(tmFuncionario);
    }

    public void buscarIdFuncionario(JTable grdFuncionario, String codigo) {
        int id = Integer.parseInt(codigo);
        Funcionario func = repositorio.buscaCodigoFuncionario(id);
        List<Funcionario> funcionario = new ArrayList<>();
        funcionario.add(func);

        TMFuncionario tmFuncionario = new TMFuncionario(funcionario);
        grdFuncionario.setModel(tmFuncionario);
    }

    public Funcionario buscaIdFuncionario(String codigo) {
        int id = Integer.parseInt(codigo);
        return repositorio.buscaCodigoFuncionario(id);
    }
    
    public Funcionario buscaLoginFuncionario(String login) {
        return repositorio.buscaLoginFuncioanrio(login);
    }

    public boolean buscaFuncionario(String codigo, String cpf) {
        int id = Integer.parseInt(codigo);
        return repositorio.temCpfFuncionario(cpf) || repositorio.temIdFuncionario(id);
    }

    public Funcionario buscaCEPFuncionario(String cep) {
        if (cep.length() != 9) {
            throw new FuncionarioException("CEP inválido");
        } else {
            WebServiceCep wsCep = WebServiceCep.searchCep(cep);
            Funcionario func = new Funcionario();

            if (wsCep.wasSuccessful()) {
                func.setEndereco(wsCep.getLogradouroFull());
                func.setCidade(wsCep.getCidade());
                func.setBairro(wsCep.getBairro());
                func.setEstado(wsCep.getUf());
                return func;
            } else {
                throw new FuncionarioException("Erro número: " + wsCep.getResulCode() + "\nDescrição do erro: " + wsCep.getResultText());
            }
        }
    }

    public Funcionario efetuarLogin(String usuario, String senha) {

        if (repositorio.login(usuario, senha) != null) {
            return repositorio.login(usuario, senha);
        } else {
            throw new FuncionarioException("Usuário ou Senha Inválido!");
        }
    }

}
