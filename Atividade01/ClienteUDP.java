package mycompany.atividade1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

public class ClienteUDP {

    public static void main(String[] args) 
        throws IOException
    {
        //criação de forma do usuário inserir dados
        Scanner teclado = new Scanner(System.in);
        //Criar um socket para transportar o pacote (enviar e receber)
        DatagramSocket pontoConexao = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
        
        //Orientações para o usuário
        System.out.println("Instruções: \n" 
        + "1. Em caso de decimais, por favor, utilize ponto ao invés de vírgula; \n"
        + "2. Os sinais podem ser '+', '-', '*' ou 'x', '/'; \n"
        + "3. Para finalizar, digite '000' no campo destinado ao 1º número. \n" 
        + "-----------------------------------------------");
        
        while(true) {
            //System.out.println("Instrução: Por favor, insira a equação no seguinte formato:");
            //System.out.println("'número1 sinal número2' \n Para finalizar o programa, digite 'Fim'");
            
            //Coleta de dados
            float num1, num2;
            String sinal, dados, dadoA, dadoB;
            
            System.out.print("Digite o 1º número: ");
            num1 = teclado.nextFloat();
                if (num1 == 000){
                   dados = "Fim";
                }else{ 
                    dadoA = Float.toString(num1);
                    System.out.print("Digite o operador: ");
                    sinal = teclado.next();
                    System.out.print("Digite o 2º número: ");
                    num2 = teclado.nextFloat();
                    dadoB = Float.toString(num2);
                    dados = (dadoA + " " + sinal + " " + dadoB);
                    }
                    //tamanho do pacote
                    buf = new byte[65535];
                    //Conversão de String para byte
                    buf = dados.getBytes();
                    //Criação de pacote para enviar o dado
                    DatagramPacket enviar = new DatagramPacket(
                            buf, buf.length, ip, 1234);
                    //Iniciar a chamada para enviar o pacote de dados
                    pontoConexao.send(enviar);
                    //finalizar o programa
                    if(dados.equals("Fim"))
                        break;
                    buf = new byte[65535];
                    //Criação de objeto para receber os dados do servidor
                    DatagramPacket receber = new DatagramPacket(buf, buf.length);
                    pontoConexao.receive(receber);
                    //Informar resposta na tela
                    System.out.println("O resultado da operação " + dados + "= " + new String(buf));
        }
    }            
}