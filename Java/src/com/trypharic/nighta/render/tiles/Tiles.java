package com.trypharic.nighta.render.tiles;

import static com.trypharic.nighta.util.Static.*;

/**
 * The static tiles class. Use to select tiles.
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.0
 */
public class Tiles
{
	/**
	 * The Stone Tile.
	 */
	public static Tile stone = new Tile(textureLoad.stone, 16.0f);
	
	/**
	 * The Grass Tile.
	 */
	public static Tile grass = new Tile(textureLoad.grass, 16.0f);
	
	/**
	 * The Dirt Tile.
	 */
	public static Tile dirt = new Tile(textureLoad.dirt, 16.0f);
		
	/**
	 * The Brick Tile.
	 */
	public static Tile brick = new Tile(textureLoad.brick, 16.0f);
	
	/**
	 * The Wood Tile.
	 */
	public static Tile wood = new Tile(textureLoad.wood, 16.0f);
	
	/**
	 * The Player TileSheet.
	 */
	public static Tile player = new Tile(textureLoad.player, 16.0f);
	
	/**
	 * The NPC TileSheet.
	 */
	public static TileSheet NPC = new TileSheet("res/imgs/npc.png", 16.0f, 16.0f, 16.0f);
	
	/**
	 * Static Tile Integers.
	 */
	public static int stoneTileNum = 0, grassTileNum = 1, tilesInGame = 5;
}
