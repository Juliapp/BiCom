package facade;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import model.Caminhos;
import remoteMethods.RMIServerServer;
import remoteMethods.ServerCliente;
import remoteMethods.ServerMethodsImple;
import util.Grafo;
import util.MapVerticesEArestas;
import static util.Settings.Servidores.SERVER_A;
import static util.Settings.Servidores.SERVER_B;

/**
 *
 * @author Juliana
 */
public class Facade {
    private RMIServerServer rmiServerServer;
    private final Grafo grafo;
    private ServerCliente serverA;
    private ServerCliente serverB;
    
    private static Facade facade;
    
    public Facade(){
        grafo = new Grafo();
    }   
    
    public static synchronized Facade getInstance() {
        return (facade == null) ? facade = new Facade() : facade;
    }
    
    public void initServer(){
        rmiServerServer = new RMIServerServer();
        System.out.println("Servidor Criado");   
        serverA = new ServerCliente(SERVER_A.getHost(), SERVER_A.getPort());
        serverB = new ServerCliente(SERVER_B.getHost(), SERVER_B.getPort());
    }
    
    public Caminhos getPossiveisCaminhosAtual(String partida, String chegada) throws MalformedURLException, MalformedURLException, MalformedURLException{
        return grafo.getPossiveisCaminhosAtual(partida, chegada);
    }
    
    public Caminhos getPossiveisCaminhosMergered(String partida, String chegada) throws NotBoundException, MalformedURLException, RemoteException{
        ServerMethodsImple lookupMethod = serverA.lookupMethod();
        MapVerticesEArestas map1 = lookupMethod.getGrafo();
        lookupMethod = serverB.lookupMethod();
        MapVerticesEArestas map2 = lookupMethod.getGrafo();
        return grafo.getPossiveisCaminhosMergered(map1, map2, partida, chegada);
    }    

    public MapVerticesEArestas getGrafo() {
        return grafo.getGrafo();
    }
    
}
