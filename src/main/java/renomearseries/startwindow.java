/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renomearseries;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Davi Henrique
 */
public class startwindow extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
      
        
        
        Button btnSerie = new Button();
        Button btnMusica = new Button();
        Button btnSair=new Button();

        
        btnSerie.setText("Renomar Seriados");
        btnMusica.setText("Renomar Musicas");
        btnSair.setText("Sair");
      
        
        
       
        
        StackPane root = new StackPane();
        root.getChildren().add(btnSerie);
        root.getChildren().add(btnMusica);
        root.getChildren().add(btnSair);
        
      
        
        Scene scene = new Scene(root, 600, 400);
        
        
        
        
        
          btnSerie.setTranslateX(((20*scene.getWidth())/100)-(scene.getWidth()/2));        
          btnMusica.setTranslateX((scene.getWidth()/2)-((20*scene.getWidth())/100));
          btnSair.setTranslateX((scene.getWidth()/2)-((10*scene.getWidth())/100));
          
          
          btnSerie.setTranslateY(((60*scene.getHeight())/100)-(scene.getHeight()/2));  
           btnMusica.setTranslateY(((60*scene.getHeight())/100)-(scene.getHeight()/2));
           btnSair.setTranslateY(((85*scene.getHeight())/100)-(scene.getHeight()/2));
       
           
           btnSerie.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                new JanelaSeries().setVisible(true);
                 Platform.exit();
            }
        });
           
           btnMusica.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 new JanelaMusicas().setVisible(true);
                 Platform.exit();
     
            }
        });
           
           btnSair.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
           
         
        
        
        primaryStage.setTitle("Renomar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
