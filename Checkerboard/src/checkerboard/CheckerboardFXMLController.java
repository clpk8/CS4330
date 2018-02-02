/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Ben
 */
public class CheckerboardFXMLController implements Initializable {
    
    Checkers checkers;
    @FXML
    private AnchorPane pane;
    private int numRows = 8;
    private int numCols = 8;
    private double boardWidth = 600;
    private double boardHeight = 600;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    

   public void build() {
        checkers = new Checkers(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        pane.getChildren().setAll(checkers.build());
    }
    
    public void rebuild() {
        pane.getChildren().clear();
        build();
    }
    
    public void getBoardSize(Scene scene) {
        boardWidth = scene.getWidth();
        boardHeight = scene.getHeight() - 29;
    }
        
            
    public void start(Scene scene){
        getBoardSize(scene);
            build();
            ChangeListener<Number> listener = new ChangeListener<Number>(){
   
     @Override 
     public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
          getBoardSize(scene);
            build();
     }
};    

    
    scene.widthProperty().addListener(listener);
    scene.heightProperty().addListener(listener);

    
    }
    
    public void initializeValue(){
        numRows = checkers.getNumRows();
        numCols = checkers.getNumCols();
        boardWidth = checkers.getWidth();
        boardHeight = checkers.getHeight();
        lightColor = checkers.getLightColor();
        darkColor = checkers.getDarkColor();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void size16(ActionEvent event) {
        initializeValue();
        numCols = 16;
        numRows = 16;
        rebuild();
        
    }

    @FXML
    private void size10(ActionEvent event) {
        initializeValue();
        numCols = 10;
        numRows = 10;
        rebuild();
    }

    @FXML
    private void size8(ActionEvent event) {
        initializeValue();
        numCols = 8;
        numRows = 8;
        rebuild();
    }

    @FXML
    private void size3(ActionEvent event) {
        initializeValue();
        numCols = 3;
        numRows = 3;
        rebuild();
    }

    @FXML
    private void setDefault(ActionEvent event) {
        initializeValue();
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        rebuild();
    }

    @FXML
    private void setBlue(ActionEvent event) {
        initializeValue();
        lightColor = Color.SKYBLUE;
        darkColor = Color.DARKBLUE;
        rebuild();
    }
    
}
