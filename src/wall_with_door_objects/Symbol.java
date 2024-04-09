package wall_with_door_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Symbol
{
	private Rectangle bounds;
	
	private short symbol;
	
	Symbol(int x)
	{
		bounds = new Rectangle(x, (int)((20 + 67*3)*Assets.Y_RATIO), (int)(44*3*Assets.X_RATIO), (int)(53*3*Assets.Y_RATIO));
		symbol = 0;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Launcher.game.get_assets().symbols[symbol], bounds.x, bounds.y, bounds.width, bounds.height, null);
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public short get_symbol() {return symbol;}
	
	public void set_symbol()
	{
		if(symbol == 9)
			symbol = 0;
		else
			symbol++;
		
		Launcher.game.get_window().get_panel().set_changed();
	}
}
