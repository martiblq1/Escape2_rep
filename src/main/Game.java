package main;
import java.io.IOException;

import menus.Home_menu;
import menus.Starter_menu;
import red_arm.Red_arm;
import red_chairs.Red_chairs;
import red_pillar.Red_pillar;
import red_rose.Red_rose;
import wall_with_bed_objects.Wall_with_bed;
import wall_with_couch_objects.Wall_with_couch;
import wall_with_donkey_objects.Wall_with_donkey;
import wall_with_door_objects.Wall_with_door;

public class Game implements Runnable
{
	private Window window;
	private Assets assets;
	private Arrow[] arrows;
	private Fade fade;
	private Clicked clicked;
	private Wall_with_couch wall_with_couch;
	private Inventory inventory;
	private Wall_with_bed wall_with_bed;
	private Wall_with_door wall_with_door;
	private Wall_with_donkey wall_with_donkey;
	private Red_chairs red_chairs;
	private Red_rose red_rose;
	private Red_arm red_arm;
	private Red_pillar red_pillar;
	private Starter_menu starter_menu;
	private Home_menu home_menu;
	
	private Scene scene;
	private Core_scene core_scene;
	
	public void reset()
	{
		wall_with_couch = new Wall_with_couch(assets);
		inventory = new Inventory();
		wall_with_bed = new Wall_with_bed(assets);
		wall_with_door = new Wall_with_door(assets);
		wall_with_donkey = new Wall_with_donkey();
		red_chairs = new Red_chairs();
		red_rose = new Red_rose();
		red_arm = new Red_arm();
		red_pillar = new Red_pillar(assets);
		scene = Scene.MENU;
		core_scene = Core_scene.STARTER_MENU;
	}
	
	Game()
	{
		window = new Window();
		Audio.initialize();
		
		try
		{
			assets = new Assets();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//----------------------
		
		scene = Scene.MENU;
		core_scene = Core_scene.STARTER_MENU;
		wall_with_couch = new Wall_with_couch(assets);
		arrows = new Arrow[4];
		arrows[0] = new Arrow(Direction.BACK);
		arrows[1] = new Arrow(Direction.LEFT);
		arrows[2] = new Arrow(Direction.RIGHT);
		arrows[3] = new Arrow(Direction.INVENTORY);
		fade = new Fade();
		clicked = new Clicked();
		inventory = new Inventory();
		wall_with_bed = new Wall_with_bed(assets);
		wall_with_door = new Wall_with_door(assets);
		wall_with_donkey = new Wall_with_donkey();
		red_chairs = new Red_chairs();
		red_rose = new Red_rose();
		red_arm = new Red_arm();
		red_pillar = new Red_pillar(assets);
		starter_menu = new Starter_menu();
		home_menu = new Home_menu(assets);
	}
	
	private void render() 
	{
		window.get_panel().repaint();
	}

	private void tick()
	{
		clicked.tick();
		fade.tick();
		Star.tick();
		
		switch(core_scene)
		{
		case WALL_WITH_COUCH:
			wall_with_couch.tick();
			break;
			
		case WALL_WITH_BED:
			wall_with_bed.tick();
			break;
			
		case WALL_WITH_DOOR:
			wall_with_door.tick();
			break;
			
		case WALL_WITH_DONKEY:
			wall_with_donkey.tick();
			break;
			
		case HOME_MENU:
			home_menu.tick();
			break;
			
		default:
			break;
		}
	}
	
	//getters and setters
	public Assets get_assets() {return assets;}
	public Scene get_scene() {return scene;}
	public Core_scene get_core_scene() {return core_scene;}
	public void set_core_scene(Core_scene core_scene) {this.core_scene = core_scene;}
	public void set_scene(Scene scene) {this.scene = scene;}
	public Window get_window() {return window;}
	public Arrow[] get_arrows() {return arrows;}
	public Fade get_fade() {return fade;}
	public Clicked get_clicked() {return clicked;}
	public Wall_with_couch get_wall_with_couch() {return wall_with_couch;}
	public Inventory get_inventory() {return inventory;}
	public Wall_with_bed get_wall_with_bed() {return wall_with_bed;}
	public Wall_with_door get_wall_with_door() {return wall_with_door;}
	public Wall_with_donkey get_wall_with_donkey() {return wall_with_donkey;}
	public Red_chairs get_red_chairs() {return red_chairs;}
	public Red_rose get_red_rose() {return red_rose;}
	public Red_arm get_red_arm() {return red_arm;}
	public Red_pillar get_red_pillar() {return red_pillar;}
	public Starter_menu get_starter_menu() {return starter_menu;}
	public Home_menu get_home_menu() {return home_menu;}
	
	//implementation of Runnable
	private static Thread thread;
	
	private static boolean running;
	
	public synchronized void start()
	{
		if(running == true)
		{
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() 
	{
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while(running == true)
		{
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			timer += now-lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				delta--;
			}
			if(timer >= 1000000000)
			{
				timer = 0;
			}
		}
		stop();
	}
	
	public static synchronized void stop()
	{
		if(running == false)
		{
			return;
		}
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
