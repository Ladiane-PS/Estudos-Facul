/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.veiculofila;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author LADY
 */
@SpringBootApplication
@Controller
public class Application {
    @Autowired
    private Produtor produtor;

    @Autowired
    private Consumidor consumidor;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/adicionarVeiculo")
    public String adicionarVeiculo(@RequestParam("nomeCliente") String nomeCliente,
                                   @RequestParam("marcaModeloVeiculo") String marcaModeloVeiculo,
                                   @RequestParam("anoModelo") int anoModelo,
                                   @RequestParam("valorVenda") double valorVenda) {
        Veiculo veiculo = new Veiculo(nomeCliente, marcaModeloVeiculo, anoModelo, valorVenda);
        produtor.adicionarVeiculo(veiculo);
        return "redirect:/";
    }

    @GetMapping("/exibirVeiculos")
    public String exibirVeiculos(Model model) {
        Iterable<Veiculo> veiculos = consumidor.getVeiculos();
        model.addAttribute("veiculos", veiculos);
        return "veiculos";
    }
}






 

  
