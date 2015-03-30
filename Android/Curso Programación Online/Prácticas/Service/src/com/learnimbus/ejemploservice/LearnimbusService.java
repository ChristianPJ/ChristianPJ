package com.learnimbus.ejemploservice;

import com.learnimbus.ejemploservice.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LearnimbusService extends Activity implements ActualizarServicioIUListener {
	
	TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        text = (TextView) findViewById(R.id.count);
                
        Button startButton = (Button) findViewById(R.id.start);
        
        startButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            	startServicio();
            }
          
        });
        
        Button stopButton = (Button) findViewById(R.id.stop);
        
        stopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            	stopServicio();
            }
          
        });
        
        MiServicio.setUpdateListener(this);
        
        
    }
    
    private void startServicio() {
    	Intent svc = new Intent(this, MiServicio.class);
        startService(svc);
    }
    
    private void stopServicio() {
    	Intent svc = new Intent(this, MiServicio.class);
		stopService(svc);
    }
    

	public void actualizar(int count) {
		text.setText("Contador: " + count);
	} 
}





