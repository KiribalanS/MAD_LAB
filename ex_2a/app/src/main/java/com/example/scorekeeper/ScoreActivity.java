package com.example.scorekeeper;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ScoreActivity extends AppCompatActivity {
    // creating an object of the text view
    TextView scoreA, scoreB, tvA, tvB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
// assigning the outputs of the user to the object
        scoreA = (TextView) findViewById(R.id.scoreA);
        scoreB = (TextView) findViewById(R.id.scoreB);
        tvA = (TextView) findViewById(R.id.nameA);
        tvB = (TextView) findViewById(R.id.nameB);
// fetching the data from the bundle
        Bundle bundle = getIntent().getExtras();
        String text1 = bundle.getString("Team A");
        String text2 = bundle.getString("Team B");
// setting the fetched data to the corresponding text views
        tvA.setText(text1);
        tvB.setText(text2);
    }
    // this method is the logic that increases the value in the text view by one on every click for team a
    public void countScoreA(View view) {
// get current string
        String score = scoreA.getText().toString();
// converts string to int
        int i = Integer.parseInt(score);
//increment
        i++;
// convert int to string
        String a = new Integer(i).toString();
// sets the score to the corresponding text view
        if (i < 10) {
            scoreA.setText("0"+a);
        }
        else {
            scoreA.setText(a);
        }
    }
    // this method is the logic that increases the value in the text view by one on every click for team B;
    public void countScoreB(View view) {
// get current string
        String score = scoreB.getText().toString();
// converts string to int
        int i = Integer.parseInt(score);
//increment
        i++;
// convert int to string
        String a = new Integer(i).toString();
// sets the score to the corresponding text view
        if (i < 10) {
            scoreB.setText("0"+a);
        }
        else {
            scoreB.setText(a);
        }
    }
    // this method clears the current score and returns it to 0
    public void startAllOver(View view) {
        scoreA.setText("00");
        scoreB.setText("00");
    }
    // this method gets the names and scores of the two teams and passes them to the next bundle.
 public void viewResults(View view) {
// saving the names and scores to strings
        String nameA = tvA.getText().toString();
        String nameB = tvB.getText().toString();
        String score = scoreA.getText().toString();
        String score1 = scoreB.getText().toString();
// creating an intent object and passing the new activity to navigate to
        Intent i = new Intent(ScoreActivity.this, ViewResults.class);
// creating an object of bundle
        Bundle bundle = new Bundle();
// putting the data into the bundle
        bundle.putString("Team A", nameA);
        bundle.putString("Team B", nameB);
        bundle.putString("Score A", score);
        bundle.putString("Score B", score1);
        i.putExtras(bundle);
// starting the activity
        startActivity(i);
    }
}