import java.applet.Applet;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Game extends Applet implements Runnable{

	public static int w = 900;
	public static int h = 600;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sider");
		Game game = new Game();
		game.init();
		game.setPreferredSize(new Dimension(w, h));
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		game.start();
	}
	@Override
	public void init()
	{
		
	}
	public void start()
	{
		
	}
	@Override
	public void stop()
	{
		
	}
	@Override
	public void run() {
		while (true){
			
		}
		
	}
}
