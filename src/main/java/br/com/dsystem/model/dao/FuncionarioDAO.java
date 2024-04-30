/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.Funcionario;
import br.com.dsystem.model.exceptions.FuncionarioException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class FuncionarioDAO {

    Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactoy().getConnection();
    }

    public void cadastraFuncionario(Funcionario func) {
        String sql = "INSERT INTO tb_funcionarios (nome,pessoa,cpf,rg,ativo,login, email,senha,"
                + "cargo,nivel_acesso,telefone,celular,cep,endereco,numero,"
                + "complemento,bairro,cidade,estado,obs)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getPessoa());
            stmt.setString(3, func.getCpf());
            stmt.setString(4, func.getRg());
            stmt.setBoolean(5, func.getAtivo());
            stmt.setString(6, func.getLogin());
            stmt.setString(7, func.getEmail());
            stmt.setString(8, func.getSenha());
            stmt.setString(9, func.getCargo());
            stmt.setString(10, func.getNivel_acesso());
            stmt.setString(11, func.getFoneFixo());
            stmt.setString(12, func.getCelular());
            stmt.setString(13, func.getCep());
            stmt.setString(14, func.getEndereco());
            stmt.setInt(15, func.getNumero());
            stmt.setString(16, func.getCompl());
            stmt.setString(17, func.getBairro());
            stmt.setString(18, func.getCidade());
            stmt.setString(19, func.getEstado());
            stmt.setString(20, func.getObs());
            
                stmt.execute();
                stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Funcionário: " + e);
        }

    }

    public void atualizaFuncionario(Funcionario func) {
        String sql = "UPDATE tb_funcionarios SET nome=?,pessoa=?,cpf=?,rg=?,"
                + "email=?,cargo=?,telefone=?,celular=?,"
                + "cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,"
                + "estado=?,obs=? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getPessoa());
            stmt.setString(3, func.getCpf());
            stmt.setString(4, func.getRg());
            stmt.setString(5, func.getEmail());
            //stmt.setString(6, func.getSenha());
            stmt.setString(6, func.getCargo());
            //stmt.setString(7, func.getNivel_acesso());
            stmt.setString(7, func.getFoneFixo());
            stmt.setString(8, func.getCelular());
            stmt.setString(9, func.getCep());
            stmt.setString(10, func.getEndereco());
            stmt.setInt(11, func.getNumero());
            stmt.setString(12, func.getCompl());
            stmt.setString(13, func.getBairro());
            stmt.setString(14, func.getCidade());
            stmt.setString(15, func.getEstado());
            stmt.setString(16, func.getObs());

            stmt.setInt(17, func.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao editar Funcionário: " + e);
        }
    }

    public void deletaFuncionario(int codigo) {
        String sql = "DELETE FROM tb_funcionarios WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Funcionário: " + e);
        }

    }

    public List<Funcionario> listaFuncionario() {
        String sql = "SELECT * FROM tb_funcionarios";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Funcionario> funcs = new ArrayList<>();

            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setAtivo(rs.getBoolean("ativo"));
                func.setPessoa(rs.getString("pessoa"));
                func.setCpf(rs.getString("cpf"));
                func.setRg(rs.getString("rg"));
                func.setLogin(rs.getString("login"));
                func.setEmail(rs.getString("email"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setNivel_acesso(rs.getString("nivel_acesso"));
                func.setFoneFixo(rs.getString("telefone"));
                func.setCelular(rs.getString("celular"));
                func.setCep(rs.getString("cep"));
                func.setEndereco(rs.getString("endereco"));
                func.setNumero(rs.getInt("numero"));
                func.setCompl(rs.getString("complemento"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setEstado(rs.getString("estado"));
                func.setObs(rs.getString("obs"));

                funcs.add(func);
            }

            return funcs;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Funcionários: " + e);
        }

    }

    public List<Funcionario> buscaNomeFuncionario(String nome) {
        String sql = "SELECT * FROM tb_funcionarios WHERE nome like ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            List<Funcionario> funcs = new ArrayList<>();

            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setAtivo(rs.getBoolean("ativo"));
                func.setPessoa(rs.getString("pessoa"));
                func.setCpf(rs.getString("cpf"));
                func.setRg(rs.getString("rg"));
                func.setLogin(rs.getString("login"));
                func.setEmail(rs.getString("email"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setNivel_acesso(rs.getString("nivel_acesso"));
                func.setFoneFixo(rs.getString("telefone"));
                func.setCelular(rs.getString("celular"));
                func.setCep(rs.getString("cep"));
                func.setEndereco(rs.getString("endereco"));
                func.setNumero(rs.getInt("numero"));
                func.setCompl(rs.getString("complemento"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setEstado(rs.getString("estado"));
                func.setObs(rs.getString("obs"));

                funcs.add(func);
            }

            return funcs;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Funcionários: " + e);
        }
    }

    public Funcionario buscaCodigoFuncionario(int codigo) {
        String sql = "SELECT * FROM tb_funcionarios WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            Funcionario func = new Funcionario();

            if (rs.next()) {
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setAtivo(rs.getBoolean("ativo"));
                func.setPessoa(rs.getString("pessoa"));
                func.setCpf(rs.getString("cpf"));
                func.setRg(rs.getString("rg"));
                func.setLogin(rs.getString("login"));
                func.setEmail(rs.getString("email"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setNivel_acesso(rs.getString("nivel_acesso"));
                func.setFoneFixo(rs.getString("telefone"));
                func.setCelular(rs.getString("celular"));
                func.setCep(rs.getString("cep"));
                func.setEndereco(rs.getString("endereco"));
                func.setNumero(rs.getInt("numero"));
                func.setCompl(rs.getString("complemento"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setEstado(rs.getString("estado"));
                func.setObs(rs.getString("obs"));

                return func;
            } else {
                throw new FuncionarioException("Funcionario não encontrado!");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Funcionários: " + e);
        }
    }

    public Funcionario buscaLoginFuncioanrio(String login) {
        String sql = "SELECT * FROM tb_funcionarios WHERE login = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            Funcionario func = new Funcionario();

            if (rs.next()) {
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setAtivo(rs.getBoolean("ativo"));
                func.setPessoa(rs.getString("pessoa"));
                func.setCpf(rs.getString("cpf"));
                func.setRg(rs.getString("rg"));
                func.setLogin(rs.getString("login"));
                func.setEmail(rs.getString("email"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setNivel_acesso(rs.getString("nivel_acesso"));
                func.setFoneFixo(rs.getString("telefone"));
                func.setCelular(rs.getString("celular"));
                func.setCep(rs.getString("cep"));
                func.setEndereco(rs.getString("endereco"));
                func.setNumero(rs.getInt("numero"));
                func.setCompl(rs.getString("complemento"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setEstado(rs.getString("estado"));
                func.setObs(rs.getString("obs"));

                return func;
            } else {
                throw new FuncionarioException("Funcionario não encontrado!");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Funcionários: " + e);
        }
    }

    public Funcionario buscaCPFFuncioanrio(String cpf) {
        String sql = "SELECT * FROM tb_funcionarios WHERE cpf = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Funcionario func = new Funcionario();

            if (rs.next()) {
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setAtivo(rs.getBoolean("ativo"));
                func.setPessoa(rs.getString("pessoa"));
                func.setCpf(rs.getString("cpf"));
                func.setRg(rs.getString("rg"));
                func.setEmail(rs.getString("email"));
                func.setLogin(rs.getString("login"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setNivel_acesso(rs.getString("nivel_acesso"));
                func.setFoneFixo(rs.getString("telefone"));
                func.setCelular(rs.getString("celular"));
                func.setCep(rs.getString("cep"));
                func.setEndereco(rs.getString("endereco"));
                func.setNumero(rs.getInt("numero"));
                func.setCompl(rs.getString("complemento"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setEstado(rs.getString("estado"));
                func.setObs(rs.getString("obs"));

                return func;
            } else {
                throw new FuncionarioException("Funcionario não encontrado!");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Funcionários: " + e);
        }
    }

    public boolean temCpfFuncionario(String cpf) {
        String sql = "SELECT * FROM tb_funcionarios where cpf = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar CPF/ CNPJ do Funcionários: " + e);
        }
    }

    public boolean temEmailFuncionario(String email) {
        String sql = "SELECT * FROM tb_funcionarios where email = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar email do Funcionários: " + e);
        }
    }
    
    public boolean temLoginFuncionario(String login) {
        String sql = "SELECT * FROM tb_funcionarios where login = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar login do Funcionários: " + e);
        }
    }
    
    public boolean temIdFuncionario(int id) {
        String sql = "SELECT * FROM tb_funcionarios where id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ID do Funcionários: " + e);
        }
    }
   
    
    
    public Funcionario login( String usuario, String senha){
        String sql = "SELECT * FROM tb_funcionarios WHERE login = ? AND senha = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            Funcionario f = new Funcionario();

            
            if(rs.next()){
                f.setId(rs.getInt("id"));
                f.setLogin(rs.getString("login"));
                f.setNome(rs.getString("nome"));
                f.setSenha(rs.getString("senha"));
                return f;
            }else{
                 return null;
            }           
        } catch (SQLException e) {
             throw new RuntimeException("Erro ao efutar Login: " + e);
        }
    }

}
