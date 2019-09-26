package remoteMethods;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import javafx.scene.control.Alert;
import model.Caminhos;

/**
 *
 * @author Juliana
 */
public class Client {

    public Client() {
    }
    
    public Caminhos getCaminhos(String host, int port, String origem, String destino, String nome) throws NotBoundException, MalformedURLException, RemoteException{
        try{
             System.out.println("rmi://" + host + ":" + port + "/UserService_" + nome);
             InterfaceServerUser a = (InterfaceServerUser) Naming.lookup("rmi://" + host + ":" + port + "/UserService_" + nome);
             return a.getCaminhos(origem, destino);
        }catch(ConnectException e){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Erro de conexão");
            a.setContentText("O servidor não foi configurado corretamente ou "
                    + "não está respondendo ao cliente. Por favor, cheque as "
                    + "configurações e tente novamente");
            a.show();
        }
        return null;
    }

    public boolean comprarTrecho(String host, int port, String nome, List<String> trechos) throws NotBoundException, RemoteException, MalformedURLException {
        InterfaceServerUser a = (InterfaceServerUser) Naming.lookup("rmi://" + host + ":" + port + "/UserService_" + nome);
        return a.comprarTrechos(trechos);        
    }
    
}
