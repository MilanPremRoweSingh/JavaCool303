package JavaCool303;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.Border;
/**
 * Abstract class which defines the possibilities of Themes used with the Cool303.
 * To use, simply create a class which inherits from this one, and define a constructor which gives a nonnull value for each of the attributes define here ( except Borders, which may be null).
 * If any are null except one of the borders, Cool303Root.draw will throw an error
 * @author Milan
 *
 */
public abstract class Cool303Theme 
{
	/** Desired dimension for a Cool303Root object using the theme */
	protected Dimension rootSize;

	/** Desired dimension for a Cool303Container object using the theme */
	protected Dimension containerSize;

	/** Desired border for a Cool303Container object using the theme */
	protected Border containerBorder;

	/** Desired Color for a Cool303Root object's backgrounf using the theme */
	protected Color containerBackground;


	/** Determines whether indiviually set or theme set backgrounds for Cool303Containers are used
	 *  True means theme's will override infivually set background colout */
	protected boolean overrideBackground;

	/** Desired colour for Cool303Button text*/
	protected Color buttonTextColor;

	/** Desired colour for Cool303Button backgrounf*/
	protected Color buttonBackground;


	/** Radius for corners of button. Higher makes the corners more rounded. 0 for rectangular*/
	protected int buttonCornerRadius;
	
	protected Dimension getRootSize() {
		return rootSize;
	}
	protected Dimension getContainerSize() {
		return containerSize;
	}
	protected Border getContainerBorder() {
		return containerBorder;
	}
	protected Color getContainerBackground() {
		return containerBackground;
	}
	protected Color getButtonTextColor() {
		return buttonTextColor;
	}
	protected Color getButtonBackground() {
		return buttonBackground;
	}
	protected int getButtonCornerRadius() {
		return buttonCornerRadius;
	}
	protected boolean isOverrideBackground() {
		return overrideBackground;
	}
}
