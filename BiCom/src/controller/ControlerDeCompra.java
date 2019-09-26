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

    public List<String> realizarCompra(ServerCliente serverA, ServerCliente serverB, List<Aresta> arestas, Semaforo semaforo, String minhacompanhia) throws MalformedURLException, NotBoundException, RemoteException {
        List<String> compA = new ArrayList<>();
        List<String> compB = new ArrayList<>();
        List<String> compMy = new ArrayList<>();
        
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
        
        if(compA.size() > 0){
            InterfaceServerServer lookupMethod = serverA.lookupMethod();
            if(!lookupMethod.queroComprarTrecho(minhacompanhia)){
                return null;
            }
        }
        
        if(compB.size() > 0){
            InterfaceServerServer lookupMethod = serverB.lookupMethod();
            if(!lookupMethod.queroComprarTrecho(minhacompanhia)){
                return null;
            }
        }
        
        if(compA.size() > 0){
            InterfaceServerServer lookupMethod = serverA.lookupMethod();
            if(!lookupMethod.comprarTrecho(compA, minhacompanhia)){
               return null; 
            }
        } 
        
        if(compA.size() > 0){
            InterfaceServerServer lookupMethod = serverA.lookupMethod();
            if(!lookupMethod.comprarTrecho(compB, minhacompanhia)){
               return null; 
            }
        }         
        
        return compMy;  
    }
}
