package wall_with_couch_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Audio;
import main.Items;
import main.Launcher;
import main.Star;
import menus.Home_menu;

public class Jars
{
	private Jars_Safe safe;
	private Jar[] jars;
	
	private Rectangle bounds;
	private Rectangle[] jars_bounds;
	
	public Jars(Assets assets)
	{
		safe = new Jars_Safe(assets);
		jars = new Jar[4];
		jars_bounds = new Rectangle[4];
		jars_bounds[0] = new Rectangle((int)((250 + 134*2)*Assets.X_RATIO), (int)((400 + 34*2)*Assets.Y_RATIO), (int)(98*2*Assets.X_RATIO), (int)(120*2*Assets.Y_RATIO));
		jars_bounds[1] = new Rectangle((int)((250 + 273*2)*Assets.X_RATIO), (int)((400 + 0*2)*Assets.Y_RATIO), (int)(100*2*Assets.X_RATIO), (int)(154*2*Assets.Y_RATIO));
		jars_bounds[2] = new Rectangle((int)((250 + 421*2)*Assets.X_RATIO), (int)((400 + 35*2)*Assets.Y_RATIO), (int)(120*2*Assets.X_RATIO), (int)(119*2*Assets.Y_RATIO));
		jars_bounds[3] = new Rectangle((int)((250 + 590*2)*Assets.X_RATIO), (int)((400 + 8*2)*Assets.Y_RATIO), (int)(119*2*Assets.X_RATIO), (int)(146*2*Assets.Y_RATIO));
		for(short i = 0; i < 4; i++) {jars[i] = new Jar(jars_bounds[i]);}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH:
			bounds = new Rectangle((int)(1200*Assets.X_RATIO), (int)(210*Assets.Y_RATIO), (int)(916/2*Assets.X_RATIO), (int)(384/2*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().jars_on_wall, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
			
		case WALL_WITH_COUCH_JARS:
			bounds = new Rectangle((int)(250*Assets.X_RATIO), (int)(400*Assets.Y_RATIO), (int)(800*2*Assets.X_RATIO), (int)(200*2*Assets.Y_RATIO));
			for(Jar jar : jars) {jar.render(g);}
			g.drawImage(Launcher.game.get_assets().jars, bounds.x, bounds.y, bounds.width, bounds.height, null);
			safe.render(g);
			break;
			
		default: break;
		}
	}
	
	public void check()
	{//oko surce ezik
		if(jars[0].get_organ() == Items.EYE && 
				jars[1].get_organ() == Items.HEART && 
				jars[2].get_organ() == Items.TONGUE && 
				jars[3].get_organ() == Items.EAR)
		{
			safe.set_opened();
			Audio.play_safe_opening();
			
			if(Home_menu.earned[2] == 0)
			{
				Home_menu.write_file(3, "1");
				Audio.play_achievement();
				Star.set_on_screen();
			}
		}
	}
	
	//getters and setters
	public Jars_Safe get_safe() {return safe;}
	public Jar[] get_jars() {return jars;}
	public Rectangle get_bounds() {return bounds;}
}