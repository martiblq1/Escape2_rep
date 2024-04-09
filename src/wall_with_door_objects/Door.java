package wall_with_door_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Door
{
	private Rectangle bounds;
	
	private boolean locked, opened;
	
	Door()
	{
		bounds = new Rectangle((int)(283*Assets.X_RATIO), (int)(214*Assets.Y_RATIO), (int)(379*Assets.X_RATIO), (int)(693*Assets.Y_RATIO));
		locked = true;
		opened = false;
	}
	
	public void render(Graphics g)
	{
		if(!opened) {g.drawImage(Launcher.game.get_assets().door, bounds.x, bounds.y, bounds.width, bounds.height, null);}
		
		if(locked)
			g.drawImage(Launcher.game.get_assets().door_lock, (int)((283 + 280)*Assets.X_RATIO), (int)((214 + 76)*Assets.Y_RATIO), (int)(234*Assets.X_RATIO), (int)(69*Assets.Y_RATIO), null);
		else
			g.drawImage(Launcher.game.get_assets().door_lock_unlocked, (int)((283 + 280)*Assets.X_RATIO), (int)((214 + 76)*Assets.Y_RATIO), (int)(234*Assets.X_RATIO), (int)(69*Assets.Y_RATIO), null);
	
		if(opened) {g.drawImage(Launcher.game.get_assets().door_opened, bounds.x, bounds.y, bounds.width, bounds.height, null);}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_locked() {return locked;}
	public void set_locked() {locked = false;}
	
	public void set_opened()
	{
		opened = true;
		bounds = new Rectangle((int)((283 - 212)*Assets.X_RATIO), (int)(214*Assets.Y_RATIO), (int)(592*Assets.X_RATIO), (int)(693*Assets.Y_RATIO));
	}
	
	public boolean get_opened() {return opened;}
}
