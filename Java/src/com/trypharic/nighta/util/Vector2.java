package com.trypharic.nighta.util;

public class Vector2
{
	private float x = 0.0f, y = 0.0f;
	
	public Vector2(float x, float y)
	{
		this.x = x;
		
		this.y = y;
	}
	
	public Vector2(float all)
	{
		this.x = all;
		
		this.y = all;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public void addX(float x)
	{
		this.x += x;
	}
	
	public void addY(float y)
	{
		this.y += y;
	}
	
	public float[] getFloatsFromVec2()
	{
		return new float[]{ x, y };
	}
}