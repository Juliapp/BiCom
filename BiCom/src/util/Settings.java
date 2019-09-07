package util;

/**
 *Classe de utilitários.
 * @author Juliana
 */
public class Settings {
    
    public enum Servidores{
        SERVER_A("localhost", "Azul", 4000),
        SERVER_B("localhost", "Gol", 4001),
        MY_SERVER("localhost", "Latam", 1099);
        
        private final String host;
        private final String nome;
        private final int port;

        private Servidores(String host, String nome, int port) {
            this.host = host;
            this.nome = nome;
            this.port = port;
        }

        public String getHost() {
            return host;
        }

        public String getNome() {
            return nome;
        }

        public int getPort() {
            return port;
        }
        
        
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
