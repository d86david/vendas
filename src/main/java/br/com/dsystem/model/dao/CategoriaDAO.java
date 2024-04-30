/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.Categoria;
import br.com.dsystem.model.exceptions.CategoriaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class CategoriaDAO {

    Connection con;

    public CategoriaDAO() {
        this.con = new ConnectionFactoy().getConnection();
    }

    public void cadastraCategoria(Categoria cat) {
        String sql = "INSERT INTO tb_categoria (descricao, tem_borda, varios_sabores) VALUES (?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cat.getDescricao());
            stmt.setBoolean(2, cat.isTemBorda());
            stmt.setBoolean(3, cat.isVariosSabores());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException ("Erro ao cadastrar Categoria: " + e);
        }

    }

    public void atuiazaCategoria(Categoria cat) {

        String sql = "UPDATE tb_categoria set descricao =?, tem_borda=?, varios_sabores=? WHERE id =? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cat.getDescricao());
            stmt.setBoolean(2, cat.isTemBorda());
            stmt.setBoolean(3, cat.isVariosSabores());
            stmt.setInt(4, cat.getId());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException ( "Erro ao editar Categoria: " + e);
        }

    }

    public void deletaCategoria(int codigo) {

        String sql = "DELETE FROM tb_categoria WHERE id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);

            stmt.execute();
            stmt.close();


        } catch (Exception e) {
            throw new RuntimeException ( "Erro ao excluir Categoria: " + e);
        }

    }

    public List<Categoria> listaCategoria() {

        String sql = "SELECT * FROM tb_categoria";
        List<Categoria> categorias = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setDescricao(rs.getString("descricao"));
                cat.setTemBorda(rs.getBoolean("tem_borda"));
                cat.setVariosSabores(rs.getBoolean("varios_sabores"));

                categorias.add(cat);
            }

            return categorias;

        } catch (Exception e) {
            throw new RuntimeException ( "Erro ao listar Categoria: " + e);
        }

    }

    public List<Categoria> buscaCategoria(String descricao) {
        String sql = "SELECT * FROM tb_categoria WHERE descricao LIKE ? ";
        List<Categoria> categorias = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setDescricao(rs.getString("descricao"));
                cat.setTemBorda(rs.getBoolean("tem_borda"));
                cat.setVariosSabores(rs.getBoolean("varios_sabores"));

                categorias.add(cat);
            }

            return categorias;

        } catch (Exception e) {
            throw new RuntimeException ("Erro ao listar Categoria: " + e);
        }
    }

    public Categoria buscaCategoria(Categoria cat) {

        String sql = "SELECT * FROM tb_categoria WHERE descricao = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cat.getDescricao());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));
                c.setTemBorda(rs.getBoolean("tem_borda"));
                c.setVariosSabores(rs.getBoolean("varios_sabores"));

                return c;
            } else {
                throw new CategoriaException ("Categoria não encontrada!");
            }

        } catch (Exception e) {
            throw new RuntimeException ( "Erro ao buscar Categoria:  " + e);
        }
    }

    public Categoria buscaCategoria(int codigo) {
        String sql = "SELECT * FROM tb_categoria WHERE id = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));
                c.setTemBorda(rs.getBoolean("tem_borda"));
                c.setVariosSabores(rs.getBoolean("varios_sabores"));

                return c;
            } else {
                throw new CategoriaException ("Categoria não encontrada!");
            }

        } catch (Exception e) {
            throw new RuntimeException ("Erro ao buscar Categoria:  " + e);
        }
    }

    public boolean temCategoria(int codigo) {
         String sql = "SELECT * FROM tb_categoria WHERE id = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            return (rs.next());

        } catch (Exception e) {
            throw new RuntimeException ( "Erro ao buscar Categoria:  " + e);
        }
    }

    public boolean temCategoria(String descricao) {
         String sql = "SELECT * FROM tb_categoria WHERE descricao = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();

            return (rs.next());

        } catch (Exception e) {
            throw new RuntimeException ("Erro ao buscar Categoria:  " + e);
        }
    }

}
