package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Aeroporto;

/**
 *
 * @author Juliana
 */
public class Vertice implements Serializable{
    private static final long serialVersionUID = 4L;
    private final Aeroporto aeroporto;
    private final List<Aresta> arestas;

    public Vertice(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
        arestas = new ArrayList<>();
    }
    
    public boolean hasAresta(){
        return arestas.size() > 0;
    }

    public Aeroporto getAeroporto() {
        return aeroporto;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public boolean addAresta(Aresta a){
        return arestas.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Vertice){
            Vertice v = (Vertice) o;
            if(aeroporto.equals(v.getAeroporto())){
                return true;
            }

        }
        return false;
    }
    
    
    
}
