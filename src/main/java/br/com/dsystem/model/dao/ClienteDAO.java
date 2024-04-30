/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.Cliente;
import br.com.dsystem.model.exceptions.ClienteExceptions;
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
public class ClienteDAO {

    private final Connection con;

    //Ao chamar o constrtor da classe ele já trás a Conecção criada 
    public ClienteDAO() {
        this.con = new ConnectionFactoy().getConnection();
    }

    public void cadastraCliente(Cliente cliente) {
        String sql = "INSERT INTO tb_clientes (nome,pessoa,cpf,rg,email,telefone,"
                + "celular,cep,endereco,numero,complemento,bairro,cidade,estado,obs)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getPessoa());
            stmt.setString(3, cliente.getCpfCnpj());
            stmt.setString(4, cliente.getRg());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getFoneFixo());
            stmt.setString(7, cliente.getCelular());
            stmt.setString(8, cliente.getCep());
            stmt.setString(9, cliente.getEndereco());
            stmt.setInt(10, cliente.getNumero());
            stmt.setString(11, cliente.getCompl());
            stmt.setString(12, cliente.getBairro());
            stmt.setString(13, cliente.getCidade());
            stmt.setString(14, cliente.getEstado());
            stmt.setString(15, cliente.getObs());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

    }

    public void atualizaCliente(Cliente cli) {
        String sql = "UPDATE tb_clientes SET nome=?, pessoa=?, cpf=?, rg=?, email=?,telefone=?,"
                + "celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?,cidade=?, estado=?,obs=?"
                + "WHERE id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getPessoa());
            stmt.setString(3, cli.getCpfCnpj());
            stmt.setString(4, cli.getRg());
            stmt.setString(5, cli.getEmail());
            stmt.setString(6, cli.getFoneFixo());
            stmt.setString(7, cli.getCelular());
            stmt.setString(8, cli.getCep());
            stmt.setString(9, cli.getEndereco());
            stmt.setInt(10, cli.getNumero());
            stmt.setString(11, cli.getCompl());
            stmt.setString(12, cli.getBairro());
            stmt.setString(13, cli.getCidade());
            stmt.setString(14, cli.getEstado());
            stmt.setString(15, cli.getObs());

            stmt.setInt(16, cli.getId());

            stmt.execute();
            stmt.close();
            

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletaCliente(int codigo) {

        String sql = "DELETE FROM tb_clientes WHERE id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);

            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Cliente> listarCliente() {
        String sql = "SELECT * FROM tb_clientes";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setPessoa(rs.getString("pessoa"));
                cli.setCpfCnpj(rs.getString("cpf"));
                cli.setRg(rs.getString("rg"));
                cli.setEmail(rs.getString("email"));
                cli.setFoneFixo(rs.getString("telefone"));
                cli.setCelular(rs.getString("celular"));
                cli.setCep(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setCompl(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setEstado(rs.getString("estado"));
                cli.setObs(rs.getString("obs"));

                clientes.add(cli);
            }

            return clientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> buscaNomeCliente(String nome) {

        String sql = "SELECT * FROM tb_clientes WHERE nome like ?  ";
        List<Cliente> clientes = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setPessoa(rs.getString("pessoa"));
                cli.setCpfCnpj(rs.getString("cpf"));
                cli.setRg(rs.getString("rg"));
                cli.setEmail(rs.getString("email"));
                cli.setFoneFixo(rs.getString("telefone"));
                cli.setCelular(rs.getString("celular"));
                cli.setCep(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setCompl(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setEstado(rs.getString("estado"));
                cli.setObs(rs.getString("obs"));

                clientes.add(cli);
            }           
                return clientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Cliente buscaCodigoCliente(int codigo) {
        String sql = "SELECT * FROM tb_clientes where id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();
            Cliente cli = new Cliente();
            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setPessoa(rs.getString("pessoa"));
                cli.setCpfCnpj(rs.getString("cpf"));
                cli.setRg(rs.getString("rg"));
                cli.setEmail(rs.getString("email"));
                cli.setFoneFixo(rs.getString("telefone"));
                cli.setCelular(rs.getString("celular"));
                cli.setCep(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setCompl(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setEstado(rs.getString("estado"));
                cli.setObs(rs.getString("obs"));

                return cli;
            } else {
                throw new ClienteExceptions("Cliente não encontrado!");
            }

        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
    
     public Cliente buscaCelularCliente(String celular) {
        String sql = "SELECT * FROM tb_clientes where celular = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, celular);

            ResultSet rs = stmt.executeQuery();
            Cliente cli = new Cliente();
            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setPessoa(rs.getString("pessoa"));
                cli.setCpfCnpj(rs.getString("cpf"));
                cli.setRg(rs.getString("rg"));
                cli.setEmail(rs.getString("email"));
                cli.setFoneFixo(rs.getString("telefone"));
                cli.setCelular(rs.getString("celular"));
                cli.setCep(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setCompl(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setEstado(rs.getString("estado"));
                cli.setObs(rs.getString("obs"));

                return cli;
            } else {        
                 throw new ClienteExceptions("Cliente não encontrado!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     
     public Cliente buscaCpfCliente(String cpf) {

        String sql = "SELECT * FROM tb_clientes WHERE cpf = ?  ";
       

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setPessoa(rs.getString("pessoa"));
                cli.setCpfCnpj(rs.getString("cpf"));
                cli.setRg(rs.getString("rg"));
                cli.setEmail(rs.getString("email"));
                cli.setFoneFixo(rs.getString("telefone"));
                cli.setCelular(rs.getString("celular"));
                cli.setCep(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setCompl(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setEstado(rs.getString("estado"));
                cli.setObs(rs.getString("obs"));

                return cli;
            } else {
                 throw new ClienteExceptions("Cliente não encontrado!");
            }

        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

    }
     
      public boolean temCpfCliente(String cpf) {

        String sql = "SELECT * FROM tb_clientes WHERE cpf = ?  ";
       
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();

        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

    }
      
       public boolean temCelularCliente(String celular) {

        String sql = "SELECT * FROM tb_clientes WHERE celular = ?  ";
       
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
 
            stmt.setString(1, celular);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();

        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
       
       public boolean temCodigoCliente(int id) {

        String sql = "SELECT * FROM tb_clientes WHERE id = ?  ";
       
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
 
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();

        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }

}
