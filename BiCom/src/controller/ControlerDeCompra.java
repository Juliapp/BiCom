package controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import model.Semaforo;
import remoteMethods.InterfaceServerServer;
import remoteMethods.ServerCliente;
import util.Aresta;

/**
 *
 * @author Juliana Aragão Pinto
 */
public class ControlerDeCompra {   
    
    /**
     *Método para realizar compra nos outros servidores
     * @param serverA
     * @param serverB
     * @param arestas
     * @param semaforo
     * @param minhacompanhia
     * @return
     * @throws MalformedURLException
     * @throws NotBoundException
     * @throws RemoteException
     */
    public List<String> realizarCompraNosOutrosServidores(ServerCliente serverA, ServerCliente serverB, List<Aresta> arestas, Semaforo semaforo, String minhacompanhia) throws MalformedURLException, NotBoundException, RemoteException {
        //Criação de três listas que vão conter os ids dos trechos em cada servidor
        List<String> compA = new ArrayList<>();
        List<String> compB = new ArrayList<>();
        List<String> compMy = new ArrayList<>();
        
        //percorre as arestas, checa quem disponibiliza a passagem e coloca o Id da aresta na respectiva lista
        arestas.forEach((aresta) -> {
            String companhia = aresta.getPassagens().get(0).getCompanhia();
            if(companhia.equals(serverA.getNome())){
                compA.add(aresta.getId());
            }else if(companhia.equals(serverB.getNome())){
                compB.add(aresta.getId());
            }else{
                compMy.add(aresta.getId());
            }
        });        
        
        //diz um dos servidores que ele deseja fazer a compra se houver algum ID da sua lista
        if(compA.size() > 0){
            InterfaceServerServer lookupMethod = serverA.lookupMethod();
            if(!lookupMethod.queroComprarTrecho(minhacompanhia)){
                return null;
            }
        }
        //diz ao outro servidor que ele deseja fazer a compra se houver algum ID da sua lista
        if(compB.size() > 0){
            InterfaceServerServer lookupMethod = serverB.lookupMethod();
            if(!lookupMethod.queroComprarTrecho(minhacompanhia)){
                return null;
            }
        }
        
        //faz a compra do trecho no servidor A se houver ID
        if(compA.size() > 0){
            InterfaceServerServer lookupMethod = serverA.lookupMethod();
            if(!lookupMethod.comprarTrecho(compA, minhacompanhia)){
               return null; 
            }
        } 
        
        //faz a compra do trecho no servidor B se houver ID
        if(compB.size() > 0){
            InterfaceServerServer lookupMethod = serverA.lookupMethod();
            if(!lookupMethod.comprarTrecho(compB, minhacompanhia)){
               return null; 
            }
        }         
        
        //retorna a lista de ids que devem ser comprados nesse servidor
        return compMy;  
    }
}
