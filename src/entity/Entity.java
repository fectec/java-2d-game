package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Entity {
	
	public int x, y, speed;
	public String direction;
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, image;
	
	public Entity(int x, int y, int speed, String direction, String up1, String up2, String down1, String down2, String left1, String left2, String right1, String right2) {
		
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.direction = direction;
		
		try {
			
			this.up1 = ImageIO.read(getClass().getResourceAsStream(up1));
			this.up2 = ImageIO.read(getClass().getResourceAsStream(up2));
			this.down1 = ImageIO.read(getClass().getResourceAsStream(down1));
			this.down2 = ImageIO.read(getClass().getResourceAsStream(down2));
			this.left1 = ImageIO.read(getClass().getResourceAsStream(left1));
			this.left2 = ImageIO.read(getClass().getResourceAsStream(left2));
			this.right1 = ImageIO.read(getClass().getResourceAsStream(right1));
			this.right2 = ImageIO.read(getClass().getResourceAsStream(right2));
			
		} 
		catch (IOException e) { e.printStackTrace(); }
		
	}
	
}
