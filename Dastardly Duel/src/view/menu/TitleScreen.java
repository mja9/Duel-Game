package view.menu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.ITitleScreenAdapter;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;

public class TitleScreen extends JPanel {

	/**
	 * Unique ID for this GUI component.
	 */
	private static final long serialVersionUID = -2584501605658797360L;
	
	private ITitleScreenAdapter _adapter;
	
	private final Toolkit _toolKit = Toolkit.getDefaultToolkit();
	
	private final Dimension _screenSize = _toolKit.getScreenSize();
	
//	private final JLabel _lblTitle = new JLabel();
	
	private final JButton _btnSinglePlayer = new JButton();
	
	private final JButton _btnMultiplayer = new JButton();
	
	private final JButton _btnSettings = new JButton();
	
	private final Image _imgBG = _toolKit.getImage(this.getClass().getResource("images/backlight.gif"));
		
//	private final Image _imgTitle = _toolKit.getImage(this.getClass().getResource("images/header.png"));
	
	private final Image _imgPlay = _toolKit.getImage(this.getClass().getResource("images/play.png"));
	
	private final Image _imgSettings = _toolKit.getImage(this.getClass().getResource("images/settings.png"));
	
	private final ImageIcon test = new ImageIcon(this.getClass().getResource("images/testbutton.gif"));

	/**
	 * Create the panel. This is where direct one-time manipulation of the panel itself can occur.
	 */
	public TitleScreen(ITitleScreenAdapter adapter) {
		_adapter = adapter;
		initTitleScreen();
		System.out.println(_screenSize);
	}
	
	private void initTitleScreen() {
		
		// This was set to allow easier manipulation within the design window.
		setPreferredSize(new Dimension(1400, 900));
		
		// Setting layout to absolute layout for drag and drop abilities.
		setLayout(null);
		
		// Setting the game title
//		_lblTitle.setBounds(_screenSize.width / 2 - _screenSize.width * 3 / 8, _screenSize.height / 12, 
//				_screenSize.width * 3 / 4, _screenSize.height * 3 / 8);
//		_lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
//		Image resizedTitle = _imgTitle.getScaledInstance(_lblTitle.getWidth(), _lblTitle.getHeight(), Image.SCALE_SMOOTH);
//		_lblTitle.setIcon(new ImageIcon(resizedTitle));
//		add(_lblTitle);
//		System.out.println("Header " + _lblTitle.getSize() + "\n");
				
		// Single Player button -- NOTE: Can also set icons for roll over and selection
		_btnSinglePlayer.setBounds(_screenSize.width / 2 - _screenSize.width * 3 / 16,  _screenSize.height / 2, 
				_screenSize.width * 3 / 8, _screenSize.height * 3 / 32);
		_btnSinglePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image resizedPlay = _imgPlay.getScaledInstance(_btnSinglePlayer.getWidth(), _btnSinglePlayer.getHeight(), Image.SCALE_SMOOTH);
//		_btnSinglePlayer.setIcon(new ImageIcon(resizedPlay));
		_btnSinglePlayer.setIcon(test);
		_btnSinglePlayer.setBorderPainted(false);
		_btnSinglePlayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(_btnSinglePlayer);
		_btnSinglePlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Single Player selected!\n");
				_adapter.singlePlayer();
			}
			
		});
//		System.out.println("Single Player button " + _btnSinglePlayer.getSize() + "\n");
		
		// Multiplayer button
		_btnMultiplayer.setAlignmentX(0.5f);
		_btnMultiplayer.setBounds(_screenSize.width / 2 - _screenSize.width * 3 / 16,  _screenSize.height / 2 + (2 * _screenSize.height * 3 / 32), 
				_screenSize.width * 3 / 8, _screenSize.height * 3 / 32);
		_btnMultiplayer.setIcon(new ImageIcon(resizedPlay));
		_btnMultiplayer.setBorderPainted(false);
		_btnMultiplayer.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		add(_btnMultiplayer);
		_btnMultiplayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Multiplayer selected!\n");
				_adapter.multiPlayer();
			}
			
		});
		
		// Settings button
		_btnSettings.setAlignmentX(0.5f);
		_btnSettings.setBounds(_screenSize.width - _screenSize.width * 3 / 18, _screenSize.width / 25, _screenSize.width / 11, _screenSize.height / 10);
		Image resizedSettings = _imgSettings.getScaledInstance(_btnSettings.getWidth(), _btnSettings.getHeight(), Image.SCALE_SMOOTH);
		_btnSettings.setIcon(new ImageIcon(resizedSettings));
		_btnSettings.setBorderPainted(false);
		_btnSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		add(_btnSettings);
		_btnSettings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Settings selected!\n");
				_adapter.settings();
			}
			
		});
		
//		System.out.println("Settings button: " + _btnSettings.getSize() + "\n");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(_imgBG, 0, 0, _screenSize.width, _screenSize.height, this);
	}

}
