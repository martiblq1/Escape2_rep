package wall_with_door_objects;

import java.awt.Color;
import java.awt.Graphics;

import main.Assets;
import main.Launcher;

public class Wall_with_door
{
	private Door door;
	private Sink sink;
	private Carpet carpet;
	private Painting painting;
	private Box box;
	
	public Wall_with_door(Assets assets)
	{
		door = new Door();
		sink = new Sink(assets);
		carpet = new Carpet();
		painting = new Painting();
		box = new Box(assets);
	}
	
	public void tick()
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DOOR_SINK:
			sink.tick();
			break;
		
		case WALL_WITH_DOOR_CARPET:
			carpet.tick();
			break;
			
		default: break;
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DOOR:
			g.drawImage(Launcher.game.get_assets().room, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			door.render(g);
			sink.render(g);
			carpet.render(g);
			painting.render(g);
			box.render(g);
			Launcher.game.get_arrows()[1].render(g);
			Launcher.game.get_arrows()[2].render(g);
			break;
		
		case WALL_WITH_DOOR_SINK:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			sink.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_DOOR_CARPET:
			g.setColor(new Color(88, 75, 57));
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().message, (int)(682*Assets.X_RATIO), (int)(480*Assets.Y_RATIO), (int)(517*Assets.X_RATIO), (int)(198*Assets.Y_RATIO), null);
			carpet.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_DOOR_PAINTING:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			painting.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_DOOR_BOX:
			g.drawImage(Launcher.game.get_assets().wall_with_floor_2, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			box.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Door get_door() {return door;}
	public Sink get_sink() {return sink;}
	public Carpet get_carpet() {return carpet;}
	public Painting get_paintng() {return painting;}
	public Box get_box() {return box;}
}
