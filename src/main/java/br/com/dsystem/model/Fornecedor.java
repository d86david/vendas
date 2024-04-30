/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.model;

import br.com.dsystem.util.ValidaDocumento;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Fornecedor {

    private int id;
    private String nome;
    private String pessoa;
    private String cpfCnpj;
    private String rgIe;
    private String email;
    private String foneFixo;
    private String celular;
    private String cep;
    private String endereco;
    private int numero;
    private String compl;
    private String bairro;
    private String cidade;
    private String estado;
    private String obs;

    public Fornecedor() {
    }

    public Fornecedor(int id, String nome, String pessoa, String cpfCnpj, String reIe, String email, String foneFixo, String celular, String cep, String endereco, int numero, String compl, String bairro, String cidade, String estado, String obs) {
        this.id = id;
        this.nome = nome;
        this.pessoa = pessoa;
        this.cpfCnpj = cpfCnpj;
        this.rgIe = reIe;
        this.email = email;
        this.foneFixo = foneFixo;
        this.celular = celular;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.compl = compl;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    

}
