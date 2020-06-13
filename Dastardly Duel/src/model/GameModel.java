package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.function.Consumer;

import javax.swing.Timer;

import model.sprites.Player;
import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMoveableKeys;
import model.sprites.movement.IMoveableStrategy;
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
	
	Player _player = new Player(IPaintStrategy.NULL_PAINT, IMovementStrategy.NULL_MOVEMENT, 
			IActionStrategy.NULL_ACTION, IUpdateStrategy.NULL_UPDATE, IMoveableStrategy.NULL_MOVEABLE, 
			new Point(0, 0));
		
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
		_player = new Player(new BasicPaint(), IMovementStrategy.NULL_MOVEMENT, 
			IActionStrategy.NULL_ACTION, IUpdateStrategy.NULL_UPDATE, new IMoveableStrategy() {

			@Override
			public void init() {		
			}

			@Override
			public Point getPoint() {
				return _player.getPosition();
			}

			@Override
			public void moveLeft() {	
				_player.setSpeed(new Point(-20, 0));
			}

			@Override
			public void moveRight() {	
				_player.setSpeed(new Point(20, 0));
			}

			@Override
			public void moveUp() {		
			}

			@Override
			public void moveDown() {		
			}

			
		}, 
			new Point(100, Toolkit.getDefaultToolkit().getScreenSize().height - 145));
		_player.setMoveableKeys(IMoveableKeys.STANDARD_KEYS);
		registerMovementKeys(_player.getMoveableKeys(), _player.getMoveableStrategy());
		_dispatcher.addObserver(_player);
	}
	
	public void registerMovementKeys(IMoveableKeys keys, final IMoveableStrategy moveableStrategy) {
		
		_model2View.addKeyCommand(keys.getLeftKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveLeft();
			}
			
		});
		
		_model2View.addKeyCommand(keys.getRightKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveRight();
			}
			
		});
		
		_model2View.addKeyCommand(keys.getUpKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveUp();
			}
			
		});
		
		_model2View.addKeyCommand(keys.getDownKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveDown();
			}
			
		});
	}
	
}
