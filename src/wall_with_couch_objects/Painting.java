package wall_with_couch_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Painting
{
	private Item tongue;
	
	private Rectangle bounds;
	private boolean unlocked, opened;
	
	Painting(Assets assets)
	{
		tongue = new Item(Items.TONGUE, true, assets, -1);
		bounds = new Rectangle((int)(425*Assets.X_RATIO), (int)(200*Assets.Y_RATIO), (int)(212*2*Assets.X_RATIO), (int)(135*2*Assets.Y_RATIO));
		unlocked = false;
		opened = false;
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH:
			bounds = new Rectangle((int)(425*Assets.X_RATIO), (int)(200*Assets.Y_RATIO), (int)(212*2*Assets.X_RATIO), (int)(135*2*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().painting_horiontal, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case WALL_WITH_COUCH_PAINTING:
			bounds = new Rectangle((int)(324*Assets.X_RATIO), (int)(135*Assets.Y_RATIO), (int)(212*6*Assets.X_RATIO), (int)(135*6*Assets.Y_RATIO));
			
			if(!opened)
			{
				g.drawImage(Launcher.game.get_assets().painting_horiontal, bounds.x, bounds.y, bounds.width, bounds.height, null);
				break;
			}
			
			g.drawImage(Launcher.game.get_assets().painting_horizontal_opened, (int)(324*Assets.X_RATIO), (int)((135 - 148*6)*Assets.Y_RATIO), (int)(212*6*Assets.X_RATIO), (int)(282*6*Assets.Y_RATIO), null);
			if(tongue != null) {tongue.render(g);}
			g.drawImage(Launcher.game.get_assets().jar_tongue, (int)((324 + 82*6)*Assets.X_RATIO), (int)((135 - 148*6 + 192*6)*Assets.Y_RATIO), (int)(47*6*Assets.X_RATIO), (int)(61*6*Assets.Y_RATIO), null);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_unlocked() {return unlocked;}
	public void set_unlocked() {unlocked = true;}
	public Item get_tongue() {return tongue;}
	public void set_tongue() {tongue = null;}
	
	public void set_opened()
	{
		if(opened)
			opened = false;
		else
			opened = true;
		
		Launcher.game.get_window().get_panel().set_changed();
	}
}
