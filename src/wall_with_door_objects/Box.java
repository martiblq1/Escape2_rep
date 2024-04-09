package wall_with_door_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Box
{
	private Symbol[] symbols;
	private Item key;
	
	private Rectangle bounds;
	
	private boolean opened;
	
	Box(Assets assets)
	{
		symbols = new Symbol[4];
		symbols[0] = new Symbol((int)(((1920 - 77*2)/2 - 550*3/2 + 118*3)*Assets.X_RATIO));
		symbols[1] = new Symbol((int)(((1920 - 77*2)/2 - 550*3/2 + 211*3)*Assets.X_RATIO));
		symbols[2] = new Symbol((int)(((1920 - 77*2)/2 - 550*3/2 + 294*3)*Assets.X_RATIO));
		symbols[3] = new Symbol((int)(((1920 - 77*2)/2 - 550*3/2 + 387*3)*Assets.X_RATIO));
		key = new Item(Items.KEY_DRAWER_0, true, assets, -1);
		bounds = new Rectangle((int)(1260*Assets.X_RATIO), (int)(752*Assets.Y_RATIO), (int)(371*Assets.X_RATIO), (int)(202*Assets.Y_RATIO));
		opened = false;
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DOOR:
			g.drawImage(Launcher.game.get_assets().box_with_signs, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
		
		case WALL_WITH_DOOR_BOX:
			if(!opened)
			{
				g.drawImage(Launcher.game.get_assets().box_with_signs_1, (int)(((1920 - 77*2)/2 - 550*3/2)*Assets.X_RATIO), (int)(20*Assets.Y_RATIO), (int)(550*3*Assets.X_RATIO), (int)(342*3*Assets.Y_RATIO), null);
				for(Symbol symbol : symbols) {symbol.render(g);}
				break;
			}
			
			g.drawImage(Launcher.game.get_assets().box_with_signs_opened, (int)(((1920 - 77*2)/2 - 550*3/2)*Assets.X_RATIO), (int)((20 - 236*3)*Assets.Y_RATIO), (int)(550*3*Assets.X_RATIO), (int)((342 + 236)*3*Assets.Y_RATIO), null);
			if(key != null) {key.render(g);}
			break;
			
		default: break;
		}
	}
	
	public void check_combination()
	{
		if(symbols[0].get_symbol() == 6 && symbols[1].get_symbol() == 8 && symbols[2].get_symbol() == 1 && symbols[3].get_symbol() == 3)
		{
			opened = true;
			Launcher.game.get_window().get_panel().set_changed();
		}
	}
	
	//getters and setters
	public Symbol[] get_symbols() {return symbols;}
	public Item get_key() {return key;}
	public void set_key() {key = null;}
	public Rectangle get_bounds() {return bounds;}
	public boolean get_opened() {return opened;}
}
