package com.trypharic.nighta.graphics;

import static com.trypharic.nighta.util.Static.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

import com.trypharic.nighta.NightAMain;
import com.trypharic.nighta.logic.GameStates;

public class Render
{
	private NightAMain gameMain = null;
	
	public Render(NightAMain gameMain)
	{
		this.gameMain = gameMain;
	}
	
	public void draw()
	{
		glClear(GL_COLOR_BUFFER_BIT);

		if (state == GameStates.SPLASH)
		{
			glColor3f(255, 166, 15);
			
			glRectf(0, 0, WIDTH, HEIGHT);
		}
		else if (state == GameStates.GAME)
		{
			if (gameMain.entityPlayer != null)
			{
				glLoadIdentity();

				glOrtho(gameMain.entityPlayer.position.getX() - WIDTH / 2.0f, gameMain.entityPlayer.position.getX() + WIDTH / 2.0f, gameMain.entityPlayer.position.getY() - HEIGHT / 2.0f, gameMain.entityPlayer.position.getY() + HEIGHT / 2.0f, VIEWPORTNEARZ, VIEWPORTFARZ);
			}

			if(gameMain.threading.world != null)
			{
				gameMain.threading.renderWorld();
			}
			
			for (Quad tile : gameMain.level.getTiles())
			{
				if(Math.abs(gameMain.entityPlayer.position.getX()) < tile.position.getX() + tile.size.getX() + Display.getWidth() / 2 && Math.abs(gameMain.entityPlayer.position.getY()) < tile.position.getY() + tile.size.getY() + Display.getHeight() / 2 && Math.abs(gameMain.entityPlayer.position.getX()) > tile.position.getX() - tile.size.getX() - Display.getWidth() / 2 && Math.abs(gameMain.entityPlayer.position.getY()) > tile.position.getY() - tile.size.getY() - Display.getHeight() / 2)
					tile.render();
			}
		}
	}
}