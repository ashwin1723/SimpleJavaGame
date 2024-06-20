package com.example.gomes.obstacles;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;

public class Lower_ob extends Obstacle
{
	public Lower_ob()
	{
		super(950,620);
	}

	public void draw(GraphicsContext gc)
	{
		Image image = new Image("D:/code/java/gomes/src/main/java/com/example/gomes/obstacles/cactus.png");
		gc.drawImage(image, x, y, WIDTH, HEIGHT);
	}
}