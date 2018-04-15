package JavaCool303;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class Cool303ThemePastel extends Cool303Theme 
{
	public Cool303ThemePastel()
	{
		rootSize = new Dimension(500,500);
		containerSize = new Dimension(500,500);;
		containerBorder = null;
		containerBackground = new Color( 50, 100, 10 );
		overrideBackground = true;
		buttonTextColor = new Color(100,100,100);
		buttonCornerRadius = 25;
	}
}


