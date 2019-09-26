package remoteMethods;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *Acesso a um outro servidor como cliente
 * @author Juliana
 */
public class ServerCliente {
    private final String nome;
    private final String host;
    private final int port;

    public ServerCliente(String nome, String host, int port) {
        this.nome = nome;
        this.host = host;
        this.port = port;
    }  
    
    public InterfaceServerServer lookupMethod() throws MalformedURLException, NotBoundException, RemoteException{
        try{
            return (InterfaceServerServer) Naming.lookup("rmi://" + host + ":" + port + "/ServerService_" + nome);
        }catch(ConnectException e){
            System.err.println("O cliente " + nome + " não está disponível no momento ou não foi configurado de forma certa"
                                 + " por favor, verifique os parâmetros da conexão");
        }
        return null;
    }

    public String getNome() {
        return nome;
    }
    
}
