package br.com.rmi.control.view;

import br.com.rmi.control.VeiculoInterface;
import br.com.rmi.control.Veiculo;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class VeiculoCliente  {
        public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry();
        VeiculoInterface stub = (VeiculoInterface) registry.lookup("ClassificadosVeiculos");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Pesquisar veículos por ano");
            System.out.println("2. Adicionar novo veículo");
            System.out.println("3. Sair");

            int opcao = 0;

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("\nInforme o ano desejado: ");

                    int ano = 0;

                    try {
                        ano = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Ano inválido. Tente novamente.");
                        continue;
                    }

                    List<Veiculo> veiculos = stub.search2Ano(ano);

                    if (veiculos.isEmpty()) {
                        System.out.println("\nNenhum veículo encontrado para o ano informado.");
                    } else {
                        System.out.println("\nVeículos encontrados para o ano " + ano + ":");

                        for (Veiculo v : veiculos) {
                            System.out.println(v);
                        }
                    }

                    break;

                case 2:
                    System.out.println("\n== Adicionar novo veículo ==");

                    System.out.print("\nNome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("Marca do veículo: ");
                    String marcaVeiculo = scanner.nextLine();

                    double valorVenda = 0.0;

                    while (true) {
                        System.out.print("Valor de venda: ");

                        try {
                            valorVenda = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido. Tente novamente.");
                        }
                    }

                    int anoVeiculo = 0;

                    while (true) {
                        System.out.print("Ano do veículo: ");

                        try {
                            anoVeiculo = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ano inválido. Tente novamente.");
                        }
                    }

                    Veiculo novoVeiculo = new Veiculo(nomeCliente, marcaVeiculo, valorVenda, anoVeiculo);

                    stub.add(novoVeiculo);

                    System.out.println("\nVeículo adicionado com sucesso!");

                    break;

                case 3:
                    System.out.println("\nEncerrando cliente...");
                    System.exit(0);

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }
}