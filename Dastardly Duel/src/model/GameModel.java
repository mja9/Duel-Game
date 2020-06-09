package model;

import javax.swing.Timer;

public class GameModel {
	
	IModel2ViewAdapter _model2View = IModel2ViewAdapter.NULL_ADAPTER;
	
	private int _framesPerMS = 50;	// 50 milliseconds --> 20 FPS
	
	Timer _timer = new Timer(_framesPerMS, (e) -> _model2View.update());
		
	public GameModel(IModel2ViewAdapter model2View) {
		_model2View = model2View;
	}
	
	public void start() {
		_timer.start();
	}
	
	public void update() {
		
	}
	
}
