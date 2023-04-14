package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	// Screen Settings
	
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3; // Scale Factor
	final int tileSize = originalTileSize * scale; // 48*48 tile
	
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeigth = tileSize * maxScreenRow; // 576 pixels
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
	}
	
}
