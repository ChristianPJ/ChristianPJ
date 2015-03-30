package com.learnimbus.ejemploservice;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class MiServicio extends Service {

	private Timer timer = new Timer();
	private static final long UPDATE_INTERVAL = 1000;
	public static ActualizarServicioIUListener UI_UPDATE_LISTENER;
	
	private int count = 0;
	
	public static void setUpdateListener(ActualizarServicioIUListener l) {
		UI_UPDATE_LISTENER = l;
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		_startServicio();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		_shutdownServicio();
	}
	
	private void _startServicio() {
		timer.scheduleAtFixedRate(
			new TimerTask() {
				public void run() {
					count++;
					handler.sendEmptyMessage(0);
				}
			},
			0,
			UPDATE_INTERVAL);
	}
	
	private void _shutdownServicio() {
		if (timer != null) timer.cancel();
	}
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			UI_UPDATE_LISTENER.actualizar(count);
		}
	};

}




