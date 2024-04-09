package red_chairs;

import java.awt.Graphics;

import main.Assets;
import main.Launcher;

public class Red_chairs
{
	private Chair[] chairs;
	
	public Red_chairs()
	{
		chairs = new Chair[2];
		chairs[0] = new Chair(true);
		chairs[1] = new Chair(false);
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Launcher.game.get_assets().red_room, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
		for(short i = 0; i < 2; i++) {chairs[i].render(g);}
		g.drawImage(Launcher.game.get_assets().lamp, (int)(807*Assets.X_RATIO), (int)(366*Assets.Y_RATIO), (int)(256*Assets.X_RATIO), (int)(621*Assets.Y_RATIO), null);
		Launcher.game.get_arrows()[1].render(g);
		Launcher.game.get_arrows()[2].render(g);
	}
	
	//getters and setters
	public Chair[] get_chairs() {return chairs;}
}
