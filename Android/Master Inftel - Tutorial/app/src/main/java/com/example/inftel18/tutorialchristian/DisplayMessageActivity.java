package com.example.inftel18.tutorialchristian;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLOutput;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE); */


        /* Get values from Intent */
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String number2  = intent.getStringExtra("KEY_Number");

        System.out.println("Número2" + number2);

        EditText text1 = (EditText) findViewById(R.id.message);
        text1.setText(number2, TextView.BufferType.EDITABLE);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
