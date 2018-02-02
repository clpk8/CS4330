/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Ben
 */
public class Checkers {
    
    private AnchorPane pane = new AnchorPane();
    private int numRows, numCols;
    private double boardWidth,boardHeight, rectWidth, rectHeight;
    private Color lightColor, darkColor;
    
    public Checkers(int numRows, int numCols, double boardWidth, double boardHeight){

        this.numCols = numCols;
        this.numRows = numRows;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        
    }
    
    public Checkers(int numCols, int numRows, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this(numRows, numCols,boardWidth,boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        
    }
    
    public AnchorPane build(){
        rectHeight = boardHeight / numRows;
        rectWidth = boardWidth / numCols;
        
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < numCols; col++){
                Rectangle rect;
                if((col+row)%2 != 1){
                    rect = new Rectangle(rectWidth, rectHeight, darkColor);
                }
                else{
                    rect = new Rectangle(rectWidth, rectHeight, lightColor);
                }
                
                pane.getChildren().add(rect);
                AnchorPane.setTopAnchor(rect, row*rectHeight);
                AnchorPane.setLeftAnchor(rect, col*rectWidth);

            }
        }
        
      return pane;  
        
    }
        public AnchorPane getBoard() {       
            return pane;
    }
    
    //getters and setters
    public int getNumRows() {
        return numRows;
    }
      
    public int getNumCols() {
        return numCols;
    }
        
    public double getWidth() {
        return boardWidth;
    }
        
    public double getHeight() {
        return boardHeight;
    }
        
    public Color getLightColor() {
        return lightColor;
    }
        
    public Color getDarkColor() {
        return darkColor;
    }
        
    public double getRectangleWidth() {
        return rectWidth;
    }
        
    public double getRectangleHeight() {
        return rectHeight;
    }  
    
}


