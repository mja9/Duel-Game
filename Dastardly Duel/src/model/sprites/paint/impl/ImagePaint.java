package model.sprites.paint.impl;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import model.sprites.ASprite;

public class ImagePaint extends APaintStrategy {
	
	private ImageObserver _canvas;
	private Image _image;
	private double _fillFactor = 0.9;
	private double _scaleFactor;

	public ImagePaint(AffineTransform affineTransform, String filename) {
		super(affineTransform);
		try {
			_image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		} catch (Exception e) {
			System.err.println("ImagePaint error: Failed to load " + filename + "\n" + e);
		}
	}
	
	@Override
	public void init(ASprite context) {
		_canvas = context.getCanvas();
		MediaTracker mediaTracker = new MediaTracker(context.getCanvas());	// Image must load before use.
		mediaTracker.addImage(_image, 1);
		try {
			mediaTracker.waitForAll();
		} catch (Exception e) {
			System.err.println("ImagePaint.init(): Error waiting for image to load. Exception e = " + e + "\n");
		}
		
		_scaleFactor = 2.0 / (_fillFactor * (_image.getWidth(_canvas) + _image.getHeight(_canvas)) / 2.0); 
	}

	@Override
	public void paintTransform(Graphics g, ASprite context, AffineTransform affineTransform) {
		
	}

}
