package bicom;

import facade.Facade;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BiCom {

    public static void main(String[] args) throws NotBoundException {
        int servidor = options();
        
        while (servidor < 1 || servidor > 3){
            System.out.println("Opção errada");
            servidor = options();
        }
        
        Facade facade = Facade.getInstance();
        facade.initializeServer(servidor);
        
        try {
            System.out.println(facade.tentativa());
        } catch (MalformedURLException | RemoteException ex) {
            Logger.getLogger(BiCom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int options(){
        System.out.println("Qual servidor deseja iniciar?");
        System.out.println("1 - Azul");
        System.out.println("2 - Gol");
        System.out.println("3 - Latam");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    
    
}
