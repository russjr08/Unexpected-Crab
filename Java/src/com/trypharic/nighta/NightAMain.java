package com.trypharic.nighta;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.trypharic.nighta.entitys.EntityPlayer;
import com.trypharic.nighta.graphics.Quad;
import com.trypharic.nighta.graphics.Render;
import com.trypharic.nighta.level.Level;
import com.trypharic.nighta.level.LevelLoader;
import com.trypharic.nighta.logic.*;
import com.trypharic.nighta.world.Chunk;

import static com.trypharic.nighta.util.Static.*;

/**
 * NightA's Main Runtime Class.
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.0
 */
public class NightAMain
{
	private int fps = 60, fpsCount;

	private long lastFPS, secondInMillis = 1000;

	public EntityPlayer entityPlayer = null;

	public boolean isRunning = true;
	
	public Threading threading = null;
	
	public Render render = null;
	
	public KeyboardInput input = null;
	
	public Level level = null;

	/**
	 * The Main Run Method.
	 */
	public NightAMain()
	{
		setupDisplay();
	}

	/**
	 * Set's up and updates the display.
	 */
	private void setupDisplay()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));

			Display.setTitle(TITLE);

			Display.setFullscreen(true);

			Display.create();
		}
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}
		
		setupOpenGL();

		init();
		
		worldInit();

		while (isRunning)
		{
			update();

			render();
			
			Display.setVSyncEnabled(false);
			
			Display.sync(fps);
			
			Display.update();
		}

		destroy();
		
		Display.destroy();

		System.exit(0);
	}

	/**
	 * Set's up OpenGL to be used in the game.
	 */
	private void setupOpenGL()
	{
		glEnable(GL_PROJECTION);

		glLoadIdentity();

		glOrtho(0, WIDTH, 0, HEIGHT, VIEWPORTNEARZ, VIEWPORTFARZ);

		glEnable(GL_MODELVIEW);

		glEnable(GL_TEXTURE_2D);

		glEnable(GL_BLEND);

		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		glClearColor(0.0f, 0.5f, 1.0f, 1.0f);

		glEnable(GL_CULL_FACE);

		glCullFace(GL_BACK);

		glCullFace(GL_LEFT);

		glCullFace(GL_RIGHT);
	}

	/**
	 * Initializes the world.
	 */
	private void worldInit()
	{
		//this.threading.addWorld();
		
		//this.threading.world.setPlayer(entityPlayer);
		level = LevelLoader.loadLevel("res/levels/test.level");
	}

	private long getTime()
	{
		return (Sys.getTime() * secondInMillis) / Sys.getTimerResolution();
	}

	/**
	 * Initialization Method.
	 */
	private void init()
	{
		lastFPS = getTime();
		
		threading = new Threading(this);
		
		render = new Render(this);
		
		setupTextures();
		
		int x = WIDTH / 2;
		
		int y = HEIGHT / 2;
		
		entityPlayer = new EntityPlayer(x, y);
		
		input = new KeyboardInput(this);
	}

	/**
	 * The game render method.
	 */
	private void render()
	{
		entityPlayer.render();
		render.draw();
	}

	/**
	 * The game update method.
	 */
	private void update()
	{
		long currentTime = Sys.getTime();

		frameLength = (currentTime - lastFPS) / 1000.0f;

		lastFPS = currentTime;

		if (getTime() - lastFPS > secondInMillis)
		{
			Display.setTitle(TITLE + " : " + fpsCount);

			fpsCount = 0;

			lastFPS += secondInMillis;
		}
		
		fpsCount++;

		while (state == GameStates.SPLASH)
		{
			int switchTime = 0;
			
			switchTime++;
			
			if(switchTime >= 220)
			{
				state = GameStates.GAME;
			}
		}
		if (state == GameStates.GAME)
		{
			if(this.threading.world != null)
			{
				this.threading.updateWorld();
			}
		}

		long currentSystemTime = System.currentTimeMillis();

		int hours = (int) ((currentSystemTime / (secondInMillis * HOUR * HOUR)) % DAY);

		if (hours <= 8)
		{
			glClearColor(0.0f, 0.1f, 0.1f, 1.0f);
		}
		else if (hours <= 12)
		{
			glClearColor(0.0f, 0.2f, 0.2f, 1.0f);
		}
		else if (hours <= 14)
		{
			glClearColor(0.0f, 0.3f, 0.3f, 1.0f);
		}
		else if (hours <= 16)
		{
			glClearColor(0.0f, 0.4f, 0.5f, 1.0f);
		}
		else if (hours <= 18)
		{
			glClearColor(0.0f, 0.5f, 0.6f, 1.0f);
		}
		else if (hours <= 20)
		{
			glClearColor(0.0f, 0.5f, 0.7f, 1.0f);
		}
		else if (hours <= 22)
		{
			glClearColor(0.0f, 0.5f, 0.8f, 1.0f);
		}
		
		input.checkInput();
		
		if (Display.isCloseRequested())
		{
			isRunning = false;
		}
	}

	public void destroy()
	{
		for(Chunk chunk : threading.world.chunks)
		{
			for(Quad tile : chunk.tiles)
			{
				tile.dispose();
			}
		}
	}
	
	public static void main(String[] args)
	{
		NightAMain aMain = new NightAMain();

		System.out.println(aMain.isRunning);
	}
}
