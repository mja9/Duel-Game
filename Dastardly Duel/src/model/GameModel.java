package model;

import java.awt.Graphics;
import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.Timer;

import model.remote.IRemotePlayerMessage;
import model.remote.classServer.ClassFileServerResources;
import model.remote.classServer.ClassServer;
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
	IModel2ObjectAdapter _model2Object = IModel2ObjectAdapter.NULL_ADAPTER;
	
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
	 * The name of the local address for this player.
	 */
	private String _localAddress = "";
	
	@SuppressWarnings("unused")
	private ClassServer classFileServer = null;
	
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
//		startRMI();

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
		
		// NOTE: In the provided he sets the security policy via the security.policy file
		String sep = System.getProperty("file.separator");
		String homeDirectory = System.getProperty("user.dir");
		String policyFilePath = homeDirectory + sep + "src" + sep + "model" + sep + "remote" + sep + "server.policy"; 
//		File policyFile = new File(policyFilePath);	// For testing purposes.
		System.setProperty("java.security.policy", policyFilePath);
		
		// Create and install the security manager
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		// Try and obtain the local IP Address and set local properties -- need to look into this more
		try {
			_localAddress = java.net.InetAddress.getLocalHost().getHostAddress();
//			System.out.println(_localAddress);
			
			// Set system properties
			System.setProperty("java.rmi.server.hostname", _localAddress);

			System.setProperty("java.rmi.server.codebase",
					"http://" + System.getProperty("java.rmi.server.hostname")
					+ ":" + 2001 + "/");
			
			// Must be false to allow remote class dynamic loading (defaults to true for JDK 1.7+)
			System.setProperty("java.rmi.server.useCodebaseOnly", "false");
			
			
			// Open class server
			classFileServer = new ClassFileServerResources(2001, System.getProperty("user.dir"), 
					System.out::println, System.err::println);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.err.println("Error: IP for the host could not be determined. " + e);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error: Unable to open class server.");
		}
		
		// Create the stub for this player
		try {
			IRemotePlayerMessage stub = (IRemotePlayerMessage) UnicastRemoteObject.exportObject(_remotePlayerMessenger, 2001);
			Registry localRegistry = LocateRegistry.getRegistry();
			localRegistry.rebind("test1", stub);

		} catch (RemoteException e) {
			System.err.println("Error: Encountered problem creating and binding stub in the registry. " + e);
			e.printStackTrace();
		}
		
		
	}
	
}
