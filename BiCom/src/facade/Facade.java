package facade;

import controller.ServerController;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import model.Caminhos;
import remoteMethods.RMIServerServer;
import remoteMethods.ServerMethodsImple;
import util.Grafo;
import util.MapVerticesEArestas;

/**
 *
 * @author Juliana
 */
public class Facade {
    private final ServerController serverController;
    private RMIServerServer myRMIServer;
    private final Grafo grafo;
    
    private static Facade facade;

    public Facade() {
        serverController = new ServerController();
        grafo = new Grafo();
    }

    public static synchronized Facade getInstance() {
        return (facade == null) ? facade = new Facade() : facade;
    }

    public void initializeServer(int servidor) {
        serverController.initializeServer(servidor);
        myRMIServer = new RMIServerServer(serverController.getMyServerPort(), serverController.getMyServerName());
    }

    public MapVerticesEArestas getGrafo() {
        return grafo.getGrafo();
    }
    
    public Caminhos getPossiveisCaminhosMergered(String partida, String chegada) throws NotBoundException, MalformedURLException, RemoteException{
        ServerMethodsImple lookupMethod = serverController.getServerALookupMethod();
        MapVerticesEArestas map1 = lookupMethod.getGrafo();
        lookupMethod = serverController.getServerBLookupMethod();
        MapVerticesEArestas map2 = lookupMethod.getGrafo();
        return grafo.getPossiveisCaminhosMergered(map1, map2, partida, chegada);
    }     
}
