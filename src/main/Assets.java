package main;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets
{
	public BufferedImage[] safe_wall_with_couch_numbers = new BufferedImage[10], drawer_numbers = new BufferedImage[10], 
			shapes_shapes = new BufferedImage[5], shelf = new BufferedImage[5], signs = new BufferedImage[2], 
			gear_animation = new BufferedImage[3], shelf_buttons_pushed = new BufferedImage[8], 
			shelf_buttons_unpushed = new BufferedImage[8], water_flowing = new BufferedImage[2], 
			symbols = new BufferedImage[10], donkey_eyes = new BufferedImage[2], donkey_wounds = new BufferedImage[3], 
			red_gear_animation = new BufferedImage[3], machine_digits = new BufferedImage[10], achievements = new BufferedImage[16], 
			achievement_names = new BufferedImage[8];
	
	public BufferedImage couch, back, left, right, paper_3, paper_3_folded, room, jars_on_wall, jars, wall, safe_jars_closed, safe_jars_opened,
	safe_wall_with_couch_closed, safe_wall_with_couch_opened, safe_wall_with_couch_numbers_sheet, inventory_box, pillar, 
	pillar_jar_empty, pillar_jar_started_filling, pillar_jar_filled, painting_horiontal, bed, pillow, bed_line, key_shelf_cabinet_1, 
	drawers_scene, wall_with_floor, drawers, knife, drawer_0, drawer_1, drawers_upper_cover, drawer_2, drawer_numbers_sheet, 
	drawers_down_cover, rose, gear, shapes, shapes_sheet, handle, jug, gear_base, shelf_upper_locked_box, shelf_box_locked, paper_2, shelf_buttons_sheet, 
	shelf_box_unlocked, ear, ear_vertical, door, sink, sink_upper, handle_up, jar_on_pillar_filled_1, jar_on_pillar_filled_2, jar_on_pillar_filled_3, 
	sink_with_handle, sponge, painting_horizontal_opened, jar_tongue, tongue, carpet, message, painting_1, lever, lever_down, box_with_signs, 
	wall_with_floor_2, box_with_signs_1, symbols_sheet, box_with_signs_opened, donkey, donkey_eyes_sheet, donkey_wounds_sheet, heart, heart_vertical, 
	donkey_dead, machine, shelf_upper_unlocked_box, shelf_cabinet_1_opened, paper_1, eye, key_door, door_lock, door_lock_unlocked, door_opened, 
	machine_lever_hole, machine_box, table_with_vase, rose_in_vase, red_room, chair, chair_left, lamp, the_arm, red_pillar, machine_plate, 
	machine_lever_horizontal, machine_lever, machine_lever_down, machine_box_opened, TP_symbol, machine_sign, arm_sign, machine_digits_sheet, 
	black_cube, play_button, pause_button, resume_button, pause_line, pause_triangle, escape_button, quit_button, info_button, 
	info_text, star_button, achievements_sheet, achievement_names_sheet, ending_1, ending_2, ending_3, continue_, achievements_button, reset_button, 
	reset_button1, reset_achievements0, reset_achievements1, video_star, paradox;

	public static BufferedImage star, space;
	
	private static final double SCREEN_X = Toolkit.getDefaultToolkit().getScreenSize().getWidth(), SCREEN_Y = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static final double X_RATIO = SCREEN_X/1920, Y_RATIO = SCREEN_Y/1080;
	
	Assets() throws IOException
	{
		couch = ImageIO.read(new File("res/images/couch.png"));
		back = ImageIO.read(new File("res/images/Back.png"));
		left = ImageIO.read(new File("res/images/Left.png"));
		right = ImageIO.read(new File("res/images/Right.png"));
		paper_3 = ImageIO.read(new File("res/images/Paper_3.png"));
		paper_3_folded = ImageIO.read(new File("res/images/Paper_3_folded.png"));
		room = ImageIO.read(new File("res/images/Escape_2_room.png"));
		jars_on_wall = ImageIO.read(new File("res/images/Jars_on_wall.png"));
		jars = ImageIO.read(new File("res/images/Jars.png"));
		wall = ImageIO.read(new File("res/images/Wall_background.png"));
		safe_jars_closed = ImageIO.read(new File("res/images/Safe_jars_closed.png"));
		safe_jars_opened = ImageIO.read(new File("res/images/Safe_jars_opened.png"));
		safe_wall_with_couch_closed = ImageIO.read(new File("res/images/Safe_wall_with_couch_closed.png"));
		safe_wall_with_couch_opened = ImageIO.read(new File("res/images/Safe_wall_with_couch_opened.png"));
		safe_wall_with_couch_numbers_sheet = ImageIO.read(new File("res/images/Safe_wall_with_couch_numbers.png"));
		inventory_box = ImageIO.read(new File("res/images/Inventory_box.png"));
		pillar = ImageIO.read(new File("res/images/Pillar.png"));
		pillar_jar_empty = ImageIO.read(new File("res/images/Jar_on_pillar_empty.png"));
		pillar_jar_started_filling = ImageIO.read(new File("res/images/Jar_on_pillar_started_filling.png"));
		pillar_jar_filled = ImageIO.read(new File("res/images/Jar_on_pillar_filled.png"));
		painting_horiontal = ImageIO.read(new File("res/images/Painting_horizontal.png"));
		bed = ImageIO.read(new File("res/images/Bed.png"));
		pillow = ImageIO.read(new File("res/images/Pillow.png"));
		bed_line = ImageIO.read(new File("res/images/Bed_line.png"));
		key_shelf_cabinet_1 = ImageIO.read(new File("res/images/Key_shelf_cabinet_1.png"));
		drawers_scene = ImageIO.read(new File("res/images/Drawers_scene.png"));
		wall_with_floor = ImageIO.read(new File("res/images/Wall_with_floor.png"));
		drawers = ImageIO.read(new File("res/images/Drawers.png"));
		knife = ImageIO.read(new File("res/images/Knife.png"));
		drawer_0 = ImageIO.read(new File("res/images/Drawer_0.png"));
		drawer_1 = ImageIO.read(new File("res/images/Drawer_1.png"));
		drawers_upper_cover = ImageIO.read(new File("res/images/Drawers_upper_cover.png"));
		drawer_2 = ImageIO.read(new File("res/images/Drawer_2.png"));
		drawer_numbers_sheet = ImageIO.read(new File("res/images/Drawer_numbers.png"));
		drawers_down_cover = ImageIO.read(new File("res/images/Drawers_down_cover.png"));
		rose = ImageIO.read(new File("res/images/Rose.png"));
		gear = ImageIO.read(new File("res/images/Gear.png"));
		shapes = ImageIO.read(new File("res/images/Shapes.png"));
		shapes_sheet = ImageIO.read(new File("res/images/Shapes_sheet.png"));
		handle = ImageIO.read(new File("res/images/Handle.png"));
		shelf[0] = ImageIO.read(new File("res/images/Shelf_cabinet_0_closed.png"));
		shelf[1] = ImageIO.read(new File("res/images/Shelf_cabinet_1_closed.png"));
		shelf[2] = ImageIO.read(new File("res/images/Shelf_upper.png"));
		shelf[3] = ImageIO.read(new File("res/images/Shelf_cabinet_0_opened.png"));
		signs[0] = ImageIO.read(new File("res/images/Sign_1.png"));
		signs[1] = ImageIO.read(new File("res/images/Sign_2.png"));
		jug = ImageIO.read(new File("res/images/Jug.png"));
		gear_base = ImageIO.read(new File("res/images/Gear_base.png"));
		gear_animation[0] = ImageIO.read(new File("res/images/Gear_spinning_0.png"));
		gear_animation[1] = ImageIO.read(new File("res/images/Gear_spinning_1.png"));
		gear_animation[2] = ImageIO.read(new File("res/images/Gear_spinning_2.png"));
		shelf_upper_locked_box = ImageIO.read(new File("res/images/Shelf_upper_locked_box.png"));
		shelf_box_locked = ImageIO.read(new File("res/images/Shelf_box_locked.png"));
		paper_2 = ImageIO.read(new File("res/images/Paper_2.png"));
		shelf_buttons_sheet = ImageIO.read(new File("res/images/Shelf_box_buttons_sheet.png"));
		shelf_box_unlocked = ImageIO.read(new File("res/images/Shelf_box_unlocked.png"));
		ear = ImageIO.read(new File("res/images/Ear.png"));
		ear_vertical = ImageIO.read(new File("res/images/Ear_vertical.png"));
		door = ImageIO.read(new File("res/images/Door_closed.png"));
		sink = ImageIO.read(new File("res/images/Sink.png"));
		sink_upper = ImageIO.read(new File("res/images/Sink_upper.png"));
		handle_up = ImageIO.read(new File("res/images/Handle_up.png"));
		water_flowing[0] = ImageIO.read(new File("res/images/Falling_water_0.png"));
		water_flowing[1] = ImageIO.read(new File("res/images/Falling_water_1.png"));
		jar_on_pillar_filled_1 = ImageIO.read(new File("res/images/Jar_on_pillar_filled_1.png"));
		jar_on_pillar_filled_2 = ImageIO.read(new File("res/images/Jar_on_pillar_filled_2.png"));
		jar_on_pillar_filled_3 = ImageIO.read(new File("res/images/Jar_on_pillar_filled_3.png"));
		sink_with_handle = ImageIO.read(new File("res/images/Sink_with_handle.png"));
		sponge = ImageIO.read(new File("res/images/Sponge.png"));
		painting_horizontal_opened = ImageIO.read(new File("res/images/Painting_horizontal_opened.png"));
		jar_tongue = ImageIO.read(new File("res/images/Jar_tongue.png"));
		tongue = ImageIO.read(new File("res/images/Tongue.png"));
		carpet = ImageIO.read(new File("res/images/Carpet.png"));
		message = ImageIO.read(new File("res/images/Message.png"));
		painting_1 = ImageIO.read(new File("res/images/Painting_1.png"));
		lever = ImageIO.read(new File("res/images/Lever.png"));
		lever_down = ImageIO.read(new File("res/images/Lever_down.png"));
		box_with_signs = ImageIO.read(new File("res/images/Box_with_signs.png"));
		wall_with_floor_2 = ImageIO.read(new File("res/images/Wall_with_floor_2.png"));
		box_with_signs_1 = ImageIO.read(new File("res/images/Box_with_signs_1.png"));
		symbols_sheet = ImageIO.read(new File("res/images/Symbols_sheet.png"));
		box_with_signs_opened = ImageIO.read(new File("res/images/Box_with_signs_opened.png"));
		donkey = ImageIO.read(new File("res/images/Donkey.png"));
		donkey_eyes_sheet = ImageIO.read(new File("res/images/Donkey_eyes_sheet.png"));
		donkey_wounds_sheet = ImageIO.read(new File("res/images/Donkey_wounds_sheet.png"));
		heart = ImageIO.read(new File("res/images/Heart.png"));
		heart_vertical = ImageIO.read(new File("res/images/Heart_vertical.png"));
		donkey_dead = ImageIO.read(new File("res/images/Donkey_dead.png"));
		machine = ImageIO.read(new File("res/images/Machine.png"));
		shelf_upper_unlocked_box = ImageIO.read(new File("res/images/Shelf_upper_unlocked_box.png"));
		shelf[4] = ImageIO.read(new File("res/images/Shelf_cabinet_1_opened.png"));
		paper_1 = ImageIO.read(new File("res/images/Paper_1.png"));
		eye = ImageIO.read(new File("res/images/Eye.png"));
		key_door = ImageIO.read(new File("res/images/Key_door.png"));
		door_lock = ImageIO.read(new File("res/images/Door_lock.png"));
		door_lock_unlocked = ImageIO.read(new File("res/images/Door_lock_unlocked.png"));
		door_opened = ImageIO.read(new File("res/images/Door_opened.png"));
		machine_lever_hole = ImageIO.read(new File("res/images/Machine_lever_hole.png"));
		machine_box = ImageIO.read(new File("res/images/Machine_box.png"));
		red_gear_animation[0] = ImageIO.read(new File("res/images/Red_gear_0.png"));
		table_with_vase = ImageIO.read(new File("res/images/Table_with_vase.png"));
		rose_in_vase = ImageIO.read(new File("res/images/Rose_in_vase.png"));
		red_room = ImageIO.read(new File("res/images/Red_room.png"));
		chair = ImageIO.read(new File("res/images/Chair.png"));
		chair_left = ImageIO.read(new File("res/images/Chair_left.png"));
		lamp = ImageIO.read(new File("res/images/Lamp.png"));
		the_arm = ImageIO.read(new File("res/images/The_arm.png"));
		red_pillar = ImageIO.read(new File("res/images/Red_pillar.png"));
		machine_plate = ImageIO.read(new File("res/images/Machine_plate.png"));
		machine_lever_horizontal = ImageIO.read(new File("res/images/Machine_lever_horizontal.png"));
		machine_lever = ImageIO.read(new File("res/images/Machine_lever.png"));
		machine_lever_down = ImageIO.read(new File("res/images/Machine_lever_down.png"));
		machine_box_opened = ImageIO.read(new File("res/images/Machine_box_opened.png"));
		TP_symbol = ImageIO.read(new File("res/images/TP_symbol.png"));
		machine_sign = ImageIO.read(new File("res/images/Machine_sign.png"));
		arm_sign = ImageIO.read(new File("res/images/Arm_sign.png"));
		red_gear_animation[1] = ImageIO.read(new File("res/images/Red_gear_1.png"));
		red_gear_animation[2] = ImageIO.read(new File("res/images/Red_gear_2.png"));
		machine_digits_sheet = ImageIO.read(new File("res/images/Machine_digits_sheet.png"));
		black_cube = ImageIO.read(new File("res/images/Black_cube.png"));
		play_button = ImageIO.read(new File("res/images/Play_button.png"));
		space = ImageIO.read(new File("res/images/Space.png"));
		pause_button = ImageIO.read(new File("res/images/Pause_button.png"));
		resume_button = ImageIO.read(new File("res/images/Resume_button.png"));
		pause_line = ImageIO.read(new File("res/images/Pause_line.png"));
		pause_triangle = ImageIO.read(new File("res/images/Pause_triangle.png"));
		escape_button = ImageIO.read(new File("res/images/Escape_button.png"));
		quit_button = ImageIO.read(new File("res/images/Quit_button.png"));
		info_button = ImageIO.read(new File("res/images/Info_button.png"));
		info_text = ImageIO.read(new File("res/images/Info_text.png"));
		star_button = ImageIO.read(new File("res/images/Star_button.png"));
		achievements_sheet = ImageIO.read(new File("res/images/Achievements_sheet.png"));
		achievement_names_sheet = ImageIO.read(new File("res/images/Achievement_names_sheet.png"));
		star = ImageIO.read(new File("res/images/Star.png"));
		ending_1 = ImageIO.read(new File("res/images/Ending_1.jpg"));
		ending_2 = ImageIO.read(new File("res/images/Ending_2.jpg"));
		ending_3 = ImageIO.read(new File("res/images/Ending_3.jpg"));
		continue_ = ImageIO.read(new File("res/images/Continue.png"));
		achievements_button = ImageIO.read(new File("res/images/Achievements.png"));
		reset_button = ImageIO.read(new File("res/images/Reset_button.png"));
		reset_button1 = ImageIO.read(new File("res/images/Reset_button1.png"));
		reset_achievements0 = ImageIO.read(new File("res/images/Reset_achievements0.png"));
		reset_achievements1 = ImageIO.read(new File("res/images/Reset_achievements1.png"));
		video_star = ImageIO.read(new File("res/images/Video_star.png"));
		paradox = ImageIO.read(new File("res/images/Paradox.png"));
		for(int i = 0; i < 10; i++) {safe_wall_with_couch_numbers[i] = safe_wall_with_couch_numbers_sheet.getSubimage(i*42, 0, 42, 42);}
		for(int i = 0; i < 10; i++) {drawer_numbers[i] = drawer_numbers_sheet.getSubimage(i*31, 0, 31, 32);}
		for(int i = 0; i < 5; i++) {shapes_shapes[i] = shapes_sheet.getSubimage(14*i, 0, 14, 14);}
		for(int i = 0; i < 8; i++) {shelf_buttons_pushed[i] = shelf_buttons_sheet.getSubimage(i*37, 0, 37, 37);}
		for(int i = 0; i < 8; i++) {shelf_buttons_unpushed[i] = shelf_buttons_sheet.getSubimage(i*37, 37, 37, 43);}
		for(int i = 0; i < 10; i++) {symbols[i] = symbols_sheet.getSubimage(i*44, 0, 44, 53);}
		for(int i = 0; i < 2; i++) {donkey_eyes[i] = donkey_eyes_sheet.getSubimage(i*13, 0, 13, 13);}
		for(int i = 0; i < 3; i++) {donkey_wounds[i] = donkey_wounds_sheet.getSubimage(i*43, 0, 43, 38);}
		for(short i = 0; i < 10; i++) {machine_digits[i] = machine_digits_sheet.getSubimage(i*264, 0, 264, 377);}
		for(short i = 0; i < 8; i++) {achievements[i] = achievements_sheet.getSubimage(i*151, 0, 151, 151);}
		for(short i = 8; i < 16; i++) {achievements[i] = achievements_sheet.getSubimage((i - 8)*151, 151, 151, 151);}
		for(byte i = 0; i < 8; i++) {achievement_names[i] = achievement_names_sheet.getSubimage(0, i*47, 397, 47);}
	}
}