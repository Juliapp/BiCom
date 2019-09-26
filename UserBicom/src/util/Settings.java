package util;

import java.util.ArrayList;
import java.util.List;
import model.Aeroporto;

public class Settings {
    
public enum Servidores{
        AZUL(1, "172.16.103.4", "Azul", 1099),
        GOL(2, "172.16.103.5", "Gol", 1099),
        LATAM(3, "172.16.103.6", "Latam", 1099);
        
        private final int id;
        private final String host;
        private final String nome;
        private final int port;

        private Servidores(int id, String host, String nome, int port) {
            this.id = id;
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

        public int getId() {
            return id;
        }
    }
    
    
    public enum Scenes {
        CONNECT("/view/screens/FXML.fxml"),
        MAIN("/view/screens/MainFXML.fxml"),
        CAMINHO_CONTAINER("/view/screens/FXMLContainer.fxml"),
        CAMINHO("/view/screens/FXMLPaneCaminho.fxml");

        private final String value;

        Scenes(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
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

        public static List<Aeroporto> getAeroportos(){
            List<Aeroporto> list = new ArrayList<>();
            EnumAeroportos[] aero = EnumAeroportos.values();
            for (EnumAeroportos enumAero : aero) {
                list.add(new Aeroporto(enumAero.getId(), enumAero.getEstado(), enumAero.getNome()));
            }
            return list;
        }
        
    }    
}
