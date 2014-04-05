package com.trypharic.nighta.render.tiles;

import org.newdawn.slick.opengl.Texture;

/**
 * The class for defining tiles.
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.0
 */
public class Tile
{
	/**
	 * The location of the tile image.
	 */
	public final Texture TILE_TEXTURE;
	
	/**
	 * The size of this tile.
	 */
	public final float TILE_SIZE, TILE_SIZE_X, TILE_SIZE_Y;
	
	public Tile(final Texture tileTexture, final float tileSize)
	{
		this.TILE_TEXTURE = tileTexture;
		
		this.TILE_SIZE = tileSize;
		
		this.TILE_SIZE_X = tileSize;
		
		this.TILE_SIZE_Y = tileSize;
	}
	
	public Tile(final Texture tileTexture, final float tileSizeX, final float tileSizeY)
	{
		this.TILE_TEXTURE = tileTexture;
		
		this.TILE_SIZE = tileSizeX;
		
		this.TILE_SIZE_X = tileSizeX;
		
		this.TILE_SIZE_Y = tileSizeY;
	}
}
