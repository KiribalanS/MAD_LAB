package com.example.scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // creating an object of the edit text
    EditText edteamA, edteamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// assigning the input of the user to the object
        edteamA = findViewById(R.id.teamNameA);
        edteamB = findViewById(R.id.teamNameB);
    }
// this method gets the names of the two teams and passes them to the next activity using a
        public void getDetails(View view) {
// saving the inputs to a string
        String nameA = edteamA.getText().toString();
        String nameB = edteamB.getText().toString();
// creating an object of Intent to move to the next activity. // In case a red line is shown, click on the text and press Alt + Enter to import the class.

            Intent i = new Intent(MainActivity.this, ScoreActivity.class);
// creating an object of bundle
        Bundle bundle = new Bundle();
// putting the inputs into the bundle
        bundle.putString("Team A", nameA);
        bundle.putString("Team B", nameB);
        i.putExtras(bundle);
// starting the activity
        startActivity(i);
    }
}