package JavaCool303Test;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import JavaCool303.*;

public class JavaCool303Example 
{
	public static void main( String[] args )
	{
		JFrame window = new JFrame();
		Cool303Root root = new Cool303Root();
 		Cool303Container container = new Cool303Container();
 		//background pane
 		Cool303Container bgcontainer = new Cool303Container();
 		container.setLayout(new GridLayout(5,4));
 		// put all components on our box
		for (int i=0; i<20; i++){
			container.putChild(new Cool303Button());
		}
		bgcontainer.putChild(container);
		//bgcontainer.add(container, BorderLayout.CENTER);
		root.putChild(bgcontainer);
		
		
		//========= render box with theme =================
		// change Cool303ThemePastel() to Cool303ThemeWinter() to see winter theme
 		root.draw(new Cool303ThemePastel());
 		
 		/*
 		//set position and layout
 		container.setLayout(new GridLayout(5,4));
 		Insets insets = bgcontainer.getInsets();
 		container.setBounds(250+insets.left, 150+insets.top, 250, 200);
 		Insets binsets = root.getInsets();
 		root.setSize(binsets.left+binsets.right+750, binsets.bottom+binsets.top+550);
 		*/
 		root.setVisible(true);
 		
 		window.add( root );
 		window.setVisible( true );
 		window.pack( );
	}
}
