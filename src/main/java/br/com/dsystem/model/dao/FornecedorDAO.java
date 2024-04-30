/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.Fornecedor;
import br.com.dsystem.model.exceptions.FornecedorException;
import br.com.dsystem.util.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class FornecedorDAO {

    private Connection con;

    public FornecedorDAO() {
        this.con = new ConnectionFactoy().getConnection();
    }

    public void cadastraFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO tb_fornecedores (nome, pessoa,cnpj,rg_ie,email,telefone,"
                + "celular,cep,endereco,numero,complemento,bairro,cidade,estado,obs)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getPessoa());
            stmt.setString(3, fornecedor.getCpfCnpj());
            stmt.setString(4, fornecedor.getRgIe());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setString(6, fornecedor.getFoneFixo());
            stmt.setString(7, fornecedor.getCelular());
            stmt.setString(8, fornecedor.getCep());
            stmt.setString(9, fornecedor.getEndereco());
            stmt.setInt(10, fornecedor.getNumero());
            stmt.setString(11, fornecedor.getCompl());
            stmt.setString(12, fornecedor.getBairro());
            stmt.setString(13, fornecedor.getCidade());
            stmt.setString(14, fornecedor.getEstado());
            stmt.setString(15, fornecedor.getObs());
         
                stmt.execute();
                stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar fornecedor " + e);
        }

    }

    public void atualizaFornecedor(Fornecedor fornecedor) {
        String sql = "UPDATE tb_fornecedores SET nome=?, pessoa=?,cnpj=?,rg_ie=?,email=?,telefone=?,"
                + "celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,obs=?"
                + "WHERE id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getPessoa());
            stmt.setString(3, fornecedor.getCpfCnpj());
            stmt.setString(4, fornecedor.getRgIe());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setString(6, fornecedor.getFoneFixo());
            stmt.setString(7, fornecedor.getCelular());
            stmt.setString(8, fornecedor.getCep());
            stmt.setString(9, fornecedor.getEndereco());
            stmt.setInt(10, fornecedor.getNumero());
            stmt.setString(11, fornecedor.getCompl());
            stmt.setString(12, fornecedor.getBairro());
            stmt.setString(13, fornecedor.getCidade());
            stmt.setString(14, fornecedor.getEstado());
            stmt.setString(15, fornecedor.getObs());

            stmt.setInt(16, fornecedor.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException ("Erro ao editar fornecedor " + e);
        }

    }

    public void deletaFornecedor(int codigo) {
        String sql = "DELETE FROM tb_fornecedores WHERE id = ? ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, codigo);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException ("Erro ao excluir fornecedor " + e);
        }

    }

    public List<Fornecedor> listaFornecedores() {
        String sql = "SELECT * FROM tb_fornecedores";
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setPessoa(rs.getString("pessoa"));
                f.setCpfCnpj(rs.getString("cnpj"));
                f.setRgIe(rs.getString("rg_ie"));
                f.setEmail(rs.getString("email"));
                f.setFoneFixo(rs.getString("telefone"));
                f.setCelular(rs.getString("celular"));
                f.setCep(rs.getString("cep"));
                f.setEndereco(rs.getString("endereco"));
                f.setNumero(rs.getInt("numero"));
                f.setCompl(rs.getString("complemento"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
                f.setObs(rs.getString("obs"));

                fornecedores.add(f);
            }

            return fornecedores;

        } catch (SQLException e) {
            throw new RuntimeException ("Erro ao listar fornecedores " + e);
        }
    }

    public List<Fornecedor> buscaNomeFornecedor(String nome) {
        String sql = "SELECT * FROM tb_fornecedores WHERE nome like ?";
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setPessoa(rs.getString("pessoa"));
                f.setCpfCnpj(rs.getString("cnpj"));
                f.setRgIe(rs.getString("rg_ie"));
                f.setEmail(rs.getString("email"));
                f.setFoneFixo(rs.getString("telefone"));
                f.setCelular(rs.getString("celular"));
                f.setCep(rs.getString("cep"));
                f.setEndereco(rs.getString("endereco"));
                f.setNumero(rs.getInt("numero"));
                f.setCompl(rs.getString("complemento"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
                f.setObs(rs.getString("obs"));

                fornecedores.add(f);
            }

            return fornecedores;

        } catch (SQLException e) {
            throw new RuntimeException ("Erro ao pesquisar fornecedor: " + e);
        }

    }
    

    public Fornecedor buscaCodigoFornecedor(int codigo) {
        String sql = "SELECT * FROM tb_fornecedores WHERE id =? ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setPessoa(rs.getString("pessoa"));
                f.setCpfCnpj(rs.getString("cnpj"));
                f.setRgIe(rs.getString("rg_ie"));
                f.setEmail(rs.getString("email"));
                f.setFoneFixo(rs.getString("telefone"));
                f.setCelular(rs.getString("celular"));
                f.setCep(rs.getString("cep"));
                f.setEndereco(rs.getString("endereco"));
                f.setNumero(rs.getInt("numero"));
                f.setCompl(rs.getString("complemento"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
                f.setObs(rs.getString("obs"));

                return f;

            } else {
                throw new FornecedorException ("Fornecedor não encontrado");
            }

        } catch (SQLException e) {
            throw new RuntimeException ("Erro ao pesquisar fornecedor: " + e);
        }

    }

    public Fornecedor buscaCpfFornecedor(String cpf) {
        String sql = "SELECT * FROM tb_fornecedores WHERE cnpj =? ";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setPessoa(rs.getString("pessoa"));
                f.setCpfCnpj(rs.getString("cnpj"));
                f.setRgIe(rs.getString("rg_ie"));
                f.setEmail(rs.getString("email"));
                f.setFoneFixo(rs.getString("telefone"));
                f.setCelular(rs.getString("celular"));
                f.setCep(rs.getString("cep"));
                f.setEndereco(rs.getString("endereco"));
                f.setNumero(rs.getInt("numero"));
                f.setCompl(rs.getString("complemento"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setEstado(rs.getString("estado"));
                f.setObs(rs.getString("obs"));

                return f;

            } else {
               throw new FornecedorException ("Fornecedor não encontrado!");
            }

        } catch (SQLException e) {
            throw new RuntimeException ("Erro ao pesquisar fornecedor: " + e);
        }

    }
    
    public boolean temCpfCnpj(String cpf){
        String sql ="SELECT * FROM tb_fornecedores WHERE cnpj = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();           
        } catch (SQLException e) {
            throw new RuntimeException ( "Erro ao pesquisar fornecedor: " + e);
        }
    }
    
     public boolean temId(int codigo){
        String sql ="SELECT * FROM tb_fornecedores WHERE id = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();           
        } catch (SQLException e) {
            throw new RuntimeException ( "Erro ao pesquisar fornecedor: " + e);
        }
    }

}
