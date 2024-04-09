package wall_with_door_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;
import main.Scene;

public class Sink
{
	private Assets assets;
	private Item sponge;
	
	private Rectangle bounds, handle_bounds, water_bounds;
	
	private short water_index, frames;
	private boolean handle_put, turned;
	
	Sink(Assets assets)
	{
		this.assets = assets;
		sponge = new Item(Items.SPONGE, true, assets, -1);
		bounds = new Rectangle((int)(740*Assets.X_RATIO), (int)(533*Assets.Y_RATIO), (int)(240*Assets.X_RATIO), (int)(392*Assets.Y_RATIO));
		handle_bounds = new Rectangle((int)((375 + 324*2)*Assets.X_RATIO), (int)((70 - 27*2)*Assets.Y_RATIO), (int)(360*Assets.X_RATIO), (int)(360*Assets.Y_RATIO));
		water_bounds = new Rectangle((int)((375 + 220*2)*Assets.X_RATIO), (int)((70 + 83*2)*Assets.Y_RATIO), (int)(44*2*Assets.X_RATIO), (int)(243*2*Assets.Y_RATIO));
		water_index = 0;
		frames = 0;
		handle_put = false;
		turned = false;
	}
	
	public void tick()
	{
		if(Launcher.game.get_scene() != Scene.WALL_WITH_DOOR_SINK) {return;}
		frames++;
		if(frames != 10) {return;}
		
		if(water_index == 0)
			water_index = 1;
		else
			water_index = 0;
		
		if(turned) {Launcher.game.get_window().get_panel().set_changed();}
		frames = 0;
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DOOR:
			if(handle_put)
			{
				g.drawImage(assets.sink_with_handle, bounds.x, bounds.y, bounds.width, bounds.height, null);
				break;
			}
			
			g.drawImage(assets.sink, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
		
		case WALL_WITH_DOOR_SINK:
			if(handle_put && !turned)
				g.drawImage(assets.handle_up, (int)((375 + 324*2)*Assets.X_RATIO), (int)((70 - 27*2)*Assets.Y_RATIO), (int)(360*Assets.X_RATIO), (int)(360*Assets.Y_RATIO), null);
			else if(handle_put && turned)
				g.drawImage(assets.handle, (int)((375 + 333*2)*Assets.X_RATIO), (int)((70 + 124*2)*Assets.Y_RATIO), (int)(454*Assets.X_RATIO), (int)(54*Assets.Y_RATIO), null);
				
			g.drawImage(assets.sink_upper, (int)(375*Assets.X_RATIO), (int)(70*Assets.Y_RATIO), (int)(542*2*Assets.X_RATIO), (int)(510*2*Assets.Y_RATIO), null);
			if(handle_put && turned) {g.drawImage(assets.water_flowing[water_index], (int)((375 + 220*2)*Assets.X_RATIO), (int)((70 + 83*2)*Assets.Y_RATIO), (int)(44*2*Assets.X_RATIO), (int)(243*2*Assets.Y_RATIO), null);}
			if(sponge != null) {sponge.render(g);}
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Item get_sponge() {return sponge;}
	public void set_sponge() {sponge = null;}
	public Rectangle get_bounds() {return bounds;}
	public Rectangle get_handle_bounds() {return handle_bounds;}
	public Rectangle get_water_bounds() {return water_bounds;}
	
	public void set_handle_bounds(boolean turned)
	{
		if(turned)
			handle_bounds = new Rectangle((int)((375 + 333*2)*Assets.X_RATIO), (int)((70 - 124*2)*Assets.Y_RATIO), (int)(227*Assets.X_RATIO), (int)(27*Assets.Y_RATIO));
		else
			handle_bounds = new Rectangle((int)((375 + 324*2)*Assets.X_RATIO), (int)((70 - 27*2)*Assets.Y_RATIO), (int)(360*Assets.X_RATIO), (int)(360*Assets.Y_RATIO));
	}
	
	public boolean get_handle_put() {return handle_put;}
	public void set_handle_put(boolean handle_put) {this.handle_put = handle_put;}
	public boolean get_turned() {return turned;}
	public void set_turned(boolean turned) {this.turned = turned;}
}
