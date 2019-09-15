package util;

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import java.util.List;
import model.Aeroporto;

/**
 *
 * @author Juliana
 */
public class Vertice {
    private static final long serialVersionUID = 4L;
    private final Aeroporto aeroporto;
    private final List<Aresta> arestas;

    public Vertice(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
        arestas = new ArrayLinkedList<>();
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

    public boolean addVertice(Aresta a){
        return arestas.add(a);
    }
    
}
