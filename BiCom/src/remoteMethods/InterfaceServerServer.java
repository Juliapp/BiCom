package remoteMethods;

import java.rmi.Remote;
import java.rmi.RemoteException;
import util.MapVerticesEArestas;

public interface InterfaceServerServer extends Remote{
    
    public MapVerticesEArestas getGrafo() throws RemoteException;
    
    public String getCompanhia() throws RemoteException;
    
}
