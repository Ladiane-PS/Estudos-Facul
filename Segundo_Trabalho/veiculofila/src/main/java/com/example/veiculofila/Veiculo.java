/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.veiculofila;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 * @author LADY
 */

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private String marcaModeloVeiculo;
    private int anoModelo;
    private double valorVenda;
    private Date dataPublicacao;

    // Construtores, getters e setters

    public Veiculo() {
        this.dataPublicacao = new Date(); // Definindo a data de publicação como a data corrente
    }

    public Veiculo(String nomeCliente, String marcaModeloVeiculo, int anoModelo, double valorVenda) {
        this.nomeCliente = nomeCliente;
        this.marcaModeloVeiculo = marcaModeloVeiculo;
        this.anoModelo = anoModelo;
        this.valorVenda = valorVenda;
        this.dataPublicacao = new Date(); // Definindo a data de publicação como a data corrente
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMarcaModeloVeiculo() {
        return marcaModeloVeiculo;
    }

    public void setMarcaModeloVeiculo(String marcaModeloVeiculo) {
        this.marcaModeloVeiculo = marcaModeloVeiculo;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", marcaModeloVeiculo='" + marcaModeloVeiculo + '\'' +
                ", anoModelo=" + anoModelo +
                ", valorVenda=" + valorVenda +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }

    void save(Veiculo veiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Iterable<Veiculo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
