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
    private final String host;
    private final int port;
    private final String service = "Service";

    public ServerCliente(String host, int port) {
        this.host = host;
        this.port = port;
    }  
    
    public ServerMethodsImple lookupMethod() throws MalformedURLException, NotBoundException, RemoteException{
        return (ServerMethodsImple) Naming.lookup("rmi://" + host + ":" + port + "/ServerService");
    }
    
}

//public class CalculadoraClient {
//    public static void main(String[] args){
//        try{
//            Calculadora c = (Calculadora) Naming.lookup("rmi://localhost/ServerService");
//            System.out.println("Adição : " + c.add(10, 15));
//        }catch(MalformedURLException | NotBoundException | RemoteException e){
//            System.err.println(e);
//        }
//    }
//}