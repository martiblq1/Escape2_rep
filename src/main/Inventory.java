package main;

import java.awt.Graphics;

public class Inventory
{
	private Inventory_box[] items;
	
	private int selected;
	private boolean visible;
	
	Inventory()
	{
		items = new Inventory_box[14];
		items[0] = new Inventory_box(0);
		selected = -1;
		visible = true;
		
		for(int i = 1; i < items.length; i++)
		{
			items[i] = new Inventory_box(i*77*2-1*2);
		}
	}
	
	public void render(Graphics g)
	{
		if(visible)
		{
			for(Inventory_box box : items)
			{
				box.render(g);
			}
		}
	}
	
	public void add_item(Item item)
	{
		for(Inventory_box box : items)
		{
			if(box.get_empty())
			{
				box.set_item(item);
				box.set_empty(false);
				Audio.play_item_click();
				break;
			}
		}
	}
	
	public void change_selected(int index)
	{
		if(index == selected)
		{
			items[index].set_selected(false);
			selected = -1;
		}
		else if(selected == -1)
		{
			items[index].set_selected(true);
			selected = index;
		}
		else if(index != selected && selected != -1)
		{	
			items[selected].set_selected(false);
			
			if(!items[selected].get_empty() && items[index].get_empty())
			{
				items[index].set_item(new Item(items[selected].get_item().get_item(), false, Launcher.game.get_assets(), items[index].get_bounds().y));
				items[index].set_empty(false);
				items[selected].set_item(null);
				items[selected].set_empty(true);
				selected = -1;
				Audio.play_item_click();
			}
			else
			{
				items[index].set_selected(true);
				selected = index;
			}
		}
	}
	
	//getters and setters
	public Inventory_box[] get_inventory_boxes()
	{
		return items;
	}
	
	public int get_selected()
	{
		return selected;
	}
	
	public void set_selected(int selected)
	{
		this.selected = selected;
	}
	
	public boolean get_visible()
	{
		return visible;
	}
	
	public void set_visible()
	{
		if(visible)
		{
			visible = false;
		}
		else
		{
			visible = true;
		}
	}
}
