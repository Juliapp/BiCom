package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Aeroporto;
import model.Passagem;

/**
 *
 * @author Juliana
 */
public class MapVerticesEArestas {
    private final Map<String, Vertice> vertices;
    private final Map<String, Aresta> arestas;

    public MapVerticesEArestas() {
        vertices = new HashMap<>();
        arestas = new HashMap<>();
        initializeVertices();
    }
    
    private void initializeVertices(){
        for (Settings.EnumAeroportos a : Settings.EnumAeroportos.values()) {
            vertices.put(a.getEstado(), new Vertice(new Aeroporto(a.getNome(), a.getEstado())));
        }          
    }

    public void merge(Map<String, Vertice> vertices1, Map<String, Aresta> arestas1,
                      Map<String, Vertice> vertices2, Map<String, Aresta> arestas2) {
        vertices.putAll(vertices1);
        vertices.putAll(vertices2);
        arestas.putAll(arestas1);
        arestas.putAll(arestas2);
    }

    public Map<String, Aresta> getAresstas() {
        return arestas;
    }

    public Map<String, Vertice> getVertices() {
        return vertices;
    }
    
    
    public List<Vertice> getAeroportos(){
        return (List<Vertice>) vertices.values();
    }
    
    public Vertice getVertice(String chave){
        return vertices.get(chave);
    }
    
    public void criarAresta(String origem, String destino, double preco, String compainha){
        Vertice o = getVertice(origem);
        Vertice d = getVertice(destino);
        Aresta a = new Aresta(o, d, new Passagem(preco, compainha));
        addAresta(o, d, a);
    }
    
    public boolean hasAresta(String origem){
        Vertice o = getVertice(origem);
        return o.hasAresta();  
    }
    
    public boolean addAresta(Vertice origem, Vertice destino, Aresta a){
        String chave = origem.getAeroporto().getEstado() + ":" + destino.getAeroporto().getEstado();
        arestas.put(chave, a);
        return origem.addVertice(a);
    }

    public boolean addAresta(String chave, Aresta a){
        Vertice v = getVertice(chave);
        arestas.put(v.getAeroporto().getEstado(), a);
        return v.addVertice(a);
    }
    
    public List<Aresta> getArestas(String chaveVertice){
        Vertice v = getVertice(chaveVertice);
        return v.getArestas();
    }
    
}
