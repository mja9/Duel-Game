package view.levels;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;

import view.IView2ModelAdapter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
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
		
		setBackground(Color.GRAY);	// Set the background.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
		// TODO: Add instructions for the demo here.
		JLabel instructions = new JLabel();
		instructions.setBounds(new Rectangle(screenSize.width / 16, screenSize.height - (screenSize.height / 8), screenSize.width / 4, screenSize.height / 8));
		this.add(instructions);
		instructions.setText("Move with the arrowkeys, M - Attack, N - Block. Run over the square to fight the boss.");
				

	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/* 
		 * Ornament design? Additional functionality for paint method
		 */
		
		// Screen size on the device running the game
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
				
		// Make this image the background. Postpone loading until this has loaded.
//		g.drawImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/test.png")), 0, 0, 
//				Toolkit.getDefaultToolkit().getScreenSize().width, 
//				Toolkit.getDefaultToolkit().getScreenSize().height - 1/4 * Toolkit.getDefaultToolkit().getScreenSize().height, 
//				this);
		
		g.setColor(Color.CYAN);
		g.fillRect(0, screenSize.height - (screenSize.height / 4), screenSize.width, screenSize.height / 4);	// Add a floor
		// Move with the arrowkeys, M - Attack, N - Block, 
		
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
