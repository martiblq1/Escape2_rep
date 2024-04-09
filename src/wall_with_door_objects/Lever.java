package wall_with_door_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Lever
{
	private Rectangle bounds;
	
	private boolean pulled;
	
	Lever()
	{
		bounds = new Rectangle((int)((324 + 75*6)*Assets.X_RATIO), (int)((135 - 148*6 + 187*6)*Assets.Y_RATIO), (int)(62*6*Assets.X_RATIO), (int)(28*6*Assets.Y_RATIO));
		pulled = false;
	}
	
	public void render(Graphics g)
	{
		if(!pulled)
			g.drawImage(Launcher.game.get_assets().lever, bounds.x, bounds.y, bounds.width, bounds.height, null);
		else
			g.drawImage(Launcher.game.get_assets().lever_down, (int)((324 + 75*6)*Assets.X_RATIO), (int)((135 - 148*6 + 211*6)*Assets.Y_RATIO), (int)(62*6*Assets.X_RATIO), (int)(28*6*Assets.Y_RATIO), null);
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_pulled() {return pulled;}
	public void set_pulled() {pulled = true;}
}
