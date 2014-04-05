package com.trypharic.nighta.world;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.Display;

import com.trypharic.nighta.entitys.Entity;
import com.trypharic.nighta.entitys.EntityPlayer;
import com.trypharic.nighta.graphics.Quad;
import com.trypharic.nighta.world.structures.StructureBrickHouse;

/**
 * The game world, complete with random generating.
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.0
 */
public class World
{
	/**
	 * The tiles in the world.
	 */
	public ArrayList<Quad> tiles = new ArrayList<>();

	/**
	 * The entitys in the world.
	 */
	public ArrayList<Entity> entitys = new ArrayList<>();

	/**
	 * The player in the world.
	 */
	public ArrayList<EntityPlayer> player = new ArrayList<>();

	/**
	 * The Chunks In The World.
	 */
	public ArrayList<Chunk> chunks = new ArrayList<>();

	/**
	 * The width and height of the screen.
	 */
	public int screenWidth = 0, screenHeight = 0;

	/**
	 * The world player instance.
	 */
	public EntityPlayer entityPlayer = null;

	/**
	 * Java Random Declaration.
	 */
	public Random random = new Random();

	/**
	 * Has the player instance been set?
	 */
	private boolean playerSet = false;

	public boolean doneGenerating = false;

	public int currentChunkLocX = 0, currentChunkLocY = 0, chunkSizeX = 40, chunkSizeY = 30, chunkBoundsX = 640, chunkBoundsY = 480, worldSize = 3;

	public StructureBrickHouse brickHouse = new StructureBrickHouse(40, 0);

	public int currentChunkNum = 0;

	/**
	 * Create a new World instance.
	 * 
	 * @param screenWidth
	 * @param screenHeight
	 * @param entityPlayer
	 */
	public World(int screenWidth, int screenHeight)
	{
		this.screenWidth = screenWidth;

		this.screenHeight = screenHeight;
	}

	/**
	 * Update's this world instance.
	 */
	public void updateWorld()
	{
		if (entitys.size() != 0)
		{
			for (Entity entity : entitys)
			{
				entity.update();
			}
		}
	}

	/**
	 * Add a chunk to the world.
	 */
	public synchronized void addWorldCells()
	{
		for (int x = 0; x < worldSize; x++)
		{
			for (int y = 0; y < worldSize; y++)
			{
				Chunk chunk = new Chunk(x * chunkSizeX, y * chunkSizeY, chunkSizeX, chunkSizeY);

				chunks.add(chunk);

				currentChunkNum++;
			}
		}

		//brickHouse.setTiles();
	}

	/**
	 * Renders this World instance.
	 */
	public void renderWorld()
	{
		/*
		 * if (tiles.size() != 0) { for (Quad quad : tiles) { quad.render();
		 * quad.updateQuad(); } }
		 */

		if (entitys.size() != 0)
		{
			for (Entity entity : entitys)
			{
				entity.render();

				entity.update();
			}
		}

		if (player.size() != 0)
		{
			for (EntityPlayer entity : player)
			{
				this.entityPlayer = entity;
			}
		}
		
		for (Chunk chunk : chunks)
		{
			for (Quad quad : chunk.tiles)
			{
				if(Math.abs(entityPlayer.position.getX()) < quad.position.getX() + quad.size.getX() + Display.getWidth() / 2 && Math.abs(entityPlayer.position.getY()) < quad.position.getY() + quad.size.getY() + Display.getHeight() / 2 && Math.abs(entityPlayer.position.getX()) > quad.position.getX() - quad.size.getX() - Display.getWidth() / 2 && Math.abs(entityPlayer.position.getY()) > quad.position.getY() - quad.size.getY() - Display.getHeight() / 2)
					quad.render();
			}
		}
		
		//brickHouse.renderTiles();
	}

	/**
	 * Set's the World instances player.
	 * 
	 * @param entityPlayer
	 */
	public void setPlayer(EntityPlayer entityPlayer)
	{
		player.add(entityPlayer);

		playerSet = true;
	}

	/**
	 * Has the player been set?
	 * 
	 * @return
	 */
	public boolean hasPlayerBeenSet()
	{
		return playerSet;
	}
}
