package bicom;

import facade.Facade;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import static util.Settings.Servidores.AZUL;
import static util.Settings.Servidores.GOL;
import static util.Settings.Servidores.LATAM;

public class BiCom {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, UnknownHostException {
        int servidor = options();
        Facade facade = Facade.getInstance();
        facade.initializeServer(servidor);
    }
    
    public static int options() throws UnknownHostException{
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        if(hostAddress.equals(AZUL.getHost())){
            return AZUL.getId();
        }
        else if(hostAddress.equals(GOL.getHost())){
            return GOL.getId();
        }else
            return LATAM.getId();
    }

}
