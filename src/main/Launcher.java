package main;

public class Launcher
{
	public static Game game;
	
	public static void main(String[] args)
	{
		game = new Game();
		game.start(); //start the thread
	}
	
	public static void reset()
	{
		game.reset();
	}
}
