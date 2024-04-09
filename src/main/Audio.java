package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class Audio//when creating a new sound add in initilize method and make play method
{
	//FIELDS------------------------------------------------------
	//oracle classes
	private static final ArrayList<AudioInputStream> list_i = new ArrayList<>();
	private static final ArrayList<Clip> list = new ArrayList<>();
	
	//METHODS-----------------------------------------------------
	//private
	private static final void play_sound(int id)
	{
		list.get(id).setFramePosition(0);
		list.get(id).start();
	}
	
	private static final void create_sound(String file_name)
	{
		try
		{
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("res/sounds/" + file_name + ".wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			list_i.add(audio);
			list.add(clip);
		}
		catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
	}
	
	//static
	public static final void initialize()
	{
		create_sound("paper");//0
		create_sound("safe_click");//1
		create_sound("item");//2
		create_sound("cabinet_unlock");//3
		create_sound("box_click");//4
		create_sound("drawer_open");//5
		create_sound("box_unlock");//6
		create_sound("sink");//7
		create_sound("pouring");//8
		create_sound("sponge");//9
		create_sound("lever");//10
		create_sound("door");//11
		create_sound("door_unlock");//12
		create_sound("donkey_first");//13
		create_sound("splash");//14
		create_sound("donkey_last");//15
		create_sound("slide");//16
		create_sound("safe_opening");//17
		create_sound("arm");//18
		create_sound("achievement");//19
	}
	
	public static final void play_paper() {play_sound(0);}
	public static final void play_safe_click() {play_sound(1);}
	public static final void play_item_click() {play_sound(2);}
	public static final void play_cabinet_unlock() {play_sound(3);}
	public static final void play_box_click() {play_sound(4);}
	public static final void play_drawer_open() {play_sound(5);}
	public static final void play_box_unlock() {play_sound(6);}
	public static final void play_sink() {play_sound(7);}
	public static final void play_pouring() {play_sound(8);}
	public static final void play_sponge() {play_sound(9);}
	public static final void play_lever() {play_sound(10);}
	public static final void play_door() {play_sound(11);}
	public static final void play_door_unlock() {play_sound(12);}
	public static final void play_donkey_first() {play_sound(13);}
	public static final void play_splash() {play_sound(14);}
	public static final void play_donkey_last() {play_sound(15);}
	public static final void play_slide() {play_sound(16);}
	public static final void play_safe_opening() {play_sound(17);}
	public static final void play_arm() {play_sound(18);}
	public static final void play_achievement() {play_sound(19);}
	
	public static final void stop_sink()
	{
		list.get(7).stop();
		list.get(7).setFramePosition(0);
	}
}