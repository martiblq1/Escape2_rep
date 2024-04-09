package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Button
{
	private Rectangle bounds;
	
	private short id;
	private boolean pushed;
	
	Button(short id)
	{
		this.id = id;
		pushed = false;
		
		switch(id)
		{
		case 0:
		    bounds = new Rectangle((int) ((363 + (68 * 3)) * Assets.X_RATIO), (int) ((140 + (48 * 3) - (6 * 3)) * Assets.Y_RATIO), (int) (37 * 3 * Assets.X_RATIO), (int) (43 * 3 * Assets.Y_RATIO));
		    break;

		case 1:
		    bounds = new Rectangle((int) ((363 + (216 * 3)) * Assets.X_RATIO), (int) ((140 + (108 * 3) - (6 * 3)) * Assets.Y_RATIO), (int) (37 * 3 * Assets.X_RATIO), (int) (43 * 3 * Assets.Y_RATIO));
		    break;

		case 2:
		    bounds = new Rectangle((int) ((363 + (137 * 3)) * Assets.X_RATIO), (int) ((140 + (108 * 3) - (6 * 3)) * Assets.Y_RATIO), (int) (37 * 3 * Assets.X_RATIO), (int) (43 * 3 * Assets.Y_RATIO));
		    break;

		case 3:
		    bounds = new Rectangle((int) ((363 + (285 * 3)) * Assets.X_RATIO), (int) ((140 + (48 * 3) - (6 * 3)) * Assets.Y_RATIO), (int) (37 * 3 * Assets.X_RATIO), (int) (43 * 3 * Assets.Y_RATIO));
		    break;

		case 4:
		    bounds = new Rectangle((int) ((363 + (68 * 3)) * Assets.X_RATIO), (int) ((140 + (108 * 3) - (6 * 3)) * Assets.Y_RATIO), (int) (37 * 3 * Assets.X_RATIO), (int) (43 * 3 * Assets.Y_RATIO));
		    break;

		case 5:
		    bounds = new Rectangle((int) ((363 + (137 * 3)) * Assets.X_RATIO), (int) ((140 + (48 * 3) - (6 * 3)) * Assets.Y_RATIO), (int) (37 * 3 * Assets.X_RATIO), (int) (43 * 3 * Assets.Y_RATIO));
		    break;

		case 6:
		    bounds = new Rectangle((int) ((363 + (216 * 3)) * Assets.X_RATIO), (int) ((140 + (48 * 3) - (6 * 3)) * Assets.Y_RATIO), (int) (37 * 3 * Assets.X_RATIO), (int) (43 * 3 * Assets.Y_RATIO));
		    break;

		case 7:
		    bounds = new Rectangle((int) ((363 + (285 * 3)) * Assets.X_RATIO), (int) ((140 + (108 * 3) - (6 * 3)) * Assets.Y_RATIO), (int) (37 * 3 * Assets.X_RATIO), (int) (43 * 3 * Assets.Y_RATIO));
		    break;
			
		default: break;
		}
	}
	
	public void render(Graphics g)
	{
		if(pushed)
			g.drawImage(Launcher.game.get_assets().shelf_buttons_pushed[id], bounds.x, bounds.y + (int)(6*3*Assets.Y_RATIO), (int)(37*3*Assets.X_RATIO), (int)(37*3*Assets.Y_RATIO), null);
		else
			g.drawImage(Launcher.game.get_assets().shelf_buttons_unpushed[id], bounds.x, bounds.y, bounds.width, bounds.height, null);
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_pushed() {return pushed;}
	public void set_pushed(boolean pushed) {this.pushed = pushed;}
}
