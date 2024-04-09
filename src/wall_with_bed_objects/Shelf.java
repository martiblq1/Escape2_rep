package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Shelf
{
	private Assets assets;
	private Item jug, key;
	private Gear gear_0, gear_1, gear_2;
	private Button[] buttons;
	private Item ear;
	
	private Rectangle[] bounds;
	private Rectangle box_bounds;
	
	private short last_pressed, box_y;
	private boolean cabinet_0_opened, box_opened, cabinet_1_opened;
	
	Shelf(Assets assets)
	{
		this.assets = assets;
		jug = new Item(Items.JUG, true, assets, -1);
		key = new Item(Items.KEY_SHELF_CABINET_1, true, assets, -1);
		bounds = new Rectangle[3];
		bounds[0] = new Rectangle((int)(300*Assets.X_RATIO), (int)(750*Assets.Y_RATIO), (int)(109*1.5*Assets.X_RATIO), (int)(122*1.5*Assets.Y_RATIO));
		bounds[1] = new Rectangle((int)((300 + (int)(109*1.5))*Assets.X_RATIO), (int)(750*Assets.Y_RATIO), (int)(111*1.5*Assets.X_RATIO), (int)(122*1.5*Assets.Y_RATIO));
		bounds[2] = new Rectangle((int)(300*Assets.X_RATIO), (int)((750 - 291*1.5 + 1)*Assets.Y_RATIO), (int)((220*1.5 - 1)*Assets.X_RATIO), (int)(291*1.5*Assets.Y_RATIO));
		gear_0 = new Gear('0');
		gear_1 = new Gear('1');
		gear_2 = new Gear('2');
		buttons = new Button[8];
		for(short i = 0; i < 8; i++) {buttons[i] = new Button(i);}
		box_bounds = new Rectangle((int)((490 + 63*4)*Assets.X_RATIO), (int)((-80 + 59*4)*Assets.Y_RATIO), (int)(96*4*Assets.X_RATIO), (int)(44*4*Assets.Y_RATIO));
		last_pressed = -1;
		box_y = (short)((-80 + 146*4)*Assets.Y_RATIO);
		cabinet_0_opened = false;
		box_opened = false;
		cabinet_1_opened = false;
		ear = new Item(Items.EAR, true, assets, -1);
	}
	
	public void tick()
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED_UPPERSHELF:
			gear_0.tick();
			gear_1.tick();
			gear_2.tick();
			if(gear_0.get_spinning() && gear_1.get_spinning() && gear_2.get_spinning() && box_y > (int)((-80 + 146*4 - 100)*Assets.Y_RATIO)) {box_y -= (int)(5*Assets.Y_RATIO);}
			break;
		
		default: break;
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED:
			bounds[0] = new Rectangle((int)(300*Assets.X_RATIO), (int)(750*Assets.Y_RATIO), (int)(109*1.5*Assets.X_RATIO), (int)(122*1.5*Assets.Y_RATIO));
			bounds[1] = new Rectangle((int)((300 + (int)(109*1.5))*Assets.X_RATIO), (int)(750*Assets.Y_RATIO), (int)(111*1.5*Assets.X_RATIO), (int)(122*1.5*Assets.Y_RATIO));
			bounds[2] = new Rectangle((int)(300*Assets.X_RATIO), (int)((750 - 291*1.5 + 1)*Assets.Y_RATIO), (int)((220*1.5 - 1)*Assets.X_RATIO), (int)(291*1.5*Assets.Y_RATIO));
			
			if(cabinet_0_opened)
				g.drawImage(assets.shelf[3], bounds[0].x - (int)(95*1.5*Assets.X_RATIO), bounds[0].y, (int)(bounds[0].width + (95*1.5 + 1)*Assets.X_RATIO), bounds[0].height, null);
			else
				g.drawImage(assets.shelf[0], bounds[0].x, bounds[0].y, bounds[0].width, bounds[0].height, null);
			
			if(cabinet_1_opened)
				g.drawImage(assets.shelf[4], bounds[1].x, bounds[1].y, (int)(bounds[1].width + 95*1.5*Assets.X_RATIO), bounds[1].height, null);
			else
				g.drawImage(assets.shelf[1], bounds[1].x, bounds[1].y, bounds[1].width, bounds[1].height, null);
			
			g.drawImage(assets.shelf[2], bounds[2].x, bounds[2].y, bounds[2].width, bounds[2].height, null);
			if(jug != null) {g.drawImage(assets.jug, (int)(441*Assets.X_RATIO), (int)((750 - 291*1.5 + 1 + 363)*Assets.Y_RATIO), (int) (44*1.5*Assets.X_RATIO), (int) (49*1.5*Assets.Y_RATIO), null);}
			gear_0.render(g);
			gear_1.render(g);
			gear_2.render(g);
			g.drawImage(assets.shelf_upper_locked_box, (int)((300 + (int)(144*1.5))*Assets.X_RATIO), (int)((750 - 291*1.5 + 146*1.5)*Assets.Y_RATIO), (int)(60*1.5*Assets.X_RATIO), (int)(47*1.5*Assets.Y_RATIO), null);
			break;
			
		case WALL_WITH_BED_UPPERSHELF:
			bounds[2] = new Rectangle((int)(490*Assets.X_RATIO), (int)(-80*Assets.Y_RATIO), (int)(220*4*Assets.X_RATIO), (int)(291*4*Assets.Y_RATIO));
			g.drawImage(assets.shelf[2], bounds[2].x, bounds[2].y, bounds[2].width, bounds[2].height, null);
			g.drawImage(assets.signs[0], (int)(1150*Assets.X_RATIO), (int)(850*Assets.Y_RATIO), (int)(30*3*Assets.X_RATIO), (int)(26*3*Assets.Y_RATIO), null);
			g.drawImage(assets.signs[1], (int)(890*Assets.X_RATIO), (int)(20*Assets.Y_RATIO), (int)(50*3*Assets.X_RATIO), (int)(19*3*Assets.Y_RATIO), null);
			if(jug != null) {jug.render(g);}
			gear_0.render(g);
			gear_1.render(g);
			gear_2.render(g);
			g.drawImage(Launcher.game.get_assets().shelf_upper_unlocked_box, (int)(1080*Assets.X_RATIO), (int)(560*Assets.Y_RATIO), (int)(222*Assets.X_RATIO), (int)(129*Assets.Y_RATIO), null);
			if(key != null) {key.render(g);}
			g.drawImage(assets.shelf_upper_locked_box, (int)((490 + 144*4)*Assets.X_RATIO), box_y, (int)(60*4*Assets.X_RATIO), (int)(47*4*Assets.Y_RATIO), null);
			break;
		
		case WALL_WITH_BED_SHELF_BOX:
			if(!box_opened)
			{
				g.drawImage(assets.shelf_box_locked, (int)((1920/2 - 398*3/2)*Assets.X_RATIO), (int)(140*Assets.Y_RATIO), (int)(398*3*Assets.X_RATIO), (int)(289*3*Assets.Y_RATIO), null);
				for(Button button : buttons) {button.render(g);}
				break;
			}
			//if it's opened
			g.drawImage(assets.shelf_box_unlocked, (int)((1920/2 - 398*3/2)*Assets.X_RATIO), (int)((140 - 165*3)*Assets.Y_RATIO), (int)(398*3*Assets.X_RATIO), (int)(454*3*Assets.Y_RATIO), null);
			if(ear != null) {ear.render(g);}
			break;
			
		default: break;
		}
	}
	
	public void check_buttons(short button)
	{
		boolean all_pushed = true;
		
		for(Button b : buttons)
			if(!b.get_pushed()) {all_pushed = false;}
		
		if(all_pushed)
		{
			box_opened = true;
			return;
		}
		
		if(last_pressed == -1)
		{
			last_pressed = button;
			return;
		}
		
		if(last_pressed%2 == 0)
		{
			if(button == last_pressed + 1)
			{
				last_pressed = -1;
				return;
			}
			
			for(Button b : buttons) {b.set_pushed(false);}
			last_pressed = -1;
			return;
		}
		
		if(button == last_pressed - 1)
		{
			last_pressed = -1;
			return;
		}
		
		for(Button b : buttons) {b.set_pushed(false);}
		last_pressed = -1;
	}
	
	//getters and setters
	public Rectangle[] get_bounds() {return bounds;}
	public Item get_jug() {return jug;}
	public void set_jug(Item item) {jug = item;}
	public Item get_key() {return key;}
	public void set_key() {key = null;}
	public Gear get_gear_0() {return gear_0;}
	public Gear get_gear_1() {return gear_1;}
	public Gear get_gear_2() {return gear_2;}
	public boolean get_cabinet_0_opened() {return cabinet_0_opened;}
	public void set_cabinet_0_opened() {cabinet_0_opened = true;}
	public boolean get_cabinet_1_opened() {return cabinet_1_opened;}
	public void set_cabinet_1_opened() {cabinet_1_opened = true;}
	public Rectangle get_box_bounds() {return box_bounds;}
	public Button[] get_buttons() {return buttons;}
	public boolean get_box_opened() {return box_opened;}
	public Item get_ear() {return ear;}
	public void set_ear(Item item) {ear = item;}
}