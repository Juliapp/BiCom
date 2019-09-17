package remoteMethods;

import facade.Facade;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Caminhos;

/**
 *
 * @author Juliana
 */
public class ServerUserImple extends UnicastRemoteObject implements InterfaceServerUser{
    private final Facade facade;
    public ServerUserImple() throws RemoteException{
        super();
        facade = Facade.getInstance();
    }

    @Override
    public Caminhos getCaminhos(String origem, String destino) throws RemoteException{
        try {
            return facade.getPossiveisCaminhosMergered(destino, origem);
        } catch (NotBoundException | MalformedURLException ex) {
            Logger.getLogger(ServerUserImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
