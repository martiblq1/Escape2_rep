package main;

import java.awt.Color;
import java.awt.Graphics;

public class Clicked
{
	private int radius, x, y, alpha;
	private boolean playing;
	
	Clicked()
	{
		radius = 0;
		alpha = 255;
		playing = false;
	}
	
	public void tick()
	{
		if(playing)
		{
			radius += 5;
			alpha -= 20;
		}
	}
	
	public void render(Graphics g)
	{
		if(playing && !Launcher.game.get_fade().get_fading())
		{	
			if(alpha < 0)
			{
				radius = 0;
				alpha = 255;
				playing = false;
			}
			
			g.setColor(new Color(255, 255, 255, alpha));
			g.drawOval((int)((x - radius/2)*Assets.X_RATIO), (int)((y - radius/2)*Assets.Y_RATIO), (int)(radius*Assets.X_RATIO), (int)(radius*Assets.Y_RATIO));
			
			for(int i = 0; i < 15; i++)
			{
				g.drawOval((int)((x - (radius - i)/2)*Assets.X_RATIO), (int)((y - (radius - i)/2)*Assets.Y_RATIO), (int)((radius - i)*Assets.X_RATIO), (int)((radius - i)*Assets.Y_RATIO));
			}
			
			Launcher.game.get_window().get_panel().set_changed();
			
			if(!playing)
			{
				Launcher.game.get_window().get_panel().set_changed();
			}
		}
	}
	
	//getters and setters
	public void set_playing(int x, int y)
	{
		this.x = x;
		this.y = y;
		radius = 0;
		alpha = 255;
		playing = true;
	}
}
