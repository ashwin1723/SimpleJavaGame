package com.example.gomes;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class calculator extends Application {

    public void start(Stage stage){
        Button onebtn = new Button("1");
        Button twobtn = new Button("2");
        Button threebtn = new Button("3");
        Button fourbtn = new Button("4");
        Button fivebtn = new Button("5");
        Button sixbtn = new Button("6");
        Button sevenbtn = new Button("7");
        Button eightbtn = new Button("8");
        Button ninebtn = new Button("9");
        Button zerobtn = new Button("0");
        GridPane root = new GridPane();
        root.setHgap(30);
        root.setVgap(30);
        final int[] flag = {0};
        Scene scene = new Scene(root,300,400);
        Label response = new Label("Hello");
        stage.setScene(scene);
        stage.setTitle("Hello");
        final Label[] l = {new Label("hellow")};

        twobtn.setOnAction(new EventHandler< ActionEvent >(){
            @Override
            public void handle(ActionEvent ae){
                l[0].setText("2 was pressed");
            }
        });
        Button addbtn = new Button("+");
        addbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                flag[0] = 1;
            }
        });
     //   root.getChildren().addAll(onebtn,twobtn,l);
        root.add(onebtn,1,2);
        root.add(twobtn,2,2);
        root.add(l[0],3,5);

        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
