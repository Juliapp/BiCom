package facade;

import controller.CompanyController;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import model.Caminhos;
import remoteMethods.Client;
import util.Aresta;

/**
 *
 * @author Juliana Aragão Pinto
 */
public class Facade {
    private static Facade facade;
    private final CompanyController company;
    private final Client client;
    
    public Facade() {
        client = new Client();
        company = new CompanyController();
    }
    
    public static synchronized Facade getInstance() {
        return (facade == null) ? facade = new Facade() : facade;
    }

    public void initializeCompany(String value) {
        company.setCompany(value);
    }

    public Caminhos getCaminhos(String origem, String destino) throws NotBoundException, MalformedURLException, RemoteException {
        return client.getCaminhos(company.getHost(), company.getPort(), origem, destino, company.getNome());
    }
    
    public boolean comprarTrecho(List<String> trechos) throws NotBoundException, RemoteException, MalformedURLException{
        return client.comprarTrecho(company.getHost(), company.getPort(), company.getNome(), trechos);
    }
    
}
