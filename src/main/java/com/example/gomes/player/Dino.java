package player;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;

public class Dino
{
	public static int WIDTH = 100;
	public static int HEIGHT = 100;

	static double GRAVITY = 1.2;
	static double JUMP_STRENGTH = -25;

	public double x;
	public double y;
	double vy;
	boolean jumping = false;

	public Dino(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void jump()
	{
		if(!jumping)
		{
			vy = JUMP_STRENGTH;
			jumping = true;
		}
	}

	public void update()
	{
		vy = vy + GRAVITY;
		y = y + vy;

		if(y>=HEIGHT+500)
		{
			y = HEIGHT+500;
			vy = 0;
			jumping = false;
		}
	}

	public void draw(GraphicsContext gc)
	{
		Image image = new Image("D:/code/java/gomes/src/main/java/com/example/gomes/player/dino.png");
		gc.drawImage(image, x, y, WIDTH, HEIGHT);
	}
}