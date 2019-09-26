package bicom;

import facade.Facade;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class BiCom {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, UnknownHostException {
        int servidor = options();
        Facade facade = Facade.getInstance();
        facade.initializeServer(servidor);
    }
    
    public static int options() throws UnknownHostException{
        System.out.println("Qual servidor você deseja inicializar?");
        System.out.println("1 - Azul");
        System.out.println("2 - Gol");
        System.out.println("3 - Latam");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

}
