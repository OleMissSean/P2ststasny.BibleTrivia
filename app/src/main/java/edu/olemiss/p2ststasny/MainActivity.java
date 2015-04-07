package edu.olemiss.p2ststasny;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity
{
    int code1 = 1;
    int code2 = 2;
    Integer bible_oldScore = 0;
    Integer bible_score = 0;
    Integer bible_tmpScore = 0;
    Integer bible_oldTimesPlayed = 0;
    Integer bible_timesPlayed = 0;
    Integer bible_tmpTimesPlayed = 0;
    Integer cal_oldScore = 0;
    Integer cal_score = 0;
    Integer cal_tmpScore = 0;
    Integer cal_oldTimesPlayed = 0;
    Integer cal_timesPlayed = 0;
    Integer cal_tmpTimesPlayed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button B_bibleButton = (Button) findViewById(R.id.B_bibleButton);
            B_bibleButton.setOnClickListener(bibleListener);
        Button B_calButton = (Button) findViewById(R.id.B_calButton);
            B_calButton.setOnClickListener(calListener);
        Button B_resetCalScore = (Button) findViewById(R.id.B_resetCalScore);
            B_resetCalScore.setOnClickListener(resetCalScoreListener);
        Button B_resetBibleScore = (Button) findViewById(R.id.B_resetBibleScore);
            B_resetBibleScore.setOnClickListener(resetBibleScoreListener);
    }

    public OnClickListener bibleListener = new OnClickListener()
    {
        public void onClick(View v)
        {
            Intent i1 = new Intent("edu.olemiss.bibleTriviaActivity");
//            startActivity(i);
            startActivityForResult(i1, code1);
        }
    };

    public OnClickListener resetCalScoreListener = new OnClickListener()
    {
        public void onClick(View v)
        {
            zeroOutCal();
            TextView TV_displayCalScore = (TextView) findViewById(R.id.ET_calAnswer);
            String calScore = "0 out of 0";
            TV_displayCalScore.setText(calScore);
            String forToast = "Date Converter Score Reset: \n0 out of 0";
            showToast(forToast);
        }
    };

    public OnClickListener resetBibleScoreListener = new OnClickListener()
    {
        public void onClick(View v)
        {
            zeroOutBible();
            TextView TV_displayBibleScore = (TextView) findViewById(R.id.TV_displayBibleScore);
            String calScore = "0 out of 0";
            TV_displayBibleScore.setText(calScore);
            String forToast = "Date Converter Score Reset: \n0 out of 0";
            showToast(forToast);
        }
    };

    public OnClickListener calListener = new OnClickListener()
    {
        public void onClick(View v)
        {
            Intent i2 = new Intent("edu.olemiss.calenderConverterActivity");
//            startActivity(i);
            startActivityForResult(i2, code2);
        }
    };

    public void zeroOutCal()
    {
        cal_tmpScore = 0;
        cal_oldScore = 0;
        cal_score = 0;
        cal_tmpTimesPlayed = 0;
        cal_oldTimesPlayed = 0;
        cal_timesPlayed = 0;
    }

    public void zeroOutBible()
    {
        bible_tmpScore = 0;
        bible_oldScore = 0;
        bible_score = 0;
        bible_tmpTimesPlayed = 0;
        bible_oldTimesPlayed = 0;
        bible_timesPlayed = 0;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == code2)
        {
            if(resultCode == RESULT_OK)
            {
                Bundle bundle = data.getExtras();
                cal_tmpScore = bundle.getInt("score");
                cal_score = calScoreFix(cal_tmpScore);
                cal_tmpTimesPlayed = bundle.getInt("timesPlayed");
                cal_timesPlayed = calTimesPlayedFix(cal_tmpTimesPlayed);
                TextView TV_displayCalScore = (TextView) findViewById(R.id.ET_calAnswer);
                String calScore = cal_score + " out of " + cal_timesPlayed;
                TV_displayCalScore.setText(calScore);
                String forToast = "Score: " + cal_score + ". " + "Times Played: " + cal_timesPlayed + ".";
                showToast(forToast);
                cal_oldScore = cal_score;
                cal_oldTimesPlayed = cal_timesPlayed;
            }
        }
        else if(requestCode == code1)
        {
            if(resultCode == RESULT_OK)
            {
                Bundle bundle = data.getExtras();
                bible_tmpScore = bundle.getInt("score");
                bible_score = bibleScoreFix(bible_tmpScore);
                bible_tmpTimesPlayed = bundle.getInt("timesPlayed");
                bible_timesPlayed = bibleTimesPlayedFix(bible_tmpTimesPlayed);
                TextView TV_displayBibleScore = (TextView) findViewById(R.id.TV_displayBibleScore);
                String bibleScore = bible_score + " out of " + bible_timesPlayed;
                TV_displayBibleScore.setText(bibleScore);
                String forToast = "Score: " + bible_score + ". " + "Times Played: " + bible_timesPlayed + ".";
                showToast(forToast);
                bible_oldScore = bible_score;
                bible_oldTimesPlayed = bible_timesPlayed;
            }
        }
    }

    public Integer bibleScoreFix(Integer bible_tmpScore)
    {
        Integer bible_returnScore = bible_tmpScore + bible_oldScore;
        return bible_returnScore;
    }

    public Integer bibleTimesPlayedFix(Integer bible_tmpTimesPlayed)
    {
        Integer bible_returnTimesPlayed = bible_tmpTimesPlayed + bible_timesPlayed;
        return bible_returnTimesPlayed;
    }

    public Integer calScoreFix(Integer bible_tmpScore)
    {
        Integer cal_returnScore = cal_tmpScore + cal_oldScore;
        return cal_returnScore;
    }

    public Integer calTimesPlayedFix(Integer cal_tmpTimesPlayed)
    {
        Integer cal_returnTimesPlayed = cal_tmpTimesPlayed + cal_timesPlayed;
        return cal_returnTimesPlayed;
    }

    public void showToast(String str)
    {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
