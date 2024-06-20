package com.example;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.animation.*;
import javafx.scene.image.*;
import javafx.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import player.Dino;
import com.example.gomes.obstacles.Lower_ob;
import com.example.gomes.obstacles.Upper_ob;

public class App extends Application
{
	public static void main(String args[])
	{
		launch(args);
	}
	private MediaPlayer mediaPlayer;

	public void start(Stage mystage)
	{
		//bkg bk = new bkg();
		//bk.start(mystage);
		String audioFilePath = "D:\\code\\java\\gomes\\demon.mp3";

		Media media = new Media("file:///" + audioFilePath.replace("\\", "/"));
		mediaPlayer = new MediaPlayer(media);

		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

		Thread BThread = new Thread(() -> mediaPlayer.play());
		//BThread.setDaemon(true);
		BThread.start();
		Screen sc = new Screen(mystage);
	}
}



class Start extends Exception
{
	public String toString()
	{
		return "Starting game...";
	}
}

class End extends Exception
{
	public String toString()
	{
		return "Game Over!";
	}
}

class Restart extends Exception
{
	public String toString()
	{
		return "Restarting...";
	}
}



interface Scenes
{
	void starting();
	void playing();
	void ending();
}



class Screen implements Scenes
{
	Stage stage;
	
	static int WIDTH = 1000;
	static int HEIGHT = 1000;
	Dino dino = new Dino(40,600);
	List<Lower_ob> lower = new ArrayList<>();
	List<Upper_ob> upper = new ArrayList<>();
	AnimationTimer animation;
	int score = 0;
	Random random = new Random();
	int time = random.nextInt((200-100) + 1)+100;
	int flag = 0;
	Label scores = new Label("Score: "+score);

	Screen(Stage stage)
	{
		this.stage = stage;
		this.stage.setTitle("Java Dash");
		this.stage.show();
		this.starting();
	}



	public void starting()
	{
		FlowPane root = new FlowPane(Orientation.VERTICAL,10,10);
		root.setStyle("-fx-background-color: #ADD8E6;");
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, WIDTH, HEIGHT);

		Canvas canvas = new Canvas(WIDTH, 400);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image image = new Image("D:/code/java/gomes/src/main/java/com/example/gomes/Java_Dash.png");
		gc.drawImage(image, 300, 100, 400, 150);

		Label load = new Label("");
		load.setFont(new Font(15));
		load.setTextFill(Color.BLACK);
		load.setTranslateX(450);
		load.setTranslateY(-100);

		Button b = new Button();
		b.setTranslateX(400);
		b.setTranslateY(-100);

		Image b_image = new Image("D:/code/java/gomes/src/main/java/com/example/gomes/Start.png");
		ImageView imageView = new ImageView(b_image);
		imageView.setFitWidth(200);
		imageView.setFitHeight(100);
		b.setGraphic(imageView);
		b.setStyle("-fx-background-color: transparent;");

		root.getChildren().addAll(canvas,b,load);
		
		b.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent ae)
			{
				PauseTransition pause = new PauseTransition(Duration.seconds(1));
				
				try
				{
					throw new Start();
				}
				catch(Start e)
				{
					load.setText(e.toString());
					pause.setOnFinished(event -> {
						playing();
					});
				}
				

				pause.play();
			}
		});

		stage.setScene(scene);
	}



	public void playing()
	{
		score = 0;

		Pane root = new Pane();
		root.setStyle("-fx-background-color: #ADD8E6;");

		Scene scene = new Scene(root, WIDTH, HEIGHT);

		scores.setFont(new Font(20));
		scores.setStyle("-fx-font-family:'Jokerman'");
		scores.setTextFill(Color.BLACK);
		scores.setLayoutX(850);
		scores.setLayoutY(50);

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		root.getChildren().addAll(canvas,scores);

		stage.setScene(scene);

		scene.setOnKeyPressed(e->
		{
			switch (e.getCode())
			{
				case SPACE: dino.jump();
							break;
			}
		});

		animation = new AnimationTimer()
		{
			long last = 0;
			public void handle(long now)
			{
				if(now - last >= 5_000_000)
				{
					update();
					draw(gc);
					last = now;
				}
			}
		};
		animation.start();
	}



	public void update()
	{
		scores.setText("Score: "+score);
		
		dino.update();

		if(flag == time)
		{
			int choose = random.nextInt(2);
			if(choose==0)
				lower.add(new Lower_ob());
			else
				upper.add(new Upper_ob());
			time = random.nextInt((200-100)+1)+70;
			flag = 0;
		}

		for(Lower_ob ob: lower)
		{
			ob.update();
			if(ob.x < 0)
				lower.remove(ob);
		}

		for(Upper_ob ob: upper)
		{
			ob.update();
			if(ob.x < 0)
				upper.remove(ob);
		}

		for(Lower_ob ob: lower)
		{
			try
			{
				if(intersects_lower(dino, ob))
				{
					throw new End();
				}
			}
			catch(End e)
			{
				ending();
			}
		}

		for(Upper_ob ob: upper)
		{
			try
			{
				if(intersects_upper(dino, ob))
					throw new End();
			}
			catch(End e)
			{
				ending();
			}
		}
		
		score++;
		flag++;
	}

	

	public void draw(GraphicsContext gc)
	{
		gc.clearRect(0, 0, WIDTH, HEIGHT);

		Image image = new Image("D:/code/java/gomes/src/main/java/com/example/gomes/cloud.png");
		gc.drawImage(image, 200, 250, 70, 50);
		gc.drawImage(image, 500, 250, 70, 50);
		gc.drawImage(image, 800, 250, 70, 50);

		gc.setStroke(Color.BROWN);
		gc.setLineWidth(3.0);
		gc.strokeLine(30,700,970,700);

		dino.draw(gc);
		for(Lower_ob ob: lower)
			ob.draw(gc);
		for(Upper_ob ob: upper)
			ob.draw(gc);

	}



	public boolean intersects_lower(Dino dino, Lower_ob ob)
	{
		return dino.x+dino.WIDTH > ob.x && dino.x < ob.x+ob.WIDTH && dino.y+dino.HEIGHT > ob.y;
	}



	public boolean intersects_upper(Dino dino, Upper_ob ob)
	{
		return dino.x+dino.WIDTH > ob.x && dino.x < ob.x+ob.WIDTH && dino.y+dino.HEIGHT < ob.y+ob.HEIGHT;
	}



	public void ending()
	{
		animation.stop();

		lower.removeAll(lower);
		upper.removeAll(upper);

		FlowPane root = new FlowPane(Orientation.VERTICAL,10,10);
		root.setStyle("-fx-background-color: #ADD8E6;");
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, WIDTH, HEIGHT);

		Canvas canvas = new Canvas(WIDTH, 400);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image image = new Image("D:/code/java/gomes/src/main/java/com/example/gomes/Game_Over.png");
		gc.drawImage(image, 270, 75, 470, 275);

		Label sc = new Label("Score: "+score);
		sc.setFont(new Font(50));
		sc.setTextFill(Color.BLACK);
		sc.setTranslateX(360);
		sc.setTranslateY(-120);

		Label load = new Label("");
		load.setFont(new Font(15));
		load.setTextFill(Color.BLACK);
		load.setTranslateX(470);
		load.setTranslateY(-100);

		Button b = new Button();
		b.setTranslateX(380);
		b.setTranslateY(-100);

		Image b_image = new Image("D:/code/java/gomes/src/main/java/com/example/gomes/Restart.png");
		ImageView imageView = new ImageView(b_image);
		imageView.setFitWidth(200);
		imageView.setFitHeight(100);
		b.setGraphic(imageView);
		b.setStyle("-fx-background-color: transparent;");

		root.getChildren().addAll(canvas,sc,b,load);
		
		b.setOnAction(new EventHandler<ActionEvent> ()
		{
			public void handle(ActionEvent ae)
			{
				PauseTransition pause = new PauseTransition(Duration.seconds(1));
				
				try
				{
					throw new Restart();
				}
				catch(Restart e)
				{
					load.setText(e.toString());
					pause.setOnFinished(event -> {
						playing();
					});
				}
				

				pause.play();
			}
		});

		stage.setScene(scene);
	}
}