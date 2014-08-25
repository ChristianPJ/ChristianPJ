package com.learnimbus.ejemplo.learnimbusgrafico2D;

import com.learnimbus.ejemplo.learnimbusgrafico2D.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Element {
	private int mX;
	private int mY;

	private Bitmap mBitmap;

	public Element(Resources res, int x, int y) {
		mBitmap = BitmapFactory.decodeResource(res, R.drawable.learnimbus);
		mX = x - mBitmap.getWidth() / 2;
		mY = y - mBitmap.getHeight() / 2;
	}

	public void doDraw(Canvas canvas) {
		canvas.drawBitmap(mBitmap, mX, mY, null);
	}
}
