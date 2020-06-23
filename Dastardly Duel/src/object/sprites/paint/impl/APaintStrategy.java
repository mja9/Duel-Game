package object.sprites.paint.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import object.sprites.AObject;
import object.sprites.paint.IPaintStrategy;

public abstract class APaintStrategy implements IPaintStrategy {
	
	protected AffineTransform _affineTransform;
	
	public APaintStrategy(AffineTransform affineTransform) {
		_affineTransform = affineTransform;
	}

	@Override
	public void init(AObject context) {
	}

	@Override
	public void paint(Graphics g, AObject context) {
		
		double scaleX = context.getWidth();
		double scaleY = context.getHeight();
		_affineTransform.setToTranslation(context.getPosition().getX(), context.getPosition().y);
		_affineTransform.scale(scaleX, scaleY);
//		_affineTransform.rotate(context.getSpeed().getX(), context.getSpeed().y);
		g.setColor(Color.RED);
		paintConfiguration(g, context);
		paintTransform(g, context, _affineTransform);
	}
	
	protected void paintConfiguration(Graphics g, AObject context) {
	}
	
	protected AffineTransform getAffineTransform() {
		return _affineTransform;
	}
	
	protected void setAffineTransform(AffineTransform newTransform) {
		_affineTransform = newTransform;
	}
	
	public abstract void paintTransform(Graphics g, AObject context, AffineTransform affineTransform);

}
