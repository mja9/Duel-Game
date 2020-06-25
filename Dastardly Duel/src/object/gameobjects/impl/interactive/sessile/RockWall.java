package object.gameobjects.impl.interactive.sessile;

import java.awt.Point;

import object.gameobjects.IGameObject2ControlAdapter;
import object.gameobjects.impl.interactive.AInteractiveObject;
import object.gameobjects.impl.interactive.vagile.auto.AutoObject;
import object.gameobjects.interaction.IInteractionStrategy;
import object.gameobjects.movement.IMovementStrategy;
import object.gameobjects.paint.IPaintStrategy;
import object.gameobjects.paint.impl.BasicPaint;
import object.gameobjects.update.IUpdateStrategy;
import object.gameobjects.update.impl.MultiUpdate;
import object.gameobjects.update.impl.PseudoGravity;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class RockWall extends SessileObject{
	
	private static IPaintStrategy paintStrategy = new BasicPaint();
	
	private static int initialWidth = 16;
	
	private static int initialHeight = 0;
	
	private static IUpdateStrategy updateStrategy = new IUpdateStrategy() {
		
		private int direction = -1;
		private int maxHeight = 130;

		@Override
		public void init() {
		}

		@Override
		public void updateState(AInteractiveObject context, IDispatcher<ICommand> dispatcher) {
			
			if (direction == -1 && context.getHeight() == maxHeight) {
				direction = 1;
				context.setHeight(context.getHeight() + direction);
				
			} else if (direction == 1 && context.getHeight() == 0) {
				dispatcher.removeObserver(context);
				
			} else {
				context.setHeight(context.getHeight() + direction);
			}
			
		}
		
	};
	
	private static IInteractionStrategy interactStrategy = IInteractionStrategy.NULL_INTERACTION;
	

	public RockWall(Point pos, IGameObject2ControlAdapter gameObject2Control) {
		super(pos, initialWidth, initialHeight, paintStrategy, gameObject2Control, updateStrategy, interactStrategy);
	}

}
