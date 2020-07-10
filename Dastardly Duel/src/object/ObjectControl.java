package object;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.function.Consumer;

import object.gameobjects.action.Block;
import object.gameobjects.action.BoulderAttack;
import object.gameobjects.action.IActionStrategy;
import object.gameobjects.boss.DemoBoss;
import object.gameobjects.impl.interactive.sessile.Platform;
import object.gameobjects.impl.interactive.sessile.SessileObject;
import object.gameobjects.impl.interactive.vagile.manual.ManualObject;
import object.gameobjects.impl.interactive.vagile.manual.Player;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.PlayerInteraction;
import object.gameobjects.movement.IMoveableKeys;
import object.gameobjects.movement.IMoveableStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.movement.impl.GroundMoveable;
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
			
	private final IGameObjectAdapter _gameObjectAdapter = new IGameObjectAdapter() {

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
	
	public ObjectControl(IObject2ViewAdapter object2View, IObject2ModelAdapter object2Model) {
		_object2View = object2View;
		_object2Model = object2Model;
	}
	
	public void start() {
		loadPlayer();
		loadEnvironment();
		loadEnemy();
	}
	
	private void loadPlayer() {
		Player _player = new Player(new Point(100, _object2View.getScreenSize().height - _object2View.getScreenSize().height / 4), 
				_gameObjectAdapter);
		registerMovementKeys(_player.getMoveableKeys(), _player);
		_object2Model.addObserver(_player);
	}
	
	private void loadEnvironment() {
		
		// Left side platforms
		_object2Model.addObserver(new Platform(new Point(250, _object2View.getScreenSize().height - 400), 
				275, 1, _gameObjectAdapter));
		_object2Model.addObserver(new Platform(new Point(80, _object2View.getScreenSize().height - 575), 
				100, 1, _gameObjectAdapter));
		_object2Model.addObserver(new Platform(new Point(370, _object2View.getScreenSize().height - 700), 
				75, 1, _gameObjectAdapter));
		_object2Model.addObserver(new Platform(new Point(115, _object2View.getScreenSize().height - 750), 
				135, 1, _gameObjectAdapter));
		
		// Middle platforms
		_object2Model.addObserver(new Platform(new Point(_object2View.getScreenSize().width / 2, 
				_object2View.getScreenSize().height - 600), 225, 1, _gameObjectAdapter));
		_object2Model.addObserver(new Platform(new Point(_object2View.getScreenSize().width / 2,
				_object2View.getScreenSize().height / 2), 450, 1, _gameObjectAdapter));
		
		// Right side platforms
		_object2Model.addObserver(new Platform(new Point(_object2View.getScreenSize().width - 115, 
				_object2View.getScreenSize().height - 400), 135, 1, _gameObjectAdapter));
		_object2Model.addObserver(new Platform(new Point(_object2View.getScreenSize().width - 390,
				_object2View.getScreenSize().height - 550), 75, 1, _gameObjectAdapter));
		_object2Model.addObserver(new Platform(new Point(_object2View.getScreenSize().width - 80, 
				_object2View.getScreenSize().height - 630), 100, 1, _gameObjectAdapter));
		_object2Model.addObserver(new Platform(new Point(_object2View.getScreenSize().width - 250, 
				_object2View.getScreenSize().height - 750), 275, 1, _gameObjectAdapter));
		
	}
	
	private void loadEnemy() {
		
		DemoBoss _demoBoss = new DemoBoss(new Point(_object2View.getScreenSize().width - 100, 
				_object2View.getScreenSize().height - _object2View.getScreenSize().height / 4 - 8), _gameObjectAdapter);
		_object2Model.addObserver(_demoBoss);
	}
	
	public void updateRemotePlayer(String id) {
		
	}
		
	private void registerMovementKeys(IMoveableKeys keys, final ManualObject context) {
			
			_object2View.addKeyCommand(keys.getLeftKey(), new Consumer<String>() {
	
				@Override
				public void accept(String t) {
					context.getMoveableStrategy().moveLeft();
				}
				
			});
			
			_object2View.addKeyCommand("released " + keys.getLeftKey(), new Consumer<String>() {
	
				@Override
				public void accept(String t) {
					context.getMoveableStrategy().stop();
				}
				
			});
			
			_object2View.addKeyCommand(keys.getRightKey(), new Consumer<String>() {
	
				@Override
				public void accept(String t) {
					context.getMoveableStrategy().moveRight();
				}
				
			});
			
			_object2View.addKeyCommand("released " + keys.getRightKey(), new Consumer<String>() {
	
				@Override
				public void accept(String t) {
					context.getMoveableStrategy().stop();
				}
				
			});
			
			_object2View.addKeyCommand("released " + keys.getUpKey(), new Consumer<String>() {
	
				@Override
				public void accept(String t) {
					context.getMoveableStrategy().moveUp();
				}
				
			});
			
			_object2View.addKeyCommand(keys.getDownKey(), new Consumer<String>() {
	
				@Override
				public void accept(String t) {
					context.getMoveableStrategy().moveDown();
				}
				
			});
			
			_object2View.addKeyCommand("released " + keys.getPrimaryActionKey(), new Consumer<String>() {
	
				@Override
				public void accept(String t) {
					context.getMoveableStrategy().act1();
				}
				
			});
			
			_object2View.addKeyCommand("released " + keys.getSecondaryActionKey(), new Consumer<String>() {
	
				@Override
				public void accept(String t) {
					context.getMoveableStrategy().act2();
				}
				
			});
		}

}
