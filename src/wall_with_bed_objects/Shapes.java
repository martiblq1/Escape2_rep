package wall_with_bed_objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.Assets;
import main.Item;
import main.Items;
import main.Launcher;

public class Shapes
{
	private Item handle;
	private Assets assets;
	
	private ArrayList<Shape> shapes;
	private Rectangle bounds;
	private Rectangle[][] positions;
	
	private int level;
	private boolean playing;
	
	Shapes(Assets assets)
	{
		this.assets = assets;
		shapes = new ArrayList<>();
		bounds = new Rectangle((int)(1116*Assets.X_RATIO), (int)(236*Assets.Y_RATIO), (int)(76*2*Assets.X_RATIO), (int)(76*2*Assets.Y_RATIO));
		positions = new Rectangle[5][5];
		level = 0;
		playing = true;
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++) {positions[i][j] = new Rectangle((int)((1920/2 - 86*7/2 - 30 + 3*7 + i*14*7)*Assets.X_RATIO), (int)((1080/2 - 86*7/2 + 3*7 + j*14*7)*Assets.Y_RATIO), (int)(14*7*Assets.X_RATIO), (int)(14*7*Assets.Y_RATIO));}
		}
	}
	
	public void tick()
	{	
		if(playing)
		{
			if(level == 0)
				next_level();
			
			for(Shape shape : shapes)
			{
				if(shape.get_selected())
				{
					shape.set_set(false);
					shape.tick();
					
					for(int i = 0; i < positions.length; i++)
					{
						for(int j = 0; j < positions[i].length; j++)
						{
							if(positions[i][j].contains(shape.get_shape_elements().get(0).get_bounds().x, shape.get_shape_elements().get(0).get_bounds().y))
							{
								boolean overlaps = false;
								overlaps = overlaps(shape);
								
								if(!overlaps)
								{
									shape.set_bounds(positions[i][j].x, positions[i][j].y);
									shape.set_set(true);
								}
							}
						}
					}
					
					Launcher.game.get_window().get_panel().set_changed();
				}
			}
			
			if(filled())
			{
				shapes.clear();
				Launcher.game.get_fade().set_fading();
				next_level();
			}
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED:
			g.drawImage(Launcher.game.get_assets().shapes, bounds.x, bounds.y, bounds.width, bounds.height, null);
			break;
		
		case WALL_WITH_BED_SHAPES:
			g.drawImage(Launcher.game.get_assets().shapes, (int)((1920/2 - 86*7/2 - 30)*Assets.X_RATIO), (int)((1080/2 - 86*7/2)*Assets.Y_RATIO), (int)(76*7*Assets.X_RATIO), (int)(76*7*Assets.Y_RATIO), null);
			for(int i = shapes.size() - 1; i >= 0; i--) {shapes.get(i).render(g);}
			if(handle != null) {handle.render(g);}
			break;
			
		default: break;
		}
	}
	
	private void next_level()
	{
		boolean[][] matrix;
		
		switch(level)
		{
		case 0:
		    matrix = new boolean[][]{{false, true, true}, {false, true, false}, {true, true, true}};
		    shapes.add(new Shape(matrix, 0, (int) (60 * Assets.X_RATIO), (int) (20 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{false, true, false}, {true, true, true}, {true}, {true}};
		    shapes.add(new Shape(matrix, 1, (int) (30 * Assets.X_RATIO), (int) (600 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{false, true}, {false, true}, {true, true}, {false, true}};
		    shapes.add(new Shape(matrix, 2, (int) (300 * Assets.X_RATIO), (int) (300 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, true}};
		    shapes.add(new Shape(matrix, 3, (int) (1200 * Assets.X_RATIO), (int) (250 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, true}, {true}, {true}, {true}, {true}};
		    shapes.add(new Shape(matrix, 4, (int) (1500 * Assets.X_RATIO), (int) (300 * Assets.Y_RATIO)));
		    break;

		case 1:
		    matrix = new boolean[][]{{true, true, true, true}};
		    shapes.add(new Shape(matrix, 0, (int) (60 * Assets.X_RATIO), (int) (20 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{false, true}, {true, true}};
		    shapes.add(new Shape(matrix, 1, (int) (30 * Assets.X_RATIO), (int) (600 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, true, true}, {false, true}};
		    shapes.add(new Shape(matrix, 2, (int) (300 * Assets.X_RATIO), (int) (300 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, true, true}};
		    shapes.add(new Shape(matrix, 3, (int) (1200 * Assets.X_RATIO), (int) (250 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true}, {true}, {true, true, true}};
		    shapes.add(new Shape(matrix, 4, (int) (1500 * Assets.X_RATIO), (int) (300 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, true, true}, {false, false, true}};
		    shapes.add(new Shape(matrix, 1, (int) (1400 * Assets.X_RATIO), (int) (500 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true}, {true}};
		    shapes.add(new Shape(matrix, 3, (int) (1350 * Assets.X_RATIO), (int) (800 * Assets.Y_RATIO)));
		    break;

		case 2:
		    matrix = new boolean[][]{{true}, {true}, {true}};
		    shapes.add(new Shape(matrix, 0, (int) (60 * Assets.X_RATIO), (int) (20 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{false, true}, {true, true}, {true, false}};
		    shapes.add(new Shape(matrix, 1, (int) (30 * Assets.X_RATIO), (int) (600 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{false, false, true}, {true, true, true}};
		    shapes.add(new Shape(matrix, 2, (int) (300 * Assets.X_RATIO), (int) (300 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, true, true}, {false, false, true}};
		    shapes.add(new Shape(matrix, 3, (int) (1200 * Assets.X_RATIO), (int) (250 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, false}, {true, true}, {true, false}};
		    shapes.add(new Shape(matrix, 4, (int) (1500 * Assets.X_RATIO), (int) (300 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true}, {true}, {true}};
		    shapes.add(new Shape(matrix, 0, (int) (1400 * Assets.X_RATIO), (int) (500 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, true}, {true}};
		    shapes.add(new Shape(matrix, 3, (int) (1350 * Assets.X_RATIO), (int) (800 * Assets.Y_RATIO)));
		    break;

		case 3:
		    matrix = new boolean[][]{{true, true, true, true, true}, {true, false, false, false, true}, {true, false, false, false, true}, {true, false, false, false, true}, {true, true, true, true, true}};
		    shapes.add(new Shape(matrix, 0, (int) (60 * Assets.X_RATIO), (int) (20 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true, true, true}, {true, false, true}, {true, true, true}};
		    shapes.add(new Shape(matrix, 3, (int) (30 * Assets.X_RATIO), (int) (600 * Assets.Y_RATIO)));
		    matrix = new boolean[][]{{true}};
		    shapes.add(new Shape(matrix, 4, (int) (300 * Assets.X_RATIO), (int) (300 * Assets.Y_RATIO)));
		    break;
			
		default: break;
		}
		
		level++;
		
		if(level == 5)
		{
			playing = false;
			handle = new Item(Items.HANDLE, true, assets, -1);
		}
	}
	
	private boolean overlaps(Shape shape)
	{
		for(Shape shape1 : shapes)
		{
			if(shape != shape1)
			{
				for(int i = 0; i < shape.get_shape_elements().size(); i++)
				{
					for(int j = 0; j < shape1.get_shape_elements().size(); j++)
					{
						if(shape.get_shape_elements().get(i).overlaps(shape1.get_shape_elements().get(j).get_bounds())) {return true;}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean filled()
	{
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				boolean filled = false;
				
				for(Shape shape : shapes)
				{	
					for(Shape_element shape_element : shape.get_shape_elements())
					{
						if(positions[i][j].x == shape_element.get_bounds().x && positions[i][j].y == shape_element.get_bounds().y)
						{
							filled = true;
						}
					}
				}
				
				if(!filled) {return false;}
			}
		}
		
		return true;
	}
	//getters and setters
	public Rectangle get_bounds() {return bounds;}
	public ArrayList<Shape> get_shapes() {return shapes;}
	public Item get_handle() {return handle;}
	public void set_item(Item item) {handle = item;}
}
