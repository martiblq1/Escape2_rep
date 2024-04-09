package wall_with_couch_objects;

import java.awt.Graphics;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Jars_Safe
{
	private Item key;
	
	private boolean opened;
	
	Jars_Safe(Assets assets)
	{
		key = new Item(Items.KEY_DOOR, true, assets, -1);
		opened = false;
	}
	
	public void render(Graphics g)
	{
		if(!opened)
		{
			g.drawImage(Launcher.game.get_assets().safe_jars_closed, 0, (int)(-100*Assets.Y_RATIO), (int)(266*2*Assets.X_RATIO), (int)(282*2*Assets.Y_RATIO), null);
		}
		else
		{
			g.drawImage(Launcher.game.get_assets().safe_jars_opened, 0, (int)(-100*Assets.Y_RATIO), (int)(266*2*Assets.X_RATIO), (int)(282*2*Assets.Y_RATIO), null);
			if(key != null) {key.render(g);}
		}
	}
	
	//getters and setters
	public Item get_key() {return key;}
	public void set_key() {key = null;}
	public boolean get_opened() {return opened;}
	public void set_opened() {opened = true;}
}
