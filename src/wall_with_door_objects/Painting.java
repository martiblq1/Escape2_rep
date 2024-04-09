package wall_with_door_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Painting
{
	private Lever lever;
	
	private Rectangle bounds;
	
	private boolean opened;
	
	Painting()
	{
		lever = new Lever();
		bounds = new Rectangle((int)(1222*Assets.X_RATIO), (int)(213*Assets.Y_RATIO), (int)(424*Assets.X_RATIO), (int)(270*Assets.Y_RATIO));
		opened = false;
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DOOR:
			g.drawImage(Launcher.game.get_assets().painting_1, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
		
		case WALL_WITH_DOOR_PAINTING:
			if(!opened)
				g.drawImage(Launcher.game.get_assets().painting_1, (int)(324*Assets.X_RATIO), (int)(135*Assets.Y_RATIO), (int)(212*6*Assets.X_RATIO), (int)(135*6*Assets.Y_RATIO), null);
			else
			{
				g.drawImage(Launcher.game.get_assets().painting_horizontal_opened, (int)(324*Assets.X_RATIO), (int)((135 - 148*6)*Assets.Y_RATIO), (int)(212*6*Assets.X_RATIO), (int)(282*6*Assets.Y_RATIO), null);
				lever.render(g);
			}
				
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Lever get_lever() {return lever;}
	public Rectangle get_bounds() {return bounds;}
	public boolean get_opened() {return opened;}
	public void set_opened() {opened = true;}
}
