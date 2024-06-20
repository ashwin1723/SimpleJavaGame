package com.example.gomes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 400;

    private List<Obstacle> obstacles = new ArrayList<>();
    private Dino dino;
    private Random random = new Random();
    private int score = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        dino = new Dino(40,   300);

        root.getChildren().add(canvas);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case SPACE:
                    dino.jump();
                    break;
            }
        });

        primaryStage.setTitle("Dino Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Game loop
        new AnimationTimer() {
            long lastTime = 0;

            @Override
            public void handle(long now) {
                if (now - lastTime >= 16_000_000) {
                    update();
                    draw(gc);
                    lastTime = now;
                }
            }
        }.start();
    }

    private void update() {
        dino.update();

        // Generate obstacles
        if (random.nextInt(150) < 2 ) {
            obstacles.add(new Obstacle(WIDTH, HEIGHT - 50));
        }

        // Update and remove off-screen obstacles
        List<Obstacle> obstaclesToRemove = new ArrayList<>();
        for (Obstacle obstacle : obstacles) {
            obstacle.update();
            if (obstacle.getX() < -Obstacle.WIDTH) {
                obstaclesToRemove.add(obstacle);
            }
        }
        obstacles.removeAll(obstaclesToRemove);

        // Check for collisions
        for (Obstacle obstacle : obstacles) {
            if (dino.intersects(obstacle)) {
                System.out.println("Game Over! Score: " + score);
                System.exit(0);
            }
        }

        score++;
    }

    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        dino.draw(gc);

        for (Obstacle obstacle : obstacles) {
            obstacle.draw(gc);
        }
    }

    public static class Dino {
        private static final int WIDTH = 30;
        private static final int HEIGHT = 30;
        private static final double GRAVITY = 1.0;
        private static final double JUMP_STRENGTH = -15;

        private double x;
        private double y;
        private double vy;
        private boolean jumping = false;

        public Dino(double x, double y) {
           this.x = x;
           this.y = y;
        }

        public void jump() {
            if (!jumping) {
                vy = JUMP_STRENGTH;
                jumping = true;
            }
        }

        public void update() {
            vy += GRAVITY;
            y += vy;

            if (y >= HEIGHT+ 330) {
                y = HEIGHT + 330;
                vy = 0;
                jumping = false;
            }
        }

        public void draw(GraphicsContext gc) {
            gc.setFill(Color.BLACK);
            gc.fillRect(x, y, WIDTH, HEIGHT);
        }

        public boolean intersects(Obstacle obstacle) {
            return x + WIDTH > obstacle.getX() && x < obstacle.getX() + Obstacle.WIDTH &&
                    y + HEIGHT > obstacle.getY();
        }
    }

    public static class Obstacle {
        private static final int WIDTH = 20;
        private static final int HEIGHT = 40;
        private double x;
        private double y;

        public Obstacle(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void update() {
            x -= 5;
        }

        public void draw(GraphicsContext gc) {
            gc.setFill(Color.GREEN);
            gc.fillRect(x, y, WIDTH, HEIGHT);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}

/*
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloApplication extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;

    private List<Obstacle> obstacles = new ArrayList<>();
    private Dino dino;
    private Random random = new Random();
    private int score = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        dino = new Dino(WIDTH / 2, HEIGHT);

        root.getChildren().add(canvas);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case SPACE:
                    dino.jump();
                    break;
            }
        });

        primaryStage.setTitle("Dino Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Game loop
        new AnimationTimer() {
            long lastTime = 0;

            @Override
            public void handle(long now) {
                if (now - lastTime >= 16_000_000) {
                    update();
                    draw(gc);
                    lastTime = now;
                }
            }
        }.start();
    }

    private void update() {
        dino.update();

        // Generate obstacles
        if (random.nextInt(100) < 2) {
            obstacles.add(new Obstacle(WIDTH, HEIGHT - 50 ));//- random.nextInt(100)));
        }

        // Update and remove off-screen obstacles
        List<Obstacle> obstaclesToRemove = new ArrayList<>();
        for (Obstacle obstacle : obstacles) {
            obstacle.update();
            if (obstacle.getX() < -obstacle.getWidth()) {
                obstaclesToRemove.add(obstacle);
            }
        }
        obstacles.removeAll(obstaclesToRemove);

        // Check for collisions
        for (Obstacle obstacle : obstacles) {
            if (dino.intersects(obstacle)) {
                System.out.println("Game Over! Score: " + score);
                System.exit(0);
            }
        }

        score++;
    }

    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        dino.draw(gc);

        for (Obstacle obstacle : obstacles) {
            obstacle.draw(gc);
        }
    }

    public static class Dino {
        private static final int WIDTH = 30;
        private static final int HEIGHT = 30;
        private static final double GRAVITY = 0.8;
        private static final double JUMP_STRENGTH = -15;

        private double x;
        private double y;
        private double vy;

        public Dino(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void jump() {
            if (y == HEIGHT - 50) {
                vy = JUMP_STRENGTH;
            }
        }

        public void update() {
            vy += GRAVITY;
            y += vy;

            if (y >= HEIGHT - 50) {
                y = HEIGHT - 50;
                vy = 0;
            }
        }

        public void draw(GraphicsContext gc) {
            gc.setFill(Color.BLACK);
            //gc.fillRect(x, y, WIDTH, HEIGHT);
            gc.fillRect(x, y, WIDTH, HEIGHT);
        }

        public boolean intersects(Obstacle obstacle) {
            return x + WIDTH > obstacle.getX() && x < obstacle.getX() + obstacle.getWidth() &&
                    y + HEIGHT > obstacle.getY();
        }
    }

    public static class Obstacle {
        private static final int WIDTH = 20;
        private static final int HEIGHT = 40;
        private double x;
        private double y;

        public Obstacle(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void update() {
            x -= 5;
        }

        public void draw(GraphicsContext gc) {
            gc.setFill(Color.GREEN);
            gc.fillRect(x, y, WIDTH, HEIGHT);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getWidth() {
            return WIDTH;
        }
    }
}

/*
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}*/
