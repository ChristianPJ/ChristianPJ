package com.learnimbus.ejemplo.Imagen;

import com.learnimbus.ejemplo.Grafico.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Imagen extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//mostramos nuestra ventana sin mostrar ningun titulo
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(new Panel(this));
	}

	public class Panel extends View {

		private Bitmap mBitmap;

		public Panel(Context context) {
			super(context);
			mBitmap = BitmapFactory.decodeResource(getResources(),
					R.drawable.learnimbus);
		}

		@Override
		public void onDraw(Canvas canvas) {
			canvas.drawColor(Color.BLACK);
			canvas.drawBitmap(mBitmap, 20, 20, null);
		}
	}
}