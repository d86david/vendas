
package br.com.dsystem.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author david
 * Classe de Conexão com o banco de Dados JDBC
 */
public class ConnectionFactoy {
    private String servidor ="127.0.0.1" ;
    private String banco = "bdvendas";
    private String usuario ="root";
    private String senha = "123456";

    public ConnectionFactoy() {
    }

    
    public ConnectionFactoy(String servidor, String banco, String usuario, String senha) {
        this.servidor = servidor;
        this.banco = banco;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //Método que pega a conexão com o banco de dados
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+banco,usuario,senha);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
}
