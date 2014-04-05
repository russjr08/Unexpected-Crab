package com.trypharic.nighta.world;

import java.util.ArrayList;
import java.util.Random;

import com.trypharic.nighta.graphics.Quad;
import com.trypharic.nighta.render.tiles.Tiles;

/**
 * The Chunk class, use this to generate chunks and render them (Note: put the
 * render method in the world class).
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.0
 */
public class Chunk
{

	public final float chunkSizeX, chunkSizeY;

	public final int chunkX, chunkY;

	public int maxChunkX, maxChunkY, defaultMaxChunkSizeX = 40, defaultMaxChunkSizeY = 30;

	public ArrayList<Quad> tiles = new ArrayList<>();

	private Random random = new Random();

	/**
	 * The constructor for creating a new Chunk.
	 * 
	 * @param chunkX
	 * @param chunkY
	 * @param chunkSizeX
	 * @param chunkSizeY
	 */
	public Chunk(final int chunkX, final int chunkY, final float chunkSizeX, final float chunkSizeY)
	{
		this.chunkSizeX = chunkSizeX;

		this.chunkSizeY = chunkSizeY;

		this.chunkX = chunkX;

		this.chunkY = chunkY;

		if (chunkX == 0 || chunkX == 1)
			maxChunkX = defaultMaxChunkSizeX;
		else
			maxChunkX = chunkX + defaultMaxChunkSizeX;

		if (chunkY == 0 || chunkY == 1)
			maxChunkY = defaultMaxChunkSizeY;
		else
			maxChunkY = chunkY + defaultMaxChunkSizeY;
		
		this.GenerateTiles();
	}

	/**
	 * Generate's the tiles within this chunk.
	 */
	public final void GenerateTiles()
	{
		for (int x = chunkX; x < maxChunkX; x++)
		{
			int tileXType = random.nextInt(Tiles.tilesInGame);

			for (int y = chunkY; y < maxChunkY; y++)
			{
				int tileYType = random.nextInt(Tiles.tilesInGame);

				if (tileXType == Tiles.stoneTileNum || tileYType == Tiles.stoneTileNum)
				{
					Quad stoneTile = new Quad(x * 2.0f, y * 2.0f, 32.0f, 32.0f, Tiles.stone);

					tiles.add(stoneTile);
				}
				else if (tileXType == Tiles.grassTileNum || tileYType == Tiles.grassTileNum)
				{
					Quad grassTile = new Quad(x * 2.0f, y * 2.0f, 32.0f, 32.0f, Tiles.grass);

					tiles.add(grassTile);
				}
				else
				{
					Quad dirtTile = new Quad(x * 2.0f, y * 2.0f, 32.0f, 32.0f, Tiles.dirt);

					tiles.add(dirtTile);
				}
			}
		}
	}

	/**
	 * Render's this Chunk instance.
	 */
	/*public synchronized void renderChunk()
	{
		for (Quad tile : tiles)
		{
			tile.render();
		}
	}*/
}
