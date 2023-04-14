package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3; // Scale Factor
	final int tileSize = originalTileSize * scale; // 48x48 tile
	
	final int maxScreenCol = 16; // Number of Columns
	final int maxScreenRow = 12; // Number of Rows
	
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeigth = tileSize * maxScreenRow; // 576 pixels
	
	Thread gameThread;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);	
		
	}
	
	public void startGameThread()
	{
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	@Override
	
	public void run() {
		
	}
}
