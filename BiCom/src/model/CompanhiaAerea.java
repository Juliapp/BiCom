package model;

/**
 *
 * @author Referência para a companhia aerea atual
 */
public class CompanhiaAerea {
    String nome;

    public CompanhiaAerea(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        return nome.equals(o);
    }
    
    
}
