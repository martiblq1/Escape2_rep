package wall_with_couch_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Audio;
import main.Item;
import main.Items;
import main.Launcher;

public class Safe
{
	private Safe_Number[] numbers;
	private Item eye;
	
	private Rectangle bounds;
	
	private boolean opened;
	
	public Safe(Assets assets)
	{
		bounds = new Rectangle((int)(200*Assets.X_RATIO), (int)(780*Assets.Y_RATIO), (int)(413/2*Assets.X_RATIO), (int)(330/2*Assets.Y_RATIO));
		opened = false;
		numbers = new Safe_Number[3];
		eye = new Item(Items.EYE, true, assets, -1);
		numbers[0] = new Safe_Number((int)(810*Assets.X_RATIO), (int)(468*Assets.Y_RATIO));
		numbers[1] = new Safe_Number((int)(960*Assets.X_RATIO), (int)(468*Assets.Y_RATIO));
		numbers[2] = new Safe_Number((int)(1113*Assets.X_RATIO), (int)(468*Assets.Y_RATIO));
	}
	
	public void tick()
	{
		if(!opened)
		{
			check();
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH:
			if(!opened)
			{
				g.drawImage(Launcher.game.get_assets().safe_wall_with_couch_closed, bounds.x, bounds.y, bounds.width, bounds.height, null);
			}
			else
			{
				g.drawImage(Launcher.game.get_assets().safe_wall_with_couch_opened, bounds.x, bounds.y, bounds.width, bounds.height, null);
			}
			
			break;
		
		case WALL_WITH_COUCH_SAFE:
			if(!opened)
			{
				g.drawImage(Launcher.game.get_assets().safe_wall_with_couch_closed, (int)(150*Assets.X_RATIO), (int)(90*Assets.Y_RATIO), (int)(413*3*Assets.X_RATIO), (int)(330*3*Assets.Y_RATIO), null);
				
				for(int i = 0; i < numbers.length; i++)
				{
					numbers[i].render(g);
				}
			}
			else
			{
				g.drawImage(Launcher.game.get_assets().safe_wall_with_couch_opened, (int)(150*Assets.X_RATIO), (int)(90*Assets.Y_RATIO), (int)(413*3*Assets.X_RATIO), (int)(330*3*Assets.Y_RATIO), null);
				if(eye != null) {eye.render(g);}
			}
			
			break;
			
		default:
			break;
		}
	}
	
	private void check()
	{
		if(numbers[0].get_number() == 1 && 
				numbers[1].get_number() == 8 && 
				numbers[2].get_number() == 3 && 
				Launcher.game.get_wall_with_bed().get_shelf().get_cabinet_0_opened() && 
				Launcher.game.get_wall_with_bed().get_shelf().get_cabinet_1_opened() && 
				Launcher.game.get_wall_with_couch().get_couch().get_paper().get_checked())
		{
			opened = true;
			Audio.play_safe_opening();
			Launcher.game.get_window().get_panel().set_changed();
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_opened() {return opened;}
	public Safe_Number[] get_numbers() {return numbers;}
	public Item get_eye() {return eye;}
	public void set_eye() {eye = null;}
}
