package controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import remoteMethods.ServerCliente;
import remoteMethods.ServerMethodsImple;
import util.Settings;
import static util.Settings.Servidores.AZUL;
import static util.Settings.Servidores.GOL;
import static util.Settings.Servidores.LATAM;

/**
 *
 * @author Juliana Aragão Pinto
 */
public class ServerController {
    private Settings.Servidores myServer;
    private ServerCliente serverA;
    private ServerCliente serverB;

    public ServerController() {
    }

        
    public void initializeServer(int servidor) {
        switch (servidor) {
            case 1:
                myServer = Settings.Servidores.AZUL;                
                serverA = new ServerCliente(GOL.getNome(), GOL.getHost(), GOL.getPort());
                serverB = new ServerCliente(LATAM.getNome(), LATAM.getHost(), LATAM.getPort());
                break;
            case 2: 
                myServer = Settings.Servidores.GOL;
                serverA = new ServerCliente(AZUL.getNome(), AZUL.getHost(), AZUL.getPort());
                serverB = new ServerCliente(LATAM.getNome(), LATAM.getHost(), LATAM.getPort());
                        
            default: 
                myServer = Settings.Servidores.LATAM;
                serverA = new ServerCliente(GOL.getNome(), GOL.getHost(), GOL.getPort());
                serverB = new ServerCliente(AZUL.getNome(), AZUL.getHost(), AZUL.getPort());
        }
    }

    public int getMyServerPort() {
        return myServer.getPort();
    }

    public String getMyServerName() {
        return myServer.getNome();
    }

    public ServerMethodsImple getServerALookupMethod() throws NotBoundException, MalformedURLException, RemoteException{
        return serverA.lookupMethod();
    }
    
    public ServerMethodsImple getServerBLookupMethod() throws NotBoundException, MalformedURLException, RemoteException{
        return serverB.lookupMethod();
    }    
    
}
