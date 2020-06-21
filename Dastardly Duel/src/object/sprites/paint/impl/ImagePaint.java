package object.sprites.paint.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import object.sprites.ASprite;

public class ImagePaint extends APaintStrategy {
	
	private ImageObserver _canvas;
	private Image _image;
	private double _fillFactorX = 0.5;
	private double _fillFactorY = 0.5;
	private double _scaleFactorX;
	private double _scaleFactorY;
	protected AffineTransform _localAffineTransform = new AffineTransform();
	
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
		
		// Jumbo player
//		_scaleFactorX = 2.0 / (_fillFactorX * _image.getWidth(_canvas) / 2.0);
//		_scaleFactorY = 2.0 / (_fillFactorY * _image.getHeight(_canvas) / 2.0); 
		
		_scaleFactorX = 1.0 / (_fillFactorX * _image.getWidth(_canvas));
		_scaleFactorY = 1.0 / (_fillFactorY * _image.getHeight(_canvas)); 
	}
	
	@Override 
	public void paintConfiguration(Graphics g, ASprite context) {
		super.paintConfiguration(g, context);
		if (Math.abs(Math.atan2(context.getSpeed().y, context.getSpeed().x)) > Math.PI / 2.0) {
			AffineTransform affineTransform = getAffineTransform();
			affineTransform.scale(-1.0, 1.0);
			setAffineTransform(affineTransform);
		}
	}

	@Override
	public void paintTransform(Graphics g, ASprite context, AffineTransform affineTransform) {
		_localAffineTransform.setToScale(_scaleFactorX, _scaleFactorY);
		_localAffineTransform.translate(-_image.getWidth(_canvas), -_image.getHeight(_canvas));
		_localAffineTransform.preConcatenate(affineTransform);
		((Graphics2D) g).drawImage(_image, _localAffineTransform, _canvas);
	}

}
