package util;

import java.util.ArrayList;
import java.util.List;

/**
 *Classe de utilitários.
 * @author Juliana Aragão Pinto
 */
public class Settings {
    
    public enum Servidores{
        AZUL("172.16.103.6", "Azul", 1099),
        GOL("172.16.103.7", "Gol", 1099),
        LATAM("172.16.103.8", "Latam", 1099);
        
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
        private final String estado;
        private final String nome;
        
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
    
    public enum RotasGol{
        ROTA1(5, 25, 100.00),
        ROTA2(25, 5, 100.00 ),
        ROTA3(13, 19, 60.00),
        ROTA4(19, 13, 60.00),
        ROTA5(14, 9, 120.45),
        ROTA6(9, 14, 120.45),
        ROTA7(12, 24, 44.32),
        ROTA8(24, 12, 44.32),
        ROTA9(22, 14, 55.90),
        ROTA10(14, 22, 55.90),
        ROTA11(16, 6, 89.90),
        ROTA12(6, 16, 89.90),
        ROTA13(1, 11, 67.45),
        ROTA14(11, 1, 67.45),
        ROTA15(18, 23, 130.32),
        ROTA16(23, 18, 130.32),
        ROTA17(5, 17, 66.90),
        ROTA18(17, 5, 66.90),
        ROTA19(11, 9, 44.30),
        ROTA20(9, 11, 44.30);

        private final String companhia = "Gol";
        private final int origem;
        private final int destino;
        private final double preco;

        private RotasGol(int origem, int destino, double preco) {
            this.origem = origem;
            this.destino = destino;
            this.preco = preco;
        }

        public String getCompanhia() {
            return companhia;
        }

        public int getDestino() {
            return destino;
        }

        public int getOrigem() {
            return origem;
        }

        public double getPreco() {
            return preco;
        } 
    }


    public static enum RotasAzul{
        ROTA1(21, 16, 100.00),
        ROTA2(16, 21, 100.00 ),
        ROTA3(12, 25, 60.00),
        ROTA4(25, 12, 60.00),
        ROTA5(4, 23, 120.45),
        ROTA6(23, 4, 120.45),
        ROTA7(8, 5, 44.32),
        ROTA8(5, 8, 44.32),
        ROTA9(5, 26, 55.90),
        ROTA10(26, 5, 55.90),
        ROTA11(11, 12, 89.90),
        ROTA12(12, 11, 89.90),
        ROTA13(14, 3, 67.45),
        ROTA14(3, 14, 67.45),
        ROTA15(1, 4, 130.32),
        ROTA16(4, 1, 130.32),
        ROTA17(27, 10, 66.90),
        ROTA18(10, 27, 66.90),
        ROTA19(21, 5, 44.30),
        ROTA20(5, 21, 44.30);

        private final String companhia = "Azul";
        private final int origem;
        private final int destino;
        private final double preco;

        private RotasAzul(int origem, int destino, double preco) {
            this.origem = origem;
            this.destino = destino;
            this.preco = preco;
        }

        public String getCompanhia() {
            return companhia;
        }

        public int getDestino() {
            return destino;
        }

        public int getOrigem() {
            return origem;
        }

        public double getPreco() {
            return preco;
        }

    }    


    public enum RotasLatam{
        ROTA1(13, 7, 100.00),
        ROTA2(7, 13, 100.00 ),
        ROTA3(6, 20, 60.00),
        ROTA4(20, 6, 60.00),
        ROTA5(15, 17, 120.45),
        ROTA6(17, 15, 120.45),
        ROTA7(14, 27, 44.32),
        ROTA8(27, 14, 44.32),
        ROTA9(18, 10, 55.90),
        ROTA10(10, 18, 55.90),
        ROTA11(22, 13, 89.90),
        ROTA12(13, 22, 89.90),
        ROTA13(22, 4, 67.45),
        ROTA14(4, 22, 67.45),
        ROTA15(23, 10, 130.32),
        ROTA16(10, 23, 130.32),
        ROTA17(19, 6, 66.90),
        ROTA18(6, 19, 66.90),
        ROTA19(6, 5, 44.30),
        ROTA20(5, 6, 44.30);

        private final String companhia = "Latam";
        private final int origem;
        private final int destino;
        private final double preco;

        private RotasLatam(int origem, int destino, double preco) {
            this.origem = origem;
            this.destino = destino;
            this.preco = preco;
        }

        public String getCompanhia() {
            return companhia;
        }

        public int getDestino() {
            return destino;
        }

        public int getOrigem() {
            return origem;
        }

        public double getPreco() {
            return preco;
        }
    }    
    
    public static List<Routs> getRotasAzul(){
        List<Routs> rotas = new ArrayList<>();
        RotasAzul[] r = RotasAzul.values();
        for (RotasAzul rotaAzul : r) {
            rotas.add(new Routs(rotaAzul.getCompanhia(), rotaAzul.getOrigem(), rotaAzul.getDestino(), rotaAzul.getPreco()));
        }
        return rotas;
    }
    
    public static List<Routs> getRotasGol(){
        List<Routs> rotas = new ArrayList<>();
        RotasGol[] r = RotasGol.values();
        for (RotasGol rotaAzul : r) {
            rotas.add(new Routs(rotaAzul.getCompanhia(), rotaAzul.getOrigem(), rotaAzul.getDestino(), rotaAzul.getPreco()));
        }
        return rotas;
    }    
    
    public static List<Routs> getRotasLatam(){
        List<Routs> rotas = new ArrayList<>();
        RotasLatam[] r = RotasLatam.values();
        for (RotasLatam rotaAzul : r) {
            rotas.add(new Routs(rotaAzul.getCompanhia(), rotaAzul.getOrigem(), rotaAzul.getDestino(), rotaAzul.getPreco()));
        }
        return rotas;
    }    
}
