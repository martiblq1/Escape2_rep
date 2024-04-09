package wall_with_donkey_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Machine
{
	private Gear gear;
	private Box box;
	private Red_gear red_gear;
	private Lever lever;
	
	private Rectangle bounds, lever_hole_bounds;
	
	Machine()
	{
		gear = new Gear();
		box = new Box();
		bounds = new Rectangle((int)(731*Assets.X_RATIO), (int)(535*Assets.Y_RATIO), (int)(434*Assets.X_RATIO), (int)(434*Assets.Y_RATIO));
		lever_hole_bounds = new Rectangle((int)((1920/2 - 77 - 434 + 351*2)*Assets.X_RATIO), (int)((220 + 336*2)*Assets.Y_RATIO), (int)(9*2*Assets.X_RATIO), (int)(7*2*Assets.Y_RATIO));
		red_gear = new Red_gear();
		lever = new Lever();
	}
	
	public void tick()
	{
		if(gear != null && gear.get_animation())
		{
			box.tick();
			gear.tick();
			red_gear.tick();
		}
		
		if(box.get_moving())
		{
			box.tick();
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			box.render(g);
			g.drawImage(Launcher.game.get_assets().machine, bounds.x, bounds.y, bounds.width, bounds.height, null);
			g.drawImage(Launcher.game.get_assets().machine_plate, bounds.x + (int)(290*Assets.X_RATIO), bounds.y + (int)(43*Assets.Y_RATIO), (int)(96*Assets.X_RATIO), (int)(53*Assets.Y_RATIO), null);
			g.drawImage(Launcher.game.get_assets().machine_lever_hole, bounds.x + (int)(351*Assets.X_RATIO), bounds.y + (int)(336*Assets.Y_RATIO), (int)(9*Assets.X_RATIO), (int)(7*Assets.Y_RATIO), null);
			red_gear.render(g);
			if(gear != null) {gear.render(g);}
			lever.render(g);
			break;
		
		case WALL_WITH_DONKEY_MACHINE:
			box.render(g);
			g.drawImage(Launcher.game.get_assets().machine, (int)((1920/2 - 77 - 434)*Assets.X_RATIO), (int)(220*Assets.Y_RATIO), (int)(434*2*Assets.X_RATIO), (int)(434*2*Assets.Y_RATIO), null);
			g.drawImage(Launcher.game.get_assets().machine_plate, (int)((1920/2 - 77 - 434 + 290*2)*Assets.X_RATIO), (int)((220 + 43*2)*Assets.Y_RATIO), (int)(96*2*Assets.X_RATIO), (int)(53*2*Assets.Y_RATIO), null);
			g.drawImage(Launcher.game.get_assets().machine_lever_hole, lever_hole_bounds.x, lever_hole_bounds.y, lever_hole_bounds.width, lever_hole_bounds.height, null);
			red_gear.render(g);
			if(gear != null) {gear.render(g);}
			lever.render(g);
			break;
			
		case WALL_WITH_DONKEY_MACHINE_NUMBERS:
			box.render(g);
			break;
			
		default: break;
		}
	}
	
	public void lever_pulled()
	{
		lever.set_switched();
		Launcher.game.get_window().get_panel().set_changed();
		if(gear != null)
		{
			gear.set_animation();
			
		}
	}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public Rectangle get_lever_hole_bounds() {return lever_hole_bounds;}
	public Gear get_gear() {return gear;}
	public void set_gear() {gear = null;}
	public Lever get_lever() {return lever;}
	public Box get_box() {return box;}
}
