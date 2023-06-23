/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.veiculofila;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author LADY
 */

@Component
public class Consumidor {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public void exibirVeiculos() {
        Iterable<Veiculo> veiculos = veiculoRepository.findAll();
        System.out.println("Lista de veículos:");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    Iterable<Veiculo> getVeiculos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
