package controller;

import facade.FacadeObjects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Settings.Scenes;
import static util.Settings.Scenes.CAMINHO;
import static util.Settings.Scenes.CAMINHO_CONTAINER;




/**
 *Controlador de cenas (interface gráfica)
 * @author Juliana
 */
public class ScreenController {
    private final Stage stage;
    private FacadeObjects facadeObject;


    public ScreenController(Stage rootStage) throws IOException, ClassNotFoundException {
        facadeObject = FacadeObjects.getInstance();
        stage = rootStage = new Stage();
    }

    /**
     *Faz o load para a cena principal
     * @param screen
     */
    public void loadRootScreen(Scenes screen){
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(screen.getValue()));
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();        
    }

    public ArrayList<Node> populatePaths() throws IOException {
        ArrayList<Node> elements = new ArrayList<>();
        for (int i = 0; i < facadeObject.getRefCaminho() ; i++) {
            elements.add(getRoot(CAMINHO_CONTAINER));
        }
        
        facadeObject.setRefCursor(0);
        facadeObject.setRefCursor1();
        return elements;
    }
    
    public ArrayList<Node> populateContainer() throws IOException {
        ArrayList<Node> elements = new ArrayList<>();
        for (int i = 0; i < facadeObject.atualLengh() ; i++) {
            elements.add(getRoot(CAMINHO));
        }
        
        return elements;
    }    

    public Parent getRoot(Scenes screen) throws IOException{
        return FXMLLoader.load(getClass().getResource(screen.getValue()));
    }
    
}    
