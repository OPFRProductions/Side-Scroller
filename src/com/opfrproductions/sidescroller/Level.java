package com.opfrproductions.sidescroller;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Level {
	int w=0;
	int h=0;
	int renderoffx=0;
	int renderoffy=0;
	int[] pieces;
	public Level(InputStream stream){
		long start = System.currentTimeMillis();
		DataInputStream in = new DataInputStream(stream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String textFile="";
		String strLine;
		try {
		while((strLine=br.readLine())!=null) {
			textFile=textFile+strLine+"\n";
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		String[] levelData = textFile.split("\n");
		w=levelData[0].length();
		h=levelData.length;
		pieces = new int[w*h];
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				pieces[x+(y*w)]=getPiece(levelData[y].charAt(x));
			}
		}
		long time = System.currentTimeMillis()-start;
		System.out.println("Took " + time + "ms to load a level");
	}
	private int getPiece(char charAt) {
		if(charAt=='%') //Air
			return 0;
		if(charAt=='#') //Solid ground
			return 1;
		return 0;
	}
	public void render(Graphics g)
	{
		
	}
}
