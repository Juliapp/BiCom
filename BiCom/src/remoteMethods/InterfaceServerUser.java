package remoteMethods;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Caminhos;

/**
 *
 * @author Juliana
 */
public interface InterfaceServerUser extends Remote{
    
    public Caminhos getCaminhos(String origem, String destino) throws RemoteException;
    
}
