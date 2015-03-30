package com.learnimbus.ejemplo.learnimbusgrafico2D;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Panel extends SurfaceView implements SurfaceHolder.Callback {
	private ViewThread mThread;
	private ArrayList<Element> mElements = new ArrayList<Element>();

	public Panel(Context context) {
		super(context);
		getHolder().addCallback(this);
		mThread = new ViewThread(this);
	}

	public void doDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		synchronized (mElements) {
	        for (Element element : mElements) {
	            element.doDraw(canvas);
	        }
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		synchronized (mElements) {
	        mElements.add(new Element(getResources(), (int) event.getX(), (int) event.getY()));
	    }
	    return super.onTouchEvent(event);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
	}

	// se ejecuta cuando SurfaceView esta listo para ser utilizado
	public void surfaceCreated(SurfaceHolder holder) {
		// si no está vivo
		if (!mThread.isAlive()) {
			mThread = new ViewThread(this);
			mThread.setRunning(true);
			// lanzo el hilo
			mThread.start();
		}
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		if (mThread.isAlive()) {
			mThread.setRunning(false);
		}
	}

}
