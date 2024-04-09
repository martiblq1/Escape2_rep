package wall_with_donkey_objects;

import java.awt.Graphics;

import main.Assets;
import main.Launcher;

public class Red_gear
{
	private short spinning_index, frames;
	
	Red_gear()
	{
		spinning_index = 0;
		frames = 0;
	}
	
	public void tick()
	{
		frames++;
		
		if(frames == 5)
		{
			frames = 0;
			
			if(!Launcher.game.get_fade().get_fading())
			{
				Launcher.game.get_window().get_panel().set_changed();
				
				if(spinning_index != 0)
					spinning_index--;
				else
					spinning_index = 2;
			}
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			g.drawImage(Launcher.game.get_assets().red_gear_animation[0], (int)(771*Assets.X_RATIO), (int)(616*Assets.Y_RATIO), (int)(127*Assets.X_RATIO), (int)(122*Assets.Y_RATIO), null);
			break;
		
		case WALL_WITH_DONKEY_MACHINE:
			g.drawImage(Launcher.game.get_assets().red_gear_animation[spinning_index], (int)((1920/2 - 77 - 434 + 40*2)*Assets.X_RATIO), (int)((220 + 81*2)*Assets.Y_RATIO), (int)(127*2*Assets.X_RATIO), (int)(122*2*Assets.Y_RATIO), null);
			break;
			
		default: break;
		}
	}
}
