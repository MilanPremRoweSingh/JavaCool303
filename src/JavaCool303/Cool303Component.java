/**
 * All items held in Cool303Root (i.e. it's children) are components
 * Components may in turn have items inside it (children). All components must apply a theme.
 * @author Milan 
 */

package JavaCool303;

import java.util.ArrayList;

public interface Cool303Component 
{
	public ArrayList<Cool303Component> getChildren();//All components have the potential for children
	
	public void changeTheme( Cool303Theme theme ); //Components must be able to have a theme applied
	
}
