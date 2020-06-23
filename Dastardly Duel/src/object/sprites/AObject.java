package object.sprites;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import object.IObject2ViewAdapter;
import object.sprites.action.IActionStrategy;
import object.sprites.movement.IMovementStrategy;
import object.sprites.paint.IPaintStrategy;
import object.sprites.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;
import util.dispatcher.IObserver;

public abstract class AObject implements IObserver<ICommand> {
		
	Point _position = new Point(0, 0);
	
	Point _speed = new Point(0, 0);
	
	int _width = 0;
	
	int _height = 0;
	
	IPaintStrategy _paintStrategy = IPaintStrategy.NULL_PAINT;
	
	IObject2ViewAdapter _object2Model = IObject2ViewAdapter.NULL_ADAPTER;
	
	public AObject(Point pos, int width, int height, IPaintStrategy paintStrategy, 
			IObject2ViewAdapter object2Model) {
		
		_paintStrategy = paintStrategy;
		_paintStrategy.init(this);
		_position = pos;
		_width = width;
		_height = height;
		_object2Model = object2Model;
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
		return _object2Model.getScreenSize();	
	}
	
	public Component getCanvas() {
		return _object2Model.getCanvas();
	}
	
	public IObject2ViewAdapter getAdapter() {
		return _object2Model;
	}
	
	protected abstract void updateState(AObject context, IDispatcher<ICommand> dispatcher);
	
	public abstract String getID();
	

}
