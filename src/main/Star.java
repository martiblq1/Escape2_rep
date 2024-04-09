package main;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

public final class Star
{
	//FIELDS------------------------
	//oracle classes
	private static Graphics2D g2d;
	
	//data types
	private static boolean on_screen;
	private static final float CHANGE = 0.005f;
	private static float alpha = 1;
	
	//METHODS-----------------------
	//static
	public static void tick()
	{
		if(!on_screen) {return;}
		
		if(alpha < CHANGE)
		{
			alpha = 1;
			on_screen = false;
		}
		
		if(alpha > 0) {alpha -= CHANGE;}
		Launcher.game.get_window().get_panel().set_changed();
	}
	
	public static void render(Graphics g)
	{
		if(!on_screen) {return;}
		if(g2d == null) {g2d = (Graphics2D) g.create();}
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.drawImage(Assets.star, 0, 0, (int)(97*Assets.X_RATIO), (int)(102*Assets.Y_RATIO), null);
	}
	
	//setters
	public static void set_on_screen() {on_screen = true;}
}