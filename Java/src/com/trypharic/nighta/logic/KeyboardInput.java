package com.trypharic.nighta.logic;

import org.lwjgl.input.Keyboard;

import com.trypharic.nighta.NightAMain;
import com.trypharic.nighta.util.Static;

public class KeyboardInput
{
	public NightAMain nightAMain = null;
	
	public boolean[] keys = new boolean[100];
	
	public float moveModifier = 40.0f * Static.frameLength;
	
	public KeyboardInput(NightAMain nightAMain)
	{
		this.nightAMain = nightAMain;
		
		init();
	}
	
	private void init()
	{
		keys[0] = Keyboard.isKeyDown(Keyboard.KEY_W);
		keys[1] = Keyboard.isKeyDown(Keyboard.KEY_S);
		keys[2] = Keyboard.isKeyDown(Keyboard.KEY_A);
		keys[3] = Keyboard.isKeyDown(Keyboard.KEY_D);
		keys[4] = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
	}
	
	public void checkInput()
	{
		while(Keyboard.next())
		{
			switch (Keyboard.getEventKey())
			{
				case Keyboard.KEY_W:
					keys[0] = !keys[0];
					break;
				case Keyboard.KEY_S:
					keys[1] = !keys[1];
					break;
				case Keyboard.KEY_A:
					keys[2] = !keys[2];
					break;
				case Keyboard.KEY_D:
					keys[3] = !keys[3];
					break;
				case Keyboard.KEY_LSHIFT:
					keys[4] = !keys[4];
					break;
				default:
					break;
			}
		}
		
		if(keys[0])
			nightAMain.entityPlayer.position.addY(moveModifier);
		if(keys[1])
			nightAMain.entityPlayer.position.addY(-moveModifier);
		if(keys[2])
			nightAMain.entityPlayer.position.addX(-moveModifier);
		if(keys[3])
			nightAMain.entityPlayer.position.addX(moveModifier);
		if(keys[4])
			moveModifier = 160.0f * Static.frameLength;
		else
			moveModifier = 80.0f * Static.frameLength;
	}
}
