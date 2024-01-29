package com.example.scorekeeper;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class ViewResults extends AppCompatActivity {
    // creating objects of the text view
    TextView tvTeamA, tvTeamB, tvScoreA, tvScoreB, tvWin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);
// assigning the views to the object
        tvTeamA = findViewById(R.id.textView8);
        tvTeamB = findViewById(R.id.textView9);
        tvWin = findViewById(R.id.textView14);
        tvScoreA = findViewById(R.id.textView12);
        tvScoreB = findViewById(R.id.textView13);
// fetching the data from the bundle
        Bundle bundle = getIntent().getExtras();
        String text1 = bundle.getString("Team A");
        String text2 = bundle.getString("Team B");
        String text3 = bundle.getString("Score A");
        String text4 = bundle.getString("Score B");
// setting the fetched data to the corresponding text views
        tvTeamA.setText(text1);
        tvTeamB.setText(text2);
        tvScoreA.setText(text3 + "points");
        tvScoreB.setText(text4+ "points");
// converting string to int
        int i = Integer.parseInt(text3);
        int j = Integer.parseInt(text4);
// if the score of team A is greater than team B, team A wins
        if (i > j) {
            tvWin.setText(text1 + "Wins !!!");
        }
// if the score of team B is greater than team A, team B wins
        else if (j > i) {
            tvWin.setText(text2+ "Wins !!!");
        }
// if they have the same score, its a draw
        else if (j == i) {
            tvWin.setText("Its A Draw!!!");
        }
    }
    // to go back to the initial activity where you input the names of the teams
    public void playAgain(View view) {
// creating an intent object and passing the new activity to navigate to
        Intent i = new Intent(ViewResults.this, MainActivity.class);
        startActivity(i);
    }
}
