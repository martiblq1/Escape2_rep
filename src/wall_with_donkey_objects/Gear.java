package wall_with_donkey_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Gear
{
	private Rectangle bounds;
	
	private short animation_index, frames;
	private boolean animation;
	
	Gear()
	{
		bounds = new Rectangle((int)((1920/2 - 77 - 434 + 252*2)*Assets.X_RATIO), (int)((220 + 154*2)*Assets.Y_RATIO), (int)(95*2*Assets.X_RATIO), (int)(91*2*Assets.Y_RATIO));
		animation_index = 0;
		frames = 0;
		animation = false;
	}
	
	public void tick()
	{
		frames++;
		
		if(frames == 5)
		{
			frames = 0;
			
			if(!Launcher.game.get_fade().get_fading())
			{	
				if(animation_index != 2)
					animation_index++;
				else
					animation_index = 0;
				
				Launcher.game.get_window().get_panel().set_changed();
			}
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			g.drawImage(Launcher.game.get_assets().gear, (int)((731 + 252)*Assets.X_RATIO), (int)((535 + 154)*Assets.Y_RATIO), (int)(95*Assets.X_RATIO), (int)(91*Assets.Y_RATIO), null);
			break;
		
		case WALL_WITH_DONKEY_MACHINE:
			g.drawImage(Launcher.game.get_assets().gear_animation[animation_index], bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_animation() {return animation;}
	public void set_animation() {animation = true;}
}
