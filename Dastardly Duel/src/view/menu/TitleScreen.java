package view.menu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TitleScreen extends JPanel {

	/**
	 * Unique ID for this GUI component.
	 */
	private static final long serialVersionUID = -2584501605658797360L;
	
	private final Toolkit _toolKit = Toolkit.getDefaultToolkit();
	
	private final Dimension _screenSize = _toolKit.getScreenSize();
	
	private final JLabel _lblTitle = new JLabel();
	
	private final JButton _btnSinglePlayer = new JButton();
	
	private final Image _imgBG = _toolKit.getImage(this.getClass().getResource("images/bg.png"));
	
	private final Image _imgTitle = _toolKit.getImage(this.getClass().getResource("images/header.png"));

	/**
	 * Create the panel. This is where direct one-time manipulation of the panel itself can occur.
	 */
	public TitleScreen() {
		
		// Setting layout to absolute layout for drag and drop abilities.
		setLayout(null);
		
		// Setting the game title
		_lblTitle.setBounds(_screenSize.width / 2 - _screenSize.width * 3 / 8, _screenSize.height / 12, 
				_screenSize.width * 3 / 4, _screenSize.height * 3 / 8);
		_lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image resizedTitle = _imgTitle.getScaledInstance(_lblTitle.getWidth(), _lblTitle.getHeight(), Image.SCALE_DEFAULT);
		_lblTitle.setIcon(new ImageIcon(resizedTitle));
		add(_lblTitle);
				
		// Setting the game buttons
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(_imgBG, 0, 0, _screenSize.width, _screenSize.height, this);
	}

}
