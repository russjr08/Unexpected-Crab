package com.trypharic.nighta.entitys;

import com.trypharic.nighta.graphics.Quad;
import com.trypharic.nighta.render.tiles.Tiles;
import com.trypharic.nighta.util.Vector2;

/**
 * The player entity.
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.0
 */
public class EntityPlayer extends Entity
{
	public int direction;

	public boolean isDead = false;

	public Quad player;

	/**
	 * Create a new Player instance.
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 */
	public EntityPlayer(float x, float y)
	{
		this.position = new Vector2(x, y);
		
		player = new Quad(this.position.getX(), this.position.getY(), 16.0f, 16.0f, Tiles.player);
	}

	public void render()
	{
		player.render();
	}

	public boolean isEntityDead()
	{
		return isDead;
	}
}
