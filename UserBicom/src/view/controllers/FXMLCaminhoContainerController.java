package view.controllers;

import facade.Facade;
import facade.FacadeFront;
import facade.FacadeObjects;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import util.Aresta;

/**
 * FXML Controller class
 *
 * @author Juliana Aragão Pinto
 */
public class FXMLCaminhoContainerController implements Initializable {

    public List<Aresta> arestas;
    private FacadeObjects facadeO;
    private FacadeFront facadef;
    private Facade facade;
    private List<String> ids;
    
    @FXML   private HBox hboxContainer;
    @FXML   private Label preco;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facadeO = FacadeObjects.getInstance();
        facadef = FacadeFront.getInstance();
        facade = Facade.getInstance();
        
        arestas = facadeO.getArestasAtual();
        preco.setText(String.format("%.2f", facadeO.getPrecoAtual()));
        ids = facadeO.getIdsAtual();
        
        try {
            hboxContainer.getChildren().setAll(facadef.populateContainer());
        } catch (IOException ex) {
            Logger.getLogger(FXMLCaminhoContainerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void comprarPassagem(ActionEvent event) throws NotBoundException, RemoteException, MalformedURLException {
        Alert a = new Alert(Alert.AlertType.WARNING);
        if(facade.comprarTrecho(ids)){
            a.setContentText("Passagens compradas com sucesso");
            //warn conseguiu
        }else{
            a.setContentText("Algo deu errado. Tente novamente mais tarde.");
            //warn não conseguiu
        }
        a.show();
    }
    
}
