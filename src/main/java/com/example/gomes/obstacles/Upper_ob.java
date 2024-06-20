package com.example.gomes.obstacles;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;

public class Upper_ob extends Obstacle
{
	public Upper_ob()
	{
		super(950,420);
	}

	public void draw(GraphicsContext gc)
	{
		Image image = new Image("D:/code/java/gomes/src/main/java/com/example/gomes/obstacles/pterodactyl.png");
		gc.drawImage(image, x, y, WIDTH, HEIGHT);
	}
}