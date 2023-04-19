package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame(); // Creates Window
		
		window.setLocationRelativeTo(null); // Window is Located at the Center of the Screen
		window.setVisible(true);
		window.setTitle("2D Game");
		window.setResizable(false); // Can Not Resize Window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Lets the Window Properly Close When User Clicks the Close Button
		
		GamePanel gamePanel = new GamePanel(); // Creates Game Panel
		window.add(gamePanel); // Adds Game Panel to Window
		window.pack(); // Window Takes Game Panel Dimensions
		
		gamePanel.startGameThread();
		gamePanel.requestFocus();
		
	}

}
