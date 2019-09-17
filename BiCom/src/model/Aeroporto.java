package model;

/**
 *
 * @author Juliana
 */
public class Aeroporto implements Comparable<Object>{
    private static final long serialVersionUID = 5L;
    private int id;
    private String estado;
    private String nome;

    public Aeroporto(int id, String estado, String nome) {
        this.id = id;
        this.estado = estado;
        this.nome = nome;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
