package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gP;
	KeyHandler keyH;
	
	public Player(int x, int y, int speed, String direction, String up1, String up2, String down1, String down2, String left1, String left2, String rigth1, String rigth2, GamePanel gP, KeyHandler keyH)
	{
		
		super(x, y, speed, direction, up1, up2, down1, down2, left1, left2, rigth1, rigth2);
		this.gP = gP;
		this.keyH = keyH;
		
	}
	
	public void update( ) {
		
		if(keyH.upPressed == true) { 
			
			this.direction = "up";
			this.y -= this.speed; 
			
		}
		else if(keyH.downPressed ==  true) { 
			
			this.direction = "down";
			this.y += this.speed; 
			
		}
		else if(keyH.leftPressed == true) {
			
			this.direction = "left";
			this.x -= this.speed; 
			
		}
		else if(keyH.rightPressed == true) {
			
			this.direction = "right";
			this.x += this.speed; 
			
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		// g2.setColor(Color.white);	
		// g2.fillRect(this.x, this.y, GamePanel.tileSize, GamePanel.tileSize);
		
		switch(this.direction) {
		
		case "up":
			
			this.image = this.up1;
			break;
			
		case "down":
			
			this.image = this.down1;
			break;
			
		case "left":
			
			this.image = this.left1;
			break;
			
		case "right":
			
			this.image = this.right1;
			break;
			
		}
		
		g2.drawImage(this.image, this.x, this.y, GamePanel.tileSize, GamePanel.tileSize, null);
			
	}
	
}
