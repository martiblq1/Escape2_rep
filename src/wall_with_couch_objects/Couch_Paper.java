package wall_with_couch_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

enum Opened
{
	OPEN,
	FOLDED
}

public class Couch_Paper
{
	private Rectangle bounds;
	
	private Opened state;
	
	private boolean checked;
	
	Couch_Paper()
	{
		bounds = new Rectangle((int)(500*Assets.X_RATIO), (int)(100*Assets.Y_RATIO), (int)(420*2*Assets.X_RATIO), (int)(500*2*Assets.Y_RATIO));
		state = Opened.FOLDED;
		checked = false;
	}
	
	public void render(Graphics g)
	{
		if(state == Opened.FOLDED)
		{
			g.drawImage(Launcher.game.get_assets().paper_3_folded, bounds.x, bounds.y, bounds.width, bounds.height, null);
		}
		else
		{
			g.drawImage(Launcher.game.get_assets().paper_3, bounds.x, bounds.y, bounds.width, bounds.height, null);
		}
	}
	
	//getters and setters
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public void set_folded()
	{
		if(state == Opened.FOLDED)
		{
			state = Opened.OPEN;
		}
		else
		{
			state = Opened.FOLDED;
		}
	}
	
	public boolean get_checked() {return checked;}
	public void set_checked() {checked = true;}
}
