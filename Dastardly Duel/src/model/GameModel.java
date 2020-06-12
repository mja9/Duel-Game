package model;

import java.awt.Graphics;

import javax.swing.Timer;

import util.dispatcher.IDispatcher;
import util.dispatcher.impl.StandardDispatcher;

public class GameModel {
	
	IModel2ViewAdapter _model2View = IModel2ViewAdapter.NULL_ADAPTER;
	
	private int _framesPerMS = 50;	// 50 milliseconds --> 20 FPS
	
	Timer _timer = new Timer(_framesPerMS, (e) -> _model2View.update());
	
	IDispatcher<Graphics> _dispatcher = new StandardDispatcher<Graphics>();
		
	public GameModel(IModel2ViewAdapter model2View) {
		_model2View = model2View;
	}
	
	public void start() {
		_timer.start();
	}
	
	public void update(Graphics g) {
		_dispatcher.sendMessage(_dispatcher, g);
	}
	
}
