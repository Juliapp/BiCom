package view.controllers;

import facade.FacadeObjects;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import util.Aresta;

/**
 * FXML Controller class
 *
 * @author Juliana Aragão Pinto
 */
public class FXMLPaneCaminhoController implements Initializable {

    private FacadeObjects facadeO;
    
    @FXML   private Pane rootPane;
    @FXML   private Label labelOrigem;
    @FXML   private Tooltip toolTipOrigem;
    @FXML   private Label labelDestino;
    @FXML   private Tooltip tooltipDestino;
    
    @FXML   private Label nomeCompanhia;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facadeO = FacadeObjects.getInstance();
        Aresta atual = facadeO.getAtual();
        
        String estadoOrigem = atual.getOrigem().getAeroporto().getEstado();
        String nomeOrigem = atual.getOrigem().getAeroporto().getNome();
        labelOrigem.setText(estadoOrigem);
        toolTipOrigem.setText(nomeOrigem);
        
        String estadoDestino = atual.getDestino().getAeroporto().getEstado();
        String nomeDestino = atual.getDestino().getAeroporto().getNome();
        labelDestino.setText(estadoDestino);
        tooltipDestino.setText(nomeDestino);
        
        nomeCompanhia.setText(atual.getPassagens().get(0).getCompanhia());
   }    
    
}
