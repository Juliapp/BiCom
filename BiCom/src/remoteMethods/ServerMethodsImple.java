package remoteMethods;

import facade.Facade;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import util.MapVerticesEArestas;

/**
 *Classe de implementação dos serviços oferecidos pelo servidor
 * @author Juliana Aragão Pinto
 */
public class ServerMethodsImple extends UnicastRemoteObject implements InterfaceServerServer{
    private static final long serialVersionUID = 1L;
    private final String companhia;
    private final Facade facade;
    //trava para garantir a exclusão mutua
    private final Lock lock;
    
    public ServerMethodsImple(String companhia) throws RemoteException {
        super();
        this.companhia = companhia;
        facade = Facade.getInstance();
        lock = new ReentrantLock();
    }

    @Override
    public String getCompanhia() {
        return companhia;
    }
    
    @Override
    public MapVerticesEArestas getGrafo(){
        return facade.getGrafo();
    }
    
    @Override
    public boolean queroComprarTrecho(String companhia){
        Condition myCondition = lock.newCondition();
        try{
            //condição de acesso para esse método = 30 segundos
            myCondition.await(30000L, TimeUnit.MILLISECONDS);
            synchronized(this){
                if(!facade.alguemQuer()){
                    facade.setPermissão(companhia);
                    return true;
                }                    
            }
        } catch (InterruptedException e) {
            return false;
        } finally{
            lock.unlock();
        }
        return false;
    }
    
    /**
     *terminar a compra nesse servidor
     * @param companhia
     */
    @Override
    public void tirarPermissao(String companhia){
        facade.tirarPermissão(companhia);      
    }    

    /**
     *comprar esse trecho
     * @param ids
     * @param companhia
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean comprarTrecho(List<String> ids, String companhia) throws RemoteException {
        return facade.comprarTrechos(ids, companhia);
    }
    
}
