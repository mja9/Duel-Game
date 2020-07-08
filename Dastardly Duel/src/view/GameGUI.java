package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.levels.DemoLevel;
import view.menu.TitleScreen;

public class GameGUI extends JFrame {

	/**
	 * Unique ID for this GUI component.
	 */
	private static final long serialVersionUID = 7853262261336396605L;
	
	private IView2ModelAdapter _view2Model = IView2ModelAdapter.NULL_ADAPTER; 
	
	private JPanel contentPane;
	
	private DemoLevel level;

	/**
	 * Create the frame.
	 */
	public GameGUI(IView2ModelAdapter view2Model) {
		_view2Model = view2Model;
		level = new DemoLevel(_view2Model);
		initGUI();
	}
	
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, getScreenSize().width, getScreenSize().height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
//		contentPane.add(level);	
		contentPane.add(new TitleScreen());
	}
	
	public void start() {
		setVisible(true);
	}
	
	public void update() {
		level.repaint();
	}
	
	public void addKeyCommand(String key, Consumer<String> command) {
		level.addKeyCommand(key, command);
	}
	
	public Dimension getScreenSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public Component getCanvas() {
		return level;
	}

}
