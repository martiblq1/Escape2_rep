package main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import menus.Ending;

@SuppressWarnings("serial")
public class Panel extends JPanel
{
	private Mouse mouse;
	private Rectangle bounds;
	
	private boolean changed = true;
	
	Panel()
	{
		this.setDoubleBuffered(true);
		this.setBounds(0, 0, 1920, 1080);
		this.setPreferredSize(new Dimension(1920, 1080));
		this.setEnabled(true);
		this.setFocusable(true);//idk
		this.setVisible(true);
		mouse = new Mouse();
		bounds = new Rectangle((int)((1920 - 77*2 - 118/2)*Assets.X_RATIO), 0, (int)(118/2*Assets.X_RATIO), (int)(118/2*Assets.Y_RATIO));
		this.addMouseListener(mouse);
	}
	
	public void paintComponent(Graphics g)
	{
		try
		{	
			if(changed)//if there is a change
			{
				super.paintComponent(g);
				
				switch(Launcher.game.get_core_scene())
				{
				case WALL_WITH_COUCH:
					Launcher.game.get_wall_with_couch().render(g);
					Launcher.game.get_inventory().render(g);
					Launcher.game.get_arrows()[3].render(g);
					g.drawImage(Launcher.game.get_assets().pause_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case WALL_WITH_BED:
					Launcher.game.get_wall_with_bed().render(g);
					Launcher.game.get_inventory().render(g);
					Launcher.game.get_arrows()[3].render(g);
					g.drawImage(Launcher.game.get_assets().pause_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				case WALL_WITH_DOOR:
					Launcher.game.get_wall_with_door().render(g);
					Launcher.game.get_inventory().render(g);
					Launcher.game.get_arrows()[3].render(g);
					g.drawImage(Launcher.game.get_assets().pause_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				case WALL_WITH_DONKEY:
					Launcher.game.get_wall_with_donkey().render(g);
					Launcher.game.get_inventory().render(g);
					Launcher.game.get_arrows()[3].render(g);
					g.drawImage(Launcher.game.get_assets().pause_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				case RED_CHAIRS:
					Launcher.game.get_red_chairs().render(g);
					Launcher.game.get_inventory().render(g);
					Launcher.game.get_arrows()[3].render(g);
					g.drawImage(Launcher.game.get_assets().pause_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case RED_ROSE:
					Launcher.game.get_red_rose().render(g);
					Launcher.game.get_inventory().render(g);
					Launcher.game.get_arrows()[3].render(g);
					g.drawImage(Launcher.game.get_assets().pause_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case RED_ARM:
					Launcher.game.get_red_arm().render(g);
					Launcher.game.get_inventory().render(g);
					Launcher.game.get_arrows()[3].render(g);
					g.drawImage(Launcher.game.get_assets().pause_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
					
				case RED_PILLAR:
					Launcher.game.get_red_pillar().render(g);
					Launcher.game.get_inventory().render(g);
					Launcher.game.get_arrows()[3].render(g);
					g.drawImage(Launcher.game.get_assets().pause_button, bounds.x, bounds.y, bounds.width, bounds.height, null);
					break;
				
				case STARTER_MENU:
					Launcher.game.get_starter_menu().render(g);
					break;
					
				case HOME_MENU:
					Launcher.game.get_home_menu().render(g);
					break;
					
				case ENDING_1:
					Ending.render(g);
					break;
				
				case ENDING_2:
					Ending.render(g);
					break;
					
				case ENDING_3:
					Ending.render(g);
					break;
					
				default:
					break;
				}
			}
			
			changed = false;//if these objects are to be redrawn call set_changed() first
			Launcher.game.get_clicked().render(g);
			Launcher.game.get_fade().render(g);
			Star.render(g);
		}
		catch(NullPointerException a)
		{
			
		}
	}
	
	//getters and setters
	public void set_changed() {changed = true;}
	public Rectangle get_boubds() {return bounds;}
}
