package model;

import java.awt.Graphics;
import java.rmi.RemoteException;

import javax.swing.Timer;

import model.remote.IRemotePlayerMessage;
import object.gameobjects.AGameObject;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;
import util.dispatcher.IObserver;
import util.dispatcher.impl.StandardDispatcher;

public class GameModel {
	
	/**
	 * An adapter for external communication between this package and 
	 * a view-handling package.
	 */
	IModel2ViewAdapter _model2View = IModel2ViewAdapter.NULL_ADAPTER;

	/**
	 * An adapter for external communication between this package and 
	 * a game object-handling package.
	 */
	IModel2ObjectAdapter _model2Object;
	
	/**
	 * The measure of ticks per second for the timer. Each tick 
	 * results in a new frame.
	 */
	private int _framesPerMS = 25;	// 25 milliseconds --> 40 FPS
	
	/**
	 * The timer on which the game runs, controlling when 
	 * a new frame should be shown in the view package.
	 */
	Timer _timer = new Timer(_framesPerMS, (e) -> _model2View.update());
	
	/**
	 * A standard synchronous dispatcher used for message-based updating 
	 * for the system in line with the Observable-Observer design
	 * pattern.
	 */
	IDispatcher<ICommand> _dispatcher = new StandardDispatcher<ICommand>();
	
	/**
	 * The remote player message object used to create the stub 
	 * for registration.		
	 */
	IRemotePlayerMessage _remotePlayerMessenger = new IRemotePlayerMessage() {

		@Override
		public void sendMessage(String id) throws RemoteException {
			_model2Object.updateRemotePlayer(id);
		}
		
	};
	
	/**
	 * A stub to a remote player used to send update messages for 
	 * this player's actions.
	 */
	IRemotePlayerMessage _remotePlayerStub;
	
	/**
	 * 
	 * The game model controlling the mechanics driving the game. This 
	 * module dictates frame rate, RMI capabilities, and local update 
	 * message control.
	 * 
	 * @param model2View An adapter for outgoing communication with a view-handling module.
	 * @param model2Object An adapter for outgoing communication with a game object-handling module.
	 */
	
	public GameModel(IModel2ViewAdapter model2View, IModel2ObjectAdapter model2Object) {
		_model2View = model2View;
		_model2Object = model2Object;
	}
	
	public void start() {
		_timer.start();

	}
	
	public void update(Graphics g) {
		_dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(AGameObject context, IDispatcher<ICommand> dispatcher) {
				context.update(dispatcher, g);
			}
			
		});
	}
	
	public void addObserver(IObserver<ICommand> observer) {
		_dispatcher.addObserver(observer);
	}
	
	public void removeObserver(IObserver<ICommand> observer) {
		_dispatcher.removeObserver(observer);
	}
	
// -------------- ADD RMI CAPABILITIES HERE ---------------------------------------------------------
	
	
	public void startRMI()  {
		
	}
	
}
