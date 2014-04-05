package com.trypharic.nighta.entitys;

import com.trypharic.nighta.util.Vector2;

/**
 * The main Entity class, extend this to make new entity's.
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.0
 */
public abstract class Entity
{
	/**
	 * The X and Y coordinates, plus the size of the entity.
	 */
	public Vector2 position = null, size = null;

	/**
	 * The update method of this entity.
	 */
	public void update()
	{

	}

	/**
	 * The render method of this entity.
	 */
	public void render()
	{

	}

	/**
	 * The key bindings (if needed) of this entity.
	 */
	public void keyBinds()
	{
		
	}
	
	/**
	 * Is this entity dead?
	 * 
	 * @return
	 */
	public boolean isEntityDead()
	{
		return false;
	}
}
