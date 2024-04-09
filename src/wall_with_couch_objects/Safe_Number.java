package wall_with_couch_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Safe_Number
{
	private Rectangle bounds;
	
	private int number;
	
	Safe_Number(int x, int y)
	{
		bounds = new Rectangle(x, y, (int)(42*3*Assets.X_RATIO), (int)(42*3*Assets.Y_RATIO));
		number = 0;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Launcher.game.get_assets().safe_wall_with_couch_numbers[number], bounds.x, bounds.y, bounds.width, bounds.height, null);
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
