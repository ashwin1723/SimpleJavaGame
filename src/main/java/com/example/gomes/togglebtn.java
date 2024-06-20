package com.example.gomes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import org.controlsfx.control.action.Action;

import java.util.concurrent.Flow;

public class togglebtn extends Application {
    ToggleButton tbonoff;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage){
        stage.setTitle("This is the title");
        FlowPane root = new FlowPane(100,100);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        response = new Label("Push the  button");
        tbonoff = new ToggleButton("On/Off");
        tbonoff.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                if(tbonoff.isSelected()){
                    response.setText("Button is on.");
                }else{
                    response.setText("Button is off");
                }
            }
        });
        root.getChildren().addAll(tbonoff,response);
        stage.show();
    }
}
