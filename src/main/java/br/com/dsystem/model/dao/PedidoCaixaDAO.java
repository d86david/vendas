/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model.dao;

import br.com.dsystem.controller.PedidoCaixaController;
import br.com.dsystem.jdbc.ConnectionFactoy;
import br.com.dsystem.model.PedidoCaixa;
import br.com.dsystem.model.exceptions.PedidoCaixaException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class PedidoCaixaDAO {

    private final Connection con;

    public PedidoCaixaDAO() {
        this.con = new ConnectionFactoy().getConnection();
    }

    //Cadastrar Pedido 
    public void cadastraPedido(PedidoCaixa pedido) {
        String sql = "INSERT INTO tb_pedido_caixa (cliente_id, data_pedido,total_pedido, "
                + "obs_pedido, funcionario_id, forma_pagto_id,status_pedido) values (?,?,?,?,?,?,?);";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getClienteId());
            stmt.setString(2, pedido.getDataPedido());
            stmt.setBigDecimal(3, pedido.getTotalPedido());
            stmt.setString(4, pedido.getObsPedido());
            stmt.setInt(5, pedido.getAtendenteId());
            stmt.setInt(6, pedido.getFormaPagtoId());
            stmt.setString(7, pedido.getStatusPedido());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Baixar Pedido 
    public void baixaPedido(PedidoCaixa pedido) {
        String sql = "UPDATE tb_pedido_caixa SET baixa_pedido = ?, valor_desconto = ?, total_a_pagar = ? where id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pedido.getDataBaixa());
            stmt.setBigDecimal(2, pedido.getValorDesconto());
            stmt.setBigDecimal(3, pedido.getTotalAPagar());
            stmt.setInt(4, pedido.getId());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Atualiza Status do Pedido 
    public void atualizaStatus(PedidoCaixa pedido) {
        String sql = "UPDATE tb_pedido_caixa SET status_pedido = ? where id = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pedido.getStatusPedido());
            stmt.setInt(2, pedido.getId());

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public PedidoCaixa buscaPedidoId(int id){
        String sql = "SELECT * FROM tb_pedido_caixa where id =?";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                PedidoCaixa pCaixa = new PedidoCaixa();
                pCaixa.setId(rs.getInt("id"));
                pCaixa.setClienteId(rs.getInt("cliente_id"));
                pCaixa.setDataPedido(rs.getString("data_pedido"));
                pCaixa.setTotalPedido(rs.getBigDecimal("total_pedido"));
                pCaixa.setTempoPreparo(rs.getString("tempo_preparo"));
                pCaixa.setDataBaixa(rs.getString("baixa_pedido"));
                pCaixa.setObsPedido(rs.getString("obs_pedido"));
                pCaixa.setAtendenteId(rs.getInt("funcionario_id"));
                pCaixa.setFormaPagtoId(rs.getInt("forma_pagto_id"));
                pCaixa.setStatusPedido(rs.getString("status_pedido"));
                pCaixa.setValorDesconto(rs.getBigDecimal("valor_desconto"));
                pCaixa.setTotalAPagar(rs.getBigDecimal("total_a_Pagar"));
                
                return pCaixa;
            }else{
                throw new PedidoCaixaException("Pedido não encontrado!");
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Pedido");
        }
        
    }

    public List<PedidoCaixa> buscarAbertos() {
        String sql = "SELECT * FROM tb_pedido_caixa WHERE baixa_pedido is null";
        List<PedidoCaixa> pedidosAbertos = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PedidoCaixa pCaixa = new PedidoCaixa();
                pCaixa.setId(rs.getInt("id"));
                pCaixa.setClienteId(rs.getInt("cliente_id"));
                pCaixa.setDataPedido(rs.getString("data_pedido"));
                pCaixa.setTotalPedido(rs.getBigDecimal("total_pedido"));
                pCaixa.setTempoPreparo(rs.getString("tempo_preparo"));
                pCaixa.setDataBaixa(rs.getString("baixa_pedido"));
                pCaixa.setObsPedido(rs.getString("obs_pedido"));
                pCaixa.setAtendenteId(rs.getInt("funcionario_id"));
                pCaixa.setFormaPagtoId(rs.getInt("forma_pagto_id"));
                pCaixa.setStatusPedido(rs.getString("status_pedido"));
                pCaixa.setValorDesconto(rs.getBigDecimal("valor_desconto"));
                pCaixa.setTotalAPagar(rs.getBigDecimal("total_a_Pagar"));

                pedidosAbertos.add(pCaixa);
            }
            return pedidosAbertos;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao Listar pedidos do Caixa\n" + e.getMessage());
        }

    }

    public List<PedidoCaixa> listarPedidos() {
        String sql = "SELECT * FROM tb_pedido_caixa";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            List<PedidoCaixa> lista = new ArrayList<>();

            while (rs.next()) {
                PedidoCaixa pcaixa = new PedidoCaixa();
                pcaixa.setId(rs.getInt("id"));
                pcaixa.setClienteId(rs.getInt("cliente_id"));
                pcaixa.setDataPedido(rs.getString("data_pedido"));
                pcaixa.setTotalPedido(rs.getBigDecimal("total_pedido"));
                pcaixa.setTempoPreparo(rs.getString("tempo_preparo"));
                pcaixa.setDataBaixa(rs.getString("baixa_pedido"));
                pcaixa.setObsPedido(rs.getString("obs_pedido"));
                pcaixa.setAtendenteId(rs.getInt("funcionario_id"));
                pcaixa.setFormaPagtoId(rs.getInt("forma_pagto_id"));
                pcaixa.setStatusPedido(rs.getString("status_pedido"));
                pcaixa.setValorDesconto(rs.getBigDecimal("valor_desconto"));
                pcaixa.setTotalAPagar(rs.getBigDecimal("total_a_Pagar"));

                lista.add(pcaixa);
            }
            return lista;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao Listar pedidos do Caixa\n" + e.getMessage());
        }

    }

    //Retorna ID do Ultimo Pedido
    public int retornaUltimoPedido() {
        int idVenda = 0;
        String sql = "SELECT MAX(id) id FROM tb_pedido_caixa";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                PedidoCaixa novoPedido = new PedidoCaixa();

                novoPedido.setId(rs.getInt("id"));
                idVenda = novoPedido.getId();
            }
            return idVenda;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
