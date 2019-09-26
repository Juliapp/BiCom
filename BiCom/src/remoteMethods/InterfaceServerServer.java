package remoteMethods;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import util.MapVerticesEArestas;

public interface InterfaceServerServer extends Remote{
    
    public MapVerticesEArestas getGrafo() throws RemoteException;
    
    public String getCompanhia() throws RemoteException;
    
    public boolean queroComprarTrecho(String companhia) throws RemoteException;
    
    public void tirarPermissao(String companhia) throws RemoteException;
    
    public boolean comprarTrecho(List<String> ids, String companhia) throws RemoteException;
    
}
