package com.opfrproductions.sidescroller;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class MediaManager {
	//Have static media here
	/*
	 * Example:
	 * BufferedImage[] terrain;
	 */
	BufferedImage[] terrain;
	public static Level level1;
	public MediaManager()
	{
		//Load the static media here
		/*
		 * Example:
		 * terrain = loadSheet(MediaManager.class.getResourceAsStream("terrain.png"), 16, 16);
		 */
		terrain = loadSheet(MediaManager.class.getResourceAsStream("Terrain.png"), 20, 20); //Path is written relative to this class's position in the jar file ;). Because terrain is in the same "package" as MediaManager(Same folder), just write Terrain.png
		level1 = new Level(MediaManager.class.getResourceAsStream("level1.dat"));
	}
	public static BufferedImage load(InputStream stream)
	{
		try {
			return ImageIO.read(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static BufferedImage[] loadSheet(InputStream stream, int celw, int celh)
	{
		BufferedImage src = null;
		try {
			src = ImageIO.read(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//First, some error checking
		if(src.getWidth()%celw!=0||src.getHeight()%celh!=0)
		{
			Exception e = new Exception();
			e.printStackTrace();
		}
		//The actual goods!
		int w = src.getWidth()/celw;
		int h = src.getHeight()/celh;
		BufferedImage[] toReturn = new BufferedImage[w*h];
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				toReturn[x+(y*w)] = src.getSubimage(x*celw, y*celh, celw, celh);
			}
		}
		return toReturn;
	}
}
