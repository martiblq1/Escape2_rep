package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public class Shape_element
{
	private Rectangle bounds;
	
	private int shape_index, x_from_mouse, y_from_mouse;
	
	Shape_element(int index, int x, int y, int shape_index)
	{
		bounds = new Rectangle(x, y, (int)(14*7*Assets.X_RATIO), (int)(14*7*Assets.Y_RATIO));
		this.shape_index = shape_index;
	}
	
	public void tick() {bounds = new Rectangle(MouseInfo.getPointerInfo().getLocation().x - x_from_mouse, MouseInfo.getPointerInfo().getLocation().y - y_from_mouse, bounds.width, bounds.height);}
	
	public void render(Graphics g) {g.drawImage(Launcher.game.get_assets().shapes_shapes[shape_index], bounds.x, bounds.y, bounds.width, bounds.height, null);}
	
	public boolean overlaps (Rectangle r) {return bounds.x < r.x + r.width && bounds.x + bounds.width > r.x + (int)(14*7*Assets.X_RATIO) && bounds.y < r.y + r.height && bounds.y + bounds.height > r.y + (int)(14*7*Assets.Y_RATIO);}//credit to that one guy on stackoverflow
	
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public void set_bounds(int x, int y) {bounds = new Rectangle(bounds.x + x, bounds.y + y, bounds.width, bounds.height);}
	public int get_shape_index() {return shape_index;}
	public void set_x_from_mouse() {x_from_mouse = MouseInfo.getPointerInfo().getLocation().x - bounds.x;}
	public void set_y_from_mouse() {y_from_mouse = MouseInfo.getPointerInfo().getLocation().y - bounds.y;}
}
