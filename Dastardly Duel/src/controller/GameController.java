package controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.function.Consumer;

import model.GameModel;
import model.IModel2ViewAdapter;
import model.IModel2ObjectAdapter;
import object.IObject2ModelAdapter;
import object.IObject2ViewAdapter;
import object.ObjectControl;
import util.dispatcher.ICommand;
import util.dispatcher.IObserver;
import view.GameGUI;
import view.IView2ModelAdapter;

public class GameController {
	
	private GameModel _model;
	
	private GameGUI _GUI;
	
	private ObjectControl _objectControl;
	
	
	public GameController() {
		
		_GUI = new GameGUI(new IView2ModelAdapter() {

			@Override
			public void update(Graphics g) {
				_model.update(g);
			}

			@Override
			public void start() {
				_objectControl.start();
				_model.start();
			}
			
		});
		
		_model = new GameModel(new IModel2ViewAdapter() {
					
					public void update() {
						_GUI.update();
					}
		}, new IModel2ObjectAdapter() {

			@Override
			public void updateRemotePlayer(String id) {
				_objectControl.updateRemotePlayer(id);
			}
			
		});	
		
		_objectControl = new ObjectControl(new IObject2ViewAdapter() {

			@Override
			public Dimension getScreenSize() {
				return _GUI.getScreenSize();
			}

			@Override
			public Component getCanvas() {
				return _GUI.getCanvas();
			}

			@Override
			public void addKeyCommand(String key, Consumer<String> command) {
				_GUI.addKeyCommand(key, command);
			}
			
		}, new IObject2ModelAdapter() {

			@Override
			public void addObserver(IObserver<ICommand> observer) {
				_model.addObserver(observer);
			}

			@Override
			public void removeObserver(IObserver<ICommand> observer) {
				_model.removeObserver(observer);
			}
			
		});
		
	}
	
	private void start() {
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
