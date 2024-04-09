package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;

import main.Assets;
import main.Launcher;

public class Home_menu
{
	private Page page;
	private static A ear, carpet, jar, door, code, chair, arm, cube;
	
	private Rectangle play_bounds, resume_bounds, escape_bounds, info_bounds, reset_bounds, ticked_bounds = new Rectangle((int)(1139*Assets.X_RATIO), (int)(923*Assets.Y_RATIO), (int)(56*Assets.X_RATIO), (int)(56*Assets.Y_RATIO)), 
			star_video_bounds = new Rectangle((int)(300*Assets.X_RATIO), (int)(450*Assets.Y_RATIO), (int)(130*Assets.X_RATIO), (int)(130*Assets.Y_RATIO));
	private static File file;
	private static Graphics2D g2d;
	private static final Font FONT_TITLE = new Font("Arial", Font.PLAIN, 70);
	
	public static int[] earned;
	private short triangle_x, new_triangle_x, ticks, x_cof;
	private boolean triangle_moving, ticked = false;
	
	public Home_menu(Assets assets)
	{
		read_file();
		page = Page.RESUME;
		play_bounds = new Rectangle((int)((1920/2 - 118/2)*Assets.X_RATIO), (int)(150*Assets.Y_RATIO), (int)(118*Assets.X_RATIO), (int)(118*Assets.Y_RATIO));
		resume_bounds = new Rectangle((int)((1920/2 - 691/2)*Assets.X_RATIO), (int)(600*Assets.Y_RATIO), (int)(691*Assets.X_RATIO), (int)(280*Assets.Y_RATIO));
		escape_bounds = new Rectangle((int)((1920/2 - 118/2 + 300*2)*Assets.X_RATIO), (int)(150*Assets.Y_RATIO), (int)(118*Assets.X_RATIO), (int)(118*Assets.Y_RATIO));
		info_bounds = new Rectangle((int)(300*Assets.X_RATIO), (int)(150*Assets.Y_RATIO), (int)(118*Assets.X_RATIO), (int)(118*Assets.Y_RATIO));
		reset_bounds = new Rectangle((int)(600*Assets.X_RATIO), (int)(150*Assets.Y_RATIO), (int)(118*Assets.X_RATIO), (int)(118*Assets.Y_RATIO));
		triangle_x = (short)((1920/2 - 20/2)*Assets.X_RATIO);
		triangle_moving = false;
		ticks = 0;
		x_cof = 0;
		ear = new A(assets.achievements[0], 535, 450, assets.achievement_names[0], assets.achievements[8]);
		carpet = new A(assets.achievements[1], 535 + 151 + 80, 450, assets.achievement_names[2], assets.achievements[9]);
		jar = new A(assets.achievements[2], 535 + (151 + 80)*2, 450, assets.achievement_names[1], assets.achievements[10]);
		door = new A(assets.achievements[3], 535 + (151 + 80)*3, 450, assets.achievement_names[3], assets.achievements[11]);
		code = new A(assets.achievements[4], 535, 450 + 151 + 80, assets.achievement_names[4], assets.achievements[12]);
		chair = new A(assets.achievements[5], 535 + 151 + 80, 450 + 151 + 80, assets.achievement_names[5], assets.achievements[13]);
		arm = new A(assets.achievements[6], 535 + (151 + 80)*2, 450 + 151 + 80, assets.achievement_names[6], assets.achievements[14]);
		cube = new A(assets.achievements[7], 535 + (151 + 80)*3, 450 + 151 + 80, assets.achievement_names[7], assets.achievements[15]);
	}
	
	private static void read_file()
	{
		try
		{
			earned = new int[8];
			file = new File("res/achievements.txt");
			Scanner scanner = new Scanner(file);
			for(byte i = 0; i < 8; i++) {earned[i] = scanner.nextInt();}
			scanner.close();
		}
		catch (FileNotFoundException e) {e.printStackTrace();}
	}
	
	public static void write_file(int linea, String replacement)
	{
		String filePath = "res/achievements.txt";
        int lineNumberToModify = linea;
        String replacementText = replacement;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder fileContents = new StringBuilder();
            String line;
            int currentLine = 1;
            
            while((line = reader.readLine()) != null)
            {
                if(currentLine == lineNumberToModify)
                {
                    line = replacementText;
                }
                
                fileContents.append(line).append(System.lineSeparator());
                currentLine++;
            }
            
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(fileContents.toString());
            writer.close();
        }
        catch (IOException e) {e.printStackTrace();}
		
		read_file();
	}
	
	public void tick()
	{
		if(!triangle_moving) {return;}
		
		if(ticks == 0)
		{
			ticks = 0;
			triangle_x += (int)(x_cof*Assets.X_RATIO);
			Launcher.game.get_window().get_panel().set_changed();
		}
		else {ticks++;}
		
		if(triangle_x >= new_triangle_x && x_cof >= 0)
		{
			triangle_moving = false;
			triangle_x = new_triangle_x;
			return;
		}
		
		if(triangle_x <= new_triangle_x && x_cof < 0)
		{
			triangle_moving = false;
			triangle_x = new_triangle_x;
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Assets.space, 0, 0, 1920, 1080, null);
		g.drawImage(Launcher.game.get_assets().pause_line, 0, (int)(290*Assets.Y_RATIO), (int)(1920*Assets.X_RATIO), (int)(10*Assets.Y_RATIO), null);
		g.drawImage(Launcher.game.get_assets().pause_triangle, triangle_x, (int)(274*Assets.Y_RATIO), (int)(20*Assets.X_RATIO), (int)(16*Assets.Y_RATIO), null);
		g.drawImage(Launcher.game.get_assets().play_button, play_bounds.x, play_bounds.y, play_bounds.width, play_bounds.height, null);
		g.drawImage(Launcher.game.get_assets().escape_button, escape_bounds.x, escape_bounds.y, escape_bounds.width, escape_bounds.height, null);
		g.drawImage(Launcher.game.get_assets().info_button, info_bounds.x, info_bounds.y, info_bounds.width, info_bounds.height, null);
		g.drawImage(Launcher.game.get_assets().reset_button, reset_bounds.x, reset_bounds.y, reset_bounds.width, reset_bounds.height, null);
		Star.render(g);
		
		switch(page)
		{
		case RESUME:
			g.drawImage(Launcher.game.get_assets().resume_button, resume_bounds.x, resume_bounds.y, resume_bounds.width, resume_bounds.height, null);
			break;
		
		case ESCAPE:
			g.drawImage(Launcher.game.get_assets().quit_button, resume_bounds.x, resume_bounds.y, resume_bounds.width, resume_bounds.height, null);
			break;
			
		case INFO:
			//g.drawImage(Launcher.game.get_assets().info_text, 1920/2 - 1267/2, 470, 1267, 372, null);
			if(g2d == null)
			{
				g2d = (Graphics2D) g.create();
				g2d.setColor(Color.WHITE);
			}
			
			g2d.setFont(FONT_TITLE);
			g2d.drawString("Code & sprites - martiblq", (int)(570*Assets.X_RATIO), (int)(500*Assets.Y_RATIO));
			g2d.drawString("Themes & inspirations - Rusty Lake & Twin Peaks", (int)(150*Assets.X_RATIO), (int)(700*Assets.Y_RATIO));
			g2d.drawString("Sounds - freesound.org", (int)(580*Assets.X_RATIO), (int)(900*Assets.Y_RATIO));
			break;
			
		case ACHIEVEMENT:
			ear.render(g);
			carpet.render(g);
			jar.render(g);
			door.render(g);
			code.render(g);
			chair.render(g);
			arm.render(g);
			cube.render(g);
			boolean first_achievements_eanred = true;
			
			for(byte i = 0; i < 4; i++)
			{
				if(earned[i] == 0)
				{
					first_achievements_eanred = false;
					break;
				}
			}
			
			if(first_achievements_eanred) {g.drawImage(Launcher.game.get_assets().video_star, star_video_bounds.x, star_video_bounds.y, star_video_bounds.width, star_video_bounds.height, null);}
			boolean all_achievements_earned = true;
			
			for(byte i = 0; i < 8; i++)
			{
				if(earned[i] == 0)
				{
					all_achievements_earned = false;
					break;
				}
			}
			
			if(all_achievements_earned) {g.drawImage(Launcher.game.get_assets().paradox, (int)(340*Assets.X_RATIO), (int)(880*Assets.Y_RATIO), (int)(1213*Assets.X_RATIO), (int)(148*Assets.Y_RATIO), null);}
			break;
			
		case RESET:
			g.drawImage(Launcher.game.get_assets().reset_button1, resume_bounds.x, resume_bounds.y, resume_bounds.width, resume_bounds.height, null);
			
			if(ticked)
				g.drawImage(Launcher.game.get_assets().reset_achievements1, (int)(720*Assets.X_RATIO), (int)(923*Assets.Y_RATIO), (int)(475*Assets.X_RATIO), (int)(56*Assets.Y_RATIO), null);
			else
				g.drawImage(Launcher.game.get_assets().reset_achievements0, (int)(720*Assets.X_RATIO), (int)(923*Assets.Y_RATIO), (int)(475*Assets.X_RATIO), (int)(56*Assets.Y_RATIO), null);
			
			break;
			
		default: break;
		}
	}
	
	//getters and setters
	public Rectangle get_play_bounds() {return play_bounds;}
	public Rectangle get_resume_bounds() {return resume_bounds;}
	public Rectangle get_escape_bounds() {return escape_bounds;}
	public Rectangle get_info_bounds() {return info_bounds;}
	public Rectangle get_star_bounds() {return Star.get_bounds();}
	public Rectangle get_reset_bounds() {return reset_bounds;}
	public Page get_page() {return page;}
	public void set_page(Page page) {this.page = page;}
	public Rectangle get_ear_bounds() {return ear.bounds;}
	public Rectangle get_carpet_bounds() {return carpet.bounds;}
	public Rectangle get_jar_bounds() {return jar.bounds;}
	public Rectangle get_door_bounds() {return door.bounds;}
	public Rectangle get_code_bounds() {return code.bounds;}
	public Rectangle get_chair_bounds() {return chair.bounds;}
	public Rectangle get_arm_bounds() {return arm.bounds;}
	public Rectangle get_cube_bounds() {return cube.bounds;}
	public boolean get_ticked() {return ticked;}
	public Rectangle get_star_video_bounds() {return star_video_bounds;}
	
	public void set_ticked()
	{
		if(ticked)
			ticked = false;
		else
			ticked = true;
	}
	
	public Rectangle get_ticked_bounds() {return ticked_bounds;}
	
	public void set_ear_selected()
	{
		ear.set_selected();
		carpet.unselect();
		jar.unselect();
		door.unselect();
		code.unselect();
		chair.unselect();
		arm.unselect();
		cube.unselect();
	}
	
	public void set_carpet_selected()
	{
		ear.unselect();
		carpet.set_selected();
		jar.unselect();
		door.unselect();
		code.unselect();
		chair.unselect();
		arm.unselect();
		cube.unselect();
	}
	
	public void set_jar_selected()
	{
		ear.unselect();
		carpet.unselect();
		jar.set_selected();
		door.unselect();
		code.unselect();
		chair.unselect();
		arm.unselect();
		cube.unselect();
	}
	
	public void set_door_selected()
	{
		ear.unselect();
		carpet.unselect();
		jar.unselect();
		door.set_selected();
		code.unselect();
		chair.unselect();
		arm.unselect();
		cube.unselect();
	}
	
	public void set_code_selected()
	{
		ear.unselect();
		carpet.unselect();
		jar.unselect();
		door.unselect();
		code.set_selected();
		chair.unselect();
		arm.unselect();
		cube.unselect();
	}
	
	public void set_chair_selected()
	{
		ear.unselect();
		carpet.unselect();
		jar.unselect();
		door.unselect();
		code.unselect();
		chair.set_selected();
		arm.unselect();
		cube.unselect();
	}
	
	public void set_arm_selected()
	{
		ear.unselect();
		carpet.unselect();
		jar.unselect();
		door.unselect();
		code.unselect();
		chair.unselect();
		arm.set_selected();
		cube.unselect();
	}
	
	public void set_cube_selected()
	{
		ear.unselect();
		carpet.unselect();
		jar.unselect();
		door.unselect();
		code.unselect();
		chair.unselect();
		arm.unselect();
		cube.set_selected();
	}
	
	public void set_all_unselected()
	{
		ear.unselect();
		carpet.unselect();
		jar.unselect();
		door.unselect();
		code.unselect();
		chair.unselect();
		arm.unselect();
		cube.unselect();
	}
	
	public void set_triangle_moving(int x)
	{
		triangle_moving = true;
		new_triangle_x = (short)(x*Assets.X_RATIO);
		x_cof = (short)((new_triangle_x - triangle_x)/10*Assets.X_RATIO);
	}
}

class Star
{//why am i using a class for this button and not the rest? Idk man, why is the sky blue
	private static Rectangle bounds = new Rectangle((int)((1920/2 - 118/2 + 300)*Assets.X_RATIO), (int)(150*Assets.Y_RATIO), (int)(118*Assets.X_RATIO), (int)(118*Assets.Y_RATIO));
	
	public static void render(Graphics g) {g.drawImage(Launcher.game.get_assets().star_button, bounds.x, bounds.y, bounds.width, bounds.height, null);}
	//getters and setters
	public static Rectangle get_bounds() {return bounds;}
}

class A
{
	//FIELDS------------------------------
	//oracle classes
	private BufferedImage image, name, earned;
	public Rectangle bounds;
	
	//data types
	private boolean selected;
	private static byte id_counter = 0;
	private byte id;

	//METHODS-----------------------------
	//constructors
	A(BufferedImage image, int x, int y, BufferedImage name, BufferedImage earned)
	{
		id = id_counter;
		id_counter++;
		this.image = image;
		selected = false;
		bounds = new Rectangle((int)(x*Assets.X_RATIO), (int)(y*Assets.Y_RATIO), (int)(151*Assets.X_RATIO), (int)(151*Assets.Y_RATIO));
		this.name = name;
		this.earned = earned;
	}
	
	//public
	public void render(Graphics g)
	{	
		if(Home_menu.earned[id] == 1)
			g.drawImage(earned, bounds.x, bounds.y, bounds.width, bounds.height, null);
		else
			g.drawImage(image, bounds.x, bounds.y, bounds.width, bounds.height, null);	
		
		if(selected) {g.drawImage(name, bounds.x - (int)(120*Assets.X_RATIO), bounds.y + (int)(160*Assets.Y_RATIO), (int)(397*Assets.X_RATIO), (int)(47*Assets.Y_RATIO), null);}
	}
	
	//setters
	public void set_selected()
	{
		if(selected)
			selected = false;
		else
			selected = true;
	}
	
	public void unselect() {selected = false;}
}