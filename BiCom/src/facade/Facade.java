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
    private final ControlerDeCompra comprarEmOutrosServidores;
    private final Semaforo semaforo;
    
    private static Facade facade;

    public Facade() {
        serverController = new ServerController();
        grafo = new Grafo();
        comprarEmOutrosServidores = new ControlerDeCompra();
        semaforo = new Semaforo();
    }

    public static synchronized Facade getInstance() {
        return (facade == null) ? facade = new Facade() : facade;
    }

    /**
     *Inicializa o servidor
     * @param servidor
     */
    public void initializeServer(int servidor) {
        List<Routs> rotas = serverController.initializeServer(servidor);
        myRMIServer = new RMIServerServer(  serverController.getMyHost(),
                                            serverController.getMyServerPort(), 
                                            serverController.getMyServerName());
        grafo.initializeRotas(rotas);
    }

    /**
     *pega o Mapa de arestas e vértices desse servidor
     * @return
     */
    public MapVerticesEArestas getGrafo() {
        return grafo.getGrafo();
    }
    
    /**
     *Pega os caminhos possíveis entre dois pontos de todos os servidores
     * @param partida
     * @param chegada
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws CloneNotSupportedException
     */
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
    
    /**
     *Pega os caminhos possíveis somente desse servidor
     * @param partida
     * @param chegada
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public Caminhos getPossiveisCaminhosAtual(String partida, String chegada) throws NotBoundException, MalformedURLException, RemoteException{
        return grafo.getPossiveisCaminhosAtual(partida, chegada);
    }

    /**
     *verifica e faz a compra de uma lista de trechos a partes de uma lista de ids
     * @param trechos
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws CloneNotSupportedException
     */
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
                List<String> realizarCompra = comprarEmOutrosServidores.realizarCompraNosOutrosServidores(serverController.getServerA(), serverController.getServerB(), arestas, semaforo, serverController.getMyServerName());
                return comprarTrechos(realizarCompra, serverController.getMyServerName());
            }catch(NullPointerException e){
                return false;
            }finally{
                semaforo.tirarPermissao(serverController.getMyServerName());
            }
            
        }
        return false;
    }

    public void setPermissão(String permissao) {
        semaforo.setPermissao(permissao);
    }
    
    /**
     *tira a permissão do servidor x de ter acesso exclusivo
     * @param permissao
     */
    public void tirarPermissão(String permissao) {
        semaforo.tirarPermissao(permissao);
    }
    
    /**
     *checa se algum dos três servidores tem interesse em fazer a compra no momento
     * @return
     */
    public boolean alguemQuer(){
        return semaforo.alguemQuer();
    }

    /**
     *faz a compra dos trechos nessa companhia 
     * @param ids
     * @param companhia
     * @return
     */
    public boolean comprarTrechos(List<String> ids, String companhia) {
        if(semaforo.getPermissao().equalsIgnoreCase(companhia)){
            List<Aresta> arestasByIds = grafo.getArestasByIds(ids);
            
            for (Aresta arestasById : arestasByIds) {
                if(!arestasById.getPassagens().get(0).comprarPassagem()){
                    return false;
                }               
            }
            return true;
        }
        return false;
    }
    
}
