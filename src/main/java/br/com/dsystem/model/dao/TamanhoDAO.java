/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.Tamanho;
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
public class TamanhoDAO {

    Connection con;

    public TamanhoDAO() {
        this.con = new ConnectionFactoy().getConnection();
    }

    public void cadastraTamanho(Tamanho tam) {
        String sql = "INSERT INTO tb_tamanho (tamanho) VALUES (?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, tam.getTamanho());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Tamanho cadastrada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Tamanho: " + e);
        }

    }

    public void alteraTamanho(Tamanho tam) {

        String sql = "UPDATE tb_tamanho set tamanho =? WHERE id =? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, tam.getTamanho());
            stmt.setInt(2, tam.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Tamanho editada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Tamanho: " + e);
        }

    }

    public void excluiTamanho(Tamanho tam) {

        String sql = "DELETE FROM tb_tamanho WHERE id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, tam.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Tamanho excluída com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir Tamanho: " + e);
        }

    }

    public List<Tamanho> listaTamanho() {

        String sql = "SELECT * FROM tb_tamanho";
        List<Tamanho> Tamanhos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tamanho tam = new Tamanho();
                tam.setId(rs.getInt("id"));
                tam.setTamanho(rs.getString("tamanho"));

                Tamanhos.add(tam);
            }

            return Tamanhos;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Tamanho: " + e);
            return null;
        }

    }

    public List<Tamanho> buscaTamanho(String tamanho) {
        String sql = "SELECT * FROM tb_tamanho WHERE tamanho LIKE ? ";
        List<Tamanho> Tamanhos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, tamanho);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tamanho tam = new Tamanho();
                tam.setId(rs.getInt("id"));
                tam.setTamanho(rs.getString("tamanho"));

                Tamanhos.add(tam);
            }

            return Tamanhos;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Tamanho: " + e);
            return null;
        }
    }

    public Tamanho buscaTamanho(Tamanho tam) {

        String sql = "SELECT * FROM tb_tamanho WHERE tamanho = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, tam.getTamanho());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Tamanho c = new Tamanho();
                c.setId(rs.getInt("id"));
                c.setTamanho(rs.getString("tamanho"));

                return c;
            } else {
                JOptionPane.showMessageDialog(null, "Tamanho não encontrada!");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Tamanho:  " + e);
            return null;
        }
    }

    public Tamanho buscaTamanho(int codigo) {
        String sql = "SELECT * FROM tb_tamanho WHERE id = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Tamanho c = new Tamanho();
                c.setId(rs.getInt("id"));
                c.setTamanho(rs.getString("tamanho"));

                return c;
            } else {
                JOptionPane.showMessageDialog(null, "Tamanho não encontrada!");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Tamanho:  " + e);
            return null;
        }
    }

    public boolean temTamanho(int codigo) {
         String sql = "SELECT * FROM tb_tamanho WHERE id = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            return (rs.next());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Tamanho:  " + e);
            return true;
        }
    }

    public boolean temTamanho(String tamanho) {
         String sql = "SELECT * FROM tb_tamanho WHERE tamanho = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, tamanho);
            ResultSet rs = stmt.executeQuery();

            return (rs.next());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Tamanho:  " + e);
            return true;
        }
    }

}
