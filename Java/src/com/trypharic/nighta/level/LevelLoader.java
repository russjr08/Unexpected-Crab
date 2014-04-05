package com.trypharic.nighta.level;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.trypharic.nighta.graphics.Quad;
import com.trypharic.nighta.render.tiles.Tiles;

public class LevelLoader
{
	public static Level loadLevel(String pathToLevel)
	{
		Level tempLevel = new Level();
		
		BufferedReader levelReader = null;
				
		String line;
		
		try
		{
			levelReader = new BufferedReader(new FileReader(new File(pathToLevel)));
			
			while ((line = levelReader.readLine()) != null)
			{
				if(line.startsWith("//"))
				{
					continue;
				}
				
				if(line.startsWith("title"))
				{
					String levelName = line.split(" ")[1];
					
					tempLevel.setTitle(levelName);
				}
				
				if(line.startsWith("author"))
				{
					String levelAuthor = line.split(" ")[1];
					
					tempLevel.setAuthor(levelAuthor);
				}
				
				if(line.startsWith("tile"))
				{
					String x = line.split(" ")[1];
					String y = line.split(" ")[2];
					String size = line.split(" ")[3];
					
					Quad tile = new Quad(Float.valueOf(x) * 2.0f, Float.valueOf(y) * 2.0f, Float.valueOf(size), Float.valueOf(size), Tiles.grass);
					tempLevel.addTile(tile);
				}
				
				if(line.startsWith("chunk"))
				{
					float x = Float.valueOf(line.split(" ")[1]);
					float y = Float.valueOf(line.split(" ")[2]);
					float chunkSize = Float.valueOf(line.split(" ")[3]);
					float quadSize = Float.valueOf(line.split(" ")[4]);
					
					for (int i = (int)x; i < y + (int)chunkSize; i++)
					{
						for (int j = (int)y; j < y + (int)chunkSize; j++)
						{
							Quad quad = new Quad(i * 2.0f, j * 2.0f, quadSize, quadSize, Tiles.grass);
							
							tempLevel.addTile(quad);
						}
					}
				}
			}
			
			levelReader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return tempLevel;
	}
}
