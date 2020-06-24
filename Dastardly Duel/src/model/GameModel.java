package model;

import java.awt.Graphics;

import javax.swing.Timer;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.vagile.manual.Player;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;
import util.dispatcher.IObserver;
import util.dispatcher.impl.StandardDispatcher;

public class GameModel {
	
	IModel2ViewAdapter _model2View = IModel2ViewAdapter.NULL_ADAPTER;
	
	private int _framesPerMS = 25;	// 25 milliseconds --> 40 FPS
	
	Timer _timer = new Timer(_framesPerMS, (e) -> _model2View.update());
	
	IDispatcher<ICommand> _dispatcher = new StandardDispatcher<ICommand>();
			
	public GameModel(IModel2ViewAdapter model2View) {
		_model2View = model2View;
	}
	
	public void start() {
		_timer.start();

	}
	
	public void update(Graphics g) {
		_dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(AGameObject context, IDispatcher<ICommand> dispatcher) {
				context.update(dispatcher, g);
			}
			
		});
	}
	
	public void addObserver(IObserver<ICommand> observer) {
		_dispatcher.addObserver(observer);
	}
	
	public void removeObserver(IObserver<ICommand> observer) {
		_dispatcher.removeObserver(observer);
	}
	
}
