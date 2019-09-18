package util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Aeroporto;
import model.Passagem;

/**
 *
 * @author Juliana
 */
public class MapVerticesEArestas implements Serializable {
    private static final long serialVersionUID = 10L;
    private final Map<Integer, Vertice> vertices;
    private final Map<String, Aresta> arestas;

    public MapVerticesEArestas() {
        vertices = new HashMap<>();
        arestas = new HashMap<>();
        initializeVertices();
    }
    
    private void initializeVertices(){
        for (Settings.EnumAeroportos a : Settings.EnumAeroportos.values()) {
            vertices.put(a.getId(), new Vertice(new Aeroporto(a.getId(), a.getNome(), a.getEstado())));
        }          
    }

    public void merge(Map<Integer, Vertice> vertices1, Map<String, Aresta> arestas1,
                      Map<Integer, Vertice> vertices2, Map<String, Aresta> arestas2) {
        vertices.putAll(vertices1);
        vertices.putAll(vertices2);
        arestas.putAll(arestas1);
        arestas.putAll(arestas2);
    }
    
    void initializeRotas(List<Routs> rotas) {
        rotas.forEach((rota) -> {
            Vertice origem = vertices.get(rota.getOrigem());
            Vertice destino = vertices.get(rota.getDestino());
            arestas.put(generateIdAresta(origem, destino),
                    new Aresta(origem, destino, new Passagem(rota.getPreco(), rota.getCompanhia())));
        });
    }
    
    public String generateIdAresta(Vertice origem, Vertice destino){
        return origem.getAeroporto().getEstado() + ":" + destino.getAeroporto().getEstado();
    }

    public Map<String, Aresta> getArestas() {
        return arestas;
    }

    public Map<Integer, Vertice> getVertices() {
        return vertices;
    }
    
    public List<Vertice> getAeroportos(){
        return (List<Vertice>) vertices.values();
    }
    
    public Vertice getVerticeByEstado(String chave){
        Collection<Vertice> aero = vertices.values();
        for (Vertice vertice : aero) {
            if(vertice.getAeroporto().compareTo(chave) == 0){
                return vertice;
            }
        }
        return null;
    }
    
    public boolean hasAresta(String origem){
        Vertice o = getVerticeByEstado(origem);
        return o.hasAresta();  
    }
    
    public List<Aresta> getArestas(String chaveVertice){
        Vertice v = getVerticeByEstado(chaveVertice);
        return v.getArestas();
    }

    
}
