package com.example.gomes.obstacles;

public class Obstacle
{
	public static int WIDTH = 50;
	public static int HEIGHT = 80;

	public double x;
	public double y;

	public Obstacle(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void update()
	{
		x = x-5;
	}
}