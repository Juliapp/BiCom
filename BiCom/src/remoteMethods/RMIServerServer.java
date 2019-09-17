package remoteMethods;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juliana
 */
public class RMIServerServer {

    public RMIServerServer(String host, int port, String companhia){
        try {
            System.setProperty("java.rmi.server.hostname", host);
            LocateRegistry.createRegistry(port);
            
            ServerMethodsImple smi = new ServerMethodsImple(companhia);
            Naming.bind("ServerService" + companhia, (Remote) smi);  
            
            ServerUserImple sui = new ServerUserImple();
            Naming.bind("UserService" + companhia, (Remote) sui);
            
        } catch (RemoteException | MalformedURLException | AlreadyBoundException ex) {
            Logger.getLogger(RMIServerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
