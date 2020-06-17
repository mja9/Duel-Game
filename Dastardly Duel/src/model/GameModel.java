package model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.function.Consumer;

import javax.swing.Timer;

import model.sprites.ASprite;
import model.sprites.action.IActionStrategy;
import model.sprites.impl.character.Player;
import model.sprites.impl.environment.Platform;
import model.sprites.movement.IMoveableKeys;
import model.sprites.movement.IMoveableStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.paint.impl.BasicPaint;
import model.sprites.paint.impl.ImagePaint;
import model.sprites.update.IUpdateStrategy;
import model.sprites.update.impl.Collision;
import model.sprites.update.impl.PseudoGravity;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;
import util.dispatcher.impl.StandardDispatcher;

public class GameModel {
	
	IModel2ViewAdapter _model2View = IModel2ViewAdapter.NULL_ADAPTER;
	
	private int _framesPerMS = 25;	// 25 milliseconds --> 40 FPS
	
	Timer _timer = new Timer(_framesPerMS, (e) -> _model2View.update());
	
	IDispatcher<ICommand> _dispatcher = new StandardDispatcher<ICommand>();
	
	Player _player;
		
	public GameModel(IModel2ViewAdapter model2View) {
		_model2View = model2View;
	}
	
	public void start() {
		loadPlayer();
		loadEnvironment();
		_timer.start();

	}
	
	public void update(Graphics g) {
		_dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(ASprite context, IDispatcher<ICommand> dispatcher) {
				context.update(dispatcher, g);
			}
			
		});
	}
	
	private void loadEnvironment() {
		Platform platform = new Platform(new BasicPaint(), IMovementStrategy.NULL_MOVEMENT, IActionStrategy.NULL_ACTION, 
				new Collision(), new Point(250, getScreenSize().height - 350), getScreenSize(), 300, 50, _model2View.getCanvas());
		_dispatcher.addObserver(platform);
	}
	
	private void loadPlayer() {
		_player = new Player(new BasicPaint(), IMovementStrategy.NULL_MOVEMENT, 
			IActionStrategy.NULL_ACTION, new PseudoGravity(), new IMoveableStrategy() {

			@Override
			public void init() {		
			}

			@Override
			public Point getPoint() {
				return _player.getPosition();
			}

			@Override
			public void moveLeft() {	
				_player.setSpeed(new Point(-5, _player.getSpeed().y));
			}

			@Override
			public void moveRight() {	
				_player.setSpeed(new Point(5, _player.getSpeed().y));
			}

			@Override
			public void moveUp() {	
				_player.setSpeed(new Point(_player.getSpeed().x, -20));
			}

			@Override
			public void moveDown() {		
			}

			@Override
			public void stop() {
				_player.setSpeed(new Point(0, _player.getSpeed().y));
			}

			
		}, 
			new Point(100, getScreenSize().height - 168), 
			getScreenSize(), 10, 46, _model2View.getCanvas());
		_player.setMoveableKeys(IMoveableKeys.STANDARD_KEYS);
		registerMovementKeys(_player.getMoveableKeys(), _player.getMoveableStrategy());
		_player.setSpeed(new Point(0, 20));
		_player.setPaintStrategy(new ImagePaint(new AffineTransform(), "images/rockmancentered.png"));
		_dispatcher.addObserver(_player);
	}
	
	public void registerMovementKeys(IMoveableKeys keys, final IMoveableStrategy moveableStrategy) {
		
		_model2View.addKeyCommand(keys.getLeftKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveLeft();
			}
			
		});
		
		_model2View.addKeyCommand("released LEFT", new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.stop();
			}
			
		});
		
		_model2View.addKeyCommand(keys.getRightKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveRight();
			}
			
		});
		
		_model2View.addKeyCommand("released RIGHT", new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.stop();
			}
			
		});
		
		_model2View.addKeyCommand("released UP", new Consumer<String>() {

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
		
		_model2View.addKeyCommand("released SPACE", new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("Screen Size: " + getScreenSize() + "\n");
				System.out.println("Player position: " + _player.getPosition() + "\n");
			}
			
		});
	}
	
	public Dimension getScreenSize() {
		return _model2View.getScreenSize();
	}
	
}
