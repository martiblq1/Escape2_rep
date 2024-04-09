package wall_with_door_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Carpet
{
	private Rectangle bounds, floor;
	
	private int x;
	private short frames;
	private boolean centered, moving;
	
	Carpet()
	{
		bounds = new Rectangle((int)(1020*Assets.X_RATIO), (int)(916*Assets.Y_RATIO), (int)(144*Assets.X_RATIO), (int)(40*Assets.Y_RATIO));
		floor = new Rectangle((int)(400*Assets.X_RATIO), (int)(400*Assets.Y_RATIO), (int)(144*8*Assets.X_RATIO), (int)((40*8 + 50)*Assets.Y_RATIO));
		x = (int)(400*Assets.X_RATIO);
		frames = 0;
		centered = true;
		moving = false;
	}
	
	public void tick()
	{
		if(!moving) {return;}
		frames++;
		
		if(frames > 1)
		{
			frames = 0;
			return;
		}
		
		if(centered)
		{
			x -= (int)(40*Assets.X_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
		}
		
		if(x < (int)(-500*Assets.X_RATIO))
		{
			x = (int)(-500*Assets.X_RATIO);
			centered = false;
			moving = false;
			Launcher.game.get_window().get_panel().set_changed();
			return;
		}
		
		if(!centered)
		{
			x += (int)(40*Assets.X_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
		}
		
		if(x > (int)(400*Assets.X_RATIO))
		{
			x = (int)(400*Assets.X_RATIO);
			centered = true;
			moving = false;
			Launcher.game.get_window().get_panel().set_changed();
			return;
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DOOR:
			g.drawImage(Launcher.game.get_assets().carpet, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case WALL_WITH_DOOR_CARPET:
			g.drawImage(Launcher.game.get_assets().carpet, x, floor.y, floor.width, floor.height, null);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public Rectangle get_floor() {return floor;}
	public boolean get_moving() {return moving;}
	public void set_moving() {moving = true;}
}
