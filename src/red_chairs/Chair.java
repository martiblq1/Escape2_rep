package red_chairs;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Chair
{
	private Rectangle bounds;
	
	private boolean right_chair;
	
	Chair(boolean right_chair)
	{
		if(right_chair)
			bounds = new Rectangle((int)(335*Assets.X_RATIO), (int)(553*Assets.Y_RATIO), (int)(383*Assets.X_RATIO), (int)(507*Assets.Y_RATIO));
		else
			bounds = new Rectangle((int)(1165*Assets.X_RATIO), (int)(553*Assets.Y_RATIO), (int)(383*Assets.X_RATIO), (int)(507*Assets.Y_RATIO));
		
		this.right_chair = right_chair;
	}
	
	public void render(Graphics g)
	{
		if(right_chair)
			g.drawImage(Launcher.game.get_assets().chair, bounds.x, bounds.y, bounds.width, bounds.height, null);
		else
			g.drawImage(Launcher.game.get_assets().chair_left, bounds.x, bounds.y, bounds.width, bounds.height, null);
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
}
