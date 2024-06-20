package com.example.gomes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class lab11q3 extends Application {
    public void start(Stage stage){
        GridPane root = new GridPane();
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        root.setVgap(10);
        root.setHgap(10);
        Label label = new Label("Welcome");
        TextField text = new TextField("Enter username");
        Label usrnme = new Label("User Name: ");
        Label passwrd = new Label("PassWord: ");

        Button sign = new Button("Sign In");
        root.add(label,0,0);
        root.add(usrnme,0,1);
        root.add(text,1,1);
        PasswordField pass = new PasswordField();
        root.add(passwrd,0,2);
        root.add(pass,1,2);
        String username;
        String password;
        root.add(sign,2,3);
        sign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Label welcome = new Label("Welcome "+text.getText());
                root.add(welcome,1,3);
            }
        });
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
