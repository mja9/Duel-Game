package controller;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.function.Consumer;

import model.GameModel;
import model.IModel2ViewAdapter;
import view.GameGUI;
import view.IView2ModelAdapter;

public class GameController {
	
	private GameModel _model;
	
	private GameGUI _GUI;
	
	
	public GameController() {
		_model = new GameModel(new IModel2ViewAdapter() {
			
			public void update() {
				_GUI.update();
			}

			@Override
			public void addKeyCommand(String key, Consumer<String> command) {
				_GUI.addKeyCommand(key, command);
			}

			@Override
			public Dimension getScreenSize() {
				return _GUI.getScreenSize();
			}

			@Override
			public ImageObserver getCanvas() {
				return _GUI.getCanvas();
			}
			
		});
		
		_GUI = new GameGUI(new IView2ModelAdapter() {

			@Override
			public void update(Graphics g) {
				_model.update(g);
			}
			
		});
	}
	
	public void start() {
		_model.start();
		_GUI.start();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameController controller = new GameController();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	

}
