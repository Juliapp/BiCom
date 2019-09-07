package controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import remoteMethods.ServerCliente;
import remoteMethods.ServerMethodsImple;
import static util.Settings.Servidores.SERVER_A;
import static util.Settings.Servidores.SERVER_B;

public class ControlerDeServidores {
    private final ServerCliente a;
    private final ServerCliente b;

    public ControlerDeServidores() {
        a = new ServerCliente(SERVER_A.getHost(), SERVER_A.getPort());
        b = new ServerCliente(SERVER_B.getHost(), SERVER_B.getPort());
    }
    
    public ServerMethodsImple getServerAMethods() throws MalformedURLException, NotBoundException, RemoteException{
        return a.lookupMethod();
    }
    
    public ServerMethodsImple getServerBMethods() throws MalformedURLException, NotBoundException, RemoteException{
        return b.lookupMethod();
    }
    
    
}
