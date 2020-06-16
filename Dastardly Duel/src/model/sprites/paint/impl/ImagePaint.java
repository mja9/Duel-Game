package model.sprites.paint.impl;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import model.sprites.ASprite;

public class ImagePaint extends APaintStrategy {
	
	private ImageObserver _canvas;

	public ImagePaint(AffineTransform affineTransform) {
		super(affineTransform);
	}
	
	public void init(ImageObserver canvas) {
		_canvas = canvas;
	}

	@Override
	public void paintTransform(Graphics g, ASprite context, AffineTransform affineTransform) {
		
	}

}
