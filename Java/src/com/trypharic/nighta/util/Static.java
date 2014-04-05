package com.trypharic.nighta.util;

import com.trypharic.nighta.logic.GameStates;

public class Static
{
	public static final String TITLE = "NightA 1.0 Alpha";
	
	public static final int WIDTH = 640, HEIGHT = 480, HOUR = 60, DAY = 24, VIEWPORTFARZ = 1, VIEWPORTNEARZ = -1;
	
	public static float frameLength = 0.0f;
	
	public static GameStates state = GameStates.GAME;
	
	public static TextureLoad textureLoad = new TextureLoad();
	
	public static void setupTextures()
	{
		textureLoad.init();
	}
}