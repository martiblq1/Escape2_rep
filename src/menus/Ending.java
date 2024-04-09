package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Assets;
import main.Launcher;

public final class Ending
{
	//FIELDS--------------------------------------------------------
	//oracle classes
	private static Graphics2D g2d;
	private static final Font FONT_TITLE = new Font("Arial", Font.PLAIN, 100), FONT_TEXT = new Font("Ariel", Font.PLAIN, 30);
	private static final Rectangle CONTINUE = new Rectangle((int)(970*Assets.X_RATIO), (int)(740*Assets.Y_RATIO), (int)(452*Assets.X_RATIO), (int)(183*Assets.Y_RATIO)), ACHIEVEMENTS = new Rectangle((int)(1450*Assets.X_RATIO), (int)(740*Assets.Y_RATIO), (int)(452*Assets.X_RATIO), (int)(183*Assets.Y_RATIO));
	
	//data types
	private static final int X = (int)(970*Assets.X_RATIO), Y_CHANGE = (int)(80*Assets.Y_RATIO), Y_DEFAULT = (int)(360*Assets.Y_RATIO);
	private static int y = Y_DEFAULT;
	
	//METHODS-------------------------------------------------------
	//private
	private static void draw_text(final String TEXT)
	{
		g2d.drawString(TEXT, X, y);
		y += Y_CHANGE;
	}
	
	//static
	public static boolean is_continue_clicked(final int X, final int Y)
	{
		if(CONTINUE.contains(X, Y)) {return true;}
		return false;
	}
	
	public static boolean is_achievements_clicked(final int X, final int Y)
	{
		if(ACHIEVEMENTS.contains(X, Y)) {return true;}
		return false;
	}
	
	public static void render(Graphics g)
	{
		if(g2d == null)
		{
			g2d = (Graphics2D) g.create();
			g2d.setColor(Color.WHITE);
		}
		
		g.drawImage(Assets.space, 0, 0, (int)(1920*Assets.X_RATIO), (int)(1080*Assets.Y_RATIO), null);
		g2d.setFont(FONT_TITLE);
		g.drawImage(Launcher.game.get_assets().continue_, CONTINUE.x, CONTINUE.y, CONTINUE.width, CONTINUE.height, null);
		g.drawImage(Launcher.game.get_assets().achievements_button, ACHIEVEMENTS.x, ACHIEVEMENTS.y, ACHIEVEMENTS.width, ACHIEVEMENTS.height, null);
		
		switch(Launcher.game.get_core_scene())
		{
		case ENDING_1:
			g2d.drawString("Ending I", (int)((1920 - 351)/2*Assets.X_RATIO), (int)(180*Assets.Y_RATIO));
			g2d.setFont(FONT_TEXT);
			draw_text("After going through the door you find yourself in a forest.");
			draw_text("You don't remember how you got inside of the room in the first place,");
			draw_text("but now you are free. You follow the dark path in the woods hoping");
			draw_text("to find a way out.");
			y = Y_DEFAULT;
			g.drawImage(Launcher.game.get_assets().ending_1, (int)(358*Assets.X_RATIO), (int)(240*Assets.Y_RATIO), (int)(512*Assets.X_RATIO), (int)(768*Assets.Y_RATIO), null);
			return;
		
		case ENDING_2:
			g2d.drawString("Ending II", (int)((1920 - 379)/2*Assets.X_RATIO), (int)(180*Assets.Y_RATIO));
			g2d.setFont(FONT_TEXT);
			y = Y_DEFAULT - (int)(80*Assets.Y_RATIO);
			draw_text("You put the rose in the vase and after touching the table");
			draw_text("you find yourself in a strange red room. You sit on one of the chairs");
			draw_text("and suddenly you lose all desire to escape.");
			draw_text("You feel your thoughts getting simpler the more time you spend here,");
			draw_text("but that doesn't bother you. As you lose yourself,");
			draw_text("spending eternity here doesn't seem like a bad option.");
			y = Y_DEFAULT;
			g.drawImage(Launcher.game.get_assets().ending_2, (int)(358*Assets.X_RATIO), (int)(240*Assets.Y_RATIO), (int)(512*Assets.X_RATIO), (int)(768*Assets.Y_RATIO), null);
			return;
		
		case ENDING_3:
			g2d.drawString("Ending III", (int)((1920 - 407)/2*Assets.X_RATIO), (int)(180*Assets.Y_RATIO));
			g2d.setFont(FONT_TEXT);
			draw_text("You find a mysterious black cube. As you hold it,");
			draw_text("you see memories inside that don't belong to you. As time passes,");
			draw_text("what you see starts to become familiar.");
			draw_text("You start remembering all your past lives,");
			draw_text("as all the people you were mesh into a single person.");
			y = Y_DEFAULT;
			g.drawImage(Launcher.game.get_assets().ending_3, (int)(358*Assets.X_RATIO), (int)(240*Assets.Y_RATIO), (int)(512*Assets.X_RATIO), (int)(768*Assets.Y_RATIO), null);
			return;
			
		default: break;
		}
	}
}