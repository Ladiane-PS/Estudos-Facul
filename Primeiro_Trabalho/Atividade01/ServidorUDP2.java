package mycompany.atividade1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

public class ServidorUDP2 {
   public static void main(String[] args) 
            throws IOException
    {
        //Criação de soclet para atender ao chamado do cliente
        DatagramSocket pontoServidor = new DatagramSocket(1234);
        byte[] buf = null;
        DatagramPacket receber = null;
        DatagramPacket enviar = null;
        
        while (true){
            buf = new byte[65535];
            //criação de datagrama para receber dados
            receber = new DatagramPacket(buf, buf.length);
            //recepção de dados
            pontoServidor.receive(receber);
            
            String input = new String(buf, 0, buf.length);
            //tratamento do dado recebido (remover espaços em excesso)
            input = input.trim();
            
            System.out.println("Parâmetro recebido: " + input);
            
            //para sair do servidor
            if (input.equals("Fim")){
                System.out.println("Cliente se despediu. \n Por favor, aguarde... \n Conexão encerrada.");
                break;
            }
            float resultado = 0;
            
            //Para desmembrar a operação, utilizamos o StringTokenizer
            StringTokenizer organizador = new StringTokenizer(input);
            
            float num1 = Float.parseFloat(organizador.nextToken());
            String sinal = organizador.nextToken();
            float num2 = Float.parseFloat(organizador.nextToken());
            
            //Habilitação dos sinais para o servidor entender qual a operação
            if(sinal.equals("+"))
                resultado = num1 + num2;
            else if(sinal.equals("-"))
                resultado = num1 - num2;
            else if(sinal.equals("x"))
                resultado = num1 * num2;
            else if(sinal.equals("*"))
                resultado = num1 * num2;
            else if(sinal.equals("/")) 
                resultado = num1 / num2;
            
            System.out.println("Enviando o resultado para o cliente, por favor, aguarde... \n Resultado enviado.");
            String resposta = Float.toString(resultado);
            
            //Limpar o buffer a cada mensagem
            buf = resposta.getBytes();
            //Obter porta do cliente
            int portaCliente = receber.getPort();
            
            enviar = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(),portaCliente);
            pontoServidor.send(enviar);
        }
    }
}