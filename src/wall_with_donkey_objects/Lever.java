package wall_with_donkey_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Lever
{
	private Rectangle bounds;
	
	private boolean in_place, switched;
	
	Lever()
	{
		bounds = new Rectangle((int)((1920/2 - 77 - 434 + 344*2)*Assets.X_RATIO), (int)((220 + 255*2)*Assets.Y_RATIO), (int)(24*2*Assets.X_RATIO), (int)(88*2*Assets.Y_RATIO));
		in_place = false;
		switched = false;
	}
	
	public void render(Graphics g)
	{
		if(!in_place) {return;}
		
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			if(switched)
			{
				g.drawImage(Launcher.game.get_assets().machine_lever_down, (int)((731 + 344)*Assets.X_RATIO), (int)((535 + 255 + 88 - 7)*Assets.Y_RATIO), (int)(24*Assets.X_RATIO), (int)(88*Assets.Y_RATIO), null);
				return;
			}
			
			g.drawImage(Launcher.game.get_assets().machine_lever, (int)((731 + 344)*Assets.X_RATIO), (int)((535 + 255)*Assets.Y_RATIO), (int)(24*Assets.X_RATIO), (int)(88*Assets.Y_RATIO), null);
			break;
		
		case WALL_WITH_DONKEY_MACHINE:
			if(switched)
			{
				g.drawImage(Launcher.game.get_assets().machine_lever_down, bounds.x, bounds.y + bounds.height - (int)(7*2*Assets.Y_RATIO), bounds.width, bounds.height, null);
				return;
			}
			
			g.drawImage(Launcher.game.get_assets().machine_lever, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_in_place() {return in_place;}
	public void set_in_place() {in_place = true;}
	public boolean get_switched() {return switched;}
	public void set_switched() {switched = true;}
}
