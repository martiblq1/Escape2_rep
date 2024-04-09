package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Bed
{
	private Item item;
	
	private Rectangle bounds;
	
	private int pillow_y;
	private boolean going_up;
	
	Bed(Assets assets)
	{
		item = new Item(Items.KEY_SHELF_CABINET_0, true, assets, -1);
		pillow_y = (int)(5*Assets.Y_RATIO);
		going_up = false;
	}
	
	public void tick()
	{
		if(pillow_y > (int)(-500*Assets.Y_RATIO) && going_up)
		{
			pillow_y -= (int)(20*Assets.Y_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
		}
		else
		{
			going_up = false;
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED:
			bounds = new Rectangle((int)(750*Assets.X_RATIO), (int)(655*Assets.Y_RATIO), (int)(345*2*Assets.X_RATIO), (int)(146*2*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().bed, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
		
		case WALL_WITH_BED_BED:
			bounds = new Rectangle((int)(407*Assets.X_RATIO), pillow_y, (int)(553*2*Assets.X_RATIO), (int)(309*2*Assets.Y_RATIO));
			
			if(item != null)
			{
				item.render(g);
			}
			
			g.drawImage(Launcher.game.get_assets().pillow, bounds.x, bounds.y, bounds.width, bounds.height, null);
			g.drawImage(Launcher.game.get_assets().bed_line, 0, (int)(660*Assets.Y_RATIO), (int)(1920*Assets.X_RATIO), (int)(10*Assets.Y_RATIO), null);
			break;
			
		default:
			break;
		}
	}
	
	//getters and setters
	public Item get_item()
	{
		return item;
	}
	
	public void set_item(Item item)
	{
		this.item = item;
	}
	
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public void set_pillow_y()
	{
		pillow_y = 5;
	}
	
	public void set_going_up(boolean going_up)
	{
		this.going_up = going_up;
	}
}
