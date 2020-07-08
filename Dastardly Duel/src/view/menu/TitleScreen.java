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
	
	private final JButton _btnMultiPlayer = new JButton();
	
	private final JButton _btnSettings = new JButton();
	
	private final Image _imgBG = _toolKit.getImage(this.getClass().getResource("images/bg.png"));
	
	private final Image _imgTitle = _toolKit.getImage(this.getClass().getResource("images/header.png"));
	
	private final Image _imgPlay = _toolKit.getImage(this.getClass().getResource("images/play.png"));
	
	private final Image _imgSettings = _toolKit.getImage(this.getClass().getResource("images/settings.png"));

	/**
	 * Create the panel. This is where direct one-time manipulation of the panel itself can occur.
	 */
	public TitleScreen() {
		setPreferredSize(new Dimension(1400, 900));
		
		// Setting layout to absolute layout for drag and drop abilities.
		setLayout(null);
		
		// Setting the game title
		_lblTitle.setBounds(_screenSize.width / 2 - _screenSize.width * 3 / 8, _screenSize.height / 12, 
				_screenSize.width * 3 / 4, _screenSize.height * 3 / 8);
		_lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image resizedTitle = _imgTitle.getScaledInstance(_lblTitle.getWidth(), _lblTitle.getHeight(), Image.SCALE_SMOOTH);
		_lblTitle.setIcon(new ImageIcon(resizedTitle));
		add(_lblTitle);
				
		// Single Player button
		_btnSinglePlayer.setBounds(_screenSize.width / 2 - _screenSize.width * 3 / 16,  _screenSize.height / 2, 
				_screenSize.width * 3 / 8, _screenSize.height * 3 / 32);
		_btnSinglePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image resizedPlay = _imgPlay.getScaledInstance(_btnSinglePlayer.getWidth(), _btnSinglePlayer.getHeight(), Image.SCALE_SMOOTH);
		_btnSinglePlayer.setIcon(new ImageIcon(resizedPlay));
		add(_btnSinglePlayer);
		
		// Multiplayer button
		_btnMultiPlayer.setAlignmentX(0.5f);
		_btnMultiPlayer.setBounds(_screenSize.width / 2 - _screenSize.width * 3 / 16,  _screenSize.height / 2 + (2 * _screenSize.height * 3 / 32), 
				_screenSize.width * 3 / 8, _screenSize.height * 3 / 32);
		_btnMultiPlayer.setIcon(new ImageIcon(resizedPlay));
		add(_btnMultiPlayer);
		
		// Settings button
		_btnSettings.setAlignmentX(0.5f);
		_btnSettings.setBounds(_screenSize.width - _screenSize.width * 3 / 18, _screenSize.width / 25, _screenSize.width / 11, _screenSize.height / 10);
		Image resizedSettings = _imgSettings.getScaledInstance(_btnSettings.getWidth(), _btnSettings.getHeight(), Image.SCALE_SMOOTH);
		_btnSettings.setIcon(new ImageIcon(resizedSettings));
		add(_btnSettings);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(_imgBG, 0, 0, _screenSize.width, _screenSize.height, this);
	}

}
