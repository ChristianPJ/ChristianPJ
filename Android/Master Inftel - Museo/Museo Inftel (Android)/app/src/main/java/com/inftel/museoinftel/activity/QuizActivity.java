package com.inftel.museoinftel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.inftel.museoinftel.utility.DbQuiz;
import com.inftel.museoinftel.R;
import com.inftel.museoinftel.entity.Pregunta;

import java.util.List;

public class QuizActivity extends Activity {
	private List<Pregunta> quesList;
    private int score;
    private int qid;
    private Pregunta currentQ;
    private TextView txtQuestion;
    private RadioButton rda, rdb, rdc;
    private Button butNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_quiz);

        score=0;
        qid=0;

        DbQuiz db=new DbQuiz();
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                }
                if(qid<5){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else {
                    Intent intent = new Intent(getApplication(), ResultQuizActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            }
        });

    }

	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		qid++;
	}
}
