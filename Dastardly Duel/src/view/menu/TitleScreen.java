package view.menu;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;

public class TitleScreen extends JPanel {

	/**
	 * Unique ID for this GUI component.
	 */
	private static final long serialVersionUID = -2584501605658797360L;
	
	private final Dimension _screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Create the panel. This is where direct one-time manipulation of the panel itself can occur.
	 */
	public TitleScreen() {
		setLayout(null);
		
		JLabel _lblTitle = new JLabel("DASTARDLY DUEL");
		_lblTitle.setBounds(169, 67, 113, 16);
		_lblTitle.setOpaque(true);
		_lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(_lblTitle);
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}

}
