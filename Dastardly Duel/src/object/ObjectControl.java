package object;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.function.Consumer;

import object.sprites.IGameObject2ControlAdapter;
import object.sprites.impl.interactive.sessile.Platform;
import object.sprites.impl.interactive.vagile.manual.Player;
import object.sprites.movement.IMoveableKeys;
import object.sprites.movement.IMoveableStrategy;
import object.sprites.paint.impl.BasicPaint;
import object.sprites.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IObserver;

public class ObjectControl {
	
	IObject2ViewAdapter _object2View = IObject2ViewAdapter.NULL_ADAPTER;
	
	IObject2ModelAdapter _object2Model = IObject2ModelAdapter.NULL_ADAPTER;
	
	Player _player;
	
	private final IGameObject2ControlAdapter _gameObject2Control = new IGameObject2ControlAdapter() {

		@Override
		public void addObserver(IObserver<ICommand> observer) {
			_object2Model.addObserver(observer);
		}

		@Override
		public Dimension getScreenSize() {
			return _object2View.getScreenSize();
		}

		@Override
		public Component getCanvas() {
			return _object2View.getCanvas();
		}
		
	};
	
	public ObjectControl(IObject2ViewAdapter object2View, IObject2ModelAdapter object2Model) {
		_object2View = object2View;
		_object2Model = object2Model;
	}
	
	public void start() {
		loadPlayer();
		loadEnvironment();
	}
	
	private void loadPlayer() {
		_player = new Player(new Point(100, _object2View.getScreenSize().height - 168), new BasicPaint(), _gameObject2Control);
		registerMovementKeys(_player.getMoveableKeys(), _player.getMoveableStrategy());
		_object2Model.addObserver(_player);
	}
	
	private void loadEnvironment() {
		Platform demoPlatform = new Platform(new Point(250, _object2View.getScreenSize().height - 350), 300, 1, 
				new BasicPaint(), _gameObject2Control, IUpdateStrategy.NULL_UPDATE);
		_object2Model.addObserver(demoPlatform);
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
