package util;

/**
 *Classe auxiliar para carregar as rotas contidas no enumarador
 * @author Juliana Aragão Pinto
 */
public class Routs {
    private final String companhia;
    private final int origem;
    private final int destino;
    private final double preco;

    public Routs(String companhia, int origem, int destino, double preco) {
        this.companhia = companhia;
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
    }

    public String getCompanhia() {
        return companhia;
    }

    public int getOrigem() {
        return origem;
    }

    public int getDestino() {
        return destino;
    }

    public double getPreco() {
        return preco;
    }
    
    
    
}
