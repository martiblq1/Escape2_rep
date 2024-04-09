package wall_with_donkey_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Donkey
{
	private Rectangle bounds, heart_bounds;
	
	private short frames, killed_stage;
	private final short FRAME_ON_EYE_CLOSED = 200, FRAME_ON_EYE_OPENED = FRAME_ON_EYE_CLOSED + 50;
	private boolean alive, heart_taken;
	
	Donkey()
	{
		bounds = new Rectangle((int)(258*Assets.X_RATIO), (int)(600*Assets.Y_RATIO), (int)(440*Assets.X_RATIO), (int)(360*Assets.Y_RATIO));
		heart_bounds = new Rectangle((int)((300 + 192*3)*Assets.X_RATIO), (int)((0 + 188*3)*Assets.Y_RATIO), (int)(42*3*Assets.X_RATIO), (int)(26*3*Assets.Y_RATIO));
		frames = 0;
		killed_stage = -1;
		alive = true;
		heart_taken = false;
	}
	
	public void tick()
	{
		if(frames == FRAME_ON_EYE_OPENED) {frames = 0;}
		frames++;
		if(frames == FRAME_ON_EYE_CLOSED) {Launcher.game.get_window().get_panel().set_changed();}
		if(frames == FRAME_ON_EYE_OPENED) {Launcher.game.get_window().get_panel().set_changed();}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			if(!alive)
			{
				bounds = new Rectangle((int)(258*Assets.X_RATIO), (int)((600 + 113)*Assets.Y_RATIO), (int)(440*Assets.X_RATIO), (int)(247*Assets.Y_RATIO));
				g.drawImage(Launcher.game.get_assets().donkey_dead, bounds.x, bounds.y, bounds.width, bounds.height, null);
				break;
			}
				
			bounds = new Rectangle((int)(258*Assets.X_RATIO), (int)(600*Assets.Y_RATIO), (int)(440*Assets.X_RATIO), (int)(360*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().donkey, bounds.x, bounds.y, bounds.width, bounds.height, null);
			if(frames == FRAME_ON_EYE_CLOSED){g.drawImage(Launcher.game.get_assets().donkey_eyes[0], (int)(641*Assets.X_RATIO), (int)(704*Assets.Y_RATIO), (int)(13*Assets.X_RATIO), (int)(13*Assets.Y_RATIO), null);}
			
			if(killed_stage > -1)
			{
				g.drawImage(Launcher.game.get_assets().donkey_eyes[1], (int)(641*Assets.X_RATIO), (int)(704*Assets.Y_RATIO), (int)(13*Assets.X_RATIO), (int)(13*Assets.Y_RATIO), null);
				g.drawImage(Launcher.game.get_assets().donkey_wounds[killed_stage], bounds.x + (int)(191*Assets.X_RATIO), bounds.y + (int)(182*Assets.Y_RATIO), (int)(43*Assets.X_RATIO), (int)(38*Assets.Y_RATIO), null);
			}
			
			if(killed_stage == 2 && !heart_taken) {g.drawImage(Launcher.game.get_assets().heart, (int)((258 + 192)*Assets.X_RATIO), (int)((600 + 188)*Assets.Y_RATIO), (int)(42*Assets.X_RATIO), (int)(26*Assets.Y_RATIO), null);}
			
			break;
		
		case WALL_WITH_DONKEY_DONKEY:
			if(!alive)
			{
				bounds = new Rectangle((int)(300*Assets.X_RATIO), (int)((0 + 113*3)*Assets.Y_RATIO), (int)(440*3*Assets.X_RATIO), (int)(247*3*Assets.Y_RATIO));
				g.drawImage(Launcher.game.get_assets().donkey_dead, bounds.x, bounds.y, bounds.width, bounds.height, null);
				break;
			}
				
			bounds = new Rectangle((int)(300*Assets.X_RATIO), 0, (int)(440*3*Assets.X_RATIO), (int)(360*3*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().donkey, bounds.x, bounds.y, bounds.width, bounds.height, null);
			if(frames == FRAME_ON_EYE_CLOSED) {g.drawImage(Launcher.game.get_assets().donkey_eyes[0], (int)(((641 - 258)*3 + 300)*Assets.X_RATIO), (int)(((704 - 600)*3 + 0)*Assets.Y_RATIO), (int)(13*3*Assets.X_RATIO), (int)(13*3*Assets.Y_RATIO), null);}
			
			if(killed_stage > -1)
			{
				g.drawImage(Launcher.game.get_assets().donkey_eyes[1], (int)(((641 - 258)*3 + 300)*Assets.X_RATIO), (int)(((704 - 600)*3 + 0)*Assets.Y_RATIO), (int)(13*3*Assets.X_RATIO), (int)(13*3*Assets.Y_RATIO), null);
				g.drawImage(Launcher.game.get_assets().donkey_wounds[killed_stage], bounds.x + (int)(191*3*Assets.X_RATIO), bounds.y + (int)(182*3*Assets.Y_RATIO), (int)(43*3*Assets.X_RATIO), (int)(38*3*Assets.Y_RATIO), null);
			}
			
			if(killed_stage == 2 && !heart_taken) {g.drawImage(Launcher.game.get_assets().heart, heart_bounds.x, heart_bounds.y, heart_bounds.width, heart_bounds.height, null);}
			
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public Rectangle get_heart_bounds() {return heart_bounds;}
	public void set_frames() {frames = FRAME_ON_EYE_CLOSED - 15;}
	public short get_killed_stage() {return killed_stage;}
	public void set_killed_stage() {killed_stage++;}
	public boolean get_alive() {return alive;}
	public void set_alive() {alive = false;}
	public boolean get_heart_taken() {return heart_taken;}
	public void set_heart_taken() {heart_taken = true;}
}
