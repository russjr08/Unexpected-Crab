package com.trypharic.nighta.world.structures;

import java.util.ArrayList;

import com.trypharic.nighta.graphics.Quad;
import com.trypharic.nighta.render.tiles.Tiles;

public class StructureBrickHouse
{
	public ArrayList<Quad> tiles = new ArrayList<>();
	
	public final int X, Y;
	
	public StructureBrickHouse(final int X, final int Y)
	{
		this.X = X;
		
		this.Y = Y;
	}
	
	/*public void setTiles()
	{
		Quad tile1 = new Quad(X, Y + 1, 32.0f, 32.0f, Tiles.brick);
		
		tiles.add(tile1);
		
		Quad tile2 = new Quad(X + 1, Y + 1, 32.0f, 32.0f, Tiles.brick);
		
		tiles.add(tile2);
		
		Quad tile3 = new Quad(X + 2, Y + 1, 32.0f, 32.0f, Tiles.brick);
		
		tiles.add(tile3);
		
		Quad tile4 = new Quad(X + 3, Y + 1, 32.0f, 32.0f, Tiles.brick);
		
		tiles.add(tile4);
		
		Quad tile5 = new Quad(X + 4, Y + 1, 32.0f, 32.0f, Tiles.brick);
				
		tiles.add(tile5);
		
		Quad tile6 = new Quad(X + 1, Y, 32.0f, 32.0f, Tiles.wood);
				
		tiles.add(tile6);
		
		Quad tile7 = new Quad(X + 2, Y, 32.0f, 32.0f, Tiles.wood);		
		
		tiles.add(tile7);
		
		Quad tile8 = new Quad(X + 3, Y, 32.0f, 32.0f, Tiles.wood);
				
		tiles.add(tile8);
		
		Quad tile9 = new Quad(X + 4, Y, 32.0f, 32.0f, Tiles.wood);
				
		tiles.add(tile9);
		
		Quad tile11 = new Quad(X + 1, Y - 1, 32.0f, 32.0f, Tiles.wood);
		
		tiles.add(tile11);
		
		Quad tile12 = new Quad(X + 2, Y - 1, 32.0f, 32.0f, Tiles.wood);		
		
		tiles.add(tile12);
		
		Quad tile13 = new Quad(X + 3, Y - 1, 32.0f, 32.0f, Tiles.wood);
				
		tiles.add(tile13);
		
		Quad tile14 = new Quad(X + 4, Y - 1, 32.0f, 32.0f, Tiles.wood);
				
		tiles.add(tile14);
	}*/
	
	public void renderTiles()
	{
		for (Quad tile : tiles)
		{
			tile.render();
		}
	}
}
