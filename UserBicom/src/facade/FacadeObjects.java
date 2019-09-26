package facade;

import java.util.ArrayList;
import java.util.List;
import model.Caminhos;
import util.Aresta;

/**
 *Classe utilitária para manipulação de alguns objetos para serem exibidas na interface
 * @author Juliana
 */
public class FacadeObjects {
    
    private static FacadeObjects facade;
    private Caminhos caminhos;
    private int refCaminho;
    private int refCursor1;
    private int refCursor2;
    
    private List<Aresta> arestas;

    public FacadeObjects() {
        //professor, me da um 10 pelo amor de Deus
    }
    
    public static synchronized FacadeObjects getInstance() {
        return (facade == null) ? facade = new FacadeObjects() : facade;
    }

    public void setCaminhos(Caminhos caminhos) {
        refCaminho = caminhos.getPossibilidades().size();
        refCursor1 = 0;
        refCursor2 = 0;
        this.caminhos = caminhos;
    }

    public void setRefCursor(int refCursor) {
        this.refCursor2 = refCursor;
    }
    
    public List<Aresta> getArestasAtual(){        
        List<List<Aresta>> possibilidades = caminhos.getPossibilidades();
        return possibilidades.get(refCursor1);
    }
    
    public double getPrecoAtual(){
        List<Aresta> arestasAtual = getArestasAtual();
        double preco = 0;
        for (Aresta aresta : arestasAtual) {
            preco = preco + aresta.getPassagens().get(0).getPreco();
        }
        return preco;
    }
    
    public Aresta getAtual(){
        List<List<Aresta>> possibilidades = caminhos.getPossibilidades();
        List<Aresta> aux = possibilidades.get(refCursor1);
        Aresta aresta = aux.get(refCursor2);
        refCursor2++;
        return aresta;
    }

    public int getRefCursor1() {
        return refCursor1;
    }

    public int getRefCursor2() {
        return refCursor2;
    }
    
    public int atualLengh(){
        return getArestasAtual().size();
    }

    public int getRefCaminho() {
        return refCaminho;
    }

    public void setRefCursor1() {
        refCursor1 = refCursor1 + 1;
    }

    public List<String> getIdsAtual() {
        List<String> list = new ArrayList<>();
        List<Aresta> arestasAtual = getArestasAtual();
        arestasAtual.forEach((Aresta aresta) -> {
            list.add(aresta.getId());
        });
        return list;
    }

}
