package br.com.rmi.control;

import java.io.Serializable;

public class Veiculo implements Serializable{
    private String nomeCliente;
    private String marcaVeiculo;
    private double valorVenda;
    private int ano;

    public Veiculo(String nomeCliente, String marcaVeiculo, double valorVenda, int ano) {
        this.nomeCliente = nomeCliente;
        this.marcaVeiculo = marcaVeiculo;
        this.valorVenda = valorVenda;
        this.ano = ano;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", marcaVeiculo='" + marcaVeiculo + '\'' +
                ", valorVenda=" + valorVenda +
                ", ano=" + ano +
                '}';
    }
}