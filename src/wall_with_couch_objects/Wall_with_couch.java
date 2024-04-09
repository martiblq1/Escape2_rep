package wall_with_couch_objects;

import java.awt.Color;
import java.awt.Graphics;

import main.Assets;
import main.Launcher;

public class Wall_with_couch
{
	private Couch couch;
	private Jars jars;
	private Safe safe;
	private Pillar[] pillars;
	private Painting painting;
	
	private final int WIDTH = (int)(1920*Assets.X_RATIO), HEIGHT = (int)(1080*Assets.Y_RATIO);
	
	public Wall_with_couch(Assets assets)
	{
		couch = new Couch();
		jars = new Jars(assets);
		safe = new Safe(assets);
		pillars = new Pillar[3];
		painting = new Painting(assets);
		
		for(char i = 0; i < 3; i++)
		{
			pillars[i] = new Pillar(i);
		}
	}
	
	public void tick()
	{	
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH_SAFE:
			if(!safe.get_opened())
			{
				safe.tick();
			}
			
			break;
			
		case WALL_WITH_COUCH_PILLAR_0:
			pillars[0].get_jar().tick();
			break;
		
		case WALL_WITH_COUCH_PILLAR_1:
			pillars[1].get_jar().tick();
			break;
			
		case WALL_WITH_COUCH_PILLAR_2:
			pillars[2].get_jar().tick();
			break;
			
		default: break;
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH: 
			g.drawImage(Launcher.game.get_assets().room, 0, 0, WIDTH, HEIGHT, null);
			couch.render(g);
			jars.render(g);
			safe.render(g);
			
			for(Pillar pillar : pillars)
			{
				pillar.render(g);
			}
			
			painting.render(g);
			Launcher.game.get_arrows()[1].render(g);
			Launcher.game.get_arrows()[2].render(g);
			
			break;
		
		case WALL_WITH_COUCH_COUCH:
			g.setColor(new Color(165, 13, 1));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			couch.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_COUCH_JARS:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, WIDTH, HEIGHT, null);
			jars.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
		
		case WALL_WITH_COUCH_SAFE:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, WIDTH, HEIGHT, null);
			safe.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_COUCH_PILLAR_0:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, WIDTH, HEIGHT, null);
			pillars[0].render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_COUCH_PILLAR_1:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, WIDTH, HEIGHT, null);
			pillars[1].render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_COUCH_PILLAR_2:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, WIDTH, HEIGHT, null);
			pillars[2].render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_COUCH_PAINTING:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, WIDTH, HEIGHT, null);
			painting.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		default:
			break;
		}
	}
	
	public void check_jars()
	{
		if(!painting.get_unlocked() && 
				pillars[0].get_jar().get_filled() == 2 && 
				pillars[1].get_jar().get_filled() == 0 && 
				pillars[2].get_jar().get_filled() == 3)
		{
			painting.set_unlocked();
			return;
		}
		
		if(!Launcher.game.get_wall_with_door().get_paintng().get_opened() && 
				pillars[0].get_jar().get_filled() == 3 && 
				pillars[1].get_jar().get_filled() == 2 && 
				pillars[2].get_jar().get_filled() == 1)
		{
			Launcher.game.get_wall_with_door().get_paintng().set_opened();
		}
	}
	
	//getters and setters
	public Jars get_jars()
	{
		return jars;
	}
	
	public Safe get_safe()
	{
		return safe;
	}
	
	public Couch get_couch()
	{
		return couch;
	}
	
	public Pillar[] get_pillars()
	{
		return pillars;
	}
	
	public Painting get_painting()
	{
		return painting;
	}
}
