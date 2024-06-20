package com.example.gomes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.controlsfx.dialog.Wizard;

import java.util.zip.Checksum;

public class checkbox extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    CheckBox cbphone;
    CheckBox tablet;
    CheckBox notebook;
    CheckBox desktop;
    Label response;
    Label selected;
    String computers;
    public void start(Stage stage){
        stage.setTitle("This is the title");
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root,500,500);
        root.setHgap(10);
        root.setVgap(10);
        stage.setScene(scene);
        Label heading = new Label("What computers do you own");
        response = new Label("");
        selected = new Label("");
        cbphone = new CheckBox("SmartPhone");
        tablet = new CheckBox("Tablet");
        notebook = new CheckBox("Notebook");
        desktop = new CheckBox("Desktop");
        cbphone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(cbphone.isSelected())
                    response.setText("Smartphone was selected");
                else
                    response.setText("SmartPhone was cleared");
            }
        });
        tablet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(cbphone.isSelected())
                    response.setText("Tablet was selected");
                else
                    response.setText("Tablet was cleared");
                showAll();
            }
        });
        notebook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(cbphone.isSelected())
                    response.setText("Notebook was selected");
                else
                    response.setText("Notebook was cleared");
                showAll();
            }
        });
        desktop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(cbphone.isSelected())
                    response.setText("Desktop was selected");
                else
                    response.setText("Desktop was cleared");
                showAll();
            }
        });
        root.getChildren().addAll(heading,cbphone,notebook,tablet,response,selected);
        stage.show();
        showAll();
    }
    void showAll(){
        computers="";
        if(cbphone.isSelected()){
            computers = "Smartphone";
        }
        if(tablet.isSelected()){
            computers+=" Tablet";
        }
        if(notebook.isSelected()){
            computers+=" Notebook";
        }
        if(desktop.isSelected()){
            computers+=" Desktop";
        }
    }
}
