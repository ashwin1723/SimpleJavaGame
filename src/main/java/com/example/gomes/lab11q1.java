package com.example.gomes;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class lab11q1 extends Application {
    public void start(Stage stage){
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root,500,220);
        root.setHgap(10);
        root.setVgap(10);
        stage.setScene(scene);
        stage.setTitle("This is the first JavaFX Application");
        Label label = new Label("Welcome to JavaFX programming");
        label.setTextFill(Color.color(1, 0, 1));
        root.getChildren().add(label);
        stage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
