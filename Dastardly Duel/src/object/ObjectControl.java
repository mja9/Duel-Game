package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.function.Consumer;

import object.sprites.action.IActionStrategy;
import object.sprites.impl.interactive.sessile.Platform;
import object.sprites.impl.interactive.vagile.auto.Boulder;
import object.sprites.impl.interactive.vagile.manual.Player;
import object.sprites.movement.IMoveableKeys;
import object.sprites.movement.IMoveableStrategy;
import object.sprites.movement.IMovementStrategy;
import object.sprites.movement.impl.ConstantMovement;
import object.sprites.paint.IPaintStrategy;
import object.sprites.paint.impl.BasicPaint;
import object.sprites.update.IUpdateStrategy;
import object.sprites.update.impl.Collision;
import object.sprites.update.impl.MultiUpdate;
import object.sprites.update.impl.PseudoGravity;

public class ObjectControl {
	
	IObject2ViewAdapter _object2View = IObject2ViewAdapter.NULL_ADAPTER;
	
	IObject2ModelAdapter _object2Mod = IObject2ModelAdapter.NULL_ADAPTER;
	
	Player _player;
	
	public ObjectControl(IObject2ViewAdapter object2View, IObject2ModelAdapter object2Model) {
		_object2View = object2View;
		_object2Mod = object2Model;
	}
	
	public void start() {
		loadPlayer();
		loadEnvironment();
	}
	
	private void loadPlayer() {
		_player = new Player(new Point(100, _object2View.getScreenSize().height - 168), new BasicPaint(), _object2View);
	}
	
	private void loadEnvironment() {
		
//		Platform platform = new Platform(new BasicPaint(), IMovementStrategy.NULL_MOVEMENT, IActionStrategy.NULL_ACTION, 
//				IUpdateStrategy.NULL_UPDATE, new Point(250, getScreenSize().height - 350), getScreenSize(), 300, 1, _model2View.getCanvas());
//		_dispatcher.addObserver(platform);
		
	}
	
public void registerMovementKeys(IMoveableKeys keys, final IMoveableStrategy moveableStrategy) {
		
		_object2View.addKeyCommand(keys.getLeftKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveLeft();
			}
			
		});
		
		_object2View.addKeyCommand("released LEFT", new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.stop();
			}
			
		});
		
		_object2View.addKeyCommand(keys.getRightKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveRight();
			}
			
		});
		
		_object2View.addKeyCommand("released RIGHT", new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.stop();
			}
			
		});
		
		_object2View.addKeyCommand("released UP", new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveUp();
			}
			
		});
		
		_object2View.addKeyCommand(keys.getDownKey(), new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.moveDown();
			}
			
		});
		
		_object2View.addKeyCommand("released SPACE", new Consumer<String>() {

			@Override
			public void accept(String t) {
				moveableStrategy.act();
			}
			
		});
	}
			

}
