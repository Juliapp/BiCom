package util;

/**
 *Classe de utilitários.
 * @author Juliana
 */
public class Settings {
    
    public enum Servidores{
        
        
        
    }
    
    public enum EnumAeroportos{
        
        BAHIA("Bahia", "Deputado Luís Eduardo Magalhães"),
        RIO("Rio", "Rio");
        
        private final String nome;
        private final String estado;
        
        EnumAeroportos(String estado, String nome) {
            this.estado = estado;
            this.nome = nome;
        }
        
        public String getNome(){
            return nome;
        }
        
        public String getEstado(){
            return estado;
        }
                
    }
    
}
