package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Drawers
{
	private Item knife;
	private Drawer_0 drawer_0;
	private Drawer_1 drawer_1;
	private Drawer_2 drawer_2;
	
	private Rectangle bounds;
	
	Drawers(Assets assets)
	{
		knife = new Item(Items.KNIFE, true, assets, -1);
		drawer_0 = new Drawer_0(assets);
		drawer_1 = new Drawer_1(assets);
		drawer_2 = new Drawer_2(assets);
		bounds = new Rectangle((int)(1480*Assets.X_RATIO), (int)(700*Assets.Y_RATIO), (int)(132*1.5*Assets.X_RATIO), (int)(170*1.5*Assets.Y_RATIO));
	}
	
	public void tick()
	{
		drawer_0.tick();
		drawer_1.tick();
		drawer_2.tick();
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED:
			g.drawImage(Launcher.game.get_assets().drawers_scene, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case WALL_WITH_BED_DRAWERS:
			g.drawImage(Launcher.game.get_assets().drawers_down_cover, (int)((1920/2 - 293 - 21)*Assets.X_RATIO), (int)(190*Assets.Y_RATIO), (int)(293*2*Assets.X_RATIO), (int)(438*2*Assets.Y_RATIO), null);
			drawer_2.render(g);
			drawer_1.render(g);
			drawer_0.render(g);
			g.drawImage(Launcher.game.get_assets().drawers_upper_cover, (int)(668*Assets.X_RATIO), (int)(32*Assets.Y_RATIO), (int)(542*Assets.X_RATIO), (int)(330*Assets.Y_RATIO), null);
			g.drawImage(Launcher.game.get_assets().drawers, (int)((1920/2 - 293 - 21)*Assets.X_RATIO), (int)(190*Assets.Y_RATIO), (int)(293*2*Assets.X_RATIO), (int)(438*2*Assets.Y_RATIO), null);
			
			if(knife != null)
			{
				knife.render(g);
			}
			
			break;
		
		case WALL_WITH_BED_DRAWERS_DRAWER:
			drawer_2.render(g);
			break;
			
		default:
			break;
		}
	}
	
	//getters and setters
	public Item get_knife()
	{
		return knife;
	}
	
	public void set_knife(Item item)
	{
		knife = item;
	}
	
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public Drawer_0 get_drawer_0()
	{
		return drawer_0;
	}
	
	public Drawer_1 get_drawer_1()
	{
		return drawer_1;
	}
	
	public Drawer_2 get_drawer_2()
	{
		return drawer_2;
	}
}
