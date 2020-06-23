package object.gameobjects;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import object.gameobjects.action.IActionStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;
import util.dispatcher.IObserver;

public abstract class AGameObject implements IObserver<ICommand> {
		
	Point _position = new Point(0, 0);
	
	Point _speed = new Point(0, 0);
	
	int _width = 0;
	
	int _height = 0;
	
	IPaintStrategy _paintStrategy = IPaintStrategy.NULL_PAINT;
	
	IGameObject2ControlAdapter _gameObject2Control = IGameObject2ControlAdapter.NULL_ADAPTER;
	
	public AGameObject(Point pos, int width, int height, IPaintStrategy paintStrategy, 
			IGameObject2ControlAdapter gameObject2Control) {
		
		_paintStrategy = paintStrategy;
		_paintStrategy.init(this);
		_position = pos;
		_width = width;
		_height = height;
		_gameObject2Control = gameObject2Control;
	}
	
	public void update(IDispatcher<ICommand> dispatcher, Graphics g) {
		updateState(this, dispatcher);
		_paintStrategy.paint(g, this);
	}
	
	@Override
	public void recieve(IDispatcher<ICommand> dispatcher, ICommand message) {
		message.apply(this, dispatcher);
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
	
	public void setPaintStrategy(IPaintStrategy newStrat) {
		_paintStrategy = newStrat;
		_paintStrategy.init(this);
	}
	
	public Dimension getScreenSize() {
		return _gameObject2Control.getScreenSize();	
	}
	
	public Component getCanvas() {
		return _gameObject2Control.getCanvas();
	}
	
	public IGameObject2ControlAdapter getAdapter() {
		return _gameObject2Control;
	}
	
	protected abstract void updateState(AGameObject context, IDispatcher<ICommand> dispatcher);
	
	public abstract String getID();
	

}
