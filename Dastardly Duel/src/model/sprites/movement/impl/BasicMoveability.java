package model.sprites.movement.impl;

import java.awt.Point;

import model.sprites.Player;
import model.sprites.movement.IMoveableStrategy;

public class BasicMoveability implements IMoveableStrategy {
	
	private final Player _player;
	
	public BasicMoveability(Player player) {
		_player = player;
	}

	@Override
	public void init() {		
	}

	@Override
	public Point getPoint() {
		return _player.getPosition();
	}

	@Override
	public void moveLeft() {		
		_player.setPosition(new Point(_player.getPosition().x - _player.getSpeed().x, _player.getPosition().y));
	}

	@Override
	public void moveRight() {	
		_player.setPosition(new Point(_player.getPosition().x - _player.getSpeed().x, _player.getPosition().y));
	}

	@Override
	public void moveUp() {		
	}

	@Override
	public void moveDown() {		
	}

}
