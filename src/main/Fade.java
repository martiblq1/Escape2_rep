package main;

import java.awt.Color;
import java.awt.Graphics;

public class Fade
{
	private int alpha;
	private boolean fading;
	
	Fade()
	{
		alpha = 0;
		fading = false;
	}
	
	public void tick()
	{
		if(fading)
		{
			alpha += 20;
		}
	}
	
	public void render(Graphics g)
	{
		if(fading)
		{	
			if(alpha > 255)
			{
				alpha = 0;
				fading = false;
			}
			
			g.setColor(new Color(0, 0, 0, alpha));		
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			
			if(!fading)
			{
				Launcher.game.get_window().get_panel().set_changed();
			}
		}
	}
	
	//getters and setters
	public boolean get_fading()
	{
		return fading;
	}
	
	public void set_fading()
	{
		fading = true;
		alpha = 0;
	}
}
