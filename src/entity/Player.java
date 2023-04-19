package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gP;
	KeyHandler keyH;
	
	public Player(int x, int y, int speed, GamePanel gP, KeyHandler keyH)
	{
		super(x, y, speed);
		this.gP = gP;
		this.keyH = keyH;
	}
	
	public void update( ) {
		
		if(keyH.upPressed == true) { this.y -= this.speed; }
		else if(keyH.downPressed ==  true) { this.y += this.speed; }
		else if(keyH.leftPressed == true) { this.x -= this.speed; }
		else if(keyH.rigthPressed == true) { this.x += this.speed; }
		
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(Color.white);	
		g2.fillRect(this.x, this.y, GamePanel.tileSize, GamePanel.tileSize);
		g2.dispose();
		
	}
	
}
