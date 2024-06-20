package com.example.gomes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class recall extends Application {
    public void start(Stage stage){
        stage.setTitle("Hello");
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root,500,300);
        root.setVgap(10);
        root.setHgap(10);
        stage.setScene(scene);
        Label label = new Label("This is a label");
        root.getChildren().add(label);
        Button btn = new Button("btn thingy");
        btn.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                label.setText("New button thingy");
            }
        });
        RadioButton rdb1 = new RadioButton("R1");
        rdb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label.setText("R1 is selected");
            }
        });
        root.getChildren().addAll(btn,rdb1);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
