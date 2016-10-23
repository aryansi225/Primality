package com.example.android.primality;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton, mNextButton, mFalseButton;
    private TextView mQuestionTextView;
    boolean v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button) findViewById(R.id.trueButton);
        mFalseButton = (Button) findViewById(R.id.falseButton);
        mNextButton = (Button) findViewById(R.id.nextButton);
        mQuestionTextView = (TextView) findViewById(R.id.questionTV);
        updateQuestion();
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
    }
    private void updateQuestion(){
        PrimeChecker p = new PrimeChecker();
        mQuestionTextView.setText(Integer.toString(p.getQuestion()));
        v = p.getValue();
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerisTrue = v;
        int messageId = 0;
        if(answerisTrue == userPressedTrue)
        {
            messageId = R.string.correct_toast;
        }
        else {
            messageId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

}
