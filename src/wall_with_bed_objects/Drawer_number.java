package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Drawer_number
{
	private Rectangle bounds;
	
	private int number, x, y;
	
	Drawer_number(int x, int y)
	{
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x + (int)(87*Assets.X_RATIO), y + (int)(79*Assets.Y_RATIO), (int)(70*Assets.X_RATIO), (int)(94*Assets.Y_RATIO));
		number = 0;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Launcher.game.get_assets().drawer_numbers[number], x, y, (int)(31*7.9*Assets.X_RATIO), (int)(32*7.9*Assets.Y_RATIO), null);
	}
	
	//getters and setters
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public int get_number()
	{
		return number;
	}
	
	public void set_number()
	{
		if(number == 9)
		{
			number = 0;
		}
		else
		{
			number++;
		}
	}
}