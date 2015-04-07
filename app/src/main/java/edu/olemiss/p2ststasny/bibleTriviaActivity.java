package edu.olemiss.p2ststasny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Sean Staz on 2/21/2015.
 */
public class bibleTriviaActivity extends Activity
{
    final int numOfQuestions = 20;
    int answer = 0;
    Integer score = 0;
    Integer timesPlayed = 0;
    TextView TV_bibleQuestion;
    Button B_bibleQsubmit;
    Button B_bibleReturn;
    RadioButton RB_answer1;
    RadioButton RB_answer2;
    RadioButton RB_answer3;
    RadioButton RB_answer4;
    RadioGroup RG_radio;
    RadioButton RB_rButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bibletrivia_activity);

        B_bibleQsubmit = (Button) findViewById(R.id.B_bibleQsubmit);
            B_bibleQsubmit.setOnClickListener(bibleCheckListener);
        B_bibleReturn = (Button) findViewById(R.id.B_bibleReturn);
            B_bibleReturn.setOnClickListener(bibleReturnListener);

        generateQuestion();
    }

    public void generateQuestion()
    {
        Random r = new Random();
        int questionNumber = (r.nextInt(numOfQuestions));
        String numForToast = "" + questionNumber;
//        showToast(numForToast);
        TV_bibleQuestion = (TextView) findViewById(R.id.TV_bibleQuestion);
        RB_answer1 = (RadioButton) findViewById(R.id.RB_answer1);
        RB_answer2 = (RadioButton) findViewById(R.id.RB_answer2);
        RB_answer3 = (RadioButton) findViewById(R.id.RB_answer3);
        RB_answer4 = (RadioButton) findViewById(R.id.RB_answer4);

        switch (questionNumber)
        {
            case 0:
                TV_bibleQuestion.setText("Who was Moses' great-grandfather?");
                RB_answer1.setText("Adam");
                RB_answer2.setText("Seth");
                RB_answer3.setText("Enoch");
                RB_answer4.setText("Enosh");

                answer = findViewById(R.id.RB_answer3).getId();
                break;
            case 1:
                TV_bibleQuestion.setText("How many horns and heads did the beast who rose out of the sea in Revelation have?");
                RB_answer1.setText("7; 10");
                RB_answer2.setText("10; 7");
                RB_answer3.setText("7; 12");
                RB_answer4.setText("12; 7");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 2:
                TV_bibleQuestion.setText("Which one of the following is NOT a Jewish group from the time of the New Testament?");
                RB_answer1.setText("The Sadducees");
                RB_answer2.setText("The Salemites");
                RB_answer3.setText("The Pharisees");
                RB_answer4.setText("The Essenes");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 3:
                TV_bibleQuestion.setText("How many clean and unclean animals did God command Noah to bring upon the ark?");
                RB_answer1.setText("2; 2");
                RB_answer2.setText("7; 7");
                RB_answer3.setText("2; 0");
                RB_answer4.setText("2, 7");

                answer = findViewById(R.id.RB_answer4).getId();
                break;
            case 4:
                TV_bibleQuestion.setText("How long did it God send rain on the earth during The Great Flood?");
                RB_answer1.setText("40 days and 40 nights");
                RB_answer2.setText("7 days and 7 nights");
                RB_answer3.setText("12 days and 12 nights");
                RB_answer4.setText("30 days and 30 nights");

                answer = findViewById(R.id.RB_answer1).getId();
                break;
            case 5:
                TV_bibleQuestion.setText("What sea did God part for Noah?");
                RB_answer1.setText("The Red Sea");
                RB_answer2.setText("The Dead Sea");
                RB_answer3.setText("The Yellow Sea");
                RB_answer4.setText("The Sea of Crete");

                answer = findViewById(R.id.RB_answer1).getId();
                break;
            case 6:
                TV_bibleQuestion.setText("What were the 10 Commandments stored in?");
                RB_answer1.setText("The Casing of God");
                RB_answer2.setText("The Ark of the Covenant");
                RB_answer3.setText("The Golden Case");
                RB_answer4.setText("The Holy Enclosure");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 7:
                TV_bibleQuestion.setText("What food did God send like dew upon the ground for the Israelites?");
                RB_answer1.setText("Apples");
                RB_answer2.setText("Rice");
                RB_answer3.setText("Manna");
                RB_answer4.setText("Fish");

                answer = findViewById(R.id.RB_answer3).getId();
                break;
            case 8:
                TV_bibleQuestion.setText("What are the first five books of The Bible Called?");
                RB_answer1.setText("The Book of Truth");
                RB_answer2.setText("The Torah");
                RB_answer3.setText("The Book of History");
                RB_answer4.setText("The Old Testament");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 9:
                TV_bibleQuestion.setText("Who is the last Prophet of the Old Testament.");
                RB_answer1.setText("Zechariah");
                RB_answer2.setText("Micah");
                RB_answer3.setText("Haggai");
                RB_answer4.setText("Malachi");

                answer = findViewById(R.id.RB_answer4).getId();
                break;
            case 10:
                TV_bibleQuestion.setText("Who was the woman who gave birth to Jesus.");
                RB_answer1.setText("Micah");
                RB_answer2.setText("Mary");
                RB_answer3.setText("Sarah");
                RB_answer4.setText("Martha");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 11:
                TV_bibleQuestion.setText("What mountain did God come down on, leaving the top charred?");
                RB_answer1.setText("Mt. Zion");
                RB_answer2.setText("Mt. Sinai");
                RB_answer3.setText("Mt. Carmel");
                RB_answer4.setText("Mt. Moriah");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 12:
                TV_bibleQuestion.setText("How many books are in The Canonical Bible?");
                RB_answer1.setText("52");
                RB_answer2.setText("66");
                RB_answer3.setText("56");
                RB_answer4.setText("72");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 13:
                TV_bibleQuestion.setText("What is the longest book of The Bible?");
                RB_answer1.setText("Psalms");
                RB_answer2.setText("Leviticus");
                RB_answer3.setText("Numbers");
                RB_answer4.setText("1 Kings");

                answer = findViewById(R.id.RB_answer1).getId();
                break;
            case 14:
                TV_bibleQuestion.setText("What is the shortest bok of The Bible");
                RB_answer1.setText("Ruth");
                RB_answer2.setText("1 John");
                RB_answer3.setText("3 John");
                RB_answer4.setText("1 Peter");

                answer = findViewById(R.id.RB_answer3).getId();
                break;
            case 15:
                TV_bibleQuestion.setText("When was the second temple in Jerusalem finally destroyed?");
                RB_answer1.setText("70 BC");
                RB_answer2.setText("77 AD");
                RB_answer3.setText("12 AD");
                RB_answer4.setText("107 AD");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 16:
                TV_bibleQuestion.setText("When was the construction on the first temple in Jerusalem completed?");
                RB_answer1.setText("987");
                RB_answer2.setText("1007 BC");
                RB_answer3.setText("877 BC");
                RB_answer4.setText("957 BC");

                answer = findViewById(R.id.RB_answer4).getId();
                break;
            case 17:
                TV_bibleQuestion.setText("When was the first temple in Jerusalem destroyed?");
                RB_answer1.setText("586 BC");
                RB_answer2.setText("567 BC");
                RB_answer3.setText("512 BC");
                RB_answer4.setText("467 BC");

                answer = findViewById(R.id.RB_answer1).getId();
                break;
            case 18:
                TV_bibleQuestion.setText("When was the construction on the second temple in Jerusalem completed?");
                RB_answer1.setText("777 BC");
                RB_answer2.setText("515 BC");
                RB_answer3.setText("557 BC");
                RB_answer4.setText("477 BC");

                answer = findViewById(R.id.RB_answer2).getId();
                break;
            case 19:
                TV_bibleQuestion.setText("Jesus was which of the following?");
                RB_answer1.setText("A miner");
                RB_answer2.setText("A hunter");
                RB_answer3.setText("A blacksmith");
                RB_answer4.setText("A carpenter");

                answer = findViewById(R.id.RB_answer1).getId();
                break;
        }
    }

    public void showToast(String str)
    {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public OnClickListener bibleReturnListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent iData = new Intent();
            iData.putExtra("score", score);
            iData.putExtra("timesPlayed", timesPlayed);
            setResult(RESULT_OK, iData);
            finish();
        }
    };


    public OnClickListener bibleCheckListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            RG_radio = (RadioGroup) findViewById(R.id.RG_radio);
            //Get selected radio button from the radio group
            int selectedID = RG_radio.getCheckedRadioButtonId();
            RB_rButton = (RadioButton) findViewById(selectedID);
            String selectedStr = RB_rButton.getText() + "";
            String review = "";
            if(selectedID == answer)
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
            generateQuestion();
        }
    };

//    public OnClickListener myListener = new OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent iData = new Intent();
//            setResult(RESULT_OK, iData);
//            finish();
//        }
//    };
}
