package red_arm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Red_arm
{
	private Rectangle arm_bounds;
	
	private boolean arm_exists;
	
	public Red_arm() {arm_exists = true;}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case RED_ARM:
			g.drawImage(Launcher.game.get_assets().red_room, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			
			if(arm_exists)
			{
				arm_bounds = new Rectangle((int)(677*Assets.X_RATIO), (int)(336*Assets.Y_RATIO), (int)(598*Assets.X_RATIO), (int)(656*Assets.Y_RATIO));
				g.drawImage(Launcher.game.get_assets().the_arm, arm_bounds.x, arm_bounds.y, arm_bounds.width, arm_bounds.height, null);
			}
			else
				g.drawImage(Launcher.game.get_assets().arm_sign, (int)((1920/2 - 561/2)*Assets.X_RATIO), (int)(200*Assets.Y_RATIO), (int)(561*Assets.X_RATIO), (int)(254*Assets.Y_RATIO), null);
			
			Launcher.game.get_arrows()[1].render(g);
			Launcher.game.get_arrows()[2].render(g);
			break;
		
		case RED_ARM_ARM:
			g.setColor(new Color(85, 0, 13));
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			
			if(arm_exists)
			{
				arm_bounds = new Rectangle(0, 0, (int)(598*3*Assets.X_RATIO), (int)(656*3*Assets.Y_RATIO));
				g.drawImage(Launcher.game.get_assets().the_arm, arm_bounds.x, arm_bounds.y, arm_bounds.width, arm_bounds.height, null);
			}
			
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return arm_bounds;}
	public boolean get_arm_exists() {return arm_exists;}
	public void set_arm_exists() {arm_exists = false;}
}
