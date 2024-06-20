package com.example.gomes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.spreadsheet.Grid;

public class radiobtn extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    Label response;
    public void start(Stage stage){
        stage.setTitle("Hello i am under the water");
        GridPane root = new GridPane();
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        root.setAlignment(Pos.CENTER);
        response = new Label("");
        RadioButton rbtrain = new RadioButton("Train");
        RadioButton rbCar = new RadioButton("Car");
        RadioButton rbPlane = new RadioButton("Airplane");
        ToggleGroup tg = new ToggleGroup();
        rbtrain.setToggleGroup(tg);
        rbPlane.setToggleGroup(tg);
        rbCar.setToggleGroup(tg);
        rbtrain.setOnAction(new EventHandler<ActionEvent>(){
           public void handle(ActionEvent e){
               response.setText("Transported selected is train");
           }
        });
        rbCar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                response.setText("Transport selected is car.");
            }
        });
        rbPlane.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                response.setText("Transport selected is airplane");
            }
        });
        rbtrain.fire();
        root.add(rbtrain,0,0);
        root.add(rbCar,1,0);
        root.add(rbPlane,2,0);
        root.add(response,2,2);
       // root.getChildren().addAll(rbtrain,rbCar,rbPlane,response);
        stage.show();
    }
}
