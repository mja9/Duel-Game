package model.sprites;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;

import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;
import util.dispatcher.IDispatcher;
import util.dispatcher.IObserver;

public abstract class ASprite implements IObserver<Graphics> {
	
	IPaintStrategy _paintStrategy = IPaintStrategy.NULL_PAINT;
	
	IMovementStrategy _movementStrategy = IMovementStrategy.NULL_MOVEMENT;
	
	IActionStrategy _actionStrategy = IActionStrategy.NULL_ACTION;
	
	IUpdateStrategy _updateStrategy = IUpdateStrategy.NULL_UPDATE;
	
	Point _position = new Point(0, 0);
	
	Point _speed = new Point(0, 0);
	
	Dimension _screenSize = new Dimension(0, 0);
	
	public ASprite(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy,
			IActionStrategy actionStrategy, IUpdateStrategy updateStrategy, Point pos, 
			Dimension screenSize) {
		
		_paintStrategy = paintStrategy;
		_movementStrategy = movementStrategy;
		_actionStrategy = actionStrategy;
		_updateStrategy = updateStrategy;
		_position = pos;
		_screenSize = screenSize;
		setMovement();
		
	}
	
	private void setMovement() {
		_movementStrategy = new IMovementStrategy() {

			@Override
			public void init() {				
			}

			@Override
			public void move() {
				ASprite.this.setPosition(new Point(ASprite.this.getPosition().x + ASprite.this.getSpeed().x, 
						ASprite.this.getPosition().y + ASprite.this.getSpeed().y));
			}
			
		};
	}
	
	public void update(Graphics g) {
		
		_movementStrategy.move();
		checkBoundary();
		_updateStrategy.updateState(this);
		_paintStrategy.paint(g, this._position);
	}

	@Override
	public void recieve(IDispatcher<Graphics> dispatcher, Graphics message) {
		this.update(message);
	}
	
	private void checkBoundary() {
		
		// Screen size on the device running the game
		int screenHeight = _screenSize.height;
		int screenWidth = _screenSize.width;
		
		// Check if hitting walls
		
		if (_position.x <= 0) {	// Left wall
			_position.x = 0;
		}
		
		if (_position.x >= screenWidth - 10) {	// Right wall
			_position.x = screenWidth - 10;
		}
		
		// Check if hitting ceiling
		
		if (_position.y <= 45) {
			_position.y = 45;
		}
		
		// Check if hitting floor
		if (_position.y >= screenHeight - (screenHeight / 4)) {
			_position.y = screenHeight - (screenHeight / 4);
		}
	}
	
	public Point getPosition() {
		return _position;
	}
	
	public void setPosition(Point newPosition) {
		_position = newPosition;
	}
	
	public Point getSpeed() {
		return _speed;
	}
	
	public void setSpeed(Point newSpeed) {
		_speed = newSpeed;
	}
	
	public abstract String getID();
	

}
