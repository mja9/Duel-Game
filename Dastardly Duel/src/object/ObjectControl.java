package object;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.function.Consumer;

import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.action.BoulderAttack;
import object.gameobjects.action.IActionStrategy;
import object.gameobjects.impl.interactive.sessile.SessileObject;
import object.gameobjects.impl.interactive.vagile.manual.ManualObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.Bounce;
import object.gameobjects.movement.IMoveableKeys;
import object.gameobjects.movement.IMoveableStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.BasicMoveable;
import object.gameobjects.movement.impl.BasicMovement;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.BasicPaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.Collision;
import object.gameobjects.update.impl.DetectBoundary;
import object.gameobjects.update.impl.MultiUpdate;
import object.gameobjects.update.impl.PseudoGravity;
import util.dispatcher.ICommand;
import util.dispatcher.IObserver;
import util.factory.IFactory;

public class ObjectControl {
	
	IObject2ViewAdapter _object2View = IObject2ViewAdapter.NULL_ADAPTER;
	
	IObject2ModelAdapter _object2Model = IObject2ModelAdapter.NULL_ADAPTER;
		
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

		@Override
		public void removeObserver(IObserver<ICommand> observer) {
			_object2Model.removeObserver(observer);
		}
		
	};
	
	IFactory<ManualObject> _playerFactory = new IFactory<ManualObject>() {

		@Override
		public ManualObject make(Object... parameters) {
			
			Point pos = (Point) parameters[0];
			
			int width = 36;
					
			int height = 120;
			
			IUpdateStrategy updateStrategy = new MultiUpdate(new DetectBoundary(), new MultiUpdate(new PseudoGravity(), new Collision()));
			
			IInteractionStrategy interactStrategy = new Bounce();
			
			IMovementStrategy movementStrategy = new BasicMovement();
			
			IMoveableStrategy moveableStrategy = new BasicMoveable();
			
			IMoveableKeys moveableKeys = IMoveableKeys.STANDARD_KEYS;
			
			IActionStrategy actionStrategy = new BoulderAttack();
//			IActionStrategy actionStrategy = new Block();
			
			IPaintStrategy paintStrategy = new BasicPaint();
			
			ManualObject product = new ManualObject(pos, width, height, paintStrategy, _gameObject2Control, 
					updateStrategy, interactStrategy, movementStrategy, moveableStrategy, moveableKeys, actionStrategy);
			
			registerMovementKeys(product.getMoveableKeys(), product.getMoveableStrategy());
			
			return product;
		}
		
	};
	
	IFactory<SessileObject> _platformFactory = new IFactory<SessileObject>() {

		@Override
		public SessileObject make(Object... parameters) {
						
			Point pos = (Point) parameters[0];
			
			int width = 300;
			
			int height = 1;
			
			IPaintStrategy paintStrategy = new BasicPaint();
			
			return new SessileObject(pos, width, height, paintStrategy, _gameObject2Control, IUpdateStrategy.NULL_UPDATE,
					IInteractionStrategy.NULL_INTERACTION);
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
		_object2Model.addObserver(_playerFactory.make(new Point(100, _object2View.getScreenSize().height - 168)));
	}
	
	private void loadEnvironment() {
		_object2Model.addObserver(_platformFactory.make(new Point(250, _object2View.getScreenSize().height - 350)));
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
