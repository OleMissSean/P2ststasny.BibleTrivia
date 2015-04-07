package edu.olemiss.p2ststasny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Sean Staz on 2/21/2015.
 */
public class calenderConverterActivity extends Activity
{
    int year1 = 0;
    int year2 = 0;
    int yearAnswer = 0;
    Integer score = 0;
    Integer timesPlayed = 0;
    TextView TV_calQuestion;
    EditText ET_calAnswer;
    Button B_calQsubmit;
    Button B_calReturn;
//    boolean isNotFirstFocus = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_activity);

        B_calQsubmit = (Button) findViewById(R.id.B_calQsubmit);
            B_calQsubmit.setOnClickListener(calCheckListener);
        B_calReturn = (Button) findViewById(R.id.B_calReturn);
            B_calReturn.setOnClickListener(calReturnListener);
        ET_calAnswer = (EditText) findViewById(R.id.ET_calAnswer);

        ET_calAnswer = (EditText) findViewById(R.id.ET_calAnswer);

        generateQuestion();

//        ET_calAnswer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus && isNotFirstFocus)
//                {
//                    ET_calAnswer.setText("");
//                    isNotFirstFocus = true;
//                }
//            }
//        });
    }

    public void generateQuestion()
    {
        Random r = new Random();
        year1 = (r.nextInt(4001 - 2000) + 2000);
        year2 = (r.nextInt(2001));
        yearAnswer = year1 - year2;
        String yearQuestion = year1 + " - " + year2;
        TV_calQuestion = (TextView) findViewById(R.id.TV_calQuestion);
        TV_calQuestion.setText(yearQuestion);
    }

    public void showToast(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public View.OnClickListener calReturnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent iData = new Intent();
            iData.putExtra("score", score);
            iData.putExtra("timesPlayed", timesPlayed);
            setResult(RESULT_OK, iData);
            finish();
        }
    };


    public View.OnClickListener calCheckListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            ET_calAnswer = (EditText) findViewById(R.id.ET_calAnswer);
            String strAns = ET_calAnswer.getText().toString();
//            if(strAns == null)
//            {
//                String msg = "No year found. Generating new question.";
//                showToast(msg);
//                generateQuestion();
//            }

            int ans = Integer.parseInt(ET_calAnswer.getText().toString());
            String review = "";

            if(ans == yearAnswer)
            {
                review = "Correct!";
                score++;
                timesPlayed++;
            }
            else
            {
                review = "Wrong answer";
                timesPlayed++;
            }
            showToast(review);
            ET_calAnswer.setText("");
            generateQuestion();
        }
    };
}
