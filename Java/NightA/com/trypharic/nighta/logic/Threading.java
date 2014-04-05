package com.trypharic.nighta.logic;

import com.trypharic.nighta.NightAMain;
import com.trypharic.nighta.world.World;
import static com.trypharic.nighta.util.Static.*;

/**
 * The class for new threads. Will use for world generation and more.
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.5
 */
public class Threading implements Runnable
{

	public Thread thread = null;

	public World world = null;

	private NightAMain nightAMain = null;

	/**
	 * Instantiates the new thread.
	 * 
	 * @param NightAMain
	 */
	public Threading(NightAMain nightAMain)
	{
		this.nightAMain = nightAMain;

		this.start();
	}

	/**
	 * Defines and starts the new thread.
	 */
	public synchronized void start()
	{
		this.world = new World(WIDTH, HEIGHT);

		this.thread = new Thread(this, "NightAThreads");

		this.thread.start();
	}

	/**
	 * Adds the world to the game.
	 */
	public void addWorld()
	{
		this.world.addWorldCells();
	}

	public void run()
	{
		while (nightAMain.isRunning)
		{
			// todo
		}

		this.stop();
	}

	/**
	 * Renders the world. Will be deprecated soon.
	 */
	public synchronized void renderWorld()
	{
		this.world.renderWorld();
	}

	/**
	 * Updates the world. Will be deprecated soon.
	 */
	public synchronized void updateWorld()
	{
		this.world.updateWorld();
	}

	/**
	 * Stops the current thread.
	 */
	public synchronized void stop()
	{
		try
		{
			this.thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
