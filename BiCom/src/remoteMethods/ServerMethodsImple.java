package remoteMethods;

import facade.Facade;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import util.MapVerticesEArestas;

public class ServerMethodsImple extends UnicastRemoteObject implements InterfaceServerServer{
    private static final long serialVersionUID = 1L;
    private final String companhia;
    private final Facade facade;
    
    public ServerMethodsImple(String companhia) throws RemoteException {
        super();
        this.companhia = companhia;
        facade = Facade.getInstance();
    }

    @Override
    public String getCompanhia() {
        return companhia;
    }
    
    @Override
    public MapVerticesEArestas getGrafo(){
        return facade.getGrafo();
    }
    
}
