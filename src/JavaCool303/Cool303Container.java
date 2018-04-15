package JavaCool303;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Cool303Container extends JPanel implements Cool303Component 
{
	private ArrayList<Cool303Component> children = new ArrayList<Cool303Component>();
	private boolean useBackground = false;
	private Color bgColor;
	
	/**
	 * Default Constructor
	 */
	public Cool303Container() 
	{
		super();
	}
	
	/**
	 * Constructor which sets the background
	 */
	public Cool303Container( Color _bgColor ) 
	{
		super();
		if( _bgColor != null )
		{
			bgColor = _bgColor;
			useBackground = true;
		}
	}
	
	/**
	 * Returns the container's child components
	 */
	@Override
	public ArrayList<Cool303Component> getChildren() 
	{
		return children;
	}

	/** Sets the background according to the theme
	 * @param 
	 */
	@Override
	public void changeTheme(Cool303Theme theme) 
	{
		if ( theme.isOverrideBackground() || !useBackground )
		{
			if (theme.getContainerBackground() instanceof Color)
				this.setBackground(theme.getContainerBackground());
		}
			
		if (theme.getContainerSize() instanceof Dimension){
			this.setPreferredSize(theme.getContainerSize());
		}
				
		this.repaint();

	}

	/**
	 * Add a Cool303Component to the container's children and calls JFrame.add(Component)
	 * @param child Cool303Component
	 */
	public void putChild(Cool303Component child)
	{
		this.add( (Component)child );
		children.add( child );
	}
	
	/**
	 * Add a Cool303Component to the container's children and calls JFrame.add(Component, String)
	 * @param child Cool303Component
	 */
	public void putChild(Cool303Component child, String s )
	{
		children.add( child );
		this.add( (Component)child, s );
	}

	/**
	 * Paints component as normal for JPanel except adds a background colour if specified in constructor
	 */
	@Override
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		if( useBackground )
		{
			Color temp = g.getColor();
			g.setColor( bgColor );
			g.drawRect( 0, 0, getWidth(), getHeight() );
			g.setColor( temp );
		}
	}
}
