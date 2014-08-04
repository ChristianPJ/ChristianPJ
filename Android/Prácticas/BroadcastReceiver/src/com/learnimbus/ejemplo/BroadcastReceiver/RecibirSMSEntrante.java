package com.learnimbus.ejemplo.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class RecibirSMSEntrante extends BroadcastReceiver {
	private final static String LOGTAG = "RecibirSMSEntrante";
	
	@Override
	 public void onReceive(Context context, Intent intent) {
	  Log.d(LOGTAG, "SMS recibido");
	  Bundle bundle = intent.getExtras();
	  if (bundle != null) {
	   Object[] pdus = (Object[]) bundle.get("pdus");
	
	final SmsMessage[] messages = new SmsMessage[pdus.length];
	   for (int i = 0; i < pdus.length; i++) {
	    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
	    
	    String idMensaje = messages[i].getOriginatingAddress();
	    String textoMensaje = messages[i].getMessageBody();
	    
	    Log.d(LOGTAG, "Mensaje recibido: id="+idMensaje+" texto="+textoMensaje);
	    
	   }
	  }
	 }
}
