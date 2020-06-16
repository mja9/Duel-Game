package model.sprites.update.impl;

import java.awt.Point;

import model.sprites.ASprite;
import model.sprites.update.IUpdateStrategy;
import util.dispatcher.ICommand;
import util.dispatcher.IDispatcher;

public class Collision implements IUpdateStrategy {

	@Override
	public void init() {		
	}

	@Override
	public void updateState(ASprite thisContext, IDispatcher<ICommand> dispatcher) {
		
		Point thisCenter = thisContext.getPosition();
		
		dispatcher.sendMessage(new ICommand() {

			@Override
			public void apply(ASprite otherContext, IDispatcher<ICommand> dispatcher) {
				if (otherContext != thisContext) {
					
					Point otherCenter = otherContext.getPosition();
					
					// Check x-positions
					if ((Math.abs(otherCenter.x - thisCenter.x) <=
							thisContext.getWidth() / 2 + otherContext.getWidth() / 2)
							// Check y-positions
							&& (Math.abs(otherCenter.y - thisCenter.y) <=
							thisContext.getHeight() / 2 + otherContext.getHeight() / 2)) {
						performAction(thisContext, otherContext);
					}
					
				}
			}
			
		});
	}
	
	// For testing purposes only!
	private void performAction(ASprite thisContext, ASprite otherContext) {
		
		// Find where otherContext was positioned before
		Point oldPos = new Point(otherContext.getPosition().x - otherContext.getSpeed().x,
				otherContext.getPosition().y - otherContext.getSpeed().y);
		
		// Find the closest point of contact
		findIntersection(oldPos, otherContext.getSpeed(), thisContext.getPosition(), 
				thisContext.getHeight(), thisContext.getWidth());
		
		// Act accordingly 
		
	}
	
	private void findIntersection(Point point, Point slope, Point thisPos, int height, int width) {
		
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;
		Point pointLeft = new Point();
		Point pointRight = new Point();
		Point pointUp = new Point();
		Point pointDown = new Point();

		int m = slope.x / slope.y;
		
		// Left line: y = [thisPos.y - height/2, thisPos.y + height/2], x = thisPos.x - width/2
		int yLeft = (m * thisPos.x - width / 2) - (m * point.x) + point.y;
		if ((yLeft >= thisPos.y - height / 2) && (yLeft <= thisPos.y + height / 2)) {
			left = true;
			pointLeft = new Point(thisPos.x - width / 2, yLeft);	// point of intersection
		}
		
		// Right line:  y = [thisPos.y - height/2, thisPos.y + height/2], x = thisPos.x + width/2
		int yRight = (m * thisPos.x + width / 2) - (m * point.x) + point.y;
		if ((yRight >= thisPos.y - height / 2) && (yRight <= thisPos.y + height / 2)) {
			right = true;
			pointRight = new Point(thisPos.x + width / 2, yRight);	// point of intersection
		}
		
		// Top line: y = this.Pos.y - height/2, x = [thisPos.x - width/2, thisPos.x + width/2]
		int xUp = ((1 / m) * thisPos.y - height/2) - ((1 / m) * point.y) + point.x;
		if ((xUp >= thisPos.x - width / 2) && (xUp <= thisPos.x + width / 2)) {
			up = true;
			pointUp = new Point(xUp, thisPos.y - height / 2);
		}
		
		// Bottom line: y = this.Pos.y + height/2, x = [thisPos.x - width/2, thisPos.x + width/2]
		int xDown = ((1 / m) * thisPos.y + height/2) - ((1 / m) * point.y) + point.x;
		if ((xDown >= thisPos.x - width / 2) && (xDown <= thisPos.x + width / 2)) {
			down = true;
			pointDown = new Point(xDown, thisPos.y + height / 2);
		}
	}
	
	
	private void findDistance() {
		
	}

}
