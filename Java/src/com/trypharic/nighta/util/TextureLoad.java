package com.trypharic.nighta.util;

import static org.lwjgl.opengl.GL11.*;
import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureLoad
{
	public Texture stone = null, dirt = null, grass = null, wood = null, brick = null, player = null;

	public TextureLoad()
	{

	}

	public void init()
	{
		try
		{
			stone = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/imgs/stone.png"), GL_NEAREST);
			dirt = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/imgs/dirt.png"), GL_NEAREST);
			grass = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/imgs/grass.png"), GL_NEAREST);
			wood = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/imgs/wood.png"), GL_NEAREST);
			brick = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/imgs/brick.png"), GL_NEAREST);
			player = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/imgs/player.png"), GL_NEAREST);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
