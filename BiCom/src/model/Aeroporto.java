package model;

/**
 *
 * @author Juliana
 */
public class Aeroporto {
    private String estado;
    private String nome;

    public Aeroporto(String estado, String nome) {
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
    

    
}
