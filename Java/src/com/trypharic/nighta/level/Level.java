package com.trypharic.nighta.level;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.trypharic.nighta.graphics.Quad;

public class Level
{
	private int id = 0;
	
	private String title = "", author = "";
	
	private List<Quad> tiles = new CopyOnWriteArrayList<Quad>();
	
	public Level()
	{
		
	}
	
	public Level(int id, String title, String author, List<Quad> quads)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.tiles = quads;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public List<Quad> getTiles()
	{
		return tiles;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public void addTile(Quad tile)
	{
		this.tiles.add(tile);
	}
}