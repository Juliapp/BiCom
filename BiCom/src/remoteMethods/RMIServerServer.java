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

    /**
     *Classe do servidor RMI, que garante o set das propriedades do sistema, registra a porta
     * do servidor, e cria os serviços para serem acessados pelos outros servidores e pelos usuários
     * @param host
     * @param port
     * @param companhia
     */
    public RMIServerServer(String host, int port, String companhia){
        try {
            System.setProperty("java.rmi.server.hostname", host);
            LocateRegistry.createRegistry(port);
            
            ServerMethodsImple smi = new ServerMethodsImple(companhia);
            Naming.rebind("ServerService_" + companhia, (Remote) smi);
            System.out.println("Objeto a ser compartilhado entre os servidores passou pelo método de bind...");
            
            ServerUserImple sui = new ServerUserImple();
            Naming.rebind("UserService_" + companhia, (Remote) sui);
            System.out.println("Objeto a ser compartilhado para os clientes passou pelo método de bind...");
            
            System.out.println("Servidor da companhia " + companhia + " pronto para trocar mensagens");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(RMIServerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
