package red_rose;

import java.awt.Color;
import java.awt.Graphics;

import main.Assets;
import main.Launcher;
import wall_with_donkey_objects.Table;

public class Red_rose
{
	private Table table;
	
	public Red_rose() {table = new Table();}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case RED_ROSE:
			g.drawImage(Launcher.game.get_assets().red_room, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			table.render(g);
			Launcher.game.get_arrows()[1].render(g);
			Launcher.game.get_arrows()[2].render(g);
			break;
		
		case RED_ROSE_TABLE:
			g.setColor(new Color(85, 0, 13));
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			table.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Table get_table() {return table;}
}
