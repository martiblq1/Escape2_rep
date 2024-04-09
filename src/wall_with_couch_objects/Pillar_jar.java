package wall_with_couch_objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;
import main.Scene;

public class Pillar_jar
{
	private Rectangle bounds, water_bounds;
	
	private char id, changed_water;
	private short filled, frames;
	
	Pillar_jar(char id)
	{
		this.id = id;
		filled = 0;
		frames = 0;
		changed_water = 'n';
		water_bounds = new Rectangle((int)((600 + 99*7/2 - 48*7/2 + 4*7)*Assets.X_RATIO), (int)((350 + 44*7 + 12*7)*Assets.Y_RATIO), (int)(40*7*Assets.X_RATIO), 0);
	}
	
	public void tick()
	{
		if(changed_water == 'u')
		{
			animate_up();
			return;
		}
		
		if(changed_water == 'd') {animate_down();}
	}
	
	private void animate_up()
	{
		frames++;
		
		if(frames == 3)
		{
			water_bounds = new Rectangle(water_bounds.x, water_bounds.y - (int)(4*Assets.Y_RATIO), water_bounds.width, water_bounds.height + (int)(4*Assets.Y_RATIO));
			frames = 0;
			Launcher.game.get_window().get_panel().set_changed();
		}
		
		if(water_bounds.y < bounds.y + (int)(44*7*Assets.Y_RATIO) && filled == 1)
		{
			changed_water = 'n';
			water_bounds.height -= bounds.y + (int)(44*7*Assets.Y_RATIO) - water_bounds.y;
			water_bounds.y = bounds.y + (int)(44*7*Assets.Y_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
			return;
		}
		
		if(water_bounds.y < bounds.y + (int)(26*7*Assets.Y_RATIO) && filled == 2)
		{
			changed_water = 'n';
			water_bounds.height -= bounds.y + (int)(26*7*Assets.Y_RATIO) - water_bounds.y;
			water_bounds.y = bounds.y + (int)(26*7*Assets.Y_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
			return;
		}
		
		if(water_bounds.y < bounds.y + (int)(14*7*Assets.Y_RATIO))
		{
			changed_water = 'n';
			water_bounds.height -= bounds.y + (int)(14*7*Assets.Y_RATIO) - water_bounds.y;
			water_bounds.y = bounds.y + (int)(14*7*Assets.Y_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
		}
	}
	
	private void animate_down()
	{
		frames++;
		
		if(frames == 1)
		{
			water_bounds = new Rectangle(water_bounds.x, water_bounds.y + (int)(4*Assets.Y_RATIO), water_bounds.width, water_bounds.height - (int)(4*Assets.Y_RATIO));
			frames = 0;
			Launcher.game.get_window().get_panel().set_changed();
		}
		
		if(water_bounds.y > bounds.y + (int)(56*7*Assets.Y_RATIO) && filled == 0)
		{
			changed_water = 'n';
			water_bounds.height = 0;
			water_bounds.y = bounds.y + (int)(56*7*Assets.Y_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
			return;
		}
		
		if(water_bounds.y > bounds.y + (int)(44*7*Assets.Y_RATIO) && filled == 1)
		{
			changed_water = 'n';
			water_bounds.height = (int)(12*7*Assets.Y_RATIO);
			water_bounds.y = bounds.y + (int)(44*7*Assets.Y_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
			return;
		}
		
		if(water_bounds.y > bounds.y + (int)(26*7*Assets.Y_RATIO) && filled == 2)
		{
			changed_water = 'n';
			water_bounds.height = (int)(30*7*Assets.Y_RATIO);
			water_bounds.y = bounds.y + (int)(26*7*Assets.Y_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
			return;
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH:
			switch(id)
			{
			case 0:
				bounds = new Rectangle((int)((450 + 37)*Assets.X_RATIO), (int)(665*Assets.Y_RATIO), (int)(48*1.5*Assets.X_RATIO), (int)(64*1.5*Assets.Y_RATIO));
				break;
			
			case 1:
				bounds = new Rectangle((int)((1310 + 37)*Assets.X_RATIO), (int)(665*Assets.Y_RATIO), (int)(48*1.5*Assets.X_RATIO), (int)(64*1.5*Assets.Y_RATIO));
				break;
				
			case 2:
				bounds = new Rectangle((int)((1525 + 37)*Assets.X_RATIO), (int)(665*Assets.Y_RATIO), (int)(48*1.5*Assets.X_RATIO), (int)(64*1.5*Assets.Y_RATIO));
				break;
				
			default:
				break;
			}
			
			break;
		
		case WALL_WITH_COUCH_PILLAR_0:
			bounds = new Rectangle((int)((600 + 99*7/2 - 48*7/2)*Assets.X_RATIO), (int)(350*Assets.Y_RATIO), (int)(48*7*Assets.X_RATIO), (int)(64*7*Assets.Y_RATIO));
			break;
			
		case WALL_WITH_COUCH_PILLAR_1:
			bounds = new Rectangle((int)((600 + 99*7/2 - 48*7/2)*Assets.X_RATIO), (int)(350*Assets.Y_RATIO), (int)(48*7*Assets.X_RATIO), (int)(64*7*Assets.Y_RATIO));
			break;
			
		case WALL_WITH_COUCH_PILLAR_2:
			bounds = new Rectangle((int)((600 + 99*7/2 - 48*7/2)*Assets.X_RATIO), (int)(350*Assets.Y_RATIO), (int)(48*7*Assets.X_RATIO), (int)(64*7*Assets.Y_RATIO));
			break;
			
		default:
			break;
		}
		
		switch(filled)
		{
		case 0:
			if(Launcher.game.get_scene() != Scene.WALL_WITH_COUCH)
			{
				g.setColor(new Color(38, 115, 248, 205));
				g.fillRect(water_bounds.x, water_bounds.y, water_bounds.width, water_bounds.height);
			}
			else
			{
				g.drawImage(Launcher.game.get_assets().pillar_jar_empty, bounds.x, bounds.y, bounds.width, bounds.height, null);
				break;
			}
			
			if(changed_water == 'n')
				g.drawImage(Launcher.game.get_assets().pillar_jar_empty, bounds.x, bounds.y, bounds.width, bounds.height, null);
			else
				g.drawImage(Launcher.game.get_assets().pillar_jar_started_filling, bounds.x, bounds.y, bounds.width, bounds.height, null);
			
			break;
		
		case 1:
			if(Launcher.game.get_scene() != Scene.WALL_WITH_COUCH)
			{
				g.setColor(new Color(38, 115, 248, 205));
				g.fillRect(water_bounds.x, water_bounds.y, water_bounds.width, water_bounds.height);
			}
			else
			{
				g.drawImage(Launcher.game.get_assets().jar_on_pillar_filled_1, bounds.x, bounds.y, bounds.width, bounds.height, null);
				break;
			}
			
			g.drawImage(Launcher.game.get_assets().pillar_jar_started_filling, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case 2:
			if(Launcher.game.get_scene() != Scene.WALL_WITH_COUCH)
			{
				g.setColor(new Color(38, 115, 248, 205));
				g.fillRect(water_bounds.x, water_bounds.y, water_bounds.width, water_bounds.height);
			}
			else
			{
				g.drawImage(Launcher.game.get_assets().jar_on_pillar_filled_2, bounds.x, bounds.y, bounds.width, bounds.height, null);
				break;
			}
			
			g.drawImage(Launcher.game.get_assets().pillar_jar_started_filling, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case 3:
			if(Launcher.game.get_scene() != Scene.WALL_WITH_COUCH)
			{
				g.setColor(new Color(38, 115, 248, 205));
				g.fillRect(water_bounds.x, water_bounds.y, water_bounds.width, water_bounds.height);
			}
			else
			{
				g.drawImage(Launcher.game.get_assets().jar_on_pillar_filled_3, bounds.x, bounds.y, bounds.width, bounds.height, null);
				break;
			}
			
			if(changed_water == 'n')
				g.drawImage(Launcher.game.get_assets().pillar_jar_filled, bounds.x, bounds.y, bounds.width, bounds.height, null);
			else
				g.drawImage(Launcher.game.get_assets().pillar_jar_started_filling, bounds.x, bounds.y, bounds.width, bounds.height, null);
			
			break;
			
		default: break;
		}
	}
	
	public void add_water()
	{
		if(filled < 3)
		{
			filled++;
			changed_water = 'u';
		}
	}
	
	public void remove_water()
	{
		if(filled > 0)
		{
			filled--;
			changed_water = 'd';
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public char get_changed_water() {return changed_water;}
	public short get_filled() {return filled;}
	
	public void set_to_n()
	{
		frames = 0;
		
		switch(changed_water)
		{
		case 'u':
			if(filled == 1)
			{
				changed_water = 'n';
				water_bounds.height -= bounds.y + (int)(44*7*Assets.Y_RATIO) - water_bounds.y;
				water_bounds.y = bounds.y + (int)(44*7*Assets.Y_RATIO);
				Launcher.game.get_window().get_panel().set_changed();
				return;
			}
			
			if(filled == 2)
			{
				changed_water = 'n';
				water_bounds.height -= bounds.y + (int)(26*7*Assets.Y_RATIO) - water_bounds.y;
				water_bounds.y = bounds.y + (int)(26*7*Assets.Y_RATIO);
				Launcher.game.get_window().get_panel().set_changed();
				return;
			}
			
			if(filled == 3)
			{
				changed_water = 'n';
				water_bounds.height -= bounds.y + (int)(14*7*Assets.Y_RATIO) - water_bounds.y;
				water_bounds.y = bounds.y + (int)(14*7*Assets.Y_RATIO);
				Launcher.game.get_window().get_panel().set_changed();
				return;
			}
			
			return;
			
		case 'd':
			if(filled == 0)
			{
				changed_water = 'n';
				water_bounds.height = 0;
				water_bounds.y = bounds.y + (int)(56*7*Assets.Y_RATIO);
				Launcher.game.get_window().get_panel().set_changed();
				return;
			}
			
			if(filled == 1)
			{
				changed_water = 'n';
				water_bounds.height = (int)(12*7*Assets.Y_RATIO);
				water_bounds.y = bounds.y + (int)(44*7*Assets.Y_RATIO);
				Launcher.game.get_window().get_panel().set_changed();
				return;
			}
			
			if(filled == 2)
			{
				changed_water = 'n';
				water_bounds.height = (int)(30*7*Assets.Y_RATIO);
				water_bounds.y = bounds.y + (int)(26*7*Assets.Y_RATIO);
				Launcher.game.get_window().get_panel().set_changed();
				return;
			}
		}
	}
}
