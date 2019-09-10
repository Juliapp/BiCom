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
        
        ACRE(1, "Acre", "Aeroporto Internacional de Cruzeiro do Sul"),
        ALAGOAS(2, "Alagoas", "Aeroporto Internacional Zumbi dos Palmares"),
        AMAPA(3, "Amapá", "Aeroporto Internacional de Macapá"),
        AMAZONAS(4, "Amazonas", "Aeroporto Internacional Eduardo Gomes"),
        BAHIA(5, "Bahia", "Deputado Luís Eduardo Magalhães"),
        CEARA(6, "Ceará", "Aeroporto Internacional Pinto Martins"),
        DISTRITO_FEDERAL(7, "Distrito Federal", "Aeroporto Internacional Juscelino Kubitschek"),
        ESPIRITO_SANTO(8, "Espírito Santo", "Aeroporto Eurico de Aguiar Salles"),
        GOIAS(9, "Goiás", "Aeroporto Santa Genoveva"),
        MARANHAO(10, "Maranhão", "Aeroporto Internacional Marechal Cunha Machado"),
        MATO_GROSSO(11, "Mato Grosso", "Aeroporto Internacional Marechal Rondon"),
        MATO_GROSSO_DO_SUL(12, "Mato Grosso do Sul", "Aeroporto Internacional de Campo Grande"),
        MINAS_GERAIS(13, "Minas Gerais", "Aeroporto Internacional Tancredo Neves"),
        PARA(14, "Pará", "Aeroporto Internacional de Belém/Val de Cans"),
        PARAIBA(15, "Paraíba", "Aeroporto Internacional Presidente Castro Pinto"),
        PARANA(16, "Paraná", "Aeroporto Internacional Afonso Pena"),
        PERNAMBUCO(17, "Pernambuco", "Aeroporto Internacional dos Guararapes Gilberto Freyre"),
        PIAUI(18, "Piauí", "Aeroporto Senador Petrônio Portella"),
        RIO_DE_JANEIRO(19, "Rio de Janeiro", "Aeroporto Internacional do Rio de Janeiro"),
        RIO_GRANDE_DO_NORTE(20, "Rio Grande do Norte", "Aeroporto Internacional Augusto Severo"),
        RIO_GRANDE_DO_SUL(21, "Rio Grande do Sul", "Aeroporto Internacional Salgado Filho"),
        RONDONIA(22, "Rondônia", "Aeroporto Internacional Governador Jorge Teixeira"),
        RORAIMA(23, "Roraima", "Aeroporto Internacional de Boa Vista"),
        SANTA_CATARINA(24, "Santa Catarina", "Aeroporto Internacional Hercílio Luz "),
        SAO_PAULO(25, "São Paulo", "Aeroporto de Congonhas"),
        SERGIPE(26, "Sergipe", "Aeroporto Internacional de Aracaju"),
        TOCANTINS(27, "Tocantins", "Aeroporto de Palmas");

        private final int id;
        private final String nome;
        private final String estado;
        
        EnumAeroportos(int id, String estado, String nome) {
            this.id = id;
            this.estado = estado;
            this.nome = nome;
        }
        
        public String getNome(){
            return nome;
        }
        
        public String getEstado(){
            return estado;
        }     

        public int getId() {
            return id;
        }
        
    }
    
    public enum Rotas{
        ROTA1("Azul", ),
        ROTA2("Azul", ),
        ROTA3("Azul", ),
        ROTA4("Azul", ),
        ROTA5("Azul", ),
        ROTA6("Azul", ),
        ROTA7("Azul", ),
        ROTA8("Azul", ),
        ROTA9("Azul", ),
        ROTA10("Azul", ),
        ROTA11("Azul", ),
        ROTA12("Azul", ),
        ROTA13("Azul", ),
        ROTA14("Azul", ),
        ROTA15("Azul", ),
        ROTA16("Azul", ),
        ROTA17("Azul", ),
        ROTA18("Azul", ),
        ROTA19("Azul", ),
        ROTA20("Azul", ),
        ROTA21("Gol", ),
        ROTA22("Gol", ),
        ROTA23("Gol", ),
        ROTA25("Gol", ),
        ROTA26("Gol", ),
        ROTA27("Gol", ),
        ROTA28("Gol", ),
        ROTA29("Gol", ),
        ROTA30("Gol", ),
        ROTA31("Gol", ),
        ROTA32("Gol", ),
        ROTA33("Gol", ),
        ROTA34("Gol", ),
        ROTA35("Gol", ),
        ROTA36("Gol", ),
        ROTA37("Gol", ),
        ROTA38("Gol", ),
        ROTA39("Gol", ),
        ROTA40("Gol", ),
        ROTA41("Latam", ),
        ROTA42("Latam", ),
        ROTA43("Latam", ),
        ROTA44("Latam", ),
        ROTA45("Latam", ),
        ROTA46("Latam", ),
        ROTA47("Latam", ),
        ROTA48("Latam", ),
        ROTA49("Latam", ),
        ROTA50("Latam", ),
        ROTA51("Latam", ),
        ROTA52("Latam", ),
        ROTA53("Latam", ),
        ROTA54("Latam", ),
        ROTA55("Latam", ),
        ROTA56("Latam", ),
        ROTA57("Latam", ),
        ROTA58("Latam", ),
        ROTA59("Latam", ),
        ROTA60("Latam", );
        
        
        private final String compainha;
        private final String origem;
        private final String destino;
        private final double preco;

        private Rotas(String compainha, String origem, String destino, double preco) {
            this.compainha = compainha;
            this.origem = origem;
            this.destino = destino;
            this.preco = preco;
        }

        
    }
    
}
