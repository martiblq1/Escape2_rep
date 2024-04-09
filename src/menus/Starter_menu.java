package menus;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Starter_menu
{
	private Rectangle bounds;
	
	public Starter_menu()
	{
		bounds = new Rectangle((int)((1920/2 - 118/2)*Assets.X_RATIO), (int)((1080/2 - 118/2)*Assets.Y_RATIO), (int)(118*Assets.X_RATIO), (int)(118*Assets.Y_RATIO));
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Launcher.game.get_assets().wall, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
		g.drawImage(Launcher.game.get_assets().play_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
}
