/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifpa.demospring.controller;
import edu.ifpa.demospring.repositorio.Veiculo;
import edu.ifpa.demospring.repositorio.VeiculoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 *
 * @author LADY
 */
@Controller
public class VeiculoWebController {
    private final VeiculoRepository veiculoRepository;

    public VeiculoWebController(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @GetMapping("/")
    public String exibirVeiculos(Model model) {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        model.addAttribute("veiculos", veiculos);
        return "index";
    }
}