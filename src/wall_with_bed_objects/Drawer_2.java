package wall_with_bed_objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Audio;
import main.Item;
import main.Items;
import main.Launcher;
import main.Scene;
import main.Star;
import menus.Home_menu;

public class Drawer_2
{
	private Drawer_number[] numbers;
	private Item rose;
	
	private Rectangle bounds;
	
	private int y;
	private boolean opened, opening;
	
	Drawer_2(Assets assets)
	{
		numbers = new Drawer_number[4];
		y = (int)((60 + 97*4)*Assets.Y_RATIO);
		opened = false;
		opening = false;
		bounds = new Rectangle((int)(695*Assets.X_RATIO), y + (int)(154*2*Assets.Y_RATIO), (int)(244*2*Assets.X_RATIO), (int)(97*2*Assets.Y_RATIO));
		numbers[0] = new Drawer_number((int)(338*Assets.X_RATIO), (int)(453*Assets.Y_RATIO));
		numbers[1] = new Drawer_number((int)(228*Assets.X_RATIO), (int)(571*Assets.Y_RATIO));
		numbers[2] = new Drawer_number((int)(448*Assets.X_RATIO), (int)(571*Assets.Y_RATIO));
		numbers[3] = new Drawer_number((int)(338*Assets.X_RATIO), (int)(680*Assets.Y_RATIO));
		rose = new Item(Items.ROSE, true, assets, -1);
	}
	
	public void tick()
	{
		if(!opened && !opening)
		{
			check();
		}
		else if(!opened && opening && !Launcher.game.get_fade().get_fading())
		{
			y += (int)(10*Assets.Y_RATIO);
			rose.set_y(rose.get_bounds().y + (int)(10*Assets.Y_RATIO));
			
			if(y > (int)((60 + 250 + 100*4)*Assets.Y_RATIO))
			{
				rose.set_y(rose.get_bounds().y - (int)(10*Assets.Y_RATIO));
				y = (int)((60 + 250 + 100*4)*Assets.Y_RATIO);
				opening = false;
				opened = true;
			}
			
			Launcher.game.get_window().get_panel().set_changed();
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED_DRAWERS:
			g.drawImage(Launcher.game.get_assets().drawer_2, (int)(695*Assets.X_RATIO), y, (int)(244*2*Assets.X_RATIO), (int)(252*2*Assets.Y_RATIO), null);
			
			if((opened || opening) && rose != null)
			{
				rose.render(g);
			}
			
			break;
		
		case WALL_WITH_BED_DRAWERS_DRAWER:
			g.drawImage(Launcher.game.get_assets().drawer_2, 0, (int)(-920*Assets.Y_RATIO), (int)(1920*Assets.X_RATIO), (int)(2000*Assets.Y_RATIO), null);
			g.drawImage(Launcher.game.get_assets().drawer_1, 0, (int)(-1680*Assets.Y_RATIO), (int)(1920*Assets.X_RATIO), (int)(2000*Assets.Y_RATIO), null);
			g.setColor(new Color(127, 96, 71));
			g.fillRect((int)(200*Assets.X_RATIO), (int)(440*Assets.Y_RATIO), (int)(550*Assets.X_RATIO), (int)(550*Assets.Y_RATIO));
			
			for(int i = 0; i < 4; i++)
			{
				numbers[i].render(g);
			}
			
			break;
			
		default:
			break;
		}
	}
	
	private void check()
	{
		if(numbers[0].get_number() == 1 && numbers[1].get_number() == 8 && numbers[2].get_number() == 3 && numbers[3].get_number() == 2)
		{
			Launcher.game.get_fade().set_fading();
			opening = true;
			Launcher.game.set_scene(Scene.WALL_WITH_BED_DRAWERS);
			Audio.play_drawer_open();
			
			if(Home_menu.earned[4] == 0)
			{
				Home_menu.write_file(5, "1");
				Audio.play_achievement();
				Star.set_on_screen();
			}
		}
	}
	
	//getters and setters
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public Drawer_number[] get_numbers()
	{
		return numbers;
	}
	
	public boolean get_opened()
	{
		return opened;
	}
	
	public Item get_rose()
	{
		return rose;
	}
	
	public void set_rose(Item item)
	{
		rose = item;
	}
}
