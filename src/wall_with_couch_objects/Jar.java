package wall_with_couch_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Items;
import main.Launcher;

public class Jar
{
	private Items organ;
	
	private Rectangle bounds;
	
	Jar(Rectangle bounds)
	{
		organ = Items.EMPTY;
		this.bounds = bounds;
	}
	
	public void render(Graphics g)
	{
		switch(organ)
		{
		case EAR:
			g.drawImage(Launcher.game.get_assets().ear_vertical, bounds.x + bounds.width/2 - (int)(108/2*Assets.X_RATIO), bounds.y + bounds.height - (int)(162*Assets.Y_RATIO), (int)(108*Assets.X_RATIO), (int)(162*Assets.Y_RATIO), null);
			break;
		
		case TONGUE:
			g.drawImage(Launcher.game.get_assets().tongue, bounds.x + bounds.width/2 - (int)(53*Assets.X_RATIO), bounds.y + bounds.height - (int)(54*2*Assets.Y_RATIO), (int)(53*2*Assets.X_RATIO), (int)(54*2*Assets.Y_RATIO), null);
			break;	
			
		case HEART:
			g.drawImage(Launcher.game.get_assets().heart_vertical, bounds.x + bounds.width/2 - (int)(71*Assets.X_RATIO), bounds.y + bounds.height - (int)(113*2*Assets.Y_RATIO), (int)(71*2*Assets.X_RATIO), (int)(113*2*Assets.Y_RATIO), null);
			break;
		
		case EYE:
			g.drawImage(Launcher.game.get_assets().eye, bounds.x + bounds.width/2 - (int)(50*Assets.X_RATIO), bounds.y + bounds.height - (int)(50*2*Assets.Y_RATIO), (int)(50*2*Assets.X_RATIO), (int)(50*2*Assets.Y_RATIO), null);
			break;
			
		default: break;
		}
	}
	//getters and setters
	public Items get_organ() {return organ;}
	public void set_organ(Items organ) {this.organ = organ;}
	public Rectangle get_bounds() {return bounds;}
}
