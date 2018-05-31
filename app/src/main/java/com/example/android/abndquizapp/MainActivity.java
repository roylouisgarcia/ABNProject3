package com.example.android.abndquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked
     *
     * @param view
     */
    public void submitAnswer(View view) {


        // Figure out if the user wants the results to be emailed or shown in the app
        CheckBox willEmailCB = (CheckBox) findViewById(R.id.sendEmail);
        boolean willEmail = willEmailCB.isChecked();

        // TextView to contain the score and feedback
        TextView scoreBoard = (TextView) findViewById(R.id.scoreBoard);

        // Aggregated string that will be show the scores via email or in the app
        String scoreInfo = "Feedback: \n";

        // Checks if the answer for Question 1 is correct which is C
        RadioButton answer1 = (RadioButton) findViewById(R.id.answerOneC);
        if (answer1.isChecked()) {
            scoreInfo += "\nAnswer # 1 is correct.";
            score += 1;
        } else {
            scoreInfo += "\nAnswer # 1 is incorrect\n\t- The correct answer is a D major.";
        }

        // Checks if the answer for Question 2 is correct which is B
        RadioButton answer2 = (RadioButton) findViewById(R.id.answerTwoB);
        if (answer2.isChecked()) {
            score += 1;
            scoreInfo += "\nAnswer # 2 is correct.";
        } else {
            scoreInfo += "\nAnswer # 2 is incorrect\n\t- The correct answer is a minor chord.";
        }

        // Checks if the answer for Question 3 is correct which is D
        RadioButton answer3 = (RadioButton) findViewById(R.id.answerThreeD);
        if (answer3.isChecked()) {
            score += 1;
            scoreInfo += "\nAnswer # 3 is correct.";
        } else {
            scoreInfo += "\nAnswer # 3 is incorrect\n\t- The correct answer is a capo.";
        }

        // Checks if the answer for Question 4 is correct which is B
        RadioButton answer4 = (RadioButton) findViewById(R.id.answerFourB);
        if (answer4.isChecked()) {
            score += 1;
            scoreInfo += "\nAnswer # 4 is correct.";
        } else {
            scoreInfo += "\nAnswer # 4 is incorrect\n\t- The correct answer is an E minor.";
        }

        // Checks if the answer for Question 5 is correct which is Slash, or SLASH, or SLaSh - toLowerCase takes care of the variations
        EditText answer5 = (EditText) findViewById(R.id.answerEditText);
        // Per Udacity reviewer's suggestions, trim() is used to get rid of extra white spaces

        String answer5Value = answer5.getText().toString().trim();

        if (answer5Value.equalsIgnoreCase("slash")) {
            score += 1;
            scoreInfo += "\nAnswer # 5 is correct\n\t- Slash is indeed the lead guitarist for GNR.";

        } else {
            scoreInfo += "\nAnswer # 5 is incorrect\n\t- Slash is the lead guitarist for GNR and not " + answer5Value + ".";
        }



        //checks if the right 3 out of 24 possible checkboxes are toggled on
        CheckBox fret1string1 = (CheckBox) findViewById(R.id.fret1string1);
        CheckBox fret1string2 = (CheckBox) findViewById(R.id.fret1string2);
        CheckBox fret1string3 = (CheckBox) findViewById(R.id.fret1string3);
        CheckBox fret1string4 = (CheckBox) findViewById(R.id.fret1string4);
        CheckBox fret1string5 = (CheckBox) findViewById(R.id.fret1string5);
        CheckBox fret1string6 = (CheckBox) findViewById(R.id.fret1string6);
        CheckBox fret2string1 = (CheckBox) findViewById(R.id.fret2string1);
        CheckBox fret2string2 = (CheckBox) findViewById(R.id.fret2string2);
        CheckBox fret2string3 = (CheckBox) findViewById(R.id.fret2string3);
        CheckBox fret2string4 = (CheckBox) findViewById(R.id.fret2string4);
        CheckBox fret2string5 = (CheckBox) findViewById(R.id.fret2string5);
        CheckBox fret2string6 = (CheckBox) findViewById(R.id.fret2string6);
        CheckBox fret3string1 = (CheckBox) findViewById(R.id.fret3string1);
        CheckBox fret3string2 = (CheckBox) findViewById(R.id.fret3string2);
        CheckBox fret3string3 = (CheckBox) findViewById(R.id.fret3string3);
        CheckBox fret3string4 = (CheckBox) findViewById(R.id.fret3string4);
        CheckBox fret3string5 = (CheckBox) findViewById(R.id.fret3string5);
        CheckBox fret3string6 = (CheckBox) findViewById(R.id.fret3string6);
        CheckBox fret4string1 = (CheckBox) findViewById(R.id.fret4string1);
        CheckBox fret4string2 = (CheckBox) findViewById(R.id.fret4string2);
        CheckBox fret4string3 = (CheckBox) findViewById(R.id.fret4string3);
        CheckBox fret4string4 = (CheckBox) findViewById(R.id.fret4string4);
        CheckBox fret4string5 = (CheckBox) findViewById(R.id.fret4string5);
        CheckBox fret4string6 = (CheckBox) findViewById(R.id.fret4string6);

        if (!fret1string1.isChecked() && !fret1string2.isChecked() &&
                !fret1string3.isChecked() &&
                !fret1string4.isChecked() &&
                !fret1string5.isChecked() &&
                !fret1string6.isChecked() &&
                !fret2string1.isChecked() &&
                fret2string2.isChecked() && //<--- should be toggled on
                !fret2string3.isChecked() &&
                !fret2string4.isChecked() &&
                !fret2string5.isChecked() &&
                !fret2string6.isChecked() &&
                fret3string1.isChecked() && //<--- should be toggled on
                !fret3string2.isChecked() &&
                !fret3string3.isChecked() &&
                !fret3string4.isChecked() &&
                !fret3string5.isChecked() &&
                fret3string6.isChecked() && //<--- should be toggled on
                !fret4string1.isChecked() &&
                !fret4string2.isChecked() &&
                !fret4string3.isChecked() &&
                !fret4string4.isChecked() &&
                !fret4string5.isChecked() &&
                !fret4string6.isChecked()) {
            score += 1;
            scoreInfo += "\nAnswer # 6 is correct\n\t- That is a G Major chord!.";
        } else {
            scoreInfo += "\nAnswer # 6 is incorrect\n\t- That is not the answer I am looking for.";
        }

        scoreInfo += "\n\nTotal Score is " + score + "/6.";

        // Checks if the results should be emailed or not

        String toastSubmitText = "";

        if (willEmail == true) {
            scoreBoard.setText("Your score and feedback will be emailed.");
            toastSubmitText += "Your score is " + score + "/6. Email App is opening.";
            composeEmail("Guitar Quiz App Results", scoreInfo);
        } else {
            scoreBoard.setText(scoreInfo);
            toastSubmitText += "Your score is " + score + "/6.";
        }
        score = 0;

        // displays the toast at the center vertical
        Toast toastSubmit = Toast.makeText(this, toastSubmitText, Toast.LENGTH_LONG);
        toastSubmit.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toastSubmit.show();


    }

    /**
     * This method passes the parameters to an email intent
     *
     * @param subject
     * @param scoreInformation
     */
    private void composeEmail(String subject, String scoreInformation) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, scoreInformation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method resets all the answers to unchecked and blank
     *
     * @param view
     */
    public void resetQuiz(View view) {
        score = 0;

        CheckBox willEmailCB = (CheckBox) findViewById(R.id.sendEmail);
        willEmailCB.setChecked(false);

        TextView scoreInformation = (TextView) findViewById(R.id.scoreBoard);
        Toast resetToast = Toast.makeText(this, "Quiz Reset Successful!", Toast.LENGTH_SHORT);
        resetToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        resetToast.show();

        //Reset buttons for question 1
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.question1);
        radioGroup1.clearCheck();
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.question2);
        radioGroup2.clearCheck();
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.question3);
        radioGroup3.clearCheck();
        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.question4);
        radioGroup4.clearCheck();

        //Reset checkboxes on the first fret of the guitar
        CheckBox fret1string1 = (CheckBox) findViewById(R.id.fret1string1);
        fret1string1.setChecked(false);
        CheckBox fret1string2 = (CheckBox) findViewById(R.id.fret1string2);
        fret1string2.setChecked(false);
        CheckBox fret1string3 = (CheckBox) findViewById(R.id.fret1string3);
        fret1string3.setChecked(false);
        CheckBox fret1string4 = (CheckBox) findViewById(R.id.fret1string4);
        fret1string4.setChecked(false);
        CheckBox fret1string5 = (CheckBox) findViewById(R.id.fret1string5);
        fret1string5.setChecked(false);
        CheckBox fret1string6 = (CheckBox) findViewById(R.id.fret1string6);
        fret1string6.setChecked(false);

        //Reset checkboxes on the second fret of the guitar
        CheckBox fret2string1 = (CheckBox) findViewById(R.id.fret2string1);
        fret2string1.setChecked(false);
        CheckBox fret2string2 = (CheckBox) findViewById(R.id.fret2string2);
        fret2string2.setChecked(false);
        CheckBox fret2string3 = (CheckBox) findViewById(R.id.fret2string3);
        fret2string3.setChecked(false);
        CheckBox fret2string4 = (CheckBox) findViewById(R.id.fret2string4);
        fret2string4.setChecked(false);
        CheckBox fret2string5 = (CheckBox) findViewById(R.id.fret2string5);
        fret2string5.setChecked(false);
        CheckBox fret2string6 = (CheckBox) findViewById(R.id.fret2string6);
        fret2string6.setChecked(false);

        //Reset checkboxes on the third fret of the guitar
        CheckBox fret3string1 = (CheckBox) findViewById(R.id.fret3string1);
        fret3string1.setChecked(false);
        CheckBox fret3string2 = (CheckBox) findViewById(R.id.fret3string2);
        fret3string2.setChecked(false);
        CheckBox fret3string3 = (CheckBox) findViewById(R.id.fret3string3);
        fret3string3.setChecked(false);
        CheckBox fret3string4 = (CheckBox) findViewById(R.id.fret3string4);
        fret3string4.setChecked(false);
        CheckBox fret3string5 = (CheckBox) findViewById(R.id.fret3string5);
        fret3string5.setChecked(false);
        CheckBox fret3string6 = (CheckBox) findViewById(R.id.fret3string6);
        fret3string6.setChecked(false);

        //Reset checkboxes on the fourth fret of the guitar
        CheckBox fret4string1 = (CheckBox) findViewById(R.id.fret4string1);
        fret4string1.setChecked(false);
        CheckBox fret4string2 = (CheckBox) findViewById(R.id.fret4string2);
        fret4string2.setChecked(false);
        CheckBox fret4string3 = (CheckBox) findViewById(R.id.fret4string3);
        fret4string3.setChecked(false);
        CheckBox fret4string4 = (CheckBox) findViewById(R.id.fret4string4);
        fret4string4.setChecked(false);
        CheckBox fret4string5 = (CheckBox) findViewById(R.id.fret4string5);
        fret4string5.setChecked(false);
        CheckBox fret4string6 = (CheckBox) findViewById(R.id.fret4string6);
        fret4string6.setChecked(false);

        //Reset EditText to blank
        EditText answer5value = (EditText) findViewById(R.id.answerEditText);
        answer5value.setText("");

        //Reset the Scoreboard TextView
        TextView scoreboard = (TextView) findViewById(R.id.scoreBoard);
        scoreboard.setText("");


    }


}



