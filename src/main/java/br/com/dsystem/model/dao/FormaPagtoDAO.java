/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.FormaPagto;
import br.com.dsystem.model.exceptions.FormaPagtoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class FormaPagtoDAO {

    Connection con;

    public FormaPagtoDAO() {
        this.con = new ConnectionFactoy().getConnection();
    }

    public void cadastraFormaPagto(FormaPagto fpagto) {
        String sql = "INSERT INTO tb_forma_pagto (descricao) VALUES (?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, fpagto.getDescricao());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar Forma de pagamento: " + e);
        }

    }

    public void atualizaFormaPagto(FormaPagto fpagto) {

        String sql = "UPDATE tb_forma_pagto set descricao =? WHERE id =? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, fpagto.getDescricao());
            stmt.setInt(2, fpagto.getId());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar forma de pagamento: " + e);
        }

    }

    public void deletaFormaPagto(int id) {

        String sql = "DELETE FROM tb_forma_pagto WHERE id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {

            throw new RuntimeException("Erro ao excluir forma de pagamento: " + e);
        }

    }

    public List<FormaPagto> listaFormaPagto() {

        String sql = "SELECT * FROM tb_forma_pagto";
        List<FormaPagto> fpagtos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FormaPagto pagto = new FormaPagto();
                pagto.setId(rs.getInt("id"));
                pagto.setDescricao(rs.getString("descricao"));

                fpagtos.add(pagto);
            }

            return fpagtos;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar formas de pagamento: " + e);
        }

    }

    public List<FormaPagto> buscaFormaPagto(String fpagto) {
        String sql = "SELECT * FROM tb_forma_pagto WHERE descricao LIKE ? ";
        List<FormaPagto> fpagtos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, fpagto);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FormaPagto pagto = new FormaPagto();
                pagto.setId(rs.getInt("id"));
                pagto.setDescricao(rs.getString("descricao"));

                fpagtos.add(pagto);
            }

            return fpagtos;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar formas de pagamento: " + e);
        }
    }

    public FormaPagto buscaDescFormaPagto(String  descricao) {

        String sql = "SELECT * FROM tb_forma_pagto WHERE descricao = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                FormaPagto f = new FormaPagto();
                f.setId(rs.getInt("id"));
                f.setDescricao(rs.getString("descricao"));

                return f;
            } else {
                throw new FormaPagtoException("Forma de pagamento não encontrada!");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Forma de pagamento:  " + e);
        }
    }

    public FormaPagto buscaFormaPagto(int codigo) {
        String sql = "SELECT * FROM tb_forma_pagto WHERE id = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                FormaPagto f = new FormaPagto();
                f.setId(rs.getInt("id"));
                f.setDescricao(rs.getString("descricao"));

                return f;
            } else {
                throw new FormaPagtoException("Forma de pagamento não encontrada!");
            }

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao buscar forma de pagamento:  " + e);
        }
    }

    public boolean temFormaPagto(int codigo) {
        String sql = "SELECT * FROM tb_forma_pagto WHERE id = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            return (rs.next());

        } catch (Exception e) {
            throw new RuntimeException( "Erro ao buscar Forma de pagamento:  " + e);
        }
    }

    public boolean temFormaPagto(String descricao) {
        String sql = "SELECT * FROM tb_forma_pagto WHERE descricao = ? ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();

            return (rs.next());

        } catch (Exception e) {
           throw new RuntimeException( "Erro ao buscar forma de pagamento:  " + e);
        }
    }

}
