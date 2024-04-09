package wall_with_donkey_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Table
{
	private Rectangle bounds;
	
	private boolean rose_put;
	
	public Table() {rose_put = false;}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			bounds = new Rectangle((int)(1310*Assets.X_RATIO), (int)(625*Assets.Y_RATIO), (int)(438*0.6*Assets.X_RATIO), (int)(547*0.6*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().table_with_vase, bounds.x, bounds.y, bounds.width, bounds.height, null);
			if(rose_put) {g.drawImage(Launcher.game.get_assets().rose_in_vase, bounds.x + (int)(186*0.6*Assets.X_RATIO), bounds.y - (int)(68*0.6*Assets.Y_RATIO), (int)(58*0.6*Assets.X_RATIO), (int)(82*0.6*Assets.Y_RATIO), null);}
			break;
		
		case WALL_WITH_DONKEY_TABLE:
			bounds = new Rectangle((int)((1920/2 - 77 - 360)*Assets.X_RATIO), (int)(400*Assets.Y_RATIO), (int)(438*2*Assets.X_RATIO), (int)(547*2*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().table_with_vase, bounds.x, bounds.y, bounds.width, bounds.height, null);
			if(rose_put) {g.drawImage(Launcher.game.get_assets().rose_in_vase, bounds.x + (int)(186*2*Assets.X_RATIO), bounds.y - (int)(68*2*Assets.Y_RATIO), (int)(58*2*Assets.X_RATIO), (int)(82*2*Assets.Y_RATIO), null);}
			break;
			
		case RED_ROSE:
			bounds = new Rectangle((int)((1920/2 - 77/2 - 150)*Assets.X_RATIO), (int)(525*Assets.Y_RATIO), (int)(438*0.8*Assets.X_RATIO), (int)(547*0.8*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().table_with_vase, bounds.x, bounds.y, bounds.width, bounds.height, null);
			g.drawImage(Launcher.game.get_assets().rose_in_vase, bounds.x + (int)(186*0.8*Assets.X_RATIO), bounds.y - (int)(68*0.8*Assets.Y_RATIO), (int)(58*0.8*Assets.X_RATIO), (int)(82*0.8*Assets.Y_RATIO), null);
			break;
			
		case RED_ROSE_TABLE:
			bounds = new Rectangle((int)((1920/2 - 77 - 360)*Assets.X_RATIO), (int)(400*Assets.Y_RATIO), (int)(438*2*Assets.X_RATIO), (int)(547*2*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().table_with_vase, bounds.x, bounds.y, bounds.width, bounds.height, null);
			g.drawImage(Launcher.game.get_assets().rose_in_vase, bounds.x + (int)(186*2*Assets.X_RATIO), bounds.y - (int)(68*2*Assets.Y_RATIO), (int)(58*2*Assets.X_RATIO), (int)(82*2*Assets.Y_RATIO), null);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public boolean get_rose_put() {return rose_put;}
	public void set_rose_put() {rose_put = true;}
}
