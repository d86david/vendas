/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.Categoria;
import br.com.dsystem.model.Produto;
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
public class ProdutoDAO {

    Connection con;

    public ProdutoDAO() {
        con = new ConnectionFactoy().getConnection();
    }

    public void cadastraProduto(Produto produto) {
        String sql = "INSERT INTO tb_produtos (codigo_produto, descricao, preco, qtd_estoque, controla_estoque, categoria_id)"
                + "VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, produto.getCodigoProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setBigDecimal(3, produto.getPreco());
            stmt.setInt(4, produto.getQtdEstoquue());
            stmt.setBoolean(5, produto.isControlaEstoque());
            stmt.setInt(6, produto.getCategoria().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar produto: " + e);
        }

    }

    public void editaProduto(Produto produto) {
        String sql = "UPDATE tb_produtos SET codigo_produto=?, descricao=?, preco=?, qtd_estoque=?, controla_estoque=?, categoria_id=? "
                + "WHERE id =?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, produto.getCodigoProduto());
            stmt.setString(2, produto.getDescricao());
            stmt.setBigDecimal(3, produto.getPreco());
            stmt.setInt(4, produto.getQtdEstoquue());
            stmt.setBoolean(5, produto.isControlaEstoque());
            stmt.setInt(6, produto.getCategoria().getId());

            stmt.setInt(7, produto.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + e);
        }
    }

    public void excluirProdutos(Produto produto) {

        String sql = "DELETE FROM tb_produtos WHERE id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excuir produto: " + e);
        }

    }

    public List<Produto> listaProdutos() {
        String sql = "SELECT p.id, p.codigo_produto,p.descricao,p.preco, p.qtd_estoque, p.controla_estoque,c.descricao "
                + "FROM tb_produtos as p INNER JOIN tb_categoria as c on (p.categoria_id = c.id)";
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                Categoria cat = new Categoria();

                prod.setId(rs.getInt("p.id"));
                prod.setCodigoProduto(rs.getInt("p.codigo_produto"));
                prod.setDescricao(rs.getString("p.descricao"));
                prod.setPreco(rs.getBigDecimal("p.preco"));
                prod.setQtdEstoquue(rs.getInt("p.qtd_estoque"));
                prod.setControlaEstoque(rs.getBoolean("p.controla_estoque"));
                cat.setDescricao(rs.getString("c.descricao"));

                prod.setCategoria(cat);

                produtos.add(prod);
            }

            return produtos;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produto: " + e);
            return null;
        }
    }

    public List<Produto> pesquisaProduto(String produto) {
        String sql = " SELECT p.id, p.codigo_produto, p.descricao, p.preco, p.qtd_estoque, p.controla_estoque, c.descricao, c.tem_borda, c.varios_sabores "
                + "FROM tb_produtos AS p INNER JOIN tb_categoria AS c ON (p.categoria_id = c.id) where p.descricao = ?";
        List<Produto> produtos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, produto);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                Categoria cat = new Categoria();

                prod.setId(rs.getInt("p.id"));
                prod.setCodigoProduto(rs.getInt("p.codigo_produto"));
                prod.setDescricao(rs.getString("p.descricao"));
                prod.setPreco(rs.getBigDecimal("p.preco"));
                prod.setQtdEstoquue(rs.getInt("p.qtd_estoque"));
                prod.setControlaEstoque(rs.getBoolean("p.controla_estoque"));
                cat.setDescricao(rs.getString("c.descricao"));
                cat.setTemBorda(rs.getBoolean("tem_borda"));
                cat.setVariosSabores(rs.getBoolean("varios_sabores"));

                prod.setCategoria(cat);

                produtos.add(prod);
            }

            return produtos;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e);
            return null;
        }
    }

    public Produto pesquisaProdutoDesc(String produto) {
        String sql = " SELECT p.id, p.codigo_produto, p.descricao, p.preco, p.qtd_estoque, p.controla_estoque, c.descricao, c.tem_borda, c.varios_sabores "
                + "FROM tb_produtos AS p INNER JOIN tb_categoria AS c ON (p.categoria_id = c.id) where p.descricao = ?";

        Produto prod = new Produto();
        Categoria cat = new Categoria();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, produto);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                prod.setId(rs.getInt("p.id"));
                prod.setCodigoProduto(rs.getInt("p.codigo_produto"));
                prod.setDescricao(rs.getString("p.descricao"));
                prod.setPreco(rs.getBigDecimal("p.preco"));
                prod.setQtdEstoquue(rs.getInt("p.qtd_estoque"));
                prod.setControlaEstoque(rs.getBoolean("p.controla_estoque"));
                cat.setDescricao(rs.getString("c.descricao"));
                cat.setTemBorda(rs.getBoolean("c.tem_borda"));
                cat.setVariosSabores(rs.getBoolean("c.varios_sabores"));
                prod.setCategoria(cat);
                return prod;
            } else {
                JOptionPane.showMessageDialog(null, "Produto nao encontrado!");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e);
            return null;
        }
    }

    public Produto pesquisaProduto(int codigo) {
        String sql = " SELECT p.id, p.codigo_produto, p.descricao, p.preco, p.qtd_estoque, p.controla_estoque, c.descricao, c.tem_borda, c.varios_sabores "
                + "FROM tb_produtos AS p INNER JOIN tb_categoria AS c ON (p.categoria_id = c.id) where p.id = ?";

        Produto prod = new Produto();
        Categoria cat = new Categoria();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                prod.setId(rs.getInt("p.id"));
                prod.setCodigoProduto(rs.getInt("p.codigo_produto"));
                prod.setDescricao(rs.getString("p.descricao"));
                prod.setPreco(rs.getBigDecimal("p.preco"));
                prod.setQtdEstoquue(rs.getInt("p.qtd_estoque"));
                prod.setControlaEstoque(rs.getBoolean("p.controla_estoque"));
                cat.setDescricao(rs.getString("c.descricao"));
                cat.setTemBorda(rs.getBoolean("c.tem_borda"));
                cat.setVariosSabores(rs.getBoolean("c.varios_sabores"));
                prod.setCategoria(cat);

                return prod;
            } else {
                JOptionPane.showMessageDialog(null, "Produto nao encontrado!");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e);
            return null;
        }
    }
    
    public List<Produto> pesquisaProdutoCategoria(int categoria) {
        String sql = " SELECT p.id, p.codigo_produto, p.descricao, p.preco, p.qtd_estoque, p.controla_estoque, c.descricao, c.tem_borda, c.varios_sabores "
                + "FROM tb_produtos AS p INNER JOIN tb_categoria AS c ON (p.categoria_id = c.id) where p.categoria_id = ?";
        List<Produto> produtos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, categoria);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                Categoria cat = new Categoria();

                prod.setId(rs.getInt("p.id"));
                prod.setCodigoProduto(rs.getInt("p.codigo_produto"));
                prod.setDescricao(rs.getString("p.descricao"));
                prod.setPreco(rs.getBigDecimal("p.preco"));
                prod.setQtdEstoquue(rs.getInt("p.qtd_estoque"));
                prod.setControlaEstoque(rs.getBoolean("p.controla_estoque"));
                cat.setDescricao(rs.getString("c.descricao"));
                cat.setTemBorda(rs.getBoolean("c.tem_borda"));
                cat.setVariosSabores(rs.getBoolean("c.varios_sabores"));

                prod.setCategoria(cat);

                produtos.add(prod);
            }

            return produtos;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e);
            return null;
        }
    }

    public boolean temProduto(String produto) {
        String sql = "SELECT * FROM tb_produtos WHERE descricao = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, produto);

            ResultSet rs = stmt.executeQuery();

            return (rs.next());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produto: " + e);
            return true;
        }
    }

    public boolean temProduto(int codigo) {
        String sql = "SELECT * FROM tb_produtos WHERE codigo_produto = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            ResultSet rs = stmt.executeQuery();

            return (rs.next());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produto: " + e);
            return true;
        }
    }

}
