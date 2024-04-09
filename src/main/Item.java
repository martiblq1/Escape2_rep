package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Item
{
	private Items item;
	
	private BufferedImage sprite;
	private Rectangle bounds;
	
	private int y;
	private boolean takeable;
	
	public Item()
	{
		
	}
	
	public Item(Items item, boolean takeable, Assets assets, int y)
	{
		this.item = item;
		this.takeable = takeable;
		this.y = y;
		
		switch(item)
		{
		case KEY_SHELF_CABINET_0:
			sprite = assets.key_shelf_cabinet_1;
			
			if(takeable)
			{
				bounds = new Rectangle((int)(800*Assets.X_RATIO), (int)(300*Assets.Y_RATIO), (int)(675/3*Assets.X_RATIO), (int)(333/3*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{	
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 675/5/2)*Assets.X_RATIO), (int)((this.y + 333/5/2)*Assets.Y_RATIO), (int)(675/5*Assets.X_RATIO), (int)(333/5*Assets.Y_RATIO));
			}
			
			break;
		
		case KNIFE:
			sprite = assets.knife;
			
			if(takeable)
			{
				bounds = new Rectangle((int)(750*Assets.X_RATIO), (int)(250*Assets.Y_RATIO), (int)(231*1.5*Assets.X_RATIO), (int)(31*1.5*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 231)*Assets.X_RATIO), (int)((this.y + 77/2 + 31/2)*Assets.Y_RATIO), (int)(231*Assets.X_RATIO), (int)(31*Assets.Y_RATIO));
			}
			
			break;
		
		case ROSE:
			sprite = assets.rose;
			
			if(takeable)
			{
				bounds = new Rectangle((int)(870*Assets.X_RATIO), (int)(670*Assets.Y_RATIO), (int)(125*Assets.X_RATIO), (int)(58*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 125/2 - 77)*Assets.X_RATIO), (int)((this.y + 77 - 58/2)*Assets.Y_RATIO), (int)(125*Assets.X_RATIO), (int)(58*Assets.Y_RATIO));
			}
			
			break;
			
		case GEAR:
			sprite = assets.gear;
			
			if(takeable)
			{
				bounds = new Rectangle((int)(885*Assets.X_RATIO), (int)(258*Assets.Y_RATIO), (int)(53*2*Assets.X_RATIO), (int)(51*2*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 53 - 77)*Assets.X_RATIO), (int)((this.y + 77 - 51)*Assets.Y_RATIO), (int)(53*2*Assets.X_RATIO), (int)(51*2*Assets.Y_RATIO));
			}
			
			break;
			
		case HANDLE:
			sprite = assets.handle;
			
			if(takeable)
			{
				bounds = new Rectangle((int)((1920/2 - 86*7/2 - 30  + 76*7/2 - (int) (454*0.8)/2)*Assets.X_RATIO), (int)((1080/2 - 86*7/2 + 76*7/2 - (int) (54*0.8)/2)*Assets.Y_RATIO), (int)(454*0.8*Assets.X_RATIO), (int) (54*0.8*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 454/2)*Assets.X_RATIO), (int)((this.y + 77 - 54/2)*Assets.Y_RATIO), (int)(454/2*Assets.X_RATIO), (int)(54/2*Assets.Y_RATIO));
			}
			
			break;
			
		case JUG:
			sprite = assets.jug;
			
			if(takeable)
			{
				bounds = new Rectangle((int)(880*Assets.X_RATIO), (int)((1080 - 49*4)*Assets.Y_RATIO), (int)(44*4*Assets.X_RATIO), (int)(49*4*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 44)*Assets.X_RATIO), (int)((this.y + 77 - 49)*Assets.Y_RATIO), (int)(44*2*Assets.X_RATIO), (int)(49*2*Assets.Y_RATIO));
			}
			
			break;
			
		case JUG_FILLED:
			sprite = assets.jug;
			
			if(takeable)
			{
				
			}
			else
			{
				if(this.y == -1)
				{
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 44)*Assets.X_RATIO), (int)((this.y + 77 - 49)*Assets.Y_RATIO), (int)(44*2*Assets.X_RATIO), (int)(49*2*Assets.Y_RATIO));
			}
			
			break;
			
		case EAR:
			sprite = assets.ear;
			
			if(takeable) //takeable from the screen
			{
				bounds = new Rectangle((int)((1920/2 - 398*3/2 + 119*3)*Assets.X_RATIO), (int)((140 - 165*3 + 248*3)*Assets.Y_RATIO), (int)(162*3*Assets.X_RATIO), (int)(108*3*Assets.Y_RATIO));
				break;
			}
			
			if(this.y == -1)
			{
				for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
				{
					if(box.get_empty())
					{
						this.y = box.get_bounds().y;
						break;
					}
				}
			}
			
			bounds = new Rectangle((int)((1920 - 77 - 162/2)*Assets.X_RATIO), (int)((this.y + 77 - 108/2)*Assets.Y_RATIO), (int)(162*Assets.X_RATIO), (int)(108*Assets.Y_RATIO));
			break;
			
		case SPONGE:
			sprite = assets.sponge;
			
			if(takeable) //takeable from the screen
			{
				bounds = new Rectangle((int)((375 + 372*2)*Assets.X_RATIO), (int)((70 + 150*2)*Assets.Y_RATIO), (int)(71*2*Assets.X_RATIO), (int)(70*2*Assets.Y_RATIO));
				break;
			}
			
			if(this.y == -1)
			{
				for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
				{
					if(box.get_empty())
					{
						this.y = box.get_bounds().y;
						break;
					}
				}
			}
			
			bounds = new Rectangle((int)((1920 - 77 - 71)*Assets.X_RATIO), (int)((this.y + 77 - 70)*Assets.Y_RATIO), (int)(71*2*Assets.X_RATIO), (int)(70*2*Assets.Y_RATIO));
			break;
			
		case TONGUE:
			sprite = assets.tongue;
			
			if(takeable) //takeable from the screen
			{
				bounds = new Rectangle((int)(900*Assets.X_RATIO), (int)(630*Assets.Y_RATIO), (int)(53*2*Assets.X_RATIO), (int)(54*2*Assets.Y_RATIO));
				break;
			}
			
			if(this.y == -1)
			{
				for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
				{
					if(box.get_empty())
					{
						this.y = box.get_bounds().y;
						break;
					}
				}
			}
			
			bounds = new Rectangle((int)((1920 - 77 - 53)*Assets.X_RATIO), (int)((this.y + 77 - 54)*Assets.Y_RATIO), (int)(53*2*Assets.X_RATIO), (int)(54*2*Assets.Y_RATIO));
			break;
			
		case KEY_DRAWER_0:
			sprite = assets.key_shelf_cabinet_1;
			
			if(takeable)
			{
				bounds = new Rectangle((int)(((1920 - 77*2)/2 - 550*3/2 + 225*3)*Assets.X_RATIO), (int)((20 - 236*3 + 377*3)*Assets.Y_RATIO), (int)(85*3*Assets.X_RATIO), (int)(42*3*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{	
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 675/5/2)*Assets.X_RATIO), (int)((this.y + 333/5/2)*Assets.Y_RATIO), (int)(675/5*Assets.X_RATIO), (int)(333/5*Assets.Y_RATIO));
			}
			
			break;
			
		case HEART:
			sprite = assets.heart_vertical;
			
			if(takeable)
			{
				bounds = new Rectangle();
			}
			else
			{
				if(this.y == -1)
				{	
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 71/2)*Assets.X_RATIO), (int)((this.y + 77 - 113/2)*Assets.Y_RATIO), (int)(71*Assets.X_RATIO), (int)(113*Assets.Y_RATIO));
			}
			
			break;
			
		case KEY_SHELF_CABINET_1:
			sprite = assets.key_shelf_cabinet_1;
			
			if(takeable)
			{
				bounds = new Rectangle((int)(1125*Assets.X_RATIO), (int)(600*Assets.Y_RATIO), (int)(675/5*Assets.X_RATIO), (int)(333/5*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{	
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 675/5/2)*Assets.X_RATIO), (int)((this.y + 333/5/2)*Assets.Y_RATIO), (int)(675/5*Assets.X_RATIO), (int)(333/5*Assets.Y_RATIO));
			}
			
			break;
		
		case EYE:
			sprite = assets.eye;
			
			if(takeable)
			{
				bounds = new Rectangle((int)((150 + 249*3)*Assets.X_RATIO), (int)((90 + 197*3)*Assets.Y_RATIO), (int)(50*3*Assets.X_RATIO), (int)(50*3*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{	
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 50)*Assets.X_RATIO), (int)((this.y + 50/2)*Assets.Y_RATIO), (int)(50*2*Assets.X_RATIO), (int)(50*2*Assets.Y_RATIO));
			}
			
			break;
			
		case KEY_DOOR:
			sprite = assets.key_door;
			
			if(takeable)
			{
				bounds = new Rectangle((int)(220*Assets.X_RATIO), (int)(340*Assets.Y_RATIO), (int)(99*Assets.X_RATIO), (int)(59*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{	
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 99/2)*Assets.X_RATIO), (int)((this.y + 59/2)*Assets.Y_RATIO), (int)(99*Assets.X_RATIO), (int)(59*Assets.Y_RATIO));
			}
			
			break;
			
		case LEVER:
			sprite = assets.machine_lever_horizontal;
			
			if(takeable)
			{
				bounds = new Rectangle((int)((1920/2 - 77/2 - 271*2 + 34 + 85*4)*Assets.X_RATIO), (int)((700 + 5*4)*Assets.Y_RATIO), (int)(88*4*Assets.X_RATIO), (int)(24*4*Assets.Y_RATIO));
			}
			else
			{
				if(this.y == -1)
				{	
					for(Inventory_box box : Launcher.game.get_inventory().get_inventory_boxes())
					{
						if(box.get_empty())
						{
							this.y = box.get_bounds().y;
							break;
						}
					}
				}
				
				bounds = new Rectangle((int)((1920 - 77 - 88/2)*Assets.X_RATIO), (int)((this.y + 77 - 24/2)*Assets.Y_RATIO), (int)(88*Assets.X_RATIO), (int)(24*Assets.Y_RATIO));
			}
			
			break;
			
		default:
			break;
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(sprite, bounds.x, bounds.y, bounds.width, bounds.height, null);
	}
	
	//getters and setters
	public Items get_item()
	{
		return item;
	}
	
	public Rectangle get_bounds()
	{
		return bounds;
	}
	
	public boolean get_takeable()
	{
		return takeable;
	}
	
	public void set_y(int y)
	{
		int x = bounds.x, width = bounds.width, height = bounds.height;
		bounds = new Rectangle(x, y, width, height);
	}
}
