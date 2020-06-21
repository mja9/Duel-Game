package model;

import java.awt.Color;
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
import model.sprites.impl.projectiles.Boulder;
import model.sprites.movement.IMoveableKeys;
import model.sprites.movement.IMoveableStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.movement.impl.ConstantMovement;
import model.sprites.paint.IPaintStrategy;
import model.sprites.paint.impl.BasicPaint;
import model.sprites.paint.impl.ImagePaint;
import model.sprites.update.IUpdateStrategy;
import model.sprites.update.impl.Collision;
import model.sprites.update.impl.MultiUpdate;
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
				IUpdateStrategy.NULL_UPDATE, new Point(250, getScreenSize().height - 350), getScreenSize(), 300, 1, _model2View.getCanvas());
		_dispatcher.addObserver(platform);
	}
	
	private void loadPlayer() {
		_player = new Player(new BasicPaint(), IMovementStrategy.NULL_MOVEMENT, 
			new IActionStrategy() {

			private final int projectileSpeed = 25;
			private ASprite _context;

			@Override
			public void init(ASprite context) {		
				_context = context;
			}

			@Override
			public void performAction() {
				Boulder boulder = new Boulder(new IPaintStrategy() {
					
					@Override
					public void init(ASprite context) {
					}

					@Override
					public void paint(Graphics g, ASprite context) {
						g.setColor(Color.YELLOW);
						g.fillOval(context.getPosition().x, context.getPosition().y, 
								context.getWidth(), context.getHeight());
					}
					
				}, 
						new ConstantMovement(), IActionStrategy.NULL_ACTION, 
						IUpdateStrategy.NULL_UPDATE, 
						new Point(_context.getPosition().x + _context.getWidth() / 2 + 5, 
								_context.getPosition().y - _context.getHeight() / 4), 
						_context.getScreenSize(), 5, 5, _context.getCanvas());
				_dispatcher.addObserver(boulder);
				
			}
			
			}, new MultiUpdate(new PseudoGravity(), new Collision()), new IMoveableStrategy() {

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
			getScreenSize(), 36, 120, _model2View.getCanvas());
		_player.setMoveableKeys(IMoveableKeys.STANDARD_KEYS);
		registerMovementKeys(_player.getMoveableKeys(), _player.getMoveableStrategy());
		_player.setSpeed(new Point(0, 20));
//		_player.setPaintStrategy(new ImagePaint(new AffineTransform(), "images/rockmancentered.png"));
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
				_player.act();
			}
			
		});
	}
	
	public Dimension getScreenSize() {
		return _model2View.getScreenSize();
	}
	
}
