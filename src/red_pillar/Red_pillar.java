package red_pillar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Red_pillar
{
	private Item lever;
	
	private Rectangle bounds;
	
	public Red_pillar(Assets assets)
	{
		bounds = new Rectangle((int)(825*Assets.X_RATIO), (int)(652*Assets.Y_RATIO), (int)(271*Assets.X_RATIO), (int)(321*Assets.Y_RATIO));
		lever = new Item(Items.LEVER, true, assets, -1);
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case RED_PILLAR:
			g.drawImage(Launcher.game.get_assets().red_room, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			g.drawImage(Launcher.game.get_assets().red_pillar, bounds.x, bounds.y, bounds.width, bounds.height, null);
			if(lever != null) {g.drawImage(Launcher.game.get_assets().machine_lever_horizontal, bounds.x + (int)(85*Assets.X_RATIO), bounds.y + (int)(5*Assets.Y_RATIO), (int)(88*Assets.X_RATIO), (int)(24*Assets.Y_RATIO), null);}
			Launcher.game.get_arrows()[1].render(g);
			Launcher.game.get_arrows()[2].render(g);
			break;
		
		case RED_PILLAR_PILLAR:
			g.setColor(new Color(85, 0, 13));
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().red_pillar, (int)((1920/2 - 77/2 - 271*2 + 34)*Assets.X_RATIO), (int)(700*Assets.Y_RATIO), (int)(271*4*Assets.X_RATIO), (int)(321*4*Assets.Y_RATIO), null);
			if(lever != null) {lever.render(g);}
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Item get_lever() {return lever;}
	public void set_lever() {lever = null;}
	public Rectangle get_bounds() {return bounds;}
}
