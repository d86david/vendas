/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.Borda;
import br.com.dsystem.model.exceptions.BordaException;
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
public class BordaDAO {

    private final Connection con;

    public BordaDAO() {
        con = new ConnectionFactoy().getConnection();
    }

    public void cadastraBorda(Borda borda) {
        String sql = "INSERT INTO tb_borda (descricao, valor) VALUES (?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, borda.getDescricao());
            stmt.setBigDecimal(2, borda.getValor());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar Borda:  " + e); 
        }

    }

    public void atualizaBorda(Borda borda) {

        String sql = "UPDATE tb_borda SET descricao=?, valor=? WHERE id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, borda.getDescricao());
            stmt.setBigDecimal(2, borda.getValor());

            stmt.setInt(3, borda.getId());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao editar Borda:  " + e);
        }

    }

    public void deletaBorda(int codigo) {
        String sql = "DELETE FROM tb_borda WHERE id =  ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao Excluir a Borda:  " + e);
        }

    }

    public List<Borda> listaBorda() {

        String sql = "SELECT * FROM tb_borda";
        List<Borda> bordas = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Borda borda = new Borda();
                borda.setId(rs.getInt("id"));
                borda.setDescricao(rs.getString("descricao"));
                borda.setValor(rs.getBigDecimal("valor"));

                bordas.add(borda);
            }

            return bordas;

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao listar boras:  " + e);
        }

    }

    public List<Borda> buscaDescricaoBorda(String descricao) {
        String sql = "SELECT * FROM tb_borda WHERE descricao like ?";
        List<Borda> bordas = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Borda borda = new Borda();

                borda.setId(rs.getInt("id"));
                borda.setDescricao(rs.getString("descricao"));
                borda.setValor(rs.getBigDecimal("valor"));

                bordas.add(borda);
            }

            return bordas;

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao pesquisar borda " + e);
        }
    }
    
   /* public List<Borda> listaCodigoBorda(int codigo) {
        String sql = "SELECT * FROM tb_borda WHERE id = ?";
        List<Borda> bordas = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Borda borda = new Borda();

                borda.setId(rs.getInt("id"));
                borda.setDescricao(rs.getString("descricao"));
                borda.setValor(rs.getBigDecimal("valor"));

                bordas.add(borda);
            }

            return bordas;

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao pesquisar borda " + e);
        }
    }*/

    public Borda buscaCodigoBorda(int codigo) {
        String sql = "SELECT * FROM tb_borda WHERE id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Borda borda = new Borda();
                borda.setId(rs.getInt("id"));
                borda.setDescricao(rs.getString("descricao"));
                borda.setValor(rs.getBigDecimal("valor"));

                return borda;
            } else {
               throw new BordaException("Borda não encontrada!");
            }
        } catch (Exception e) {
            throw new RuntimeException( "Erro ao pesquisar borda " + e);
        }
    }

    public Borda buscaDescricao1Borda(String descricao) {
        String sql = "SELECT * FROM tb_borda WHERE descricao = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Borda borda = new Borda();

                borda.setId(rs.getInt("id"));
                borda.setDescricao(rs.getString("descricao"));
                borda.setValor(rs.getBigDecimal("valor"));

                return borda;
            } else {
                throw new BordaException("Borda não encontrada!");
            }

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao pesquisar borda " + e);
        }
    }

    public boolean temBorda(String descricao) {
        String sql = "SELECT * FROM tb_borda WHERE descricao = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao pesquisar borda " + e);
        }
    }
    
    public boolean temBorda(int codigo) {
        String sql = "SELECT * FROM tb_borda WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao pesquisar borda " + e);
        }
    }

}
