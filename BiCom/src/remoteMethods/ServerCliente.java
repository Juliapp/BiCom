package remoteMethods;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
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
        return (InterfaceServerServer) Naming.lookup("rmi://" + host + ":" + port + "/ServerService_" + nome);
    }
    
}
