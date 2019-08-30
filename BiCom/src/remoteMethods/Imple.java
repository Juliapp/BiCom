package remoteMethods;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Imple extends UnicastRemoteObject implements  InterfaceAcessoEntreServidores{

    public Imple() throws RemoteException {
        super();
    }
    
    public void initializeServer(){
        
    }
    
}
