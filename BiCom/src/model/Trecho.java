package model;

import java.util.Date;

public class Trecho {
    private final Aeroporto saida;
    private Date tempoSaida;
    private final Aeroporto chegada;
    private Date tempoChegada;
    private final double preço;

    public Trecho(Aeroporto saida, Date tempoSaida, Aeroporto chegada, Date tempoChegada, double preço) {
        this.saida = saida;
        this.tempoSaida = tempoSaida;
        this.chegada = chegada;
        this.tempoChegada = tempoChegada;
        this.preço = preço;
    }

    public Trecho(Aeroporto saida, Aeroporto chegada, double preço) {
        this.saida = saida;
        this.chegada = chegada;
        this.preço = preço;
    }

    public Aeroporto getSaida() {
        return saida;
    }

    public Date getTempoSaida() {
        return tempoSaida;
    }

    public Aeroporto getChegada() {
        return chegada;
    }

    public Date getTempoChegada() {
        return tempoChegada;
    }

    public double getPreço() {
        return preço;
    }

    
    
}
