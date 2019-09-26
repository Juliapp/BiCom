package facade;

import controller.ScreenController;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.Settings;

public class FacadeFront {
    private static FacadeFront facade;
    private ScreenController screenController;

    public FacadeFront() {
    }
    
    
    
    public static synchronized FacadeFront getInstance() {
        return (facade == null) ? facade = new FacadeFront() : facade;
    }
    
    /**
     *Inicializa a cena principal
     * @param stage
     */
    public void initializeRootStage(Stage stage) {
        try {
            screenController = new ScreenController(stage);
            screenController.loadRootScreen(Settings.Scenes.CONNECT);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
    public void goToMain(){
        screenController.loadRootScreen(Settings.Scenes.MAIN);
    }

    public ArrayList<Node> populatePaths() throws IOException {
        return screenController.populatePaths();
    }

    public ArrayList<Node> populateContainer() throws IOException {
        return screenController.populateContainer();
    }
}
