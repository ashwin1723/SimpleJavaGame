package com.example.gomes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
public class drawing extends Application{
    Color[] colors = {Color.RED,Color.BLUE,Color.GREEN,Color.BLACK};
    int coloridx = 0;
    public static void main(String[] args){
        launch(args);
    }
    GraphicsContext gc;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Draw Directly to a Canvas");
        FlowPane root = new FlowPane();

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root,400,500);
        stage.setScene(scene);
        Canvas canvas = new Canvas(400,500);
        gc = canvas.getGraphicsContext2D();

        Button btnchangecolor = new Button("Change color");

        btnchangecolor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gc.setStroke(colors[coloridx]);
                gc.setFill(colors[coloridx]);

                gc.strokeLine(0,0,200,200);
                gc.fillText("This is drawn on the canvas.",60,50);
                gc.fillRect(100,320,300,40);

                coloridx++;
                if(coloridx==colors.length) {
                    coloridx=0;
                }
            }
        });

        gc.strokeLine(0,0,200,200);
        gc.strokeOval(100,100,200,200);
        gc.strokeRect(0,200,50,200);
        gc.fillOval(0,0,20,20);
        gc.fillRect(100,320,300,40);

        gc.setFont(new Font(20));
        gc.fillText("This is drawn on the canvaas.",60,50);

        root.getChildren().addAll(canvas,btnchangecolor);

        stage.show();
    }
}
*/

public class drawing extends Application{
    GraphicsContext gc;
    Color[] colors = {Color.RED,Color.BLUE,Color.GREEN,Color.BLACK};
    int coloridx = 0;

    public void start(Stage stage){
        stage.setTitle("This is the title");
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        root.setAlignment(Pos.CENTER);

        Canvas canvas = new Canvas(400,400);
        gc = canvas.getGraphicsContext2D();

        Button btnChangeColor = new Button("Change Color");

        btnChangeColor.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                gc.setStroke(colors[coloridx]);
                gc.setFill(colors[coloridx]);
                gc.strokeLine(0,0,200,200);
                gc.fillText("This is drawn on the canvas",60,50);
                gc.fillRect(100,320,300,40);
                coloridx++;
                if(coloridx==colors.length) coloridx=0;
            }
        });

        gc.strokeLine(0,0,200,200);
        gc.strokeOval(100,100,200,200);
        gc.strokeRect(0,200,50,200);
        gc.fillOval(0,0,20,20);
        gc.fillRect(100,320,300,40);

        gc.setFont(new Font(20));
        gc.fillText("This is drawn on the canvas.",60,50);
        root.getChildren().addAll(canvas,btnChangeColor);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
