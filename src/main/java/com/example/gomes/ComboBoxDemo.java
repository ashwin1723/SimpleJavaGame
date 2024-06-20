package com.example.gomes;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application{
    ComboBox<String> cbTransport;

    public static void main(String args[]){
        launch(args);
    }
    Label response;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("HEllow");
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,600,600);
        stage.setScene(scene);

        response = new Label();

        ObservableList<String> transportTypes = FXCollections.observableArrayList("Train","Car","Airplane");
        cbTransport = new ComboBox<String>(transportTypes);

        cbTransport.setValue("Train");

        response.setText("Selected Transport is"+ cbTransport.getValue());


        cbTransport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                response.setText("Selected Transport is"+cbTransport.getValue());
            }
        });
        root.getChildren().addAll(cbTransport,response);
        stage.show();
    }
}
