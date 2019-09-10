package remoteMethods;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import static util.Settings.Servidores.MY_SERVER;

/**
 *
 * @author Juliana
 */
public class RMIServerServer {

    public RMIServerServer(){
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            LocateRegistry.createRegistry(MY_SERVER.getPort());
            ServerMethodsImple smi = new ServerMethodsImple("a");
            Naming.bind("ServerService", (Remote) smi);  
            ServerUserImple sui = new ServerUserImple();
            Naming.bind("UserService", (Remote) sui);
        } catch (RemoteException | MalformedURLException | AlreadyBoundException ex) {
            Logger.getLogger(RMIServerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
