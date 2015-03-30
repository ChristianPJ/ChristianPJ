package com.inftel.museoinftel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.inftel.museoinftel.R;

public class ResultQuizActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_result);

        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(1f);

        TextView t=(TextView)findViewById(R.id.textResult);

        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        bar.setRating(score);

        switch (score)
        {
            case 0:
            case 1:
                t.setText("Ignorante");
                break;
            case 2:
                t.setText("Aprendiz");
                break;
            case 3:
            case 4: t.setText("Experto");
                break;
            case 5: t.setText("Erudito");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }


}
