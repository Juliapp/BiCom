package model;


/**
 *
 * @author Juliana
 */
public class Passagem {
    private static final long serialVersionUID = 6L;
    private final String companhia;
    private double preco;
    private int vagas;
    private boolean flag = false;
       
    public Passagem(double preco, String companhia) {
        this.companhia = companhia;
        this.preco = preco;
        this.vagas = 10;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    
    
    
    
}
