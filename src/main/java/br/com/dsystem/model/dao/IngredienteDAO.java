/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.Ingrediente;
import br.com.dsystem.model.exceptions.IngredienteException;
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
public class IngredienteDAO {

    private final Connection con;

    public IngredienteDAO() {
        con = new ConnectionFactoy().getConnection();
    }

    public void cadastraIngrediente(Ingrediente ingr) {
        String sql = "INSERT INTO tb_ingredientes (ingrediente) VALUES (?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ingr.getIngrediente());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Ingrediente:  " + e);
        }

    }

    public void atualizaIngrediente(Ingrediente ingr) {

        String sql = "UPDATE tb_ingredientes SET ingrediente=? WHERE id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, ingr.getIngrediente());

            stmt.setInt(2, ingr.getId());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar Ingrediente:  " + e);
        }

    }

    public void deletaIngrediente(int codigo) {
        String sql = "DELETE FROM tb_ingredientes WHERE id =  ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao Excluir a Ingrediente:  " + e);
        }

    }

    public List<Ingrediente> listaIngrediente() {

        String sql = "SELECT * FROM tb_ingredientes";
        List<Ingrediente> ingredientes = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ingrediente ingr = new Ingrediente();
                ingr.setId(rs.getInt("id"));
                ingr.setIngrediente(rs.getString("ingrediente"));

                ingredientes.add(ingr);
            }

            return ingredientes;

        } catch (Exception e) {

            throw new RuntimeException("Erro ao listar ingredientes:  " + e);
        }

    }

    public List<Ingrediente> buscaDescricaoIngrediente(String ingrediente) {
        String sql = "SELECT * FROM tb_ingredientes WHERE ingrediente like ?";
        List<Ingrediente> ingredientes = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ingrediente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ingrediente ingr = new Ingrediente();

                ingr.setId(rs.getInt("id"));
                ingr.setIngrediente(rs.getString("ingrediente"));

                ingredientes.add(ingr);
            }

            return ingredientes;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar ingrediente " + e);
        }
    }

    public Ingrediente buscaDescricaoIngrediente(Ingrediente ingr) {
        String sql = "SELECT * FROM tb_ingredientes WHERE ingrediente = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ingr.getIngrediente());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Ingrediente i = new Ingrediente();

                i.setId(rs.getInt("id"));
                i.setIngrediente(rs.getString("ingrediente"));

                return i;
            } else {
                throw new IngredienteException("Ingrediente não encontrado!");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar ingrediente " + e);
        }
    }

    public Ingrediente buscaCodigoIngrediente(int codigo) {
        String sql = "SELECT * FROM tb_ingredientes WHERE id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Ingrediente ingr = new Ingrediente();
                ingr.setId(rs.getInt("id"));
                ingr.setIngrediente(rs.getString("ingrediente"));

                return ingr;
            } else {
                throw new IngredienteException("Ingrediente não encontrado! ");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar ingrediente " + e);
        }
    }

    public boolean temIngrediente(String ingrediente) {
        String sql = "SELECT * FROM tb_ingredientes WHERE ingrediente = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ingrediente);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException ("Erro ao pesquisar ingrediente " + e);
        }
    }

    public boolean temIngrediente(int codigo) {
        String sql = "SELECT * FROM tb_ingredientes WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException ( "Erro ao pesquisar ingrediente " + e);
        }
    }

}
