package br.com.rmi.control.view;

import br.com.rmi.control.VeiculoInterface;
import br.com.rmi.control.Veiculo;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class VeiculoCliente  {
    public static void main(String[] args) throws Exception {
        // Localiza o servidor no serviço de nomes RMI Registry
        
       
Registry registry = LocateRegistry.getRegistry();
        VeiculoInterface stub = (VeiculoInterface) registry.lookup("ClassificadosVeiculos");

        // Cria um objeto Scanner para leitura de entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Loop do menu principal do cliente
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Pesquisar por ano");
            System.out.println("2. Adicionar veículo");
            System.out.println("3. Sair");

            // Lê a opção selecionada pelo usuário
            System.out.print("\nOpção: ");
            int opcao = scanner.nextInt();

            // Executa a ação correspondente à opção selecionada
            switch (opcao) {
                case 1:
                    System.out.print("\nAno do veículo: ");
                    int ano = scanner.nextInt();

                    // Chama o método search2Ano no servidor para buscar veículos por ano
                    List<Veiculo> veiculos = stub.search2Ano(ano);

                    // Exibe os resultados da busca
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo encontrado para o ano informado.");
                    } else {
                        System.out.println("\nVeículos encontrados para o ano " + ano + ":");
                        for (Veiculo v : veiculos) {
                            System.out.println(v);
                             break;
                        }
                    }
                case 2:
                    // Lê os dados do novo veículo a ser adicionado
                    System.out.print("\nNome do cliente: ");
                    String nomeCliente = scanner.next();
                    System.out.print("Marca do veículo: ");
                    String marcaVeiculo = scanner.next();
                    System.out.print("Valor de venda: ");
                    double valorVenda = scanner.nextDouble();
                    System.out.print("Ano do veículo: ");
                    ano = scanner.nextInt();

                    // Cria um objeto Veiculo com os dados lidos
                    Veiculo veiculo = new Veiculo(nomeCliente, marcaVeiculo, valorVenda, ano);

                    // Chama o método add no servidor para adicionar o novo veículo
                    stub.add(veiculo);

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