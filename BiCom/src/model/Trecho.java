package model;

import java.util.Date;

public class Trecho {
    private final Aeroporto saida;
    private final Date tempoSaida;
    private final Aeroporto chegada;
    private final Date tempoChegada;

    public Trecho(Aeroporto saida, Date tempoSaida, Aeroporto chegada, Date tempoChegada) {
        this.saida = saida;
        this.tempoSaida = tempoSaida;
        this.chegada = chegada;
        this.tempoChegada = tempoChegada;
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

    
}
