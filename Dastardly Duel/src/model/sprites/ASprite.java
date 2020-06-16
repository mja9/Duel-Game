package model.sprites;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import model.sprites.action.IActionStrategy;
import model.sprites.movement.IMovementStrategy;
import model.sprites.paint.IPaintStrategy;
import model.sprites.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;
import util.dispatcher.IObserver;

public abstract class ASprite implements IObserver<ICommand> {
	
	IPaintStrategy _paintStrategy = IPaintStrategy.NULL_PAINT;
	
	IMovementStrategy _movementStrategy = IMovementStrategy.NULL_MOVEMENT;
	
	IActionStrategy _actionStrategy = IActionStrategy.NULL_ACTION;
	
	IUpdateStrategy _updateStrategy = IUpdateStrategy.NULL_UPDATE;
	
	Point _position = new Point(0, 0);
	
	Point _speed = new Point(0, 0);
	
	Dimension _screenSize = new Dimension(0, 0);
	
	int _width = 0;
	
	int _height = 0;
	
	ImageObserver _canvas;
	
	public ASprite(IPaintStrategy paintStrategy, IMovementStrategy movementStrategy,
			IActionStrategy actionStrategy, IUpdateStrategy updateStrategy, Point pos, 
			Dimension screenSize, int width, int height, ImageObserver canvas) {
		
		_paintStrategy = paintStrategy;
		_movementStrategy = movementStrategy;
		_actionStrategy = actionStrategy;
		_updateStrategy = updateStrategy;
		_position = pos;
		_screenSize = screenSize;
		_width = width;
		_height = height;
		_canvas = canvas;
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
	
	public void update(IDispatcher<ICommand> dispatcher, Graphics g) {
		
		_movementStrategy.move();
		checkBoundary();
		_updateStrategy.updateState(this, dispatcher);
		_paintStrategy.paint(g, this);
	}

	@Override
	public void recieve(IDispatcher<ICommand> dispatcher, ICommand message) {
		message.apply(this, dispatcher);
	}
	
	private void checkBoundary() {
		
		// Screen size on the device running the game
		int screenHeight = _screenSize.height;
		int screenWidth = _screenSize.width;
		
		// Check if hitting walls
		
		if (_position.x - (_width / 2) <= 0) {	// Left wall
			_position.x = _width / 2;
		}
		
		if (_position.x + (_width / 2) >= screenWidth) {	// Right wall
			_position.x = screenWidth - (_width / 2);
		}
		
		// Check if hitting ceiling
		
		if (_position.y - (_height / 2) <= 0) {
			_position.y = _height / 2;
		}
		
		// Check if hitting floor
		if (_position.y + (_height / 2) >= screenHeight - (screenHeight / 4)) {
			_position.y = screenHeight - (screenHeight / 4) - (_height / 2);
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
	
	public void setWidth(int newWidth) {
		_width = newWidth;
	}
	
	public int getWidth() {
		return _width;
	}
	
	public void setHeight(int newHeight) {
		_height = newHeight;
	}
	
	public int getHeight() {
		return _height;
	}
	
	public ImageObserver getCanvas() {
		return null;
	}
	
	public abstract String getID();
	

}
