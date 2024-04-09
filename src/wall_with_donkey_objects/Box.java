package wall_with_donkey_objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Audio;
import main.Launcher;

public class Box
{
	private Digit[] digits;
	
	private Rectangle bounds, cube_bounds;
	
	private short x, color_x, sign_x, symbol_x;
	private boolean moving;
	
	Box()
	{
		digits = new Digit[3];
		digits[0] = new Digit((int)((811 - 500)*Assets.X_RATIO));
		digits[1] = new Digit((int)(811*Assets.X_RATIO));
		digits[2] = new Digit((int)((811 + 500)*Assets.X_RATIO));
		bounds = new Rectangle((int)((1920/2 - 77 - 434 + 51*2)*Assets.X_RATIO), (int)((220 + 293*2)*Assets.Y_RATIO), (int)(176*2*Assets.X_RATIO), (int)(81*2*Assets.Y_RATIO));
		cube_bounds = new Rectangle((int)(707*Assets.X_RATIO), (int)(318*Assets.Y_RATIO), (int)(421*Assets.X_RATIO), (int)(421*Assets.Y_RATIO));
		x = (short)(51*Assets.X_RATIO);
		color_x = 0;
		sign_x = (short)((1920/2 - 77 - 403/2 + 55 + 201 - 75)*Assets.X_RATIO);
		symbol_x = (short)((1920/2 - 77 - 403/2 + 55)*Assets.X_RATIO);
		moving = false;
	}
	
	public void check_digits()
	{
		if(digits[0].get_digit() == 3 && 
				digits[1].get_digit() == 1 && 
				digits[2].get_digit() == 5)
		{
			moving = true;
			Audio.play_slide();
		}
	}
	
	public void tick()
	{
		if(x < (int)((177 + 51)*Assets.X_RATIO))
		{
			x += (int)(5*Assets.X_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
		}
		
		if(moving && color_x < (int)(1920*Assets.X_RATIO))
		{
			color_x += (int)(15*Assets.X_RATIO);
			symbol_x += (int)(15*Assets.X_RATIO);
			sign_x += (int)(15*Assets.X_RATIO);
			for(short i = 0; i < 3; i++) {digits[i].tick();}
			Launcher.game.get_window().get_panel().set_changed();
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_DONKEY:
			g.drawImage(Launcher.game.get_assets().machine_box_opened, (int)((731 + 51)*Assets.X_RATIO), (int)((535 + 293)*Assets.Y_RATIO), (int)(176*Assets.X_RATIO), (int)(80*Assets.Y_RATIO), null);
			g.drawImage(Launcher.game.get_assets().machine_box, (int)(731*Assets.X_RATIO) + x, (int)((535 + 293)*Assets.Y_RATIO), (int)(177*Assets.X_RATIO), (int)(81*Assets.Y_RATIO), null);
			break;
		
		case WALL_WITH_DONKEY_MACHINE:
			g.drawImage(Launcher.game.get_assets().machine_box_opened, bounds.x, bounds.y, bounds.width, bounds.height, null);
			g.drawImage(Launcher.game.get_assets().machine_box, (int)((1920/2 - 77 - 434)*Assets.X_RATIO) + x*2, (int)((220 + 293*2)*Assets.Y_RATIO), (int)(177*2*Assets.X_RATIO), (int)(81*2*Assets.Y_RATIO), null);
			break;
			
		case WALL_WITH_DONKEY_MACHINE_NUMBERS:
			g.setColor(new Color(44, 44, 44));
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().black_cube, cube_bounds.x, cube_bounds.y, cube_bounds.width, cube_bounds.height, null);
			g.setColor(new Color(84, 84, 84));
			g.fillRect(color_x, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().TP_symbol, symbol_x, 0, (int)(403*Assets.X_RATIO), (int)(465*Assets.Y_RATIO), null);
			g.drawImage(Launcher.game.get_assets().machine_sign, sign_x, (int)(480*Assets.Y_RATIO), (int)(153*Assets.X_RATIO), (int)(69*Assets.Y_RATIO), null);
			for(short i = 0; i < 3; i++) {digits[i].render(g);}
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Digit[] get_digits() {return digits;}
	public Rectangle get_bounds() {return bounds;}
	public Rectangle get_cube_bounds() {return cube_bounds;}
	public boolean get_moving() {return moving;}
}
