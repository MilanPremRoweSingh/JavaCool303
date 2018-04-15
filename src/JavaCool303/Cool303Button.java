package JavaCool303;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class Cool303Button extends JButton implements Cool303Component
{
	int cornerRadius = 0;
	boolean clicked = false;
	/**
	 * Returns null, as we do not allow buttons to have children
	 */
	@Override
	public ArrayList<Cool303Component> getChildren() 
	{
		return null;
	}

	/**
	 * Applies the theme to the button
	 */
	@Override
	public void changeTheme(Cool303Theme theme) 
	{
		if (theme.getButtonBackground() instanceof Color)
		{
			this.setBackground(theme.getButtonBackground());
		}

		final Cool303Button parent = this;
		
		if (theme.getButtonTextColor() instanceof Color)
			this.setForeground(theme.getButtonTextColor());
	
		this.cornerRadius = theme.getButtonCornerRadius();

		this.repaint();
	}
	
	/**
	 * 
	 */
	
	/**
	 * Paints the button
	 */
	@Override
	public void paint( Graphics g )
	{
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        // draw the perimeter of the button
        g.setColor(getBackground().darker().darker().darker());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        // draw the label centered in the button
        Font f = getFont();
        if (f != null) {
            FontMetrics fm = getFontMetrics(getFont());
            g.setColor(getForeground());
            g.drawString(getText(), getWidth() / 2 - fm.stringWidth(getText()) / 2, getHeight() / 2 + fm.getMaxDescent());
        }
	}
	
	 /**
     * Paints the button and distribute an action event to all listeners.
     */
    @Override
    public void processMouseEvent(MouseEvent e) {
        Graphics g;
        switch (e.getID()) {
            case MouseEvent.MOUSE_PRESSED:
                // render myself inverted....
                clicked = true;

                // Repaint might flicker a bit. To avoid this, you can use
                // double buffering (see the Gauge example).
                break;
            case MouseEvent.MOUSE_RELEASED:
                if (actionListener != null) {
                    actionListener.actionPerformed(new ActionEvent(
                            this, ActionEvent.ACTION_PERFORMED, getText() ));
                }
                // render myself normal again
                if (clicked == true) {
                    clicked = false;

                    // Repaint might flicker a bit. To avoid this, you can use
                    // double buffering (see the Gauge example).
                    //repaint();
                }
                break;
           
        }
        //super.processMouseEvent(e);
    }

}
