import java.awt.Color;
import java.awt.Graphics;


public class GameScreen extends Screen {
	@Override
	
	public void tick(int delta, Graphics g)
	{
		g.setColor(Color.white);
		g.drawString("A GAME", 100, 100);
	}
}
