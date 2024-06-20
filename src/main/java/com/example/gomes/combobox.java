package com.example.gomes;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import org.controlsfx.dialog.Wizard;

/*interface inter{
    public static void ran(int iput){};
    public static void ran2(int iput){};
    public static void ran3(int iput){};

}

class c implements inter{

}

public class combobox extends Application {

    public static void main(String[] args){
        launch(args);
    }

    ComboBox<String> cbTransport;
    Label response;


    public void start(Stage stage){
        stage.setTitle("ComboBox Demo");
        FlowPane root = new FlowPane(10,10);
        Scene scene = new Scene(root);
        root.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        response = new Label();


    }
}*/

public class combobox extends Application{
    ComboBox<String> cbTransport;
    Label Response;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage){
        stage.setTitle("This is the title");
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root,500,500);
        root.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        Response = new Label();
        ObservableList<String> transportTypes = FXCollections.observableArrayList("Train","Car","Airplane");
        cbTransport = new ComboBox<>(transportTypes);
        cbTransport.setValue("Train");

        Response.setText("Selected Transport is "+cbTransport.getValue());
        cbTransport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Response.setText("Selected Transport is "+cbTransport.getValue());
            }
        });
        root.getChildren().addAll(cbTransport,Response);
        stage.show();
    }
}

