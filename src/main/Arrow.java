package main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Arrow
{
	private Rectangle bounds;
	
	private Direction direction;
	
	Arrow(Direction direction)
	{
		this.direction = direction;
		
		switch(direction)
		{
		case BACK:
			bounds = new Rectangle((int)(920*Assets.X_RATIO), (int)(1030*Assets.Y_RATIO), (int)(80/2*Assets.X_RATIO), (int)(50/2*Assets.Y_RATIO));
			break;
			
		case LEFT:
			bounds = new Rectangle((int)(25*Assets.X_RATIO), (int)(560*Assets.Y_RATIO), (int)(50/2*Assets.X_RATIO), (int)(80/2*Assets.Y_RATIO));
			break;
			
		case RIGHT:
			bounds = new Rectangle((int)((1920 - 30 - 2*77)*Assets.X_RATIO), (int)(560*Assets.Y_RATIO), (int)(50/2*Assets.X_RATIO), (int)(80/2*Assets.Y_RATIO));
			break;
			
		case INVENTORY:
			bounds = new Rectangle((int)((1920 - 30 - 2*77)*Assets.X_RATIO), (int)(1040*Assets.Y_RATIO), (int)(50/2*Assets.X_RATIO), (int)(80/2*Assets.Y_RATIO));
			break;
		}
	}
	
	public void render(Graphics g)
	{
		switch(direction)
		{
		case BACK:
			g.drawImage(Launcher.game.get_assets().back, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case LEFT:
			g.drawImage(Launcher.game.get_assets().left, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case RIGHT:
			g.drawImage(Launcher.game.get_assets().right, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case INVENTORY:
			if(Launcher.game.get_inventory().get_visible())
			{
				bounds = new Rectangle((int)((1920 - 30 - 2*77)*Assets.X_RATIO), (int)(1040*Assets.Y_RATIO), (int)(50/2*Assets.X_RATIO), (int)(80/2*Assets.Y_RATIO));
				g.drawImage(Launcher.game.get_assets().right, bounds.x, bounds.y, bounds.width, bounds.height, null);
			}
			else
			{
				bounds = new Rectangle((int)((1920 - 30)*Assets.X_RATIO), (int)(1040*Assets.Y_RATIO), (int)(50/2*Assets.X_RATIO), (int)(80/2*Assets.Y_RATIO));
				g.drawImage(Launcher.game.get_assets().left, bounds.x, bounds.y, bounds.width, bounds.height, null);
			}
			
			break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds()
	{
		return bounds;
	}
}
