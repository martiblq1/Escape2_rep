package main;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;

import menus.Ending;
import menus.Home_menu;
import menus.Page;
import wall_with_couch_objects.Jar;

public class Mouse implements MouseListener
{
	//FIELDS
	//enums
	private static Scene scene_after_resume;
	private static Core_scene core_scene_after_resume;
	
	Mouse()
	{
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		switch(Launcher.game.get_core_scene())
		{
		case STARTER_MENU:
			if(Launcher.game.get_starter_menu().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_COUCH);
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				Launcher.game.get_fade().set_fading();
			}
			
			return;
		
		case HOME_MENU:
			switch(Launcher.game.get_home_menu().get_page())
			{
			case RESUME:
				if(Launcher.game.get_home_menu().get_resume_bounds().contains(e.getX(), e.getY()))
				{//resume button
					Launcher.game.get_home_menu().set_page(Page.RESUME);
					Launcher.game.set_core_scene(core_scene_after_resume);
					Launcher.game.set_scene(scene_after_resume);
					Launcher.game.get_fade().set_fading();
					return;
				}
				
				break;
			
			case ESCAPE:
				if(Launcher.game.get_home_menu().get_resume_bounds().contains(e.getX(), e.getY())) {System.exit(0);}
				break;
				
			case ACHIEVEMENT:
				if(Launcher.game.get_home_menu().get_ear_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_ear_selected();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_carpet_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_carpet_selected();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_jar_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_jar_selected();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_door_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_door_selected();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_code_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_code_selected();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_chair_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_chair_selected();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_arm_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_arm_selected();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_cube_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_cube_selected();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_star_video_bounds().contains(e.getX(), e.getY()))
				{
					boolean first_achievements_eanred = true;
					
					for(byte i = 0; i < 4; i++)
					{
						if(Home_menu.earned[i] == 0)
						{
							first_achievements_eanred = false;
							break;
						}
					}
					
					if(first_achievements_eanred)
					{
						try {
							Desktop.getDesktop().browse(new URL("https://youtu.be/sJlNp4sRcfk").toURI());
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				break;
				
			case RESET:
				if(Launcher.game.get_home_menu().get_resume_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.set_core_scene(Core_scene.STARTER_MENU);
					Launcher.game.set_scene(Scene.MENU);
					Launcher.game.get_fade().set_fading();
					
					if(Launcher.game.get_home_menu().get_ticked())
					{	
						for(byte i = 1; i <= 8; i++) {Home_menu.write_file(i, "0");}
					}
					
					Launcher.reset();
					return;
				}
				
				if(Launcher.game.get_home_menu().get_ticked_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_home_menu().set_ticked();
					Launcher.game.get_window().get_panel().set_changed();
				}
				
				break;
				
			default: break;
			}
			
			if(Launcher.game.get_home_menu().get_play_bounds().contains(e.getX(), e.getY()))
			{//pause
				Launcher.game.get_home_menu().set_page(Page.RESUME);
				Launcher.game.get_home_menu().set_triangle_moving(Launcher.game.get_home_menu().get_play_bounds().x + Launcher.game.get_home_menu().get_play_bounds().width/2 - 20/2);
				return;
			}
			
			if(Launcher.game.get_home_menu().get_escape_bounds().contains(e.getX(), e.getY()))
			{//escape
				Launcher.game.get_home_menu().set_page(Page.ESCAPE);
				Launcher.game.get_home_menu().set_triangle_moving(Launcher.game.get_home_menu().get_escape_bounds().x + Launcher.game.get_home_menu().get_escape_bounds().width/2 - 20/2);
				return;
			}
			
			if(Launcher.game.get_home_menu().get_info_bounds().contains(e.getX(), e.getY()))
			{//info
				Launcher.game.get_home_menu().set_page(Page.INFO);
				Launcher.game.get_home_menu().set_triangle_moving(Launcher.game.get_home_menu().get_info_bounds().x + Launcher.game.get_home_menu().get_info_bounds().width/2 - 20/2);
				return;
			}
			
			if(Launcher.game.get_home_menu().get_star_bounds().contains(e.getX(), e.getY()))
			{//achievements
				Launcher.game.get_home_menu().set_all_unselected();
				Launcher.game.get_home_menu().set_page(Page.ACHIEVEMENT);
				Launcher.game.get_home_menu().set_triangle_moving(Launcher.game.get_home_menu().get_star_bounds().x + Launcher.game.get_home_menu().get_star_bounds().width/2 - 20/2);
				return;
			}
			
			if(Launcher.game.get_home_menu().get_reset_bounds().contains(e.getX(), e.getY()))
			{//reset
				Launcher.game.get_home_menu().set_page(Page.RESET);
				Launcher.game.get_home_menu().set_triangle_moving(Launcher.game.get_home_menu().get_reset_bounds().x + Launcher.game.get_home_menu().get_reset_bounds().width/2 - 20/2);
				return;
			}
			
			Launcher.game.get_window().get_panel().set_changed();
			return;
			
		case ENDING_1:
			if(Ending.is_continue_clicked(e.getX(), e.getY()))
			{
				Launcher.game.set_core_scene(Core_scene.STARTER_MENU);
				Launcher.game.set_scene(Scene.MENU);
				Launcher.game.get_fade().set_fading();
				Launcher.reset();
				return;
			}
			
			if(Ending.is_achievements_clicked(e.getX(), e.getY()))
			{
				Launcher.game.get_fade().set_fading();
				Launcher.reset();
				Launcher.game.get_home_menu().set_page(Page.ACHIEVEMENT);
				Launcher.game.set_core_scene(Core_scene.HOME_MENU);
				Launcher.game.set_scene(Scene.MENU);
				core_scene_after_resume = Core_scene.WALL_WITH_COUCH;
				scene_after_resume = Scene.WALL_WITH_COUCH;
				Launcher.game.get_home_menu().set_triangle_moving(Launcher.game.get_home_menu().get_star_bounds().x + Launcher.game.get_home_menu().get_star_bounds().width/2 - 20/2);
				return;
			}
			else
				Launcher.game.get_window().get_panel().set_changed();
			
			return;
			
		case ENDING_2:
			if(Ending.is_continue_clicked(e.getX(), e.getY()))
			{
				Launcher.game.set_core_scene(Core_scene.STARTER_MENU);
				Launcher.game.set_scene(Scene.MENU);
				Launcher.game.get_fade().set_fading();
				Launcher.reset();
				return;
			}
			
			if(Ending.is_achievements_clicked(e.getX(), e.getY()))
			{
				Launcher.game.get_fade().set_fading();
				Launcher.reset();
				Launcher.game.get_home_menu().set_page(Page.ACHIEVEMENT);
				Launcher.game.set_core_scene(Core_scene.HOME_MENU);
				Launcher.game.set_scene(Scene.MENU);
				core_scene_after_resume = Core_scene.WALL_WITH_COUCH;
				scene_after_resume = Scene.WALL_WITH_COUCH;
				Launcher.game.get_home_menu().set_triangle_moving(Launcher.game.get_home_menu().get_star_bounds().x + Launcher.game.get_home_menu().get_star_bounds().width/2 - 20/2);
				return;
			}
			else
				Launcher.game.get_window().get_panel().set_changed();
			
			return;
			
		case ENDING_3:
			if(Ending.is_continue_clicked(e.getX(), e.getY()))
			{
				Launcher.game.set_core_scene(Core_scene.STARTER_MENU);
				Launcher.game.set_scene(Scene.MENU);
				Launcher.game.get_fade().set_fading();
				Launcher.reset();
				return;
			}
			
			if(Ending.is_achievements_clicked(e.getX(), e.getY()))
			{
				Launcher.game.get_fade().set_fading();
				Launcher.reset();
				Launcher.game.get_home_menu().set_page(Page.ACHIEVEMENT);
				Launcher.game.set_core_scene(Core_scene.HOME_MENU);
				Launcher.game.set_scene(Scene.MENU);
				core_scene_after_resume = Core_scene.WALL_WITH_COUCH;
				scene_after_resume = Scene.WALL_WITH_COUCH;
				Launcher.game.get_home_menu().set_triangle_moving(Launcher.game.get_home_menu().get_star_bounds().x + Launcher.game.get_home_menu().get_star_bounds().width/2 - 20/2);
				return;
			}
			else
				Launcher.game.get_window().get_panel().set_changed();
			
			return;
			
		default:
			if(Launcher.game.get_window().get_panel().get_boubds().contains(e.getX(), e.getY()))
			{
				scene_after_resume = Launcher.game.get_scene();
				core_scene_after_resume = Launcher.game.get_core_scene();
				Launcher.game.set_core_scene(Core_scene.HOME_MENU);
				Launcher.game.set_scene(Scene.MENU);
				Launcher.game.get_fade().set_fading();
				return;
			}
			
			break;
		}
		
		Launcher.game.get_clicked().set_playing(e.getX(), e.getY());
		
		//objects
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_COUCH:
			if(Launcher.game.get_arrows()[1].get_bounds().contains(e.getX(), e.getY()))//left
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_DONKEY);
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_arrows()[2].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_BED);
				Launcher.game.set_scene(Scene.WALL_WITH_BED);
				Launcher.game.get_fade().set_fading();
			}
			else if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
			}
			else if(Launcher.game.get_wall_with_couch().get_couch().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH_COUCH);
				Launcher.game.get_fade().set_fading();
			}
			else if(Launcher.game.get_wall_with_couch().get_jars().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH_JARS);
				Launcher.game.get_fade().set_fading();
			}
			else if(Launcher.game.get_wall_with_couch().get_safe().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH_SAFE);
				Launcher.game.get_fade().set_fading();
			}
			else if(Launcher.game.get_wall_with_couch().get_painting().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH_PAINTING);
				Launcher.game.get_fade().set_fading();
			}
			else if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			for(int i = 0; i < 3; i++)
			{
				if(Launcher.game.get_wall_with_couch().get_pillars()[i].get_bounds().contains(e.getX(), e.getY()) || 
						Launcher.game.get_wall_with_couch().get_pillars()[i].get_jar().get_bounds().contains(e.getX(), e.getY()))
				{
					switch(i)
					{
					case 0:
						Launcher.game.set_scene(Scene.WALL_WITH_COUCH_PILLAR_0);
						break;
					
					case 1:
						Launcher.game.set_scene(Scene.WALL_WITH_COUCH_PILLAR_1);
						break;
						
					case 2:
						Launcher.game.set_scene(Scene.WALL_WITH_COUCH_PILLAR_2);
						break;
						
					default:
						break;
					}
					
					Launcher.game.get_fade().set_fading();
				}
			}
			
			break;
			
		case WALL_WITH_COUCH_COUCH:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
			}
			else if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				Launcher.game.get_fade().set_fading();//redraw with fade
			}
			else if(Launcher.game.get_wall_with_couch().get_couch().get_paper().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_wall_with_couch().get_couch().get_paper().set_folded();
				Launcher.game.get_wall_with_couch().get_couch().get_paper().set_checked();
				Audio.play_paper();
				Launcher.game.get_window().get_panel().set_changed();//redraw without fade
			}
			else if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
		
		case WALL_WITH_COUCH_JARS:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_couch().get_jars().get_safe().get_opened() && //safe
					Launcher.game.get_wall_with_couch().get_jars().get_safe().get_key() != null && 
					Launcher.game.get_wall_with_couch().get_jars().get_safe().get_key().get_bounds().contains(e.getX(), e.getY()))
			{//if the safe is opened and the key exists and it's clicked
				Launcher.game.get_wall_with_couch().get_jars().get_safe().set_key();
				Launcher.game.get_inventory().add_item(new Item(Items.KEY_DOOR, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			for(Jar jar : Launcher.game.get_wall_with_couch().get_jars().get_jars()) //jars
			{
				if(!jar.get_bounds().contains(e.getX(), e.getY())) {continue;} //if the jar is not clicked
				//if the jar is clicked
				if(jar.get_organ() != Items.EMPTY)
				{//if the jar is not empty
					Launcher.game.get_inventory().add_item(new Item(jar.get_organ(), false, Launcher.game.get_assets(), -1));
					jar.set_organ(Items.EMPTY);
					Launcher.game.get_window().get_panel().set_changed();
					break;
				}
				
				if(jar.get_organ() == Items.EMPTY && Launcher.game.get_inventory().get_selected() > -1 && 
						!Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_empty())
				{//if the jar is empty and there is a selected inventory box and it's not empty
					switch(Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item())
					{
					case EAR:
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
						Launcher.game.get_inventory().set_selected(-1);
						jar.set_organ(Items.EAR);
						Launcher.game.get_wall_with_couch().get_jars().check();
						Audio.play_item_click();
						Launcher.game.get_window().get_panel().set_changed();
						break;
					
					case TONGUE:
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
						Launcher.game.get_inventory().set_selected(-1);
						jar.set_organ(Items.TONGUE);
						Launcher.game.get_wall_with_couch().get_jars().check();
						Audio.play_item_click();
						Launcher.game.get_window().get_panel().set_changed();
						break;
						
					case HEART:
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
						Launcher.game.get_inventory().set_selected(-1);
						jar.set_organ(Items.HEART);
						Launcher.game.get_wall_with_couch().get_jars().check();
						Audio.play_item_click();
						Launcher.game.get_window().get_panel().set_changed();
						break;
						
					case EYE:
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
						Launcher.game.get_inventory().set_selected(-1);
						jar.set_organ(Items.EYE);
						Launcher.game.get_wall_with_couch().get_jars().check();
						Audio.play_item_click();
						Launcher.game.get_window().get_panel().set_changed();
						break;
						
					default: break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_COUCH_SAFE:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_couch().get_safe().get_opened() && //eye
					Launcher.game.get_wall_with_couch().get_safe().get_eye() != null && 
					Launcher.game.get_wall_with_couch().get_safe().get_eye().get_bounds().contains(e.getX(), e.getY()))
			{//if the safe is opened and the eye exists and it's clicked
				Launcher.game.get_wall_with_couch().get_safe().set_eye();
				Launcher.game.get_inventory().add_item(new Item(Items.EYE, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(!Launcher.game.get_wall_with_couch().get_safe().get_opened())
			{
				for(int i = 0; i < Launcher.game.get_wall_with_couch().get_safe().get_numbers().length; i++)
				{
					if(Launcher.game.get_wall_with_couch().get_safe().get_numbers()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_wall_with_couch().get_safe().get_numbers()[i].set_number();
						Audio.play_safe_click();
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
		
		case WALL_WITH_COUCH_PILLAR_0:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				for(byte i = 0; i < Launcher.game.get_wall_with_couch().get_pillars().length; i++) {Launcher.game.get_wall_with_couch().get_pillars()[i].get_jar().set_to_n();}
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() != -1 && //if there is a selected inventory box and it's filled jug and jar_0 was clicked and there isn't an animation
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.JUG_FILLED &&
					Launcher.game.get_wall_with_couch().get_pillars()[0].get_jar().get_bounds().contains(e.getX(), e.getY()) && 
					Launcher.game.get_wall_with_couch().get_pillars()[0].get_jar().get_changed_water() == 'n')
			{
				Launcher.game.get_wall_with_couch().get_pillars()[0].get_jar().add_water();
				Audio.play_pouring();
				Launcher.game.get_window().get_panel().set_changed();
				Launcher.game.get_wall_with_couch().check_jars();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() != -1 && //if there is a selected inventory box and it's sponge and jar_0 was clicked and there isn't an animation
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.SPONGE &&
					Launcher.game.get_wall_with_couch().get_pillars()[0].get_jar().get_bounds().contains(e.getX(), e.getY()) && 
					Launcher.game.get_wall_with_couch().get_pillars()[0].get_jar().get_changed_water() == 'n')
			{
				Launcher.game.get_wall_with_couch().get_pillars()[0].get_jar().remove_water();
				Audio.play_sponge();
				Launcher.game.get_window().get_panel().set_changed();
				Launcher.game.get_wall_with_couch().check_jars();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
				
				break;
			}
			
			break;
			
		case WALL_WITH_COUCH_PILLAR_1:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				for(byte i = 0; i < Launcher.game.get_wall_with_couch().get_pillars().length; i++) {Launcher.game.get_wall_with_couch().get_pillars()[i].get_jar().set_to_n();}
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() != -1 && //if there is a selected inventory box and it's filled jug and jar_0 was clicked and there isn't an animation
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.JUG_FILLED &&
					Launcher.game.get_wall_with_couch().get_pillars()[1].get_jar().get_bounds().contains(e.getX(), e.getY()) && 
					Launcher.game.get_wall_with_couch().get_pillars()[1].get_jar().get_changed_water() == 'n')
			{
				Launcher.game.get_wall_with_couch().get_pillars()[1].get_jar().add_water();
				Audio.play_pouring();
				Launcher.game.get_window().get_panel().set_changed();
				Launcher.game.get_wall_with_couch().check_jars();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() != -1 && //if there is a selected inventory box and it's sponge and jar_0 was clicked and there isn't an animation
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.SPONGE &&
					Launcher.game.get_wall_with_couch().get_pillars()[1].get_jar().get_bounds().contains(e.getX(), e.getY()) && 
					Launcher.game.get_wall_with_couch().get_pillars()[1].get_jar().get_changed_water() == 'n')
			{
				Launcher.game.get_wall_with_couch().get_pillars()[1].get_jar().remove_water();
				Audio.play_sponge();
				Launcher.game.get_window().get_panel().set_changed();
				Launcher.game.get_wall_with_couch().check_jars();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
				
				break;
			}
			
			break;
			
		case WALL_WITH_COUCH_PILLAR_2:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				for(byte i = 0; i < Launcher.game.get_wall_with_couch().get_pillars().length; i++) {Launcher.game.get_wall_with_couch().get_pillars()[i].get_jar().set_to_n();}
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() != -1 && //if there is a selected inventory box and it's filled jug and jar_0 was clicked and there isn't an animation
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.JUG_FILLED &&
					Launcher.game.get_wall_with_couch().get_pillars()[2].get_jar().get_bounds().contains(e.getX(), e.getY()) && 
					Launcher.game.get_wall_with_couch().get_pillars()[2].get_jar().get_changed_water() == 'n')
			{
				Launcher.game.get_wall_with_couch().get_pillars()[2].get_jar().add_water();
				Audio.play_pouring();
				Launcher.game.get_window().get_panel().set_changed();
				Launcher.game.get_wall_with_couch().check_jars();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() != -1 && //if there is a selected inventory box and it's sponge and jar_0 was clicked and there isn't an animation
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.SPONGE &&
					Launcher.game.get_wall_with_couch().get_pillars()[2].get_jar().get_bounds().contains(e.getX(), e.getY()) && 
					Launcher.game.get_wall_with_couch().get_pillars()[2].get_jar().get_changed_water() == 'n')
			{
				Launcher.game.get_wall_with_couch().get_pillars()[2].get_jar().remove_water();
				Audio.play_sponge();
				Launcher.game.get_window().get_panel().set_changed();
				Launcher.game.get_wall_with_couch().check_jars();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
				
				break;
			}
			
			break;
			
		case WALL_WITH_COUCH_PAINTING:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_couch().get_painting().get_tongue() != null && //if the tongue exists and it's clicked and the painting is unlocked
					Launcher.game.get_wall_with_couch().get_painting().get_tongue().get_bounds().contains(e.getX(), e.getY()) && 
					Launcher.game.get_wall_with_couch().get_painting().get_unlocked())
			{
				Launcher.game.get_wall_with_couch().get_painting().set_tongue();
				Launcher.game.get_inventory().add_item(new Item(Items.TONGUE, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_wall_with_couch().get_painting().get_unlocked() && //if the painting is unlocked and it is clicked
					Launcher.game.get_wall_with_couch().get_painting().get_bounds().contains(e.getX(), e.getY()))
			{//painting
				Launcher.game.get_wall_with_couch().get_painting().set_opened();
				Audio.play_box_unlock();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_BED:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[2].get_bounds().contains(e.getX(), e.getY())) //left
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_DOOR);
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_arrows()[1].get_bounds().contains(e.getX(), e.getY())) //right
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_COUCH);
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_bed().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_BED);
				Launcher.game.get_wall_with_bed().get_bed().set_going_up(false);
				Launcher.game.get_wall_with_bed().get_bed().set_pillow_y();
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_DRAWERS);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_shapes().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_SHAPES);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_shelf().get_bounds()[2].contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_UPPERSHELF);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_shelf().get_bounds()[0].getBounds().contains(e.getX(), e.getY()) && Launcher.game.get_wall_with_bed().get_shelf().get_cabinet_0_opened())
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_CABINET_0);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() > -1)
			{
				if(Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.KEY_SHELF_CABINET_0 && Launcher.game.get_wall_with_bed().get_shelf().get_bounds()[0].contains(e.getX(), e.getY()))
				{
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
					Launcher.game.get_inventory().set_selected(-1);
					Launcher.game.get_wall_with_bed().get_shelf().set_cabinet_0_opened();
					Audio.play_box_unlock();
					Launcher.game.get_window().get_panel().set_changed();
					break;
				}
			}
			
			if(Launcher.game.get_inventory().get_selected() > -1 && //cabinet 1 unlocking
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.KEY_SHELF_CABINET_1 && 
					Launcher.game.get_wall_with_bed().get_shelf().get_bounds()[1].contains(e.getX(), e.getY()))
			{//if there is a selected inventory box and it's the key and the cabinet is clicked
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
				Launcher.game.get_inventory().set_selected(-1);
				Launcher.game.get_wall_with_bed().get_shelf().set_cabinet_1_opened();
				Audio.play_box_unlock();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_shelf().get_cabinet_1_opened() && //cabinet 1
					Launcher.game.get_wall_with_bed().get_shelf().get_bounds()[1].contains(e.getX(), e.getY()))
			{//if the cabinet is opened and the cabinet is clicked
				Launcher.game.set_scene(Scene.WALL_WITH_BED_CABINET_1);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(!Launcher.game.get_wall_with_bed().get_shelf().get_cabinet_1_opened() && //cabinet 1 locked
					Launcher.game.get_wall_with_bed().get_shelf().get_bounds()[1].contains(e.getX(), e.getY()))
			{//if the cabinet is locked and the cabinet is clicked
				Audio.play_door();
				break;
			}
			
			if(!Launcher.game.get_wall_with_bed().get_shelf().get_cabinet_0_opened() && //cabinet 0 locked
					Launcher.game.get_wall_with_bed().get_shelf().get_bounds()[0].contains(e.getX(), e.getY()))
			{//if the cabinet is locked and the cabinet is clicked
				Audio.play_door();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
				
			break;
			
		case WALL_WITH_BED_BED:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
			}
			else if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED);
				Launcher.game.get_fade().set_fading();
			}
			else if(Launcher.game.get_wall_with_bed().get_bed().get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_wall_with_bed().get_bed().set_going_up(true);
			}
			else if(Launcher.game.get_wall_with_bed().get_bed().get_item() != null)
			{
				if(Launcher.game.get_wall_with_bed().get_bed().get_item().get_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_wall_with_bed().get_bed().set_item(null);
					Launcher.game.get_inventory().add_item(new Item(Items.KEY_SHELF_CABINET_0, false, Launcher.game.get_assets(), -1));
					Launcher.game.get_window().get_panel().set_changed();
				}
			}
			else if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
		
		case WALL_WITH_BED_DRAWERS:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().get_bounds().contains(e.getX(), e.getY()))
			{	
				if(!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().get_opening())
				{
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().set_opening(true);
					Audio.play_drawer_open();
				}
				
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_locked() && //drawer1
					Launcher.game.get_inventory().get_selected() != -1 && 
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.KEY_DRAWER_0 && 
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_bounds().contains(e.getX(), e.getY()) && 
					!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().get_opened())
			{//if the drawer is locked and there is a selected inventory box and the item is the key and the drawer is clicked and drawer0 is not opened
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
				Launcher.game.get_inventory().set_selected(-1);
				Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().set_locked();
				Audio.play_box_unlock();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_bounds().contains(e.getX(), e.getY()))
			{
				if(!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_opening() &&
						!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().get_opened() &&
						!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_locked())
				{
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().set_opening(true);
					Audio.play_drawer_open();
					break;
				}
				
				if(!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_opening() &&
						Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_opened() &&
						!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_locked())
				{
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().set_opening(true);
					Audio.play_drawer_open();
					break;
				}
				
				if(!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_opening() && 
						!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().get_opened() &&
						Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_locked())
				{
					Audio.play_door();
					break;
				}
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().get_bounds().contains(e.getX(), e.getY()) &&
					!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().get_opened() && 
					!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_opened())
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_DRAWERS_DRAWER);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_knife() != null)
			{
				if(Launcher.game.get_wall_with_bed().get_drawers().get_knife().get_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_wall_with_bed().get_drawers().set_knife(null);
					Launcher.game.get_inventory().add_item(new Item(Items.KNIFE, false, Launcher.game.get_assets(), -1));
					Launcher.game.get_window().get_panel().set_changed();
					break;
				}
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().get_rose() != null && 
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().get_opened())
			{
				if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().get_rose().get_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().set_rose(null);
					Launcher.game.get_inventory().add_item(new Item(Items.ROSE, false, Launcher.game.get_assets(), -1));
					Launcher.game.get_window().get_panel().set_changed();
					break;
				}
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().get_gear() != null &&
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().get_opened())
			{
				if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().get_gear().get_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_0().set_gear(null);
					Launcher.game.get_inventory().add_item(new Item(Items.GEAR, false, Launcher.game.get_assets(), -1));
					Launcher.game.get_window().get_panel().set_changed();
					break;
				}
			}
			
			if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_opened() && //gear
					!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_opening() && 
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_gear() != null && 
					Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().get_gear().get_bounds().contains(e.getX(), e.getY()))
			{//if the drawer is opened and it's not opening and the gear exists and it's clicked
				Launcher.game.get_wall_with_bed().get_drawers().get_drawer_1().set_gear();
				Launcher.game.get_inventory().add_item(new Item(Items.GEAR, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_BED_DRAWERS_DRAWER:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
			}
			else if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_DRAWERS);
				Launcher.game.get_fade().set_fading();
			}
			else if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			if(!Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().get_opened())
			{
				for(int i = 0; i < 4; i++)
				{
					if(Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().get_numbers()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_wall_with_bed().get_drawers().get_drawer_2().get_numbers()[i].set_number();
						Audio.play_safe_click();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_BED_SHAPES:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
			}
			else if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED);
				Launcher.game.get_fade().set_fading();
			}
			else if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			for(int i = 0; i < Launcher.game.get_wall_with_bed().get_shapes().get_shapes().size(); i++)
			{
				if(Launcher.game.get_wall_with_bed().get_shapes().get_shapes().get(i).get_selected())
				{
					Launcher.game.get_wall_with_bed().get_shapes().get_shapes().get(i).set_selected(false);
					break;
				}
			}
			
			if(Launcher.game.get_wall_with_bed().get_shapes().get_handle() != null)
			{
				if(Launcher.game.get_wall_with_bed().get_shapes().get_handle().get_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_wall_with_bed().get_shapes().set_item(null);
					Launcher.game.get_inventory().add_item(new Item(Items.HANDLE, false, Launcher.game.get_assets(), -1));
					Launcher.game.get_window().get_panel().set_changed();
				}
			}
			
			break;
			
		case WALL_WITH_BED_UPPERSHELF:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_shelf().get_box_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_SHELF_BOX);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_bed().get_shelf().get_key() != null && //key
					Launcher.game.get_wall_with_bed().get_shelf().get_gear_0().get_spinning() && 
					Launcher.game.get_wall_with_bed().get_shelf().get_gear_1().get_spinning() && 
					Launcher.game.get_wall_with_bed().get_shelf().get_gear_2().get_spinning() && 
					Launcher.game.get_wall_with_bed().get_shelf().get_key().get_bounds().contains(e.getX(), e.getY()))
			{//if the key exists and all the gears are spinning and the key is clicked
				Launcher.game.get_wall_with_bed().get_shelf().set_key();
				Launcher.game.get_inventory().add_item(new Item(Items.KEY_SHELF_CABINET_1, false, Launcher.game.get_assets(), -1));
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			if(Launcher.game.get_wall_with_bed().get_shelf().get_jug() != null)
			{
				if(Launcher.game.get_wall_with_bed().get_shelf().get_jug().get_bounds().contains(e.getX(), e.getY()))
				{
					Launcher.game.get_wall_with_bed().get_shelf().set_jug(null);
					Launcher.game.get_inventory().add_item(new Item(Items.JUG, false, Launcher.game.get_assets(), -1));
					Launcher.game.get_window().get_panel().set_changed();
				}
			}
			
			if(Launcher.game.get_inventory().get_selected() > -1 && !Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_empty())
			{
				if(Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.GEAR)
				{	
					if(Launcher.game.get_wall_with_bed().get_shelf().get_gear_0().get_bounds().contains(e.getX(), e.getY()) && Launcher.game.get_wall_with_bed().get_shelf().get_gear_0().get_slot_empty())
					{
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
						Launcher.game.get_inventory().set_selected(-1);
						Launcher.game.get_wall_with_bed().get_shelf().get_gear_0().set_slot_empty();
						Audio.play_item_click();
					}
					else if(Launcher.game.get_wall_with_bed().get_shelf().get_gear_1().get_bounds().contains(e.getX(), e.getY()) && Launcher.game.get_wall_with_bed().get_shelf().get_gear_1().get_slot_empty())
					{
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
						Launcher.game.get_inventory().set_selected(-1);
						Launcher.game.get_wall_with_bed().get_shelf().get_gear_1().set_slot_empty();
						Audio.play_item_click();
					}
					else if(Launcher.game.get_wall_with_bed().get_shelf().get_gear_2().get_bounds().contains(e.getX(), e.getY()) && Launcher.game.get_wall_with_bed().get_shelf().get_gear_2().get_slot_empty())
					{
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
						Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
						Launcher.game.get_inventory().set_selected(-1);
						Launcher.game.get_wall_with_bed().get_shelf().get_gear_2().set_slot_empty();
						Audio.play_item_click();
					}
					
					Launcher.game.get_window().get_panel().set_changed();
					
					if(!Launcher.game.get_wall_with_bed().get_shelf().get_gear_0().get_slot_empty() && //slide
							!Launcher.game.get_wall_with_bed().get_shelf().get_gear_1().get_slot_empty() && 
							!Launcher.game.get_wall_with_bed().get_shelf().get_gear_2().get_slot_empty())
					{//if all 3 gears are put
						Audio.play_slide();
					}
				}
			}
			
			break;
			
		case WALL_WITH_BED_CABINET_0:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
			}
			else if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED);
				Launcher.game.get_fade().set_fading();
				break;
			}
			else if(Launcher.game.get_inventory().get_visible())
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
		
		case WALL_WITH_BED_SHELF_BOX:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			else if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back arrow
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED_UPPERSHELF);
				Launcher.game.get_fade().set_fading();
				break;
			}
			else if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			if(Launcher.game.get_wall_with_bed().get_shelf().get_box_opened() && //ear
					Launcher.game.get_wall_with_bed().get_shelf().get_ear() != null && 
					Launcher.game.get_wall_with_bed().get_shelf().get_ear().get_bounds().contains(e.getX(), e.getY()))
			{//if the box is opened and the ear exists and the mouse clicked it
				Launcher.game.get_wall_with_bed().get_shelf().set_ear(null);
				Launcher.game.get_inventory().add_item(new Item(Items.EAR, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_window().get_panel().set_changed();
				
				if(Home_menu.earned[0] == 0)
				{
					Home_menu.write_file(1, "1");
					Audio.play_achievement();
					Star.set_on_screen();
				}
			}
			
			for(short i = 0; i < Launcher.game.get_wall_with_bed().get_shelf().get_buttons().length; i++) //shelf buttons
			{
				if(!Launcher.game.get_wall_with_bed().get_shelf().get_buttons()[i].get_pushed())
				{
					if(Launcher.game.get_wall_with_bed().get_shelf().get_buttons()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_wall_with_bed().get_shelf().get_buttons()[i].set_pushed(true);
						Launcher.game.get_wall_with_bed().get_shelf().check_buttons(i);
						Audio.play_box_click();
						if(Launcher.game.get_wall_with_bed().get_shelf().get_box_opened()) {Audio.play_box_unlock();}
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_DOOR:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[1].get_bounds().contains(e.getX(), e.getY())) //left
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_BED);
				Launcher.game.set_scene(Scene.WALL_WITH_BED);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_arrows()[2].get_bounds().contains(e.getX(), e.getY())) //right
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_DONKEY);
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_carpet().get_bounds().contains(e.getX(), e.getY()))//if the carpet is clicked
			{//carpet
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR_CARPET);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_sink().get_bounds().contains(e.getX(), e.getY()))//sink
			{//if the sink is clicked
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR_SINK);
				if(Launcher.game.get_wall_with_door().get_sink().get_turned()) {Audio.play_sink();}
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_paintng().get_bounds().contains(e.getX(), e.getY())) //if the painting is clicked
			{//painting
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR_PAINTING);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_box().get_bounds().contains(e.getX(), e.getY())) //box
			{//if the box is clicked
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR_BOX);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() != -1 && //door
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.KEY_DOOR && 
					!Launcher.game.get_wall_with_door().get_door().get_locked() && 
					Launcher.game.get_wall_with_door().get_door().get_bounds().contains(e.getX(), e.getY()))
			{//if there is a selected inventory box and it's the key and the door is unlocked and it's clicked
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
				Launcher.game.get_inventory().set_selected(-1);
				Launcher.game.get_wall_with_door().get_door().set_opened();
				Audio.play_door_unlock();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(!Launcher.game.get_wall_with_door().get_door().get_opened() && //door locked
					Launcher.game.get_wall_with_door().get_door().get_bounds().contains(e.getX(), e.getY()))
			{//if the door is locked and it's clicked
				Audio.play_door();
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_door().get_opened() && //door ending
					Launcher.game.get_wall_with_door().get_door().get_bounds().contains(e.getX(), e.getY()))
			{//if the door is opened and it's clicked
				Launcher.game.set_core_scene(Core_scene.ENDING_1);
				if(Home_menu.earned[3] == 0) {Home_menu.write_file(4, "1");}
				Launcher.game.get_fade().set_fading();
				return;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_DOOR_SINK:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back arrow
			{
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR);
				Audio.stop_sink();
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() > -1 && //putting sink handle
					!Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_empty() && 
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.HANDLE)
			{
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
				Launcher.game.get_inventory().set_selected(-1);
				Launcher.game.get_wall_with_door().get_sink().set_handle_put(true);
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_sink().get_handle_put() && 
					Launcher.game.get_wall_with_door().get_sink().get_handle_bounds().contains(e.getX(), e.getY()))
			{
				Launcher.game.get_wall_with_door().get_sink().set_turned(!Launcher.game.get_wall_with_door().get_sink().get_turned());
				
				if(Launcher.game.get_wall_with_door().get_sink().get_turned())
					Audio.play_sink();
				else
					Audio.stop_sink();
				
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_sink().get_turned() &&//if the water is running and it was clicked and there is a selected inventory box and it's jug
					Launcher.game.get_wall_with_door().get_sink().get_water_bounds().contains(e.getX(), e.getY()) && 
					Launcher.game.get_inventory().get_selected() != -1 && 
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.JUG)
			{
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
				Launcher.game.get_inventory().add_item(new Item(Items.JUG_FILLED, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
				Launcher.game.get_inventory().set_selected(-1);
				Audio.play_pouring();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_sink().get_sponge() != null && //sponge
					Launcher.game.get_wall_with_door().get_sink().get_sponge().get_bounds().contains(e.getX(), e.getY()))
			{//if the sponge exists and it is clicked
				Launcher.game.get_wall_with_door().get_sink().set_sponge();
				Launcher.game.get_inventory().add_item(new Item(Items.SPONGE, false, Launcher.game.get_assets(), -1));
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_DOOR_CARPET:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(!Launcher.game.get_wall_with_door().get_carpet().get_moving() && //if the carpet animation is not playing and it's clicked
					Launcher.game.get_wall_with_door().get_carpet().get_floor().contains(e.getX(), e.getY()))
			{//carpet
				Launcher.game.get_wall_with_door().get_carpet().set_moving();
				
				if(Home_menu.earned[1] == 0)
				{
					Home_menu.write_file(2, "1");
					Audio.play_achievement();
					Star.set_on_screen();
				}
				
				break;
			}
				
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_DOOR_PAINTING:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_door().get_paintng().get_opened() && //if the painting is opened and the lever is not pulled and the lever is clicked
					!Launcher.game.get_wall_with_door().get_paintng().get_lever().get_pulled() && 
					Launcher.game.get_wall_with_door().get_paintng().get_lever().get_bounds().contains(e.getX(), e.getY()))
			{//lever
				Launcher.game.get_wall_with_door().get_paintng().get_lever().set_pulled();
				Audio.play_lever();
				Launcher.game.get_wall_with_door().get_door().set_locked();
				Launcher.game.get_window().get_panel().set_changed();
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_DOOR_BOX:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			for(int i = 0; i < Launcher.game.get_wall_with_door().get_box().get_symbols().length; i++)
			{
				if(!Launcher.game.get_wall_with_door().get_box().get_opened() && //symbol
						Launcher.game.get_wall_with_door().get_box().get_symbols()[i].get_bounds().contains(e.getX(), e.getY()))
				{//if the box is closed and the symbol is clicked
					Launcher.game.get_wall_with_door().get_box().get_symbols()[i].set_symbol();
					Launcher.game.get_wall_with_door().get_box().check_combination();
					
					if(Launcher.game.get_wall_with_door().get_box().get_opened())
						Audio.play_door_unlock();
					else
						Audio.play_safe_click();
					
					break;
				}
			}
			
			if(Launcher.game.get_wall_with_door().get_box().get_opened() && //key
					Launcher.game.get_wall_with_door().get_box().get_key() != null && 
					Launcher.game.get_wall_with_door().get_box().get_key().get_bounds().contains(e.getX(), e.getY()))
			{//if the box is opened and the key exists and it's clikced
				Launcher.game.get_wall_with_door().get_box().set_key();
				Launcher.game.get_inventory().add_item(new Item(Items.KEY_DRAWER_0, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
		
		case WALL_WITH_DONKEY:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[1].get_bounds().contains(e.getX(), e.getY())) //left
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_DOOR);
				Launcher.game.set_scene(Scene.WALL_WITH_DOOR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_arrows()[2].get_bounds().contains(e.getX(), e.getY())) //right
			{
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_COUCH);
				Launcher.game.set_scene(Scene.WALL_WITH_COUCH);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_donkey().get_bounds().contains(e.getX(), e.getY()))//donkey
			{//if the donkey is clicked
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY_DONKEY);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_machine().get_bounds().contains(e.getX(), e.getY()))//machine
			{//if the machine is clicked
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY_MACHINE);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_table().get_bounds().contains(e.getX(), e.getY()))//table
			{//if the table is clicked
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY_TABLE);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_DONKEY_DONKEY:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_donkey().get_killed_stage() == 2 && //donkey heart
					Launcher.game.get_wall_with_donkey().get_donkey().get_alive() && 
					!Launcher.game.get_wall_with_donkey().get_donkey().get_heart_taken() && 
					Launcher.game.get_wall_with_donkey().get_donkey().get_heart_bounds().contains(e.getX(), e.getY()))
			{//if the donkey is alive and it's opened and the heart is there and is clicked
				Launcher.game.get_wall_with_donkey().get_donkey().set_alive();
				Launcher.game.get_wall_with_donkey().get_donkey().set_heart_taken();
				Launcher.game.get_inventory().add_item(new Item(Items.HEART, false, Launcher.game.get_assets(), -1));
				Audio.play_donkey_last();
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_donkey().get_alive() && //donkey
					Launcher.game.get_inventory().get_selected() != -1 && 
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.KNIFE &&
					Launcher.game.get_wall_with_donkey().get_donkey().get_killed_stage() < 2 && 
					Launcher.game.get_wall_with_donkey().get_donkey().get_bounds().contains(e.getX(), e.getY()))
			{//if the donkey is alive and there is a selected item and it's a knife and the killed stage is less than 3 and the donkey is clicked
				Launcher.game.get_wall_with_donkey().get_donkey().set_killed_stage();
				
				if(Launcher.game.get_wall_with_donkey().get_donkey().get_killed_stage() == 0)
					Audio.play_donkey_first();
				else
					Audio.play_splash();
					
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
				
			if(Launcher.game.get_wall_with_donkey().get_donkey().get_alive() && //donkey eye 
					Launcher.game.get_wall_with_donkey().get_donkey().get_bounds().contains(e.getX(), e.getY()))
			{//if the donkey is alive and it's clicked
				Launcher.game.get_wall_with_donkey().get_donkey().set_frames();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_DONKEY_MACHINE:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_machine().get_gear() != null && //gear
					!Launcher.game.get_wall_with_donkey().get_machine().get_gear().get_animation() && 
					Launcher.game.get_wall_with_donkey().get_machine().get_gear().get_bounds().contains(e.getX(), e.getY()))
			{//if the gear exists and it's not spinning it's clicked
				Launcher.game.get_wall_with_donkey().get_machine().set_gear();
				Launcher.game.get_inventory().add_item(new Item(Items.GEAR, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_window().get_panel().set_changed();
			}
			
			if(Launcher.game.get_inventory().get_selected() > -1 && //putting the lever
					!Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_empty() && 
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.LEVER)
			{//if there is a selected inventory box and it's not empty and it's the lever
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
				Launcher.game.get_inventory().set_selected(-1);
				Launcher.game.get_wall_with_donkey().get_machine().get_lever().set_in_place();
				Audio.play_item_click();
				break;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_machine().get_lever().get_in_place() && //lever 
					Launcher.game.get_wall_with_donkey().get_machine().get_lever().get_bounds().contains(e.getX(), e.getY()))
			{//if the lever is in place and it's clicked
				Launcher.game.get_wall_with_donkey().get_machine().lever_pulled();
				Audio.play_box_unlock();
				if(Launcher.game.get_wall_with_donkey().get_machine().get_gear() != null) {Audio.play_slide();}
				return;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_machine().get_lever().get_switched() && //box
					Launcher.game.get_wall_with_donkey().get_machine().get_gear() != null && 
					Launcher.game.get_wall_with_donkey().get_machine().get_box().get_bounds().contains(e.getX(), e.getY()))
			{//if the lever is switched and the gear exists and the box is clicked
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY_MACHINE_NUMBERS);
				Launcher.game.get_fade().set_fading();
				return;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_BED_CABINET_1:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.WALL_WITH_BED);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
		
		case WALL_WITH_DONKEY_TABLE:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_selected() != -1 && //table
					Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].get_item().get_item() == Items.ROSE && 
					Launcher.game.get_wall_with_donkey().get_table().get_bounds().contains(e.getX(), e.getY()))
			{//if there is a selected inventory box and it's the rose and the table is clicked
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_empty(true);
				Launcher.game.get_inventory().get_inventory_boxes()[Launcher.game.get_inventory().get_selected()].set_selected(false);
				Launcher.game.get_inventory().set_selected(-1);
				Launcher.game.get_wall_with_donkey().get_table().set_rose_put();
				Audio.play_item_click();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_wall_with_donkey().get_table().get_rose_put() &&//table warp
					Launcher.game.get_wall_with_donkey().get_table().get_bounds().contains(e.getX(), e.getY()))
			{//if the rose is put and the table is clicked
				Launcher.game.set_scene(Scene.RED_CHAIRS);
				Launcher.game.set_core_scene(Core_scene.RED_CHAIRS);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case RED_CHAIRS:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[1].get_bounds().contains(e.getX(), e.getY())) //left
			{
				Launcher.game.set_core_scene(Core_scene.RED_PILLAR);
				Launcher.game.set_scene(Scene.RED_PILLAR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_arrows()[2].get_bounds().contains(e.getX(), e.getY())) //right
			{
				Launcher.game.set_core_scene(Core_scene.RED_ROSE);
				Launcher.game.set_scene(Scene.RED_ROSE);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_red_chairs().get_chairs()[0].get_bounds().contains(e.getX(), e.getY()) || //chairs ending
					Launcher.game.get_red_chairs().get_chairs()[1].get_bounds().contains(e.getX(), e.getY()))
			{//if chair 1 is clicked or chair 2 is clicked
				Launcher.game.set_core_scene(Core_scene.ENDING_2);
				if(Home_menu.earned[5] == 0) {Home_menu.write_file(6, "1");}
				Launcher.game.get_fade().set_fading();
				return;
			}
				
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
		
		case RED_ROSE:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[1].get_bounds().contains(e.getX(), e.getY())) //left
			{
				Launcher.game.set_core_scene(Core_scene.RED_CHAIRS);
				Launcher.game.set_scene(Scene.RED_CHAIRS);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_arrows()[2].get_bounds().contains(e.getX(), e.getY())) //right
			{
				Launcher.game.set_core_scene(Core_scene.RED_ARM);
				Launcher.game.set_scene(Scene.RED_ARM);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_red_rose().get_table().get_bounds().contains(e.getX(), e.getY()))//table
			{//if the table is clicked
				Launcher.game.set_scene(Scene.RED_ROSE_TABLE);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case RED_ROSE_TABLE:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.RED_ROSE);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_red_rose().get_table().get_bounds().contains(e.getX(), e.getY()))//table warp
			{//if the table is clicked
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY);
				Launcher.game.set_core_scene(Core_scene.WALL_WITH_DONKEY);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case RED_ARM:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[1].get_bounds().contains(e.getX(), e.getY())) //left
			{
				Launcher.game.set_core_scene(Core_scene.RED_ROSE);
				Launcher.game.set_scene(Scene.RED_ROSE);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_arrows()[2].get_bounds().contains(e.getX(), e.getY())) //right
			{
				Launcher.game.set_core_scene(Core_scene.RED_PILLAR);
				Launcher.game.set_scene(Scene.RED_PILLAR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_red_arm().get_arm_exists() && //the arm
					Launcher.game.get_red_arm().get_bounds().contains(e.getX(), e.getY()))
			{//if the arm exists and it's clicked
				Launcher.game.set_scene(Scene.RED_ARM_ARM);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case RED_ARM_ARM:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.RED_ARM);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_red_arm().get_bounds().contains(e.getX(), e.getY()))//the arm
			{//if the arm is clicked
				Launcher.game.get_red_arm().set_arm_exists();
				Launcher.game.set_scene(Scene.RED_ARM);
				Audio.play_arm();
				Launcher.game.get_fade().set_fading();
				
				if(Home_menu.earned[6] == 0)
				{
					Home_menu.write_file(7, "1");
					Audio.play_achievement();
					Star.set_on_screen();
				}
				
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case RED_PILLAR:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[1].get_bounds().contains(e.getX(), e.getY())) //left
			{
				Launcher.game.set_core_scene(Core_scene.RED_ARM);
				Launcher.game.set_scene(Scene.RED_ARM);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_arrows()[2].get_bounds().contains(e.getX(), e.getY())) //right
			{
				Launcher.game.set_core_scene(Core_scene.RED_CHAIRS);
				Launcher.game.set_scene(Scene.RED_CHAIRS);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_red_pillar().get_bounds().contains(e.getX(), e.getY())) //pillar
			{//if the pillar is clicked
				Launcher.game.set_scene(Scene.RED_PILLAR_PILLAR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case RED_PILLAR_PILLAR:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.RED_PILLAR);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			if(Launcher.game.get_red_pillar().get_lever() != null && //lever
					Launcher.game.get_red_pillar().get_lever().get_bounds().contains(e.getX(), e.getY()))
			{//if the lever exists and it's clicked
				Launcher.game.get_red_pillar().set_lever();
				Launcher.game.get_inventory().add_item(new Item(Items.LEVER, false, Launcher.game.get_assets(), -1));
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			break;
			
		case WALL_WITH_DONKEY_MACHINE_NUMBERS:
			if(Launcher.game.get_arrows()[3].get_bounds().contains(e.getX(), e.getY())) //invisible/visible inventory
			{
				Launcher.game.get_inventory().set_visible();
				Launcher.game.get_window().get_panel().set_changed();
				break;
			}
			
			if(Launcher.game.get_arrows()[0].get_bounds().contains(e.getX(), e.getY())) //back
			{
				Launcher.game.set_scene(Scene.WALL_WITH_DONKEY_MACHINE);
				Launcher.game.get_fade().set_fading();
				break;
			}
			
			for(short i = 0; i < 3; i++)//digits
			{	
				if(!Launcher.game.get_wall_with_donkey().get_machine().get_box().get_moving() && 
						Launcher.game.get_wall_with_donkey().get_machine().get_box().get_digits()[i].get_bounds().contains(e.getX(), e.getY()))
				{//if the box isn't moving and the digit is clicked
					Launcher.game.get_wall_with_donkey().get_machine().get_box().get_digits()[i].set_digit();
					Launcher.game.get_wall_with_donkey().get_machine().get_box().check_digits();
					Audio.play_safe_click();
					Launcher.game.get_window().get_panel().set_changed();
					return;
				}
			}
			
			if(Launcher.game.get_wall_with_donkey().get_machine().get_box().get_moving() && //cube ending
					Launcher.game.get_wall_with_donkey().get_machine().get_box().get_cube_bounds().contains(e.getX(), e.getY()))
			{//if the box is opened and the cube is clicked
				Launcher.game.set_core_scene(Core_scene.ENDING_3);
				if(Home_menu.earned[7] == 0) {Home_menu.write_file(8, "1");}
				Launcher.game.get_fade().set_fading();
				return;
			}
			
			if(Launcher.game.get_inventory().get_visible()) //inventory boxes
			{
				for(int i = 0; i < Launcher.game.get_inventory().get_inventory_boxes().length; i++)
				{
					if(Launcher.game.get_inventory().get_inventory_boxes()[i].get_bounds().contains(e.getX(), e.getY()))
					{
						Launcher.game.get_inventory().change_selected(i);
						Launcher.game.get_window().get_panel().set_changed();
						break;
					}
				}
			}
			
			return;
			
		default: break;
		}
	}
	
	//useless
	@Override
	public void mousePressed(MouseEvent e)
	{
		switch(Launcher.game.get_scene())
		{
		case WALL_WITH_BED_SHAPES:
			for(int i = 0; i < Launcher.game.get_wall_with_bed().get_shapes().get_shapes().size(); i++)
			{
				for(int j = 0; j < Launcher.game.get_wall_with_bed().get_shapes().get_shapes().get(i).get_shape_elements().size(); j++)
				{
					if(Launcher.game.get_wall_with_bed().get_shapes().get_shapes().get(i).get_shape_elements().get(j).get_bounds().contains(e.getX(), e.getY()))
					{
						for(int m = 0; m < Launcher.game.get_wall_with_bed().get_shapes().get_shapes().get(i).get_shape_elements().size(); m++)
						{
							Launcher.game.get_wall_with_bed().get_shapes().get_shapes().get(i).get_shape_elements().get(m).set_x_from_mouse();
							Launcher.game.get_wall_with_bed().get_shapes().get_shapes().get(i).get_shape_elements().get(m).set_y_from_mouse();
						}
						
						Launcher.game.get_wall_with_bed().get_shapes().get_shapes().get(i).set_selected(true);
						
						if(i != 0)
							Collections.swap(Launcher.game.get_wall_with_bed().get_shapes().get_shapes(), i, 0);
						
						return;
					}
				}
			}
			
			break;
		
		default: break;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}
}
