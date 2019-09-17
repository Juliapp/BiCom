package controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import remoteMethods.ServerCliente;
import remoteMethods.ServerMethodsImple;
import util.Routs;
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

        
    public List<Routs> initializeServer(int servidor) {
        switch (servidor) {
            case 1:
                myServer = Settings.Servidores.AZUL;                
                serverA = new ServerCliente(GOL.getNome(), GOL.getHost(), GOL.getPort());
                serverB = new ServerCliente(LATAM.getNome(), LATAM.getHost(), LATAM.getPort());
                return Settings.getRotasAzul();
                
            case 2: 
                myServer = Settings.Servidores.GOL;
                serverA = new ServerCliente(AZUL.getNome(), AZUL.getHost(), AZUL.getPort());
                serverB = new ServerCliente(LATAM.getNome(), LATAM.getHost(), LATAM.getPort());
                return Settings.getRotasGol();
            default: 
                myServer = Settings.Servidores.LATAM;
                serverA = new ServerCliente(GOL.getNome(), GOL.getHost(), GOL.getPort());
                serverB = new ServerCliente(AZUL.getNome(), AZUL.getHost(), AZUL.getPort());
                return Settings.getRotasLatam();
        }
    }

    public int getMyServerPort() {
        return myServer.getPort();
    }

    public String getMyServerName() {
        return myServer.getNome();
    }
    
    public String getMyHost(){
        return myServer.getHost();
    }

    public ServerMethodsImple getServerALookupMethod() throws NotBoundException, MalformedURLException, RemoteException{
        return serverA.lookupMethod();
    }
    
    public ServerMethodsImple getServerBLookupMethod() throws NotBoundException, MalformedURLException, RemoteException{
        return serverB.lookupMethod();
    }    
    
}
