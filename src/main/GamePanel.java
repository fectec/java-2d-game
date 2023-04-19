package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Player;


public class GamePanel extends JPanel implements Runnable {
	
	// Screen Settings
	
	static final int originalTileSize = 16; // 16x16 tile
	static final int scale = 3; // Scale Factor
	public static final int tileSize = originalTileSize * scale; // 48x48 tile
	
	final int maxScreenCol = 16; // Number of Columns
	final int maxScreenRow = 12; // Number of Rows
	
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeigth = tileSize * maxScreenRow; // 576 pixels
	
	final int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	
	// Player Instantiation
	
	Player player = new Player(100, 100, 5, "down", "/player/boy_up_1.png", "/player/boy_up_2.png", "/player/boy_down_1.png", "/player/boy_down_2.png", "/player/boy_left_1.png", "/player/boy_left_2.png", "/player/boy_right_1.png", "/player/boy_right_2.png", this, keyH);

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
		
		player.update();

	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g; // Graphics2D Extends Graphics Class to Provide Better Control Over Graphics
		
		player.draw(g2);
		
		g2.dispose();
		
	}
	
}
