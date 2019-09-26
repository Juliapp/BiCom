package userbicom;

import facade.Facade;
import facade.FacadeFront;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Juliana
 */
public class UserBicom extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        FacadeFront facadef = FacadeFront.getInstance();
        facadef.initializeRootStage(stage);
    }

    /**
     *Inicialização da página inicial
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NotBoundException {
        launch(args);
    }
    
    
}
