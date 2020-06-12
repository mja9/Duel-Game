package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.Timer;

import model.sprites.Sprite;
import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.BasicPaint;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;
import util.dispatcher.IDispatcher;
import util.dispatcher.impl.StandardDispatcher;

public class GameModel {
	
	IModel2ViewAdapter _model2View = IModel2ViewAdapter.NULL_ADAPTER;
	
	private int _framesPerMS = 50;	// 50 milliseconds --> 20 FPS
	
	Timer _timer = new Timer(_framesPerMS, (e) -> _model2View.update());
	
	IDispatcher<Graphics> _dispatcher = new StandardDispatcher<Graphics>();
	
	Sprite _player = new Sprite(IPaintStrategy.NULL_PAINT, IMovementStrategy.NULL_MOVEMENT, 
			IActionStrategy.NULL_ACTION, IUpdateStrategy.NULL_UPDATE, new Point(0, 0));
		
	public GameModel(IModel2ViewAdapter model2View) {
		_model2View = model2View;
	}
	
	public void start() {
		_timer.start();
		loadPlayer();
	}
	
	public void update(Graphics g) {
		_dispatcher.sendMessage(_dispatcher, g);
	}
	
	private void loadPlayer() {
		_player = new Sprite(new BasicPaint(), IMovementStrategy.NULL_MOVEMENT, 
				IActionStrategy.NULL_ACTION, IUpdateStrategy.NULL_UPDATE, 
				new Point(100, Toolkit.getDefaultToolkit().getScreenSize().height - 145));
		_dispatcher.addObserver(_player);
	}
	
}
