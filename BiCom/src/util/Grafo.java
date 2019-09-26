package util;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import model.Caminhos;
import remoteMethods.InterfaceServerServer;
/**
 *
 * @author Juliana
 */
public class Grafo {
    private final MapVerticesEArestas map;
    private MapVerticesEArestas mergeredMap;
    
    public Grafo() {
        map = new MapVerticesEArestas();
    }
    
    public MapVerticesEArestas getGrafo(){
        return map;
    }
    
    public void initializeRotas(List<Routs> rotas) {
        map.initializeRotas(rotas);
    }    
    
    public MapVerticesEArestas getReferenceMap(){
        return new MapVerticesEArestas();
    }
    
    public Caminhos getPossiveisCaminhosAtual(String strOrigem, String strDestino){
        return getPossiveisCaminhos(map, strOrigem, strDestino);
    }
    
    public Caminhos getPossiveisCaminhosMergered(InterfaceServerServer lookupMethod, InterfaceServerServer lookupMethod2, String partida, String chegada) throws RemoteException, CloneNotSupportedException {
        mergeredMap = getGrafoTotal(lookupMethod, lookupMethod2);
        return getPossiveisCaminhos(mergeredMap, partida, chegada);
    }
    
    public MapVerticesEArestas getGrafoTotal(InterfaceServerServer lookupMethod, InterfaceServerServer lookupMethod2) throws RemoteException, CloneNotSupportedException {
        mergeredMap = (MapVerticesEArestas) map.clone();
        if(lookupMethod != null){
            mergeredMap.mergeOne(lookupMethod.getGrafo().getVertices(), lookupMethod.getGrafo().getArestas());
        }
        if(lookupMethod2 != null){
             mergeredMap.mergeOne(lookupMethod2.getGrafo().getVertices(), lookupMethod2.getGrafo().getArestas());
        }
        return mergeredMap;
    }
    
    public List<Aresta> getVertices(InterfaceServerServer lookupMethod, InterfaceServerServer lookupMethod2, List<String> trechos) throws RemoteException, CloneNotSupportedException{
        mergeredMap = getGrafoTotal(lookupMethod, lookupMethod2);
        List<Aresta> arestas = new ArrayList<>();
        for (String trecho : trechos) {
            Aresta arestaByID = mergeredMap.getArestaByID(trecho);
            if(arestaByID == null){
                return null;
            }
            arestas.add(arestaByID);
        }
        return arestas;
    }
    
    // ALGORITIMO PARA GERAR TODOS OS CAMINHOS
    private Caminhos getPossiveisCaminhos(MapVerticesEArestas map, String strOrigem, String strDestino){
        //pega o vertice de origem
        Vertice origem = map.getVerticeByEstado(strOrigem);
        //pega o vertice de destino
        Vertice destino = map.getVerticeByEstado(strDestino);
        //Lista de caminhos possíveis
        List<List<Aresta>> aux = new ArrayList<>();
        //algoritimo de busca dos caminhos entre a origem e o destino
        System.out.println("--------- Começo da busca no grafo -----------");
        busca(aux, new ArrayList<>(), origem, destino);
        System.out.println("---------- Fim da busca no grafo ------------");
        //chama o garbage colletor
        System.gc();     
        //retorna um objeto com todos os caminhos possíveis
        return new Caminhos(aux);
    }
    
    private void busca(List<List<Aresta>> listaDeLista, ArrayList<Aresta> array, Vertice origem, Vertice destino){
        //Lista das arestas que tem nesse vértice
        List<Aresta> refs = origem.getArestas();
        //itera as arestas que tem nesse vértice
        for (Aresta aresta : refs) {     
            //confere se já passou por essa aresta
            if(!containsAeroporto(array, aresta) && aresta.getPassagens().get(0).getVagas() > 0){
                //Cria um novo array de arestas pra cada aresta que ele percorrer baseado num array passado por parâmetro
                ArrayList<Aresta> novo = new ArrayList<>(array);                   
                //Adiciona essa aresta a nova lista de arestas
                novo.add(aresta);              
                //referência para a outra ponda da aresta
                Vertice proximo = aresta.getDestino();
                //Se o próximo vértice for igual ao destino, ele adiciona a lista de aresta a lista de lista de caminhos
                if(proximo.equals(destino)){ 
                    System.out.println("Achou uma rota");
                    listaDeLista.add(novo);
                }
                //Se esse nó não foi visitado ou não tem mais arestas seta a nova lista como nula para ser recolhida
                else if(proximo.hasAresta()){               
                    busca(listaDeLista, novo, proximo, destino);  
                }
                //garante que os objetos vão ser excluidos
                novo = null;
            }       
        }
    }
    
    private boolean containsAeroporto(ArrayList<Aresta> array, Aresta aresta){
        int i = 0;
        for (Aresta aresta1 : array) {
            if(aresta1.equals(aresta)){
                i++;
                if(i == 2){
                    return true;
                }
            }
        }
        return false;
    }
    
    public List<Aresta> getArestasByIds(List<String> ids){
        return map.getArestas(ids);
    }
}
