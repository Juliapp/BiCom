package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Aeroporto;
import model.Passagem;

/**
 *
 * @author Juliana
 */
public class MapVerticesEArestas implements Serializable, Cloneable {
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
            vertices.put(a.getId(), new Vertice(new Aeroporto(a.getId(), a.getEstado(), a.getNome())));
        }          
    }
    
    public void mergeOne(Map<Integer, Vertice> vertices, Map<String, Aresta> arestas){
        this.vertices.putAll(vertices);
        this.arestas.putAll(arestas);
    }
    
    void initializeRotas(List<Routs> rotas) {
        int i = 0;
        rotas.forEach((rota) -> {
            Vertice origem = vertices.get(rota.getOrigem());
            Vertice destino = vertices.get(rota.getDestino());
            Aresta aresta = new Aresta(origem, destino, new Passagem(rota.getPreco(), rota.getCompanhia()));
            arestas.put(generateIdAresta(origem, destino),
                    aresta);
            origem.addAresta(aresta);
        });
    }
    
    public String generateIdAresta(Vertice origem, Vertice destino){
        return origem.getAeroporto().getEstado() + ":" + destino.getAeroporto().getEstado();
    }
    
    public Aresta getArestaByID(String id){
        return arestas.get(id);
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
        Set<Map.Entry<Integer, Vertice>> entrySet = vertices.entrySet();
        for (Map.Entry<Integer, Vertice> entry : entrySet) {            
            if(entry.getValue().getAeroporto().getEstado().equalsIgnoreCase(chave)){
                return entry.getValue();
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

    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }    

    public List<Aresta> getArestas(List<String> ids) {
        List<Aresta> list = new ArrayList<>();
        for (String id : ids) {
            list.add(arestas.get(id));
        }
        
       return list;         
    }
    
}
