package com.opfrproductions.sidescroller;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Game extends Applet implements Runnable{

	public static int w = 900;
	public static int h = 600;
	
	public static Thread gameThread;
	public static GameScreen gameScreen;
	
	public static MediaManager media;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sider");
		Game game = new Game();
		game.init();
		game.setPreferredSize(new Dimension(w, h));
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		game.start();
	}
	@Override
	public void init()
	{
		gameThread = new Thread(this);
		media = new MediaManager();
	}
	public void start()
	{
		gameScreen = new GameScreen();
		gameThread.start();
	}
	@Override
	public void stop()
	{
		
	}
	BufferedImage backBuffer;
	@Override
	public void run() {
		int fps=0;
		int frames=0;
		long lastFpsUpdate=System.currentTimeMillis();
		long lastUpdate=System.currentTimeMillis();
		double sine = 0;
		while (true){
			//Measure time
			if(System.currentTimeMillis()-lastFpsUpdate>1000)
			{
				fps=frames;
				frames=0;
				lastFpsUpdate=System.currentTimeMillis();
				System.out.println(fps);
			}
			frames++;
			int delta = (int)(System.currentTimeMillis()-lastUpdate);
			lastUpdate = System.currentTimeMillis();
			//Use double buffering
			if(backBuffer==null||backBuffer.getWidth(null)!=this.getWidth()||backBuffer.getHeight(null)!=this.getHeight())
			{
				backBuffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
			}
			Graphics g = backBuffer.getGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			/*
			 * YOUR CODE GOES FROM HERE
			 */
			gameScreen.tick(delta, g);
			/*
			 * TO HERE
			 */
			this.getGraphics().drawImage(backBuffer, 0, 0, null);
			
		}
		
	}
}
