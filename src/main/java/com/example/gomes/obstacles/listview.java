package com.example.gomes.obstacles;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class listview extends Application {
    Label response;
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){
        stage.setTitle("This is the title");
        FlowPane root = new FlowPane(10,10);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,500,500);
        response = new Label("Select Computer type");
        stage.setScene(scene);
        ObservableList<String> computertypes = FXCollections.observableArrayList("Smartphone","Tablet","Notebook","Desktop");
        ListView<String> lv = new ListView<>(computertypes);
        lv.setPrefSize(200,140);


        MultipleSelectionModel<String> lvsel = lv.getSelectionModel();
        lvsel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

            }
        });



        MultipleSelectionModel<String> lvselmodel = lv.getSelectionModel();
        lvselmodel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                response.setText("Computer selected it"+t1);
            }
        });
        root.getChildren().addAll(lv,response);
        stage.show();
    }
}
