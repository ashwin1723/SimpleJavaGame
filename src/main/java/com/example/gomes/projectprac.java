package com.example.gomes;

import com.example.App;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class projectprac extends Application {
    Label response;
    public static void main(String[] args) {
        System.out.println("Launching JavaFX application");
        launch(args);
    }

    public void init(){
        System.out.println("Inside the init() method");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Inside the start() method");

        stage.setTitle("JavaFX Skeleton");
        FlowPane rootNode = new FlowPane();
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode,600,400);
        Label label = new Label("This is a JavaFX label");
        response = new Label("Push a Button");
        Button btnAlpha = new Button("Alpha");
        Button btnBeta = new Button("Beta");
        Button btnZeta = new Button("Zeta");
        btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                response.setText("Alpha was pressed.");
            }
        });

        btnBeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                response.setText("Beta was pressed.");
            }
        });

        btnZeta.setOnAction(new EventHandler<ActionEvent>(){
            @Override
                    public void handle(ActionEvent ae){
                response.setText("Zeta was pressed");
            }
        });
        rootNode.getChildren().addAll(btnBeta,btnAlpha,response);
        rootNode.getChildren().add(label);
        stage.setScene(scene);
        stage.show();
    }

    public void stop() {
        System.out.println("Inside the stop() method");
    }
}

