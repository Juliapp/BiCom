package view.controllers;

import facade.Facade;
import facade.FacadeFront;
import facade.FacadeObjects;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.Aeroporto;
import model.Caminhos;
import util.Settings.EnumAeroportos;

/**
 * FXML Controller class
 *
 * @author Juliana Aragão Pinto
 */
public class MainFXMLController implements Initializable {

    @FXML   private ChoiceBox<Aeroporto> partidaBox;
    @FXML   private ChoiceBox<Aeroporto> chegadaBox;

    private Facade facade;
    private FacadeFront facadef;
    private FacadeObjects facadeo;
    
    @FXML   private ScrollPane ScrollPaneMain;
    @FXML   private VBox mainVbox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Aeroporto> list = EnumAeroportos.getAeroportos();
        ObservableList<Aeroporto> ol = FXCollections.observableList(list);
        partidaBox.setItems(ol);
        chegadaBox.setItems(ol);
        
        facade = Facade.getInstance();
        facadef = FacadeFront.getInstance();
        facadeo = FacadeObjects.getInstance();
    } 

    @FXML
    private void buscar(ActionEvent event) throws NotBoundException, MalformedURLException, RemoteException, IOException {
        if(partidaBox.getValue() != null &&
           chegadaBox.getValue() != null &&
           !partidaBox.getValue().equals(chegadaBox.getValue())){
           
            Caminhos caminhos = facade.getCaminhos(partidaBox.getValue().getEstado(), chegadaBox.getValue().getEstado());
            if(caminhos != null){
                facadeo.setCaminhos(caminhos);
                populate();
            }
        }
    }
    
    public void populate() throws IOException{
        mainVbox.getChildren().clear();
        ArrayList<Node> populatePaths = facadef.populatePaths();
        mainVbox.getChildren().setAll(populatePaths);
    }
    
}
