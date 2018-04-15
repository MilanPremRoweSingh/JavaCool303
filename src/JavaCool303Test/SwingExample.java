package JavaCool303Test;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SwingExample 
{
	public static void main( String[] args )
	{
		final int windowSideLength = 500;
		int n, panelSideLengthInButtons;
		JFrame window;
		JPanel panel;
		JButton[] buttons;
		
		try 
		{
			n = Integer.valueOf( args[0] );
		} 
		catch( IllegalArgumentException e )
		{
			System.out.println( "Invalid Argument" );
			return;
		}
		catch( ArrayIndexOutOfBoundsException e )
		{
			System.out.println( "Please pass an argument" );
			return;
		}
		
		//Create Window //////////////////////////////////////
		window = new JFrame("Swing Example");
		window.setSize( windowSideLength, windowSideLength );
		window.setVisible( true );
		//Create Window - END ////////////////////////////////

		//Create Panel //////////////////////////////////////
		panelSideLengthInButtons = (int)Math.ceil(Math.sqrt( n ) );
		panel = new JPanel( new GridLayout( panelSideLengthInButtons, panelSideLengthInButtons ) );
		panel.setPreferredSize( new Dimension( windowSideLength, windowSideLength) );
		//Create Panel - END ////////////////////////////////
		
		//Create Buttons ////////////////////////////////////
		buttons = new JButton[n];
		for( int idx = 0; idx < panelSideLengthInButtons*panelSideLengthInButtons; idx++ ) //We do the last row out of the loop in case it is not a perfect square
		{
			if( idx < n)
				buttons[idx] = createButtonInPanel(panel, String.valueOf(idx) );
			else
				panel.add( Box.createHorizontalStrut(0) ); //Add an empty box to empty grid spaces to preserve square format
		}
		//Create Buttons - END //////////////////////////////

		window.add( panel );
		window.pack();
	}
	
	static JButton createButtonInPanel( JPanel panel, String text )
	{
		final JButton retBtn = new JButton( text );
		panel.add( retBtn );
		
		retBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog( null, retBtn.getText() );
			}
		} );
		
		
		return retBtn;
	}
	
}
