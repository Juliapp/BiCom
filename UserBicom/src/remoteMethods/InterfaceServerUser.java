package remoteMethods;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Caminhos;

/**
 *
 * @author Juliana
 */
public interface InterfaceServerUser extends Remote{
    
    public Caminhos getCaminhos(String origem, String destino) throws RemoteException;
    
    public boolean comprarTrechos(List<String> trechos) throws RemoteException;
    
}
