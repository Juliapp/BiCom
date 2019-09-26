package model;

import java.io.Serializable;

/**
 *
 * @author Juliana
 */
public class Aeroporto implements Comparable, Serializable{
    private static final long serialVersionUID = 5L;
    private final int id;
    private final String estado;
    private final String nome;

    public Aeroporto(int id, String estado, String nome) {
        this.id = id;
        this.estado = estado;
        this.nome = nome;
    }
    
    public String getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return estado + " - " + nome;
    }

    @Override
    public int compareTo(Object t) {
        if(t instanceof Aeroporto && estado.equals(((Aeroporto) t).getEstado())){
           return 0;
        }
        return -1;
    }
    
}
