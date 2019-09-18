package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Caminhos;

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
    
    public void mergeMaps(Map<Integer, Vertice> vertices1, Map<String, Aresta> arestas1,
                      Map<Integer, Vertice> vertices2, Map<String, Aresta> arestas2){
        mergeredMap = new MapVerticesEArestas();
        mergeredMap.merge(vertices1, arestas1, vertices2, arestas2);
    }
    
    public Caminhos getPossiveisCaminhosAtual(String strOrigem, String strDestino){
        return getPossiveisCaminhos(map, strOrigem, strDestino);
    }
    
    public Caminhos getPossiveisCaminhosMergered(MapVerticesEArestas map1, MapVerticesEArestas map2, String strOrigem, String strDestino){
        mergeMaps(map1.getVertices(), map1.getArestas(), map2.getVertices(), map2.getArestas());
        return getPossiveisCaminhos(mergeredMap, strOrigem, strDestino);
    }
    
    // ALGORITIMO PARA GERAR TODOS OS CAMINHOS
    private Caminhos getPossiveisCaminhos(MapVerticesEArestas map, String strOrigem, String strDestino){
        //pega o vertice de origem
        Vertice origem = map.getVerticeByEstado(strOrigem);
        System.out.println(origem);
        //pega o vertice de destino
        Vertice destino = map.getVerticeByEstado(strDestino);
        //Lista de caminhos possíveis
        List<List<Aresta>> aux = new ArrayList<>();
        //algoritimo de busca dos caminhos entre a origem e o destino
        busca(aux, new ArrayList<>(), origem, destino);
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
            if(!array.contains(aresta)){
                //Cria um novo array de arestas pra cada aresta que ele percorrer baseado num array passado por parâmetro
                ArrayList<Aresta> novo = new ArrayList<>(array);                   
                //Adiciona essa aresta a nova lista de arestas
                novo.add(aresta);              
                //referência para a outra ponda da aresta
                Vertice proximo = aresta.getDestino();
                //Se o próximo vértice for igual ao destino, ele adiciona a lista de aresta a lista de lista de caminhos
                if(proximo.equals(destino)){      
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
}
