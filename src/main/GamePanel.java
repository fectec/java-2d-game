package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	// SCREEN SETTINGS
	
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3; // Scale Factor
	final int tileSize = originalTileSize * scale; // 48x48 tile
	
	final int maxScreenCol = 16; // Number of Columns
	final int maxScreenRow = 12; // Number of Rows
	
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeigth = tileSize * maxScreenRow; // 576 pixels
	
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	
	// Set Player's Default Position
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 20;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);	
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	@Override
	
	public void run() {
		
		double drawInterval = 1000000000 / FPS; // 0.01666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		// Game Loop
		
		while(gameThread != null) {
			
			// Updating Information	
			
			update();
			
			// Redrawing Screen with Updated Information
			
			repaint();
			
			try {
				
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				
				if(remainingTime < 0) {	remainingTime = 0; }
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} 
			catch (InterruptedException e) { e.printStackTrace(); }
			
		}
		
	}
	
	public void update() {
		
		System.out.println(keyH.upPressed);
		
		if(keyH.upPressed == true) { playerY -= playerSpeed; }
		else if(keyH.downPressed ==  true) { playerY += playerSpeed; }
		else if(keyH.leftPressed == true) { playerX -= playerSpeed; }
		else if(keyH.rigthPressed == true) {playerX += playerSpeed; }

	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g; // Graphics2D Extends Graphics Class to Provide Better Control Over Graphics
		
		g2.setColor(Color.white);	
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
		
	}
}
