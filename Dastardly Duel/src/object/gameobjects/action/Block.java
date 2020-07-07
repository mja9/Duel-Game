package object.gameobjects.action;

import java.awt.Point;
import java.awt.geom.AffineTransform;

import object.gameobjects.AGameObject;
import object.gameobjects.impl.interactive.sessile.SessileObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.interaction.impl.Kill;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.BottomPaint;
import object.gameobjects.paint.impl.ImagePaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.Rise;
import util.factory.IFactory;

public class Block implements IActionStrategy {

	private AGameObject _context;
	
	private IFactory<SessileObject> _wallFactory;
	
	@Override
	public void init(AGameObject context) {
		_context = context;
		buildFactory();
	}
	
	private void buildFactory() {
		_wallFactory = new IFactory<SessileObject>() {

			@Override
			public SessileObject make(Object... parameters) {
//				IPaintStrategy paintStrategy = new BottomPaint();
				IPaintStrategy paintStrategy = new ImagePaint(new AffineTransform(), "images/rockwall.png", 0.82, 0.96);


				int initialWidth = 16;
				
				int initialHeight = 0;
					
				IInteractionStrategy interactStrategy = new Kill();
				
				Point pos = new Point(_context.getSpeed().x >= 0 ?
						_context.getPosition().x + _context.getWidth() : 
							_context.getPosition().x - _context.getWidth(), _context.getPosition().y + _context.getHeight() / 2);
				
				IUpdateStrategy updateStrategy = new Rise();
				
				return new SessileObject(pos, initialWidth, initialHeight, 
						paintStrategy, _context.getAdapter(), updateStrategy, interactStrategy);
			}
			
		};
	}

	@Override
	public void performAction() {
		_context.getAdapter().addObserver(_wallFactory.make());
	}

}
