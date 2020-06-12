package view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.levels.DemoLevel;

public class GameGUI extends JFrame {

	/**
	 * Unique ID for this GUI component.
	 */
	private static final long serialVersionUID = 7853262261336396605L;
	
	private IView2ModelAdapter _view2Model = IView2ModelAdapter.NULL_ADAPTER; 
	
	private JPanel contentPane;
	
	private JPanel level;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(level);
	}
	
	public void start() {
		setVisible(true);
	}
	
	public void update() {
		level.repaint();
	}

}
