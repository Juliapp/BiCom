/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import facade.Facade;
import facade.FacadeFront;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author Juliana Aragão Pinto
 */
public class FXMLController implements Initializable {

    @FXML  private ChoiceBox<String> compainhaBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Azul");
        al.add("Gol");
        al.add("Latam");
        ObservableList<String> ol = FXCollections.observableList(al);
        compainhaBox.setItems(ol);
    }    

    @FXML
    private void selectCompany(ActionEvent event) {
        if(compainhaBox.getValue() != null){
            Facade facade = Facade.getInstance();
            facade.initializeCompany(compainhaBox.getValue());
            FacadeFront facadef = FacadeFront.getInstance();
            facadef.goToMain();
        }
    }
    
}
