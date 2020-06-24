package object.gameobjects.interaction.impl;

import java.awt.Point;

import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.interaction.IInteractionStrategy;

public class Bounce implements IInteractionStrategy {
	
	private AInteractiveObject _context;

	@Override
	public void init(AInteractiveObject context) {
		_context = context;
	}

	@Override
	public void interact() {
		// Screen size on the device running the game
		int screenHeight = _context.getScreenSize().height;
		int screenWidth = _context.getScreenSize().width;
		
		// Check if hitting walls
		if (_context.getPosition().x - (_context.getWidth() / 2) <= 0) {	// Left wall
			_context.setPosition(new Point(_context.getWidth() / 2, _context.getPosition().y));
		}
		
		if (_context.getPosition().x + (_context.getWidth() / 2) >= screenWidth) {	// Right wall
			_context.setPosition(new Point(screenWidth - _context.getWidth() / 2, _context.getPosition().y));
		}
		
		// Check if hitting ceiling
		if (_context.getPosition().y - (_context.getHeight() / 2) <= 0) {
			_context.setPosition(new Point(_context.getPosition().x, _context.getHeight() / 2));
			_context.setSpeed(new Point(_context.getSpeed().x, 0));
		}
		
		// Check if hitting floor
		if (_context.getPosition().y + (_context.getHeight() / 2) >= screenHeight - (screenHeight / 4)) {
			_context.setPosition(new Point(_context.getPosition().x, 
					screenHeight - (screenHeight / 4) - (_context.getHeight() / 2)));
		}
		
	}

}
