package controller;

import java.awt.EventQueue;

import model.GameModel;
import model.IModel2ViewAdapter;
import view.GameGUI;

public class GameController {
	
	private GameModel _model;
	
	private GameGUI _GUI;
	
	
	public GameController() {
		_model = new GameModel(new IModel2ViewAdapter() {
			
			public void update() {
				_GUI.update();
			}
			
		});
		
		_GUI = new GameGUI();
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
