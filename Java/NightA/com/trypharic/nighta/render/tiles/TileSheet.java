package com.trypharic.nighta.render.tiles;

/**
 * @author Tinfoilboy
 * @see Tile
 */
public class TileSheet
{
	public final String TILESHEETLOCATION;
	
	public final float TILESIZE, TILESHEETSIZEX, TILESHEETSIZEY;
	
	public TileSheet(final String tileSheetLocation, final float tileSize, final float sheetSizeX, final float sheetSizeY)
	{
		this.TILESHEETLOCATION = tileSheetLocation;
		
		this.TILESHEETSIZEX = sheetSizeX;

		this.TILESHEETSIZEY = sheetSizeY;
		
		this.TILESIZE = tileSize;
	}
}
