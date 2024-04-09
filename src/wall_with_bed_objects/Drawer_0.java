package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Drawer_0
{
	private Item gear;
	
	private Rectangle bounds;
	
	private int y;
	private boolean opening, opened;
	
	Drawer_0(Assets assets)
	{
		y = (int)(60*Assets.Y_RATIO);
		opening = false;
		opened = false;
		bounds = new Rectangle((int)(695*Assets.X_RATIO), y + (int)(154*2*Assets.Y_RATIO), (int)(244*2*Assets.X_RATIO), (int)(97*2*Assets.Y_RATIO));
		gear = new Item(Items.GEAR, true, assets, 0);
	}
	
	public void tick()
	{	
		if(opening)
		{	
			if(opened)
			{
				y -= (int)(10*Assets.Y_RATIO);
				
				if(gear != null) {gear.set_y(gear.get_bounds().y - (int)(10*Assets.Y_RATIO));}
				
				if(y < (int)(60*Assets.Y_RATIO))
				{
					if(gear != null) {gear.set_y(gear.get_bounds().y + (int)(10*Assets.Y_RATIO));}
					y = (int)(60*Assets.Y_RATIO);
					opening = false;
					opened = false;
					bounds = new Rectangle((int)(695*Assets.X_RATIO), y + (int)(154*2*Assets.Y_RATIO), (int)(244*2*Assets.X_RATIO), (int)(97*2*Assets.Y_RATIO));
				}
			}
			else
			{
				y += (int)(10*Assets.Y_RATIO);
				
				if(gear != null) {gear.set_y(gear.get_bounds().y + (int)(10*Assets.Y_RATIO));}
				
				if(y > (int)((60 + 250)*Assets.Y_RATIO))
				{
					if(gear != null) {gear.set_y(gear.get_bounds().y - (int)(10*Assets.Y_RATIO));}
					y = (int)((60 + 250)*Assets.Y_RATIO);
					opening = false;
					opened = true;
					bounds = new Rectangle((int)(695*Assets.X_RATIO), y + (int)(154*2*Assets.Y_RATIO), (int)(244*2*Assets.X_RATIO), (int)(97*2*Assets.Y_RATIO));
				}
			}
			
			Launcher.game.get_window().get_panel().set_changed();
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Launcher.game.get_assets().drawer_0, (int)(695*Assets.X_RATIO), y, (int)(244*2*Assets.X_RATIO), (int)(252*2*Assets.Y_RATIO), null);
		
		if(gear != null && (opened || opening))
		{
			gear.render(g);
		}
	}
	
	//getters and setters
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public boolean get_opened()
	{
		return opened;
	}
	
	public boolean get_opening()
	{
		return opening;
	}
	
	public void set_opening(boolean opening)
	{
		this.opening = opening;
	}

	public Item get_gear()
	{
		return gear;
	}
	
	public void set_gear(Item item)
	{
		gear = item;
	}
}
