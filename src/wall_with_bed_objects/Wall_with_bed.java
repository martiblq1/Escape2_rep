package wall_with_bed_objects;

import java.awt.Color;
import java.awt.Graphics;

import main.Assets;
import main.Launcher;

public class Wall_with_bed
{
	private Bed bed;
	private Drawers drawers;
	private Shapes shapes;
	private Shelf shelf;
	
	public Wall_with_bed(Assets assets)
	{
		bed = new Bed(assets);
		drawers = new Drawers(assets);
		shapes = new Shapes(assets);
		shelf = new Shelf(assets);
	}
	
	public void tick()
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED_BED:
			bed.tick();
			break;
		
		case WALL_WITH_BED_DRAWERS:
			drawers.tick();
			break;
			
		case WALL_WITH_BED_DRAWERS_DRAWER:
			drawers.tick();
			break;
			
		case WALL_WITH_BED_SHAPES:
			shapes.tick();
			break;
			
		case WALL_WITH_BED_UPPERSHELF:
			shelf.tick();
			break;
			
		default:
			break;
		}
	}
	
	public void render(Graphics g)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED:
			g.drawImage(Launcher.game.get_assets().room, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			Launcher.game.get_arrows()[1].render(g);
			Launcher.game.get_arrows()[2].render(g);
			bed.render(g);
			drawers.render(g);
			shapes.render(g);
			shelf.render(g);
			break;
		
		case WALL_WITH_BED_BED:
			bed.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_BED_DRAWERS:
			g.drawImage(Launcher.game.get_assets().wall_with_floor, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			drawers.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_BED_DRAWERS_DRAWER:
			drawers.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_BED_SHAPES:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			shapes.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_BED_UPPERSHELF:
			g.drawImage(Launcher.game.get_assets().wall, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
			shelf.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_BED_CABINET_0:
			g.setColor(new Color(51, 37, 28));
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().paper_2, (int)((1920/2 - 304 - 35)*Assets.X_RATIO), (int)(30*Assets.Y_RATIO), (int)(304*2*Assets.X_RATIO), (int)(406*2*Assets.Y_RATIO), null);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_BED_SHELF_BOX:
			g.setColor(new Color(127, 96, 71));
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			shelf.render(g);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		case WALL_WITH_BED_CABINET_1:
			g.setColor(new Color(51, 37, 28));
			g.fillRect(0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO));
			g.drawImage(Launcher.game.get_assets().paper_1, (int)((1920/2 - 304 - 35)*Assets.X_RATIO), (int)(30*Assets.Y_RATIO), (int)(304*2*Assets.X_RATIO), (int)(406*2*Assets.Y_RATIO), null);
			Launcher.game.get_arrows()[0].render(g);
			break;
			
		default:break;
		}
	}
	
	//getters and setters
	public Bed get_bed(){return bed;}
	public Drawers get_drawers(){return drawers;}
	public Shapes get_shapes() {return shapes;}
	public Shelf get_shelf() {return shelf;}
}
