package wall_with_couch_objects;

import main.Assets;
import main.Launcher;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Couch
{
	private Couch_Paper paper;
	
	private Rectangle bounds;
	
	public Couch()
	{
		paper = new Couch_Paper();
		bounds = new Rectangle((int)(650*Assets.X_RATIO), (int)(535*Assets.Y_RATIO), (int)(310*2*Assets.X_RATIO), (int)(210*2*Assets.Y_RATIO));
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH:
			g.drawImage(Launcher.game.get_assets().couch, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case WALL_WITH_COUCH_COUCH:
			paper.render(g);
			break;
			
		default:
			break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public Couch_Paper get_paper()
	{
		return paper;
	}
}
