package view.levels;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import view.IView2ModelAdapter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

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
		
		// Make this image the background. Postpone loading until this has loaded.
//		g.drawImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/test.png")), 0, 0, 
//				Toolkit.getDefaultToolkit().getScreenSize().width, 
//				Toolkit.getDefaultToolkit().getScreenSize().height - 1/4 * Toolkit.getDefaultToolkit().getScreenSize().height, 
//				this);
		
		g.setColor(Color.CYAN);
		g.fillRect(0, screenSize.height - (screenSize.height / 4), screenSize.width, screenSize.height / 4);	// Add a floor
		
		_view2Model.update(g);
	
	}
	
	public void addKeyCommand(String key, Consumer<String> command) {
		this.requestFocus();
		this.getInputMap().put(KeyStroke.getKeyStroke(key), key);
		this.getActionMap().put(key, new AbstractAction() {

			/**
			 * Unique ID.
			 */
			private static final long serialVersionUID = 6158937318022105684L;

			@Override
			public void actionPerformed(ActionEvent e) {
				command.accept(key);
			}
			
		});
	}

}
