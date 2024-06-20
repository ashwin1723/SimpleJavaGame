package com.example.gomes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class practice extends Application{

    public static void main(String[] args){
    launch();
    }
    public void start(Stage stage) throws Exception{


        Group root = new Group();
        Scene scene = new Scene(root, Color.LIGHTSKYBLUE);
        Image icon = new Image("D:\\Users\\morvin\\Documents\\gomes\\src\\main\\java\\gg.jpg");
        stage.getIcons().add(icon);
        stage.setTitle("Stage Demo Program woot woot");
        stage.setWidth(600);
        stage.setHeight(600);
       // stage.setResizable(false);
        //stage.setX(50);
        //stage.setY(50);
/*
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("YOU CAN'T EXCAPE unless you press q");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
*/
        Text text = new Text();
        text.setText("WHOOOAAA");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.LIMEGREEN);

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        //line.setStroke
        line.setOpacity(0.5);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.BLUE);
        rectangle.setStroke(Color.BLACK);

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                200.0,200.0,
                300.0,300.0,
                200.0,300.0
            );
        triangle.setFill(Color.YELLOW);
        Circle circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);

        Image image = new Image("C:\\Users\\morvin\\Desktop\\angy.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(400);
        imageView.setY(400);


        root.getChildren().add(imageView);
        root.getChildren().add(rectangle);
        root.getChildren().add(line);
        root.getChildren().add(text);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        stage.setScene(scene);
        stage.show();
    }
}
