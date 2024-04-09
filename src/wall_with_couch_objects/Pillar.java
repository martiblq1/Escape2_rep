package wall_with_couch_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Pillar
{
	private Pillar_jar jar;
	
	private Rectangle bounds;
	
	private char id;
	
	Pillar(char id)
	{
		this.id = id;
		jar = new Pillar_jar(id);
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH:
			switch(id)
			{
			case 0:
				bounds = new Rectangle((int)(450*Assets.X_RATIO), (int)(740*Assets.Y_RATIO), (int)(99*1.5*Assets.X_RATIO), (int)(144*1.5*Assets.Y_RATIO));
				break;
			
			case 1:
				bounds = new Rectangle((int)(1310*Assets.X_RATIO), (int)(740*Assets.Y_RATIO), (int)(99*1.5*Assets.X_RATIO), (int)(144*1.5*Assets.Y_RATIO));
				break;
				
			case 2:
				bounds = new Rectangle((int)(1525*Assets.X_RATIO), (int)(740*Assets.Y_RATIO), (int)(99*1.5*Assets.X_RATIO), (int)(144*1.5*Assets.Y_RATIO));
				break;
				
			default:
				break;
			}
			
			break;
		
		case WALL_WITH_COUCH_PILLAR_0:
			bounds = new Rectangle((int)(600*Assets.X_RATIO), (int)(700*Assets.Y_RATIO), (int)(99*7*Assets.X_RATIO), (int)(144*7*Assets.Y_RATIO));
			break;
			
		case WALL_WITH_COUCH_PILLAR_1:
			bounds = new Rectangle((int)(600*Assets.X_RATIO), (int)(700*Assets.Y_RATIO), (int)(99*7*Assets.X_RATIO), (int)(144*7*Assets.Y_RATIO));
			break;
			
		case WALL_WITH_COUCH_PILLAR_2:
			bounds = new Rectangle((int)(600*Assets.X_RATIO), (int)(700*Assets.Y_RATIO), (int)(99*7*Assets.X_RATIO), (int)(144*7*Assets.Y_RATIO));
			break;
			
		default:
			break;
		}
		
		g.drawImage(Launcher.game.get_assets().pillar, bounds.x, bounds.y, bounds.width, bounds.height, null);
		jar.render(g);
	}
	
	//getters and setters
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public Pillar_jar get_jar()
	{
		return jar;
	}
	
	public char get_id()
	{
		return id;
	}
}
