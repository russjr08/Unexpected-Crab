package com.trypharic.nighta.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import com.trypharic.nighta.render.tiles.Tile;
import com.trypharic.nighta.render.tiles.TileSheet;
import com.trypharic.nighta.util.Vector2;

/**
 * A quad for making tiles with.
 * 
 * @author Tinfoilboy
 * @version 1.0
 * @since NightA Pre-Alpha 1.0
 */
public class Quad
{
	public Vector2 position;

	public Vector2 size;

	public Vector2 spritePositions;
	
	public int vboVertexHandle, vboTextCoordHandle, vboIndiceHandle;
	
	public FloatBuffer vboVerticeBuffer, vboTextCoordBuffer;
	
	public ByteBuffer vboIndiceBuffer;
	
	public float[] vertices, textCoords;
	
	public byte[] indices;

	private float zoomAmount = 16f;

	public Tile tile;

	public TileSheet tileSheet;

	/**
	 * The constructor for creating a quad with a tile.
	 * 
	 * @param x
	 * @param y
	 * @param tile
	 */
	public Quad(final float x, final float y, float sizeX, float sizeY, Tile tile)
	{
		this.position = new Vector2(x * zoomAmount, y * zoomAmount);

		this.size = new Vector2(sizeX, sizeY);

		this.tile = tile;
		
		init();
	}
	
	private void init()
	{
		vboVertexHandle = glGenBuffers();
		
		vboTextCoordHandle = glGenBuffers();
		
		vboIndiceHandle = glGenBuffers();
		
		vertices = new float[]
		{
			this.zoomAmount, this.zoomAmount, 0.0f,
			-this.zoomAmount, this.zoomAmount, 0.0f,
			-this.zoomAmount, -this.zoomAmount, 0.0f,
			this.zoomAmount, -this.zoomAmount, 0.0f
		};

		textCoords = new float[]
		{
			0.0f, 0.0f,
			1.0f, 0.0f,
			1.0f, 1.0f,
			0.0f, 1.0f
		};

		indices = new byte[]
		{
			0, 1, 2,
			2, 3, 0
		};
		
		vboVerticeBuffer = BufferUtils.createFloatBuffer(vertices.length);
		
		vboVerticeBuffer.put(vertices);
		
		vboVerticeBuffer.flip();
		
		vboTextCoordBuffer = BufferUtils.createFloatBuffer(textCoords.length);
		
		vboTextCoordBuffer.put(textCoords);
		
		vboTextCoordBuffer.flip();

		vboIndiceBuffer = BufferUtils.createByteBuffer(indices.length);
		
		vboIndiceBuffer.put(indices);
		
		vboIndiceBuffer.flip();
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboVertexHandle);

		glBufferData(GL_ELEMENT_ARRAY_BUFFER, vboVerticeBuffer, GL_STATIC_DRAW);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboTextCoordHandle);

		glBufferData(GL_ELEMENT_ARRAY_BUFFER, vboTextCoordBuffer, GL_STATIC_DRAW);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboIndiceHandle);

		glBufferData(GL_ELEMENT_ARRAY_BUFFER, vboIndiceBuffer, GL_STATIC_DRAW);
	}
	
	/**
	 * Render this quad instance (Uses OpenGL 1.1 Methods)
	 */
	public void render()
	{
		glPushMatrix();

		glTranslatef(position.getX(), position.getY(), 0.0f);

		glEnableClientState(GL_VERTEX_ARRAY);

		glEnableClientState(GL_TEXTURE_COORD_ARRAY);

			glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);

			glVertexPointer(3, GL_FLOAT, 3 << 2, 0L);

			glBindBuffer(GL_ARRAY_BUFFER, vboTextCoordHandle);

			glTexCoordPointer(2, GL_FLOAT, 0, 0L);
			
			glBindBuffer(GL_ARRAY_BUFFER, vboIndiceHandle);
			
			glBindTexture(GL_TEXTURE_2D, tile.TILE_TEXTURE.getTextureID());

			glDrawElements(GL_TRIANGLES, indices.length, GL_UNSIGNED_BYTE, 0L);

		glDisableClientState(GL_TEXTURE_COORD_ARRAY);

		glDisableClientState(GL_VERTEX_ARRAY);

		glPopMatrix();
	}
	
	public void dispose()
	{
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

		glDeleteBuffers(vboVertexHandle);

		glDeleteBuffers(vboTextCoordHandle);

		glDeleteBuffers(vboIndiceHandle);
	}
}
