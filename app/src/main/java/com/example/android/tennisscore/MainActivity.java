package com.example.android.tennisscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    String scoreTeamA = "";
    String scoreTeamB = "";
    String scoreAB = "";
    String serverAB = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA("");
        displayForTeamB("");
        displayAB("Love All");
        serverAB = "A";
    }

    /**
     * Toggle button is used to determine team serving also serving as reset button
     */
    public void changeTeam(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            serverAB = "A";
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Love All";
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            displayAB(scoreAB);
        } else {
            serverAB = "B";
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Love All";
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            displayAB(scoreAB);
        }
    }


    /**
     * Displays the given score for Teams A and B and who is serving
     */
    public void displayForTeamA(String score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(String score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayAB(String score) {
        TextView scoreView = findViewById(R.id.teams_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method is called when added points button for Team A is clicked.
     */
    public void addTeamA(View view) {
        if (
                (("Love All".equals(scoreAB)) && (scoreTeamA.equals("")))
                        || ((scoreAB.isEmpty()) && (scoreTeamA.equals("")))
                        || ((scoreAB.isEmpty()) && (scoreTeamA.equals("0")))) {
            scoreTeamA = "15";
            scoreAB = "";
            if ("".equals(scoreTeamB)) {
                scoreTeamB = "0";
            }
        } else if (scoreTeamA.equals("15")) {
            scoreTeamA = "30";
        } else if ((scoreTeamA.equals("30")) && (!"40".equals(scoreTeamB))) {
            scoreTeamA = "40";
        } else if ((scoreTeamA.equals("40")) && (!"40".equals(scoreTeamB))) {
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Game A!";
        } else if ((scoreTeamA.equals("30")) && ((scoreTeamB.equals("40")))) {
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Deuce";
        }
        //score is Deuce
        else if (scoreAB.equals("Deuce")) {
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Ad-In A";
        } else if (scoreAB.equals("Ad-In A")) {
            scoreAB = "Game A!";
        } else if (scoreAB.equals("Ad-In B")) {
            scoreAB = "Deuce";
        }
        //reset game
        else if ((scoreAB.equals("Game A!")) || (scoreAB.equals("Game B!"))) {
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Love All";
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAB(scoreAB);
    }


    /**
     * This method is called when added points button for Team B is clicked.
     */
    public void addTeamB(View view) {
        if (
                (("Love All".equals(scoreAB)) && (scoreTeamB.equals("")))
                        || ((scoreAB.isEmpty()) && (scoreTeamB.equals("")))
                        || ((scoreAB.isEmpty()) && (scoreTeamB.equals("0")))) {
            scoreTeamB = "15";
            scoreAB = "";
            if ("".equals(scoreTeamA)) {
                scoreTeamA = "0";
            }
        } else if (scoreTeamB.equals("15")) {
            scoreTeamB = "30";
        } else if ((scoreTeamB.equals("30")) && (!"40".equals(scoreTeamA))) {
            scoreTeamB = "40";
        } else if ((scoreTeamB.equals("40")) && (!"40".equals(scoreTeamA))) {
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Game B!";
        } else if ((scoreTeamB.equals("30")) && ((scoreTeamA.equals("40")))) {
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Deuce";
        }
        //score is Deuce
        else if (scoreAB.equals("Deuce")) {
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Ad-In B";
        } else if (scoreAB.equals("Ad-In B")) {
            scoreAB = "Game B!";
        } else if (scoreAB.equals("Ad-In A")) {
            scoreAB = "Deuce";
        } else if ((scoreAB.equals("Game B!")) || (scoreAB.equals("Game A!"))) {
            scoreTeamA = "";
            scoreTeamB = "";
            scoreAB = "Love All";
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayAB(scoreAB);
    }

}
