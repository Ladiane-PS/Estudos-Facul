package br.com.rmi.control;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VeiculoServidor extends UnicastRemoteObject implements VeiculoInterface{  
    private static final long serialVersionUID = 1L;
    private final List<Veiculo> veiculos;

    protected VeiculoServidor() throws RemoteException {
        super();
        this.veiculos = new ArrayList<Veiculo>();
    }
    
    public static void main(String[] args) throws Exception {
        
        // PORTA PADRÃO DO RMI 1099
        LocateRegistry.createRegistry(1099);

        // Instancia o Objeto do Servidor Remoto
        VeiculoServidor serv = new VeiculoServidor();

        // Vincula um nome para o objeto Remoto
        Naming.bind("ClassificadosVeiculos", serv);

        System.out.println("VeiculoServidor Conectado !!!");
    }

    public List<Veiculo> search2Ano(int anoVeiculo) throws RemoteException {
        List<Veiculo> veiculosEncontrados = new ArrayList<Veiculo>();
        for (Veiculo v : veiculos) {
            if (v.getAno() == anoVeiculo) {
                veiculosEncontrados.add(v);
            }
        }
        return veiculosEncontrados;
    }

    public void add(Veiculo v) throws RemoteException {
        veiculos.add(v);
    }

    public String exibirMensagem(String txt) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); 
}}
