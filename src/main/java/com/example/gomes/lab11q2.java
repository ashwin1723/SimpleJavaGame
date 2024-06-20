package com.example.gomes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class lab11q2 extends Application {
    public void start(Stage stage){
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root,500,200);
        root.setVgap(10);
        root.setHgap(10);
        stage.setScene(scene);
//        Label label = new Label("Input a number");
        TextField numberTextField = new TextField();
        root.getChildren().add(numberTextField);
        numberTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int val = Integer.parseInt(numberTextField.getText());
                for(int i =1;i<=10;i++) {
                    Label label = new Label(String.valueOf(val*i));
                    root.getChildren().add(label);
                }
            }
        });
        stage.show();
    }

    public static void main(String[] arg){
        launch(arg);
    }
}
