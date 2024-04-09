package wall_with_donkey_objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Digit
{
	private Rectangle bounds;
	
	private short digit, x;
	
	Digit(int x)
	{
		bounds = new Rectangle(x, (int)(595*Assets.Y_RATIO), (int)(264*Assets.X_RATIO), (int)(377*Assets.Y_RATIO));
		digit = 0;
		this.x = (short)(x);
	}
	
	public void tick()
	{
		x += (int)(15*Assets.X_RATIO);
	}
	
	public void render(Graphics g) {g.drawImage(Launcher.game.get_assets().machine_digits[digit], x, bounds.y, bounds.width, bounds.height, null);}
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public short get_digit() {return digit;}
	
	public void set_digit()
	{
		if(digit != 9)
			digit++;
		else
			digit = 0;
	}
}
