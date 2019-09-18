package model;

import java.io.Serializable;


/**
 *
 * @author Juliana
 */
public class Passagem implements Serializable{
    private static final long serialVersionUID = 6L;
    private final String companhia;
    private double preco;
    private int vagas;
       
    public Passagem(double preco, String companhia) {
        this.companhia = companhia;
        this.preco = preco;
        this.vagas = 10;
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

    public String getCompanhia() {
        return companhia;
    }

}
