package wall_with_bed_objects;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Assets;
import main.Launcher;

public class Shape
{
	private ArrayList<Shape_element> shape_elements;
	
	private boolean selected, set;
	
	Shape(boolean[][] matrix, int shape_index, int x, int y)
	{
		shape_elements = new ArrayList<>();
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(matrix[i][j])
				{
					shape_elements.add(new Shape_element(Launcher.game.get_wall_with_bed().get_shapes().get_shapes().size(), x + (int)(j*14*7*Assets.X_RATIO), y + (int)(i*14*7*Assets.Y_RATIO), shape_index));
				}
			}
		}
		
		set = false;
		selected = false;
	}
	
	public void tick() {for(Shape_element shape : shape_elements) {shape.tick();}}
	
	public void render(Graphics g) {for(Shape_element shape_element : shape_elements) {shape_element.render(g);}}
	
	//getters and setters
	public ArrayList<Shape_element> get_shape_elements() {return shape_elements;}
	public boolean get_selected() {return selected;}
	public void set_selected(boolean selected){this.selected = selected;}
	
	public void set_bounds(int x, int y)
	{
		int new_x = x - shape_elements.get(0).get_bounds().x;
		int new_y = y - shape_elements.get(0).get_bounds().y;
		for(Shape_element shape : shape_elements) {shape.set_bounds(new_x, new_y);}
		Launcher.game.get_window().get_panel().set_changed();
	}
	
	public boolean get_set() {return set;}
	public void set_set(boolean set) {this.set = set;}
}
