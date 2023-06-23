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
public class Produtor {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public void adicionarVeiculo(Veiculo veiculo) {
        System.out.println("Adicionando veículo à fila: " + veiculo);
        veiculoRepository.save(veiculo);
        System.out.println("Veículo adicionado à fila: " + veiculo);
    }
}
