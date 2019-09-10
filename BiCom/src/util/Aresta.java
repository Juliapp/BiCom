package util;

import java.util.ArrayList;
import java.util.List;
import model.Passagem;

/**
 *
 * @author Juliana
 */
public class Aresta {
    private static final long serialVersionUID = 3L;
    private Vertice origem;
    private Vertice destino;
    private List<Passagem> passagens;

    public Aresta(Vertice origem, Vertice destino, Passagem passagem) {
        this.origem = origem;
        this.destino = destino;
        this.passagens = new ArrayList<>();
        this.passagens.add(passagem);
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

}
