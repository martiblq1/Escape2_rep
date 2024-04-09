package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Inventory_box
{	
	private Item item;
	
	private Rectangle bounds;

	private boolean empty, selected;
	
	Inventory_box(int y)
	{
		item = new Item();
		bounds = new Rectangle((int)((1920-77*2)*Assets.X_RATIO), (int)(y*Assets.Y_RATIO), (int)(77*2*Assets.X_RATIO), (int)(77*2*Assets.Y_RATIO));
		empty = true;
		selected = false;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Launcher.game.get_assets().inventory_box, bounds.x, bounds.y, bounds.width, bounds.height, null);
		
		if(selected)
		{
			g.setColor(Color.WHITE);
			g.fillRect(bounds.x + (int)(5*2*Assets.X_RATIO), bounds.y + (int)(5*2*Assets.Y_RATIO), bounds.width - (int)(5*2*2*Assets.X_RATIO), bounds.height - (int)(5*2*2*Assets.Y_RATIO));
		}
		
		if(!empty)
		{
			item.render(g);
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
	
	public boolean get_empty()
	{
		return empty;
	}
	
	public void set_empty(boolean empty)
	{
		this.empty = empty;
	}
	
	public boolean get_selected()
	{
		return selected;
	}
	
	public void set_selected(boolean selected)
	{
		this.selected = selected;
	}
}
