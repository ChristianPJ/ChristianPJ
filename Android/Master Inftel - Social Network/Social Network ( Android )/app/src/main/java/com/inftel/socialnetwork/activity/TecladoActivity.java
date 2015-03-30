package com.inftel.socialnetwork.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.inftel.socialnetwork.R;

public class TecladoActivity extends ActionBarActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado);

        String txt = getIntent().getStringExtra("string");
        editText = (EditText) findViewById(R.id.txtTeclado);
        editText.setText(txt);
    }

    public void ClickSend(View view) {

        Intent intentLocal = new Intent();
        intentLocal.putExtra("string", editText.getText().toString());
        setResult(RESULT_OK ,intentLocal);
        finish();
    }


    public void ClickQ(View view) {
        editText.setText(editText.getText()+ "Q");
    }

    public void ClickW(View view) {
        editText.setText(editText.getText()+ "W");
    }

    public void ClickE(View view) {
        editText.setText(editText.getText()+ "E");
    }

    public void ClickR(View view) {
        editText.setText(editText.getText()+ "R");
    }

    public void ClickT(View view) {
        editText.setText(editText.getText()+ "T");
    }

    public void ClickY(View view) {
        editText.setText(editText.getText()+ "Y");
    }

    public void ClickU(View view) {
        editText.setText(editText.getText()+ "U");
    }

    public void ClickI(View view) {
        editText.setText(editText.getText()+ "I");
    }

    public void ClickO(View view) {
        editText.setText(editText.getText()+ "O");
    }

    public void ClickA(View view) {
        editText.setText(editText.getText()+ "A");
    }

    public void ClickP(View view) {
        editText.setText(editText.getText()+ "P");
    }

    public void ClickS(View view) {
        editText.setText(editText.getText()+ "S");
    }

    public void ClickD(View view) {
        editText.setText(editText.getText()+ "D");
    }

    public void ClickF(View view) {
        editText.setText(editText.getText()+ "F");
    }

    public void ClickG(View view) {
        editText.setText(editText.getText()+ "G");
    }

    public void ClickH(View view) {
        editText.setText(editText.getText()+ "H");
    }

    public void ClickJ(View view) {
        editText.setText(editText.getText()+ "J");
    }

    public void ClickK(View view) {
        editText.setText(editText.getText()+ "K");
    }

    public void ClickL(View view) {
        editText.setText(editText.getText()+ "L");
    }

    public void ClickÑ(View view) {
        editText.setText(editText.getText()+ "Ñ");
    }

    public void ClickZ(View view) {
        editText.setText(editText.getText()+ "Z");
    }

    public void ClickX(View view) {
        editText.setText(editText.getText()+ "X");
    }

    public void ClickC(View view) {
        editText.setText(editText.getText()+ "C");
    }

    public void ClickV(View view) {
        editText.setText(editText.getText()+ "V");
    }

    public void ClickB(View view) {
        editText.setText(editText.getText()+ "B");
    }

    public void ClickN(View view) {
        editText.setText(editText.getText()+ "N");
    }

    public void ClickM(View view) {
        editText.setText(editText.getText()+ "M");
    }

    public void Click1(View view) {
        editText.setText(editText.getText()+ "1");
    }

    public void Click2(View view) {
        editText.setText(editText.getText()+ "2");
    }

    public void Click3(View view) {
        editText.setText(editText.getText()+ "3");
    }

    public void Click4(View view) {
        editText.setText(editText.getText()+ "4");
    }

    public void Click5(View view) {
        editText.setText(editText.getText()+ "5");
    }

    public void Click6(View view) {
        editText.setText(editText.getText()+ "6");
    }

    public void Click7(View view) {
        editText.setText(editText.getText()+ "7");
    }

    public void Click8(View view) {
        editText.setText(editText.getText()+ "8");
    }

    public void Click9(View view) {
        editText.setText(editText.getText()+ "9");
    }

    public void Click0(View view) {
        editText.setText(editText.getText()+ "0");
    }

    public void ClickComa(View view) {
        editText.setText(editText.getText()+ ",");
    }

    public void ClickPoint(View view) {
        editText.setText(editText.getText()+ ".");
    }

    public void ClickArroba(View view) {
        editText.setText(editText.getText()+ "@");
    }

    public void ClickSpace(View view) {
        editText.setText(editText.getText()+ " ");
    }

    public void ClickInterrogation(View view) {
        editText.setText(editText.getText()+ "?");
    }

    public void ClickDelete(View view) {
        String text = editText.getText().toString();
        if (text.length() == 0) {
            return;
        }
        editText.setText(text.substring(0, text.length() - 1));
    }

    public void ClickBarra(View view) {
        editText.setText(editText.getText()+ "_");
    }

    public void ClickEnter(View view) {
        editText.setText(editText.getText()+ ""+'\n');
    }

}
