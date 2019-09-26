package facade;

import controller.ControlerDeCompra;
import controller.ServerController;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import model.Caminhos;
import model.Semaforo;
import remoteMethods.InterfaceServerServer;
import remoteMethods.RMIServerServer;
import util.Aresta;
import util.Grafo;
import util.MapVerticesEArestas;
import util.Routs;

/**
 *
 * @author Juliana
 */
public class Facade {
    private final ServerController serverController;
    private RMIServerServer myRMIServer;
    private final Grafo grafo;
    private final ControlerDeCompra comprar;
    private final Semaforo semaforo;
    
    private static Facade facade;

    public Facade() {
        serverController = new ServerController();
        grafo = new Grafo();
        comprar = new ControlerDeCompra();
        semaforo = new Semaforo();
    }

    public static synchronized Facade getInstance() {
        return (facade == null) ? facade = new Facade() : facade;
    }

    public void initializeServer(int servidor) {
        List<Routs> rotas = serverController.initializeServer(servidor);
        myRMIServer = new RMIServerServer(  serverController.getMyHost(),
                                            serverController.getMyServerPort(), 
                                            serverController.getMyServerName());
        grafo.initializeRotas(rotas);
    }

    public MapVerticesEArestas getGrafo() {
        return grafo.getGrafo();
    }
    
    public Caminhos getPossiveisCaminhosMergered(String partida, String chegada) throws NotBoundException, MalformedURLException, RemoteException, CloneNotSupportedException{
        InterfaceServerServer lookupMethod = null;
        InterfaceServerServer lookupMethod2 = null;
        try{
            lookupMethod = serverController.getServerALookupMethod();
        }catch(NullPointerException e){}
        
        try{
            lookupMethod2 = serverController.getServerBLookupMethod();
        }catch(NullPointerException e){}
        
        return grafo.getPossiveisCaminhosMergered(lookupMethod, lookupMethod2, partida, chegada);
        
    }
    
    public Caminhos getPossiveisCaminhosAtual(String partida, String chegada) throws NotBoundException, MalformedURLException, RemoteException{
        return grafo.getPossiveisCaminhosAtual(partida, chegada);
    }

    public boolean comprarTrechos(List<String> trechos) throws NotBoundException, MalformedURLException, RemoteException, CloneNotSupportedException {
        if(!semaforo.alguemQuer()){
            semaforo.setPermissao(serverController.getMyServerName());
            InterfaceServerServer lookupMethod = null;
            InterfaceServerServer lookupMethod2 = null;

            try{
                lookupMethod = serverController.getServerALookupMethod();
            }catch(NullPointerException e){}

            try{
                lookupMethod2 = serverController.getServerBLookupMethod();
            }catch(NullPointerException e){}

            try{
                List<Aresta> arestas = grafo.getVertices(lookupMethod, lookupMethod2, trechos);
                List<String> realizarCompra = comprar.realizarCompra(serverController.getServerA(), serverController.getServerB(), arestas, semaforo, serverController.getMyServerName());
                return comprarTrechos(realizarCompra, serverController.getMyServerName());
            }catch(NullPointerException e){
                return false;
            }finally{
                semaforo.tirarPermissao(serverController.getMyServerName());
            }
            
        }
        return false;
    }

    public String getPermissão() {
        return semaforo.getPermissao();
    }

    public void setPermissão(String permissao) {
        semaforo.setPermissao(permissao);
    }
    
    public void tirarPermissão(String permissao) {
        semaforo.tirarPermissao(permissao);
    }
    
    public boolean alguemQuer(){
        return semaforo.alguemQuer();
    }

    public boolean comprarTrechos(List<String> ids, String companhia) {
        if(semaforo.getPermissao().equalsIgnoreCase(companhia)){
            List<Aresta> arestasByIds = grafo.getArestasByIds(ids);
            
            for (Aresta arestasById : arestasByIds) {
                if(!arestasById.getPassagens().get(0).comprarPassagem()){
                    return false;
                }               
            }
        }
        return true;
    }
    
}
