package view.levels;

import javax.swing.JPanel;

import view.IView2ModelAdapter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

public class DemoLevel extends JPanel {
	
	private IView2ModelAdapter _view2Model = IView2ModelAdapter.NULL_ADAPTER; 

	/**
	 * A unique ID for this GUI component.
	 */
	private static final long serialVersionUID = -840814701713912231L;

	/**
	 * Create the panel.
	 */
	public DemoLevel(IView2ModelAdapter view2Model) {
		_view2Model = view2Model;
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/* 
		 * Ornament design? Additional functionality for paint method
		 */
		
		// Screen size on the device running the game
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
		
		setBackground(Color.GRAY);	// Set the background.
		
		g.setColor(Color.CYAN);
		g.fillRect(0, screenSize.height - 100, screenSize.width, 100);	// Add a floor
		
		_view2Model.update(g);
	
	}

}
