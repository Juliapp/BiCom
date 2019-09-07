package remoteMethods;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerMethodsImple extends UnicastRemoteObject implements InterfaceServerServer{
    private static final long serialVersionUID = 1L;
    private final String companhia;
    
    public ServerMethodsImple(String companhia) throws RemoteException {
        super();
        this.companhia = companhia;
    }

    public String getCompanhia() {
        return companhia;
    }
    
    
    
    
}
