package wall_with_donkey_objects;

import java.awt.Graphics;

import main.Assets;
import main.Launcher;

public class Wall_with_donkey
{
	private Donkey donkey;
	private Machine machine;
	private Table table;
	
	public Wall_with_donkey()
	{
		donkey = new Donkey();
		machine = new Machine();
		table = new Table();
	}
	
	public void tick()
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			if(donkey.get_alive()) {donkey.tick();}
			break;
		
		case WALL_WITH_DONKEY_DONKEY:
			if(donkey.get_alive()) {donkey.tick();}
			break;
			
		case WALL_WITH_DONKEY_MACHINE:
			machine.tick();
			break;
			
		case WALL_WITH_DONKEY_MACHINE_NUMBERS:
			machine.tick();
			break;
			
		default: break;
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			g.drawImage(Launcher.game.get_assets().room, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			donkey.render(g);
			machine.render(g);
			table.render(g);
			Launcher.game.get_arrows()[1].render(g);
			Launcher.game.get_arrows()[2].render(g);
			break;
		
		case WALL_WITH_DONKEY_DONKEY:
			g.drawImage(Launcher.game.get_assets().wall_with_floor, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			donkey.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
		
		case WALL_WITH_DONKEY_MACHINE:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			machine.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_DONKEY_TABLE:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			table.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_DONKEY_MACHINE_NUMBERS:
			machine.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Donkey get_donkey() {return donkey;}
	public Machine get_machine() {return machine;}
	public Table get_table() {return table;}
}
