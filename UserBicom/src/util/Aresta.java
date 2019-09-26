package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Passagem;

/**
 *
 * @author Juliana
 */
public class Aresta implements Serializable, Comparable<Object>{
    private static final long serialVersionUID = 3L;
    private Vertice origem;
    private Vertice destino;
    private List<Passagem> passagens;
    private final String id;

    public Aresta(Vertice origem, Vertice destino, Passagem passagem) {
        this.origem = origem;
        this.destino = destino;
        this.passagens = new ArrayList<>();
        this.passagens.add(passagem);
        id = origem.getAeroporto().getEstado() + ":" + destino.getAeroporto().getEstado();
    }
        
    public void addPassagem(Passagem p){
        passagens.add(p);
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
    
    public String getId(){
        return id;
    }

    @Override
    public int compareTo(Object t) {
        if(t instanceof Aresta){
            Aresta a = (Aresta) t;
            if(id.equals(a.getId()))
                return 0;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Aresta){
            Aresta a = (Aresta) o;
            if(id.contains(a.destino.getAeroporto().getEstado()) ||
               id.contains(a.origem.getAeroporto().getEstado()))
                return true;
        }
        return false;
    }
    
    

}
