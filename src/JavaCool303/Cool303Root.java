package JavaCool303;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Cool303Root extends JPanel implements Cool303Component
{
	private ArrayList<Cool303Component> children = new ArrayList<Cool303Component>();
	private Cool303Theme theme;
	
	/**
	 * Returns a list of the root's child components
	 */
	@Override 
	public ArrayList<Cool303Component> getChildren()
	{
		return children;
	}
	

	/**
	 * Applies change
	 * 
	 */
	public void changeTheme( Cool303Theme theme )
	{
		if ( theme.getRootSize() instanceof Dimension )
			setSize(theme.getRootSize());
	}
	
	
	/**
	 * Applies the theme to component and all descendants.
	 * Used as a helper for applyTheme( Cool303Theme )
	 * @param theme Cool303Theme 
	 */
	public void applyTheme( Cool303Component component )
	{
		component.changeTheme( theme );
		
		if( component.getChildren() == null )
			return;
		
		for( Cool303Component child : component.getChildren() )
		{
			if( child == null )
				continue;

			applyTheme( child );
		}
	}

	/**
	 * Add a Cool303Component to the root's children
	 * @param child Cool303Component
	 */
	public void putChild(Cool303Component child) 
	{
		children.add(child);
	}
	
	/**
	 * Draw root and children with applying the supplied theme. 
	 * Theows IllegalArgumentException if theme is null
	 * @param theme Cool303Theme
	 */
	public void draw( Cool303Theme theme ) 
	{
		if( theme == null )
			throw new IllegalArgumentException( "Theme must not be null" );
	
		this.theme = theme;
		
		changeTheme( theme );
		for( Cool303Component child : children )
			if( child != null )
			{
				applyTheme( child );
				this.add( (Component)child );
			}
	}
}
