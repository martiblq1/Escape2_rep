package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Gear
{
	private Rectangle bounds;
	
	private boolean slot_empty, spinning;
	private char id;
	private int index, frames;
	
	Gear(char id)
	{
		slot_empty = true;
		spinning = false;
		this.id = id;
		index = 0;
		frames = 0;
	}
	
	public void tick()
	{
		if(!slot_empty)
		{
			if(spinning)
			{
				frames++;
				
				if(frames == 5)
				{
					frames = 0;
					
					if(!Launcher.game.get_fade().get_fading())
					{
						Launcher.game.get_window().get_panel().set_changed();
						
						if(index != 2)
							index++;
						else
							index = 0;
					}
				}
			}
			else
			{
				switch(id)
				{
				case '0':
					spinning = true;
					break;
				
				case '1':
					if(Launcher.game.get_wall_with_bed().get_shelf().get_gear_0().get_spinning()) {spinning = true;}
					break;
					
				case '2':
					if(Launcher.game.get_wall_with_bed().get_shelf().get_gear_0().get_spinning() && Launcher.game.get_wall_with_bed().get_shelf().get_gear_1().get_spinning()) {spinning = true;}
					break;
					
				default: break;
				}
			}
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED:
			if(slot_empty)
			{
				switch(id)
				{
				case '0':
					bounds = new Rectangle((int)(300*Assets.X_RATIO) + (int)(41*1.5*Assets.X_RATIO), (int)((750 - 291*1.5 + 135*1.5)*Assets.Y_RATIO), (int)(7*1.5*Assets.X_RATIO), (int)(8*1.5*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_base, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case '1':
					bounds = new Rectangle((int)(300*Assets.X_RATIO) + (int)(79*1.5*Assets.X_RATIO), (int)((750 - 291*1.5 + 168*1.5)*Assets.Y_RATIO), (int)(7*1.5*Assets.X_RATIO), (int)(8*1.5*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_base, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				case '2':
					bounds = new Rectangle((int)(300*Assets.X_RATIO) + (int)(115*1.5*Assets.X_RATIO), (int)((750 - 291*1.5 + 135*1.5)*Assets.Y_RATIO), (int)(7*1.5*Assets.X_RATIO), (int)(8*1.5*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_base, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				default: break;
				}
			}
			else
			{
				switch(id)
				{
				case '0':
					bounds = new Rectangle((int)(300*Assets.X_RATIO) + (int)(18*1.5*Assets.X_RATIO), (int)((750 - 291*1.5 + 114*1.5)*Assets.Y_RATIO), (int)(53*1.5*Assets.X_RATIO), (int)(51*1.5*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_animation[index], bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case '1':
					bounds = new Rectangle((int)(300*Assets.X_RATIO) + (int)(56*1.5*Assets.X_RATIO), (int)((750 - 291*1.5 + 147*1.5)*Assets.Y_RATIO), (int)(53*1.5*Assets.X_RATIO), (int)(51*1.5*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_animation[index], bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case '2':
					bounds = new Rectangle((int)(300*Assets.X_RATIO) + (int)(92*1.5*Assets.X_RATIO), (int)((750 - 291*1.5 + 114*1.5)*Assets.Y_RATIO), (int)(53*1.5*Assets.X_RATIO), (int)(51*1.5*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_animation[index], bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				default: break;
				}
			}
			
			break;
			
		case WALL_WITH_BED_UPPERSHELF:
			if(slot_empty)
			{
				switch(id)
				{
				case '0':
					bounds = new Rectangle((int)((490 + 41*4)*Assets.X_RATIO), (int)((-80 + 135*4)*Assets.Y_RATIO), (int)(7*4*Assets.X_RATIO), (int)(8*4*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_base, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case '1':
					bounds = new Rectangle((int)((490 + 79*4)*Assets.X_RATIO), (int)((-80 + 168*4)*Assets.Y_RATIO), (int)(7*4*Assets.X_RATIO), (int)(8*4*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_base, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				case '2':
					bounds = new Rectangle((int)((490 + 115*4)*Assets.X_RATIO), (int)((-80 + 135*4)*Assets.Y_RATIO), (int)(7*4*Assets.X_RATIO), (int)(8*4*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_base, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				default: break;
				}
			}
			else
			{
				switch(id)
				{
				case '0':
					bounds = new Rectangle((int)((490 + 18*4)*Assets.X_RATIO), (int)((-80 + 114*4)*Assets.Y_RATIO), (int)(53*4*Assets.X_RATIO), (int)(51*4*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_animation[index], bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case '1':
					bounds = new Rectangle((int)((490 + 56*4)*Assets.X_RATIO), (int)((-80 + 147*4)*Assets.Y_RATIO), (int)(53*4*Assets.X_RATIO), (int)(51*4*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_animation[index], bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				case '2':
					bounds = new Rectangle((int)((490 + 92*4)*Assets.X_RATIO), (int)((-80 + 114*4)*Assets.Y_RATIO), (int)(53*4*Assets.X_RATIO), (int)(51*4*Assets.Y_RATIO));
					g.drawImage(Launcher.game.get_assets().gear_animation[index], bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				default: break;
				}
			}
			
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_slot_empty() {return slot_empty;}
	public void set_slot_empty() {slot_empty = false;}
	public boolean get_spinning() {return spinning;}
}
