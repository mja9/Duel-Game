package object.gameobjects.action;

import object.gameobjects.AGameObject;

public class Block implements IActionStrategy {

	private AGameObject _context;
	
	@Override
	public void init(AGameObject context) {
		_context = context;
	}

	@Override
	public void performAction() {
		
	}

}
