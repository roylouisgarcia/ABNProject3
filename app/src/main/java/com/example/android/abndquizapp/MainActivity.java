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
        if (answer1.isChecked()){
            scoreInfo += "\nAnswer # 1 is correct.";
            score += 1;
        }else{
            scoreInfo += "\nAnswer # 1 is incorrect\n\t- The correct answer is a D major.";
        }

        // Checks if the answer for Question 2 is correct which is B
        RadioButton answer2 = (RadioButton) findViewById(R.id.answerTwoB);
        if (answer2.isChecked()){
            score += 1;
            scoreInfo += "\nAnswer # 2 is correct.";
        }else{
            scoreInfo += "\nAnswer # 2 is incorrect\n\t- The correct answer is a minor chord.";
        }

        // Checks if the answer for Question 3 is correct which is D
        RadioButton answer3 = (RadioButton) findViewById(R.id.answerThreeD);
        if (answer3.isChecked()){
            score += 1;
            scoreInfo += "\nAnswer # 3 is correct.";
        }else{
            scoreInfo += "\nAnswer # 3 is incorrect\n\t- The correct answer is a capo.";
        }

        // Checks if the answer for Question 4 is correct which is B
        RadioButton answer4 = (RadioButton) findViewById(R.id.answerFourB);
        if (answer4.isChecked()){
            score += 1;
            scoreInfo += "\nAnswer # 4 is correct.";
        }else{
            scoreInfo += "\nAnswer # 4 is incorrect\n\t- The correct answer is an E minor.";
        }

        // Checks if the answer for Question 5 is correct which is Slash, or SLASH, or SLaSh - toLowerCase takes care of the variations
        EditText answer5 = (EditText) findViewById(R.id.answerEditText);
        String answer5Value = answer5.getText().toString();
        String lc_answer5Value = answer5Value.toLowerCase();

        if (lc_answer5Value.equals("slash")){
            score += 1;
            scoreInfo += "\nAnswer # 5 is correct\n\t- Slash is indeed the lead guitarist for GNR.";

        }else{
            scoreInfo += "\nAnswer # 5 is incorrect\n\t- Slash is the lead guitarist for GNR and not " + answer5Value + ".";
        }

        scoreInfo += "\n\nTotal Score is " + score + "/5.";

        // Checks if the results should be emailed or not

        String toastSubmitText = "";

        if (willEmail == true){
            scoreBoard.setText("Your score and feedback will be emailed.");
            toastSubmitText += "Your score is " + score + "/5. Email App is opening.";
            composeEmail("Guitar Quiz App Results" , scoreInfo);
        }else{
            scoreBoard.setText(scoreInfo);
            toastSubmitText += "Your score is " + score + "/5.";
        }
        score = 0;

        Toast toastSubmit = Toast.makeText(this, toastSubmitText, Toast.LENGTH_LONG);
        toastSubmit.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toastSubmit.show();


    }

    /**
     * This method passes the parameters to an email intent
     * @param subject
     * @param scoreInformation
     */
    private void composeEmail(String subject, String scoreInformation){
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
     * @param view
     */
    public void resetQuiz(View view) {
        score = 0;

        CheckBox willEmailCB = (CheckBox) findViewById(R.id.sendEmail);
        willEmailCB.setChecked(false);

        TextView scoreInformation = (TextView) findViewById(R.id.scoreBoard);
        Toast resetToast = Toast.makeText(this, "Quiz Reset Successful!", Toast.LENGTH_SHORT);
        resetToast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
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


        //Reset EditText to blank
        EditText answer5value = (EditText) findViewById(R.id.answerEditText);
        answer5value.setText("");

        //Reset the Scoreboard TextView
        TextView scoreboard = (TextView) findViewById(R.id.scoreBoard);
        scoreboard.setText("");


    }

}



