package facade;

import controller.ControladorDeAeroportos;
import remoteMethods.RMIServerServer;

/**
 *
 * @author Juliana
 */
public class Facade {
    private final ControladorDeAeroportos aeroportos;
    private RMIServerServer rmiServerServer;
    
    public Facade(){
        aeroportos = new ControladorDeAeroportos();
    }
    
    public void initServer(){
        rmiServerServer = new RMIServerServer();
        System.out.println("Servidor Criado");
    }
    
    
    
}
